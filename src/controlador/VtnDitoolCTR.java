package controlador;

import controlador.ejemplo.EjemploCTR;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Constantes;
import modelo.Version;
import vista.BienvenidaPnl;
import vista.VtnDitool;
import vista.VtnPrincipal;
import vista.ejemplo.NvPnl;

/**
 *
 * @author alumno
 */
public class VtnDitoolCTR {

    private final Version version;
    private final VtnDitool vtnDitool;
    private boolean aCorrecto = true;
    private final ImageIcon icono;

    public VtnDitoolCTR(Version version, VtnDitool vtnPrin) {
        this.icono = new ImageIcon(getClass().getResource("/vista/img/update.png"));
        this.version = version;
        this.vtnDitool = vtnPrin;
        this.vtnDitool.setIconImage(icono.getImage());
    }

    public void iniciar() {
        mostrarVtn();
        mostrarInformacion();
        if (validarVersion()) {
            if (aCorrecto) {
                comprobarVersion();
            }
        } else {
            JOptionPane.showMessageDialog(vtnDitool, "No se an publicado versiones.");
            ejecutarPrograma();
        }

    }

    private void mostrarInformacion() {
        File pv = new File(Constantes.V_DIR);
        Properties p = new Properties();
        if (pv.exists()) {
            if (comprobarRequisitos(p, pv)) {
                try {
                    p.load(new FileReader(pv));
                    vtnDitool.getLblAutor().setText(p.getProperty(Constantes.V_AUTOR));
                    vtnDitool.getLblNombre().setText(version.getNombreSinExtension(
                            p.getProperty(Constantes.V_NOMBRE)));
                    vtnDitool.getLblVersion().setText(p.getProperty(Constantes.V_VERSION));
                    //Ponemos la version del sistema en el titulo
                    vtnDitool.setTitle(vtnDitool.getTitle() + " " + p.getProperty(Constantes.V_VERSION));
                } catch (IOException e) {
                    System.out.println("No pudimos leer las propiedades de version: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(vtnDitool, "Su archivo de propiedades esta corrupto,\n"
                        + "vamos a descargar todo nuevamente.");
                aCorrecto = false;
                if (validarVersion()) {
                    crearVersion();
                    cerrarTodo();
                }

            }
        }

    }

    public void mostrarVtn() {
        vtnDitool.setVisible(true);
        vtnDitool.setLocationRelativeTo(null);
    }

    public void comprobarVersion() {
        File pv = new File(Constantes.V_DIR);
        Properties p = new Properties();
        if (pv.exists()) {
            if (comprobarRequisitos(p, pv)) {
                if (compara(p, pv)) {
                    JOptionPane.showMessageDialog(null, "Esta instalada la ultima version del sistema.");
                    ejecutarPrograma();
                } else {
                    //Aqui descargamos la versio nueva
                    crearVersion();
                }
            } else {
                //Si el archivo de version no contiene todo lo necesario se descarga
                crearVersion();
            }
        } else {
            crearVersion();
        }
        cerrarTodo();
    }

    public void crearVersion() {
        vtnDitool.getLblFondo().setText("Descargando...");
        File pv = new File(Constantes.V_DIR);
        Properties p = new Properties();
        Descarga descarga = new Descarga(version);
        if (descarga.descargar()) {
            crearPropiedades(p, pv);
            vtnDitool.getLblFondo().setText("Descargado");
            Descomprime uzip = new Descomprime(version);
            vtnDitool.getLblFondo().setText("Instalando..");
            uzip.descomprime();
        }
    }

    private boolean compara(Properties p, File bd) {
        boolean igual = true;
        String pNombre = "";
        String pVersion = "";
        try {
            p.load(new FileReader(bd));
            pNombre = p.getProperty(Constantes.V_NOMBRE);
            pVersion = p.getProperty(Constantes.V_VERSION);
        } catch (IOException e) {
            System.out.println("No pudimos leer las propiedades de version: " + e.getMessage());
        }

        if (!pNombre.equals(version.getNombre())) {
            igual = false;
        }

        if (!pVersion.equals(version.getVersion())) {
            igual = false;
        }

        return igual;
    }

    private boolean crearPropiedades(Properties p, File bd) {
        boolean creado = false;
        try {
            FileOutputStream fo = new FileOutputStream(bd);
            p.setProperty(Constantes.V_AUTOR, version.getUsername());
            p.setProperty(Constantes.V_NOMBRE, version.getNombre());
            p.setProperty(Constantes.V_VERSION, version.getVersion());
            p.setProperty(Constantes.V_FECHA, version.getFecha().toString());
            p.setProperty(Constantes.V_NOTAS, version.getNotas());
            p.store(fo, "Descripcion de la version del sistema: ");
            creado = true;
        } catch (FileNotFoundException e) {
            System.out.println("No podemos escribir el archivo: " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo guardar el properties: " + ex.getMessage());
        }
        return creado;
    }

    private boolean comprobarRequisitos(Properties p, File bd) {
        boolean todas = true;
        try {
            p.load(new FileReader(bd));
            if (p.getProperty(Constantes.V_AUTOR) == null) {
                todas = false;
            }

            if (p.getProperty(Constantes.V_FECHA) == null) {
                todas = false;
            }

            if (p.getProperty(Constantes.V_NOMBRE) == null) {
                todas = false;
            }

            if (p.getProperty(Constantes.V_NOTAS) == null) {
                todas = false;
            }

            if (p.getProperty(Constantes.V_VERSION) == null) {
                todas = false;
            }

        } catch (IOException e) {
            System.out.println("Error al comprobar si tiene todas las constantes:" + e.getMessage());
        }
        return todas;
    }

    private void ejecutarPrograma() {

        File pv = new File(Constantes.V_DIR);
        Properties p = new Properties();
        try {
            p.load(new FileReader(pv));
            String pNombre = version.getNombreSinExtension(p.getProperty(Constantes.V_NOMBRE));

            VtnPrincipal vtnPrin = new VtnPrincipal();
            vtnPrin.setTitle(vtnPrin.getTitle() + " | " + pNombre + ": " + p.getProperty(Constantes.V_VERSION));
            BienvenidaPnl pnlBienvenida = new BienvenidaPnl();
            NvPnl pnlNv = new NvPnl();

            EjemploCTR ejem = new EjemploCTR(pnlBienvenida, vtnPrin, pnlNv);
            ejem.iniciar();
        } catch (IOException e) {
            System.out.println("No se pudo encontrar la propiedad de nombre: " + e.getMessage());
        }
    }

    private void cerrarTodo() {
        vtnDitool.dispose();
    }

    private boolean validarVersion() {
        return !(version.getFecha() == null
                || version.getId() == 0
                || version.getNombre() == null
                || version.getNotas() == null
                || version.getUrl() == null
                || version.getUsername() == null
                || version.getVersion() == null);
    }

}
