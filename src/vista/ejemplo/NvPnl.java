package vista.ejemplo;

import javax.swing.JButton;

/**
 *
 * @author Johnny
 */
public class NvPnl extends javax.swing.JPanel {

    /**
     * Creates new form MenuPnl
     */
    public NvPnl() {
        initComponents();
    }

    public JButton getBtnEjemplo() {
        return btnEjemplo;
    }

    public JButton getBtnInicio() {
        return btnInicio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEjemplo = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();

        setBackground(new java.awt.Color(49, 79, 117));
        setMinimumSize(new java.awt.Dimension(600, 35));
        setPreferredSize(new java.awt.Dimension(600, 35));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEjemplo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEjemplo.setForeground(new java.awt.Color(204, 204, 204));
        btnEjemplo.setText("Ejemplo");
        btnEjemplo.setBorder(null);
        btnEjemplo.setContentAreaFilled(false);
        btnEjemplo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEjemplo.setFocusPainted(false);
        add(btnEjemplo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, 35));

        btnInicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(204, 204, 204));
        btnInicio.setText("Inicio");
        btnInicio.setBorder(null);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setFocusPainted(false);
        add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 35));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjemplo;
    private javax.swing.JButton btnInicio;
    // End of variables declaration//GEN-END:variables
}
