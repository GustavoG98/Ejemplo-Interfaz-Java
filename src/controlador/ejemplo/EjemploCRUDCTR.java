package controlador.ejemplo;

import controlador.estilo.BtnsCTR;
import controlador.estilo.TblCTR;
import controlador.vtn.CambioPnlCTR;
import vista.VtnPrincipal;
import vista.ejemplo.EjemploPnl;

/**
 *
 * @author Johnny
 */
public class EjemploCRUDCTR {
    
    private final EjemploPnl pnlEjemplo; 

    public EjemploCRUDCTR(EjemploPnl pnlEjemplo, VtnPrincipal vtnPrin) {
        this.pnlEjemplo = pnlEjemplo;
        //Repinto el panel por su panel correspondiente
        CambioPnlCTR.cambioPnl(vtnPrin.getPnlPrincipal(), pnlEjemplo); 
    }
    
    public void iniciar(){
        //Pasamos el estilo de la tabla 
        TblCTR.estiloTbl(pnlEjemplo.getTblEjemplo()); 
        
        //Y le damos animaciones a los botones 
        BtnsCTR.hoverBtnFondo(pnlEjemplo.getBtnIngresar(), pnlEjemplo.getBtnEditar(), pnlEjemplo.getBtnEliminar()); 
        
        //Animamos a los botones con icono  
        BtnsCTR.hoverBtnIcono(pnlEjemplo.getBtnAnterior(), pnlEjemplo.getBtnAyuda(), pnlEjemplo.getBtnBuscar(), pnlEjemplo.getBtnSiguiente());
    }
    
}
