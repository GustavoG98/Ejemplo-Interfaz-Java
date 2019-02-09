package modelo.estilo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Johnny
 */
public class TblRenderLblIcono extends DefaultTableCellRenderer {
    
    int ultColumna; 
    
    public TblRenderLblIcono(int ultColumna){
        this.ultColumna = ultColumna; 
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected,
            boolean focused, int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
        JLabel lbl = new JLabel();  
        lbl.setIcon(new ImageIcon(getClass().getResource("/vista/img/mas25px.png"))); 
        lbl.setVisible(true); 
        lbl.setOpaque(false);
        lbl.setHorizontalAlignment(JLabel.CENTER); 
        
        if (focused) {
            if (ultColumna == column) {
                lbl.setOpaque(true);
                lbl.setBackground(new Color(153, 153, 153));  
            }
         }

        return lbl;
    }

}
