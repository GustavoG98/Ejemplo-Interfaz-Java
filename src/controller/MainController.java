/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Controllers.Libraries.Effects;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
        view.setLocationRelativeTo(null);
        view.setVisible(true);

        view.getBtnProductos().addActionListener(e -> btnProductosOnMouseClicked(e));
        InitEffectos();
    }
    
    private void InitEffectos(){
        
        Font entrada = new Font("Tahoma", 1, 15);
        Font salida = view.getBtnProductos().getFont();
        
        
        
        Effects.letterHover(view.getBtnProductos(), entrada, salida);
        Effects.letterHover(view.getBtnCategorias(), entrada, salida);
        
    }

    //Metodos de Apoyo
    //Procesadores de Eventos
    private void btnProductosOnMouseClicked(ActionEvent e) {
        ListaProducto lista = new ListaProducto();

        ListaProductosCntrl producto = new ListaProductosCntrl(view, lista, model);
        producto.Init();
    }

}
