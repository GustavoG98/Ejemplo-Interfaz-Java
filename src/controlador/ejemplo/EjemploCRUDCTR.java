package controlador.ejemplo;

import controlador.estilo.BtnsCTR;
import controlador.estilo.TblCTR;
import controlador.vtn.CambioPnlCTR;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vista.VtnFormulario;
import vista.VtnPrincipal;
import vista.ejemplo.EjemploFrmPnl;
import vista.ejemplo.EjemploPnl;

/**
 *
 * @author Johnny
 */
public class EjemploCRUDCTR {

    private final EjemploPnl pnlEjemplo;

    String NOMBRES[] = {"Byron", "David", "Jose", "Andres", "Alexander", "Pablo",
        "Luis", "Alberto", "Diego", "Xavier", "Alejandro", "Yanina", "Antonela",
        "Johnny", "Gustavo", "Kevin", "Paul", "Dannes", "Dario", "Ana", "Paola", "Felipe",
        "Lina", "Mercedes", "Cesar", "Aurelio", "Sebastian", "Marcelo", "Antonio",
        "Maria", "Cristina", "Christian", "Daniel"};
    String APELLIDOS[] = {"Anchundia", "Bermeo", "Cajamarca", "Chacon",
        "Chuquiguanda", "Condo", "Coraizaca", "Flores", "Garcia", "Guevara",
        "Maurad", "Medina", "Novillo", "Orellana", "Pesantez", "Ullauri",
        "Vidal", "Viñanzaca", "Zhungo"};
    String DIRECCIONES[] = {"Totoracocha", "Miraflores", "Mayancela",
        "El Valle", "Monay", "Trigales", "El vecino", "Centro", "Ochoa leon",
        "San Andres"};

    String TELEFONOS[] = {"0964541212", "09654521524", "0965232321", "0954785214",
        "0954758512", "0957412030", "0965741020", "0965452010", "0968796010",
        "0954421010"};

    String FECHAS[] = {"12/10/1997", "05/11/1995", "06/05/1998", "15/12/2000"};

    //Aqui guardare los datos  que se llenan en la tabla 
    private ArrayList<Object[]> datos;

    //Para rellenar la tabla  
    private final DefaultTableModel mdTblEjemplo;
    //
    private final VtnPrincipal vtnPrin;

    public EjemploCRUDCTR(EjemploPnl pnlEjemplo, VtnPrincipal vtnPrin) {
        //Inciamos el modelo de tabla personas 
        String titulo[] = {"Nombre", "Apellido", "Direccion", "Teléfono", "Fecha N", " "};
        String d[][] = {};
        //mdTblEjemplo = new DefaultTableModel(datos, titulo);
        mdTblEjemplo = TblCTR.modeloTablaSinEditar(d, titulo);
        //Pasamos el modelo a la tabla  
        pnlEjemplo.getTblEjemplo().setModel(mdTblEjemplo);
        this.vtnPrin = vtnPrin;
        this.pnlEjemplo = pnlEjemplo;
        //Repinto el panel por su panel correspondiente
        CambioPnlCTR.cambioPnl(vtnPrin.getPnlPrincipal(), pnlEjemplo);
    }

    public void iniciar() {
        //Pasamos el estilo de la tabla la que contiene un icono 
        TblCTR.estiloTblConIcono(pnlEjemplo.getTblEjemplo());

        //Y le damos animaciones a los botones 
        BtnsCTR.hoverBtnFondo(pnlEjemplo.getBtnIngresar(), pnlEjemplo.getBtnEditar(), pnlEjemplo.getBtnEliminar());

        //Animamos a los botones con icono  
        BtnsCTR.hoverBtnIcono(pnlEjemplo.getBtnAnterior(), pnlEjemplo.getBtnAyuda(), pnlEjemplo.getBtnBuscar(), pnlEjemplo.getBtnSiguiente());

        llenaTblEjemplo();

        //Guardamos el numero de la ultima columna de la tabla
        //Nos ayudara al momento de hacer un click en la tabla y 
        //saber si se dio click en la columna que tiene el icono 
        int ultColumna = pnlEjemplo.getTblEjemplo().getColumnCount() - 1;

        pnlEjemplo.getTblEjemplo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int columna = pnlEjemplo.getTblEjemplo().columnAtPoint(e.getPoint());
                //Si en la columna que se dio click es igual a la ultima columna
                //Se muestra mas informacion del usuario por consola
                if (columna == ultColumna) {
                    int fila = pnlEjemplo.getTblEjemplo().rowAtPoint(e.getPoint());
                    masInformacion(fila);
                }
            }
        });

        pnlEjemplo.getBtnIngresar().addActionListener(e -> clickIngresar());
    }

    public void llenaTblEjemplo() {
        //Con esto borramos los datos de la tabla
        mdTblEjemplo.setRowCount(0);

        //Iniciamos el array  
        datos = new ArrayList();

        int numNom;
        int numApe;
        int numDir;
        int numTel;
        int numFec;

        for (int i = 0; i < 100; i++) {
            numNom = (int) (Math.random() * NOMBRES.length);
            numApe = (int) (Math.random() * APELLIDOS.length);
            numDir = (int) (Math.random() * DIRECCIONES.length);
            numTel = (int) (Math.random() * TELEFONOS.length);
            numFec = (int) (Math.random() * FECHAS.length);

            Object valores[] = {NOMBRES[numNom], APELLIDOS[numApe],
                DIRECCIONES[numDir], TELEFONOS[numTel], FECHAS[numFec]};

            datos.add(valores);

            mdTblEjemplo.addRow(valores);
        }

        pnlEjemplo.getLblNumResultados().setText(datos.size() + " resultados obtendios.");

    }

    public void masInformacion(int fila) {
        if (fila >= 0) {
            System.out.println("-------------------------------");
            System.out.println("Nombre: " + datos.get(fila)[0]);
            System.out.println("Apellido: " + datos.get(fila)[1]);
            System.out.println("Direccion: " + datos.get(fila)[2]);
            System.out.println("Telefono: " + datos.get(fila)[3]);
            System.out.println("Fecha: " + datos.get(fila)[4]);
            System.out.println("-------------------------------");
        }
    }

    public void clickIngresar() {
        VtnFormulario vtnFrm = new VtnFormulario(vtnPrin, true);
        EjemploFrmPnl pnlFrm = new EjemploFrmPnl();

        IngresarCTR ingCtr = new IngresarCTR(vtnFrm, pnlFrm);
        ingCtr.iniciar();
    }
}
