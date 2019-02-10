/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author MrRainx
 */
public class Main extends javax.swing.JFrame {
    
    public Main() {
        initComponents();
    }

    public JButton getBtnCategorias() {
        return btnCategorias;
    }

    public JButton getBtnProductos() {
        return btnProductos;
    }

    public JPanel getContainer() {
        return container;
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navbar = new javax.swing.JPanel();
        btnCategorias = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 520));
        setSize(new java.awt.Dimension(800, 520));

        navbar.setBackground(new java.awt.Color(0, 102, 102));
        navbar.setMinimumSize(new java.awt.Dimension(800, 40));
        navbar.setPreferredSize(new java.awt.Dimension(800, 40));
        navbar.setLayout(new javax.swing.BoxLayout(navbar, javax.swing.BoxLayout.LINE_AXIS));

        btnCategorias.setBackground(new java.awt.Color(0, 102, 102));
        btnCategorias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btnCategorias.setText("Categorias");
        btnCategorias.setBorderPainted(false);
        btnCategorias.setContentAreaFilled(false);
        btnCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategorias.setFocusPainted(false);
        btnCategorias.setMaximumSize(new java.awt.Dimension(130, 30));
        btnCategorias.setMinimumSize(new java.awt.Dimension(130, 30));
        btnCategorias.setPreferredSize(new java.awt.Dimension(130, 30));
        navbar.add(btnCategorias);
        btnCategorias.getAccessibleContext().setAccessibleName("btnLista");

        btnProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setBorderPainted(false);
        btnProductos.setContentAreaFilled(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setFocusPainted(false);
        btnProductos.setMaximumSize(new java.awt.Dimension(130, 30));
        btnProductos.setMinimumSize(new java.awt.Dimension(130, 30));
        btnProductos.setPreferredSize(new java.awt.Dimension(130, 30));
        navbar.add(btnProductos);
        btnProductos.getAccessibleContext().setAccessibleName("btnAgregar");

        container.setBackground(new java.awt.Color(102, 102, 102));
        container.setMinimumSize(new java.awt.Dimension(800, 480));
        container.setPreferredSize(new java.awt.Dimension(800, 480));
        container.setLayout(new javax.swing.BoxLayout(container, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnProductos;
    private javax.swing.JPanel container;
    private javax.swing.JPanel navbar;
    // End of variables declaration//GEN-END:variables
}
