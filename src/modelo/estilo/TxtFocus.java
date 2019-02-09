package modelo.estilo;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Johnny
 */
public class TxtFocus implements FocusListener{
    
    private final JTextField txt; 
    
    public TxtFocus(JTextField txt){
        this.txt = txt; 
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 66, 86)));
    }

    @Override
    public void focusLost(FocusEvent e) {
        txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
    }
    
}
