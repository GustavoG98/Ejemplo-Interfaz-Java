package controlador.ejemplo;

import controlador.estilo.BtnsCTR;
import controlador.estilo.TblCTR;
import controlador.vtn.CambioPnlCTR;
import javax.swing.table.DefaultTableModel;
import vista.VtnPrincipal;
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
        "Chuquiguanda", "Condo", "Coraiza", "Flores", "Garcia", "Guevara",
        "Maurad", "Medina", "Novillo", "Orellana", "Pesantez", "Ullauri",
        "Vidal", "Viñanzaca", "Zhungo"};
    String DIRECCIONES[] = {"Totoracocha", "Miraflores", "Mayancela",
        "El Valle", "Monay", "Trigales", "El vecino", "Centro", "Ochoa leon",
        "San Andres"};

    String TELEFONOS[] = {"0964541212", "09654521524", "0965232321", "0954785214",
        "0954758512", "0957412030", "0965741020", "0965452010", "0968796010",
        "0954421010"};

    String FECHAS[] = {"12/10/1997", "05/11/1995", "06/05/1998", "15/12/2000"};

    //Para rellenar la tabla  
    DefaultTableModel mdTblEjemplo;

    public EjemploCRUDCTR(EjemploPnl pnlEjemplo, VtnPrincipal vtnPrin) {
        //Inciamos el modelo de tabla personas 
        String titulo[] = {"Nombre", "Apellido", "Direccion", "Teléfono", "Fecha N"};
        String datos[][] = {};
        mdTblEjemplo = new DefaultTableModel(datos, titulo);
        //Pasamos el modelo a la tabla  
        pnlEjemplo.getTblEjemplo().setModel(mdTblEjemplo);

        this.pnlEjemplo = pnlEjemplo;
        //Repinto el panel por su panel correspondiente
        CambioPnlCTR.cambioPnl(vtnPrin.getPnlPrincipal(), pnlEjemplo);
    }

    public void iniciar() {
        //Pasamos el estilo de la tabla 
        TblCTR.estiloTbl(pnlEjemplo.getTblEjemplo());

        //Y le damos animaciones a los botones 
        BtnsCTR.hoverBtnFondo(pnlEjemplo.getBtnIngresar(), pnlEjemplo.getBtnEditar(), pnlEjemplo.getBtnEliminar());

        //Animamos a los botones con icono  
        BtnsCTR.hoverBtnIcono(pnlEjemplo.getBtnAnterior(), pnlEjemplo.getBtnAyuda(), pnlEjemplo.getBtnBuscar(), pnlEjemplo.getBtnSiguiente());
        
        llenaTblEjemplo();
    }

    public void llenaTblEjemplo() {
        //Con esto borramos los datos de la tabla
        mdTblEjemplo.setRowCount(0);
        
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
            
            Object valores [] ={NOMBRES[numNom], APELLIDOS[numApe], 
            DIRECCIONES[numDir], TELEFONOS[numTel], FECHAS[numFec]};
            
            mdTblEjemplo.addRow(valores); 
        }

    }

}
