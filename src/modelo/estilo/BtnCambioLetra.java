package modelo.estilo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Johnny
 */
public class BtnCambioLetra implements MouseListener{
    
    private final JButton btn; 
    
    public BtnCambioLetra(JButton btn){
        this.btn  = btn; 
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        btn.setForeground(new Color(255, 255, 255));
        btn.setFont(new java.awt.Font("Arial", 1, 16));      
    }

    @Override
    public void mouseExited(MouseEvent e) {
        btn.setForeground(new Color(204, 204, 204));
        btn.setFont(new java.awt.Font("Arial", 1, 14));
    }
      
}
