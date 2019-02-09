package modelo.estilo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Johnny
 */
public class BtnCambioFondo implements MouseListener{
    
    private final JButton btn; 
    
    public BtnCambioFondo(JButton btn){
        this.btn = btn;
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
        btn.setBackground(new Color(0, 24, 56));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        btn.setBackground(new Color(49, 79, 117));
    }
    
}
