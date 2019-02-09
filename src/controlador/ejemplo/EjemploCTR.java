package controlador.ejemplo;

import controlador.estilo.BtnsCTR;
import controlador.vtn.CambioPnlCTR;
import vista.BienvenidaPnl;
import vista.VtnPrincipal;
import vista.ejemplo.EjemploPnl;
import vista.ejemplo.NvPnl;

/**
 *
 * @author Johnny
 */
public class EjemploCTR {
     
    private final BienvenidaPnl pnlBienvenido; 
    private final VtnPrincipal vtnPrin; 
    private final NvPnl pnlNvEjemplo;  

    public EjemploCTR(BienvenidaPnl pnlBienvenido, VtnPrincipal vtnPrin, NvPnl pnlNvEjemplo) {
        this.pnlBienvenido = pnlBienvenido;
        this.vtnPrin = vtnPrin;
        this.pnlNvEjemplo = pnlNvEjemplo;
        
        //Al iniciar repintamos los paneles 
        CambioPnlCTR.cambioPnl(vtnPrin.getPnlMenu(), pnlNvEjemplo);
        CambioPnlCTR.cambioPnl(vtnPrin.getPnlPrincipal(), pnlBienvenido);
        //Mostramos la ventana  
        vtnPrin.setVisible(true); 
    }
    
    
    public void iniciar(){
        //Agrego las animaciones a los btns  
        BtnsCTR.hoverBtnLetra(pnlNvEjemplo.getBtnEjemplo(), pnlNvEjemplo.getBtnInicio());
        
        
        pnlNvEjemplo.getBtnInicio().addActionListener(e -> clickInicio()); 
        pnlNvEjemplo.getBtnEjemplo().addActionListener(e -> clickEjemplo()); 
        
        
    }
    
    
    public void clickEjemplo(){
        EjemploPnl pnlEjemplo = new EjemploPnl();
        BtnsCTR.clickBtnNv(pnlNvEjemplo.getBtnEjemplo(), pnlNvEjemplo.getBtnInicio());
        
        EjemploCRUDCTR ejem = new EjemploCRUDCTR(pnlEjemplo, vtnPrin); 
        ejem.iniciar();
        
    }
    
    
    public void clickInicio(){
        CambioPnlCTR.cambioPnl(vtnPrin.getPnlPrincipal(), pnlBienvenido);
        
        BtnsCTR.clickBtnNv(pnlNvEjemplo.getBtnInicio(), pnlNvEjemplo.getBtnEjemplo());
    }
    
    
   
    
    
}
