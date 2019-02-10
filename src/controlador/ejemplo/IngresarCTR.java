package controlador.ejemplo;

import controlador.estilo.BtnsCTR;
import controlador.estilo.TxtCTR;
import controlador.vtn.CambioPnlCTR;
import vista.VtnFormulario;
import vista.ejemplo.EjemploFrmPnl;

/**
 *
 * @author Johnny
 */
public class IngresarCTR {
    
    private final VtnFormulario vtnFormulario; 
    private final EjemploFrmPnl pnlFormulario;  

    public IngresarCTR(VtnFormulario vtnFormulario, EjemploFrmPnl pnlFormulario) {
        this.vtnFormulario = vtnFormulario;
        this.pnlFormulario = pnlFormulario;
        
        CambioPnlCTR.cambioPnl(vtnFormulario.getPnlFormulario(), pnlFormulario); 
        vtnFormulario.setVisible(true); 
    }
    
    public void iniciar(){
        vtnFormulario.getBtnCancelar().addActionListener(e -> clickCancelar());
        
        //Pasamos la animacion a todos los txt 
        TxtCTR.focusTxt(pnlFormulario.getTxtApellido(), pnlFormulario.getTxtCedula(), 
                pnlFormulario.getTxtCodEstudiante(), pnlFormulario.getTxtColegio(), 
                pnlFormulario.getTxtCorreo(), pnlFormulario.getTxtDireccion(), 
                pnlFormulario.getTxtNombre(), pnlFormulario.getTxtTitulo());  
        
        //Animacion de los botones  
        BtnsCTR.hoverBtnFondo(vtnFormulario.getBtnCancelar(), vtnFormulario.getBtnGuardar());
    }
    
    public void clickCancelar(){
        vtnFormulario.dispose();
    }
    
}
