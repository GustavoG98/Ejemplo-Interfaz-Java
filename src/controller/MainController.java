/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.interfaces.ProductoImp;
import view.ListaProducto;
import view.Main;

/**
 *
 * @author MrRainx
 */
public class MainController {

    private Main view;
    private ProductoImp model;

    public MainController(Main main, ProductoImp model) {
        this.view = main;
        this.model = model;
    }

    //Inits
    public void Init() {
        view.setVisible(true);

        view.getBtnProductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnProductosOnMouseClicked(e);
            }
        });

    }

    //Metodos de Apoyo
    //Procesadores de Eventos
    private void btnProductosOnMouseClicked(MouseEvent e) {
        ListaProducto lista = new ListaProducto();

        ListaProductosCntrl producto = new ListaProductosCntrl(view, lista, model);
        producto.Init();
    }

}
