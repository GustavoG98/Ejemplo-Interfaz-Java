/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Controllers.Libraries.Effects;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.dto.Producto;
import model.interfaces.ProductoImp;
import view.ListaProducto;
import view.Main;

/**
 *
 * @author MrRainx
 */
public class ListaProductosCntrl {

    private Main main;
    private ListaProducto view;
    private ProductoImp model;

    private List<Producto> Lista = null;
    private DefaultTableModel modelT;

    private int paginaActual = 0;
    private int paginas = 0;

    public ListaProductosCntrl(Main main, ListaProducto view, ProductoImp model) {
        this.main = main;
        this.view = view;
        this.model = model;
    }

    /*
        Inits
     */
    public void Init() {

        modelT = (DefaultTableModel) view.getTabProductos().getModel();

        main.getContainer().removeAll();
        main.getContainer().add(view);
        main.getContainer().updateUI();

        setPaginas();

        cargarTabla();
        InitEventos();
        InitEfectos();

        view.setVisible(true);

    }

    private void InitEventos() {
        view.getBtnBuscar().addActionListener(e -> btnBuscarActionPerformance(e));

        view.getBtnSiguiente().addActionListener(e -> btnSiguienteActionPerformance(e));

        view.getBtnAnterior().addActionListener(e -> btnAnterioActionPerformace(e));

    }

    private void InitEfectos() {
        Color colorSalida = view.getBtnAgregar().getBackground();
        Color colorEntrada = new Color(0, 102, 102);

        Effects.colorHover(view.getBtnAgregar(), colorEntrada, colorSalida);
        Effects.colorHover(view.getBtnBuscar(), colorEntrada, colorSalida);
        Effects.colorHover(view.getBtnEditar(), colorEntrada, colorSalida);
        Effects.colorHover(view.getBtnEliminar(), colorEntrada, colorSalida);
        Effects.colorHover(view.getLbEstado(), colorEntrada, colorSalida);
        
    }

    /*
        Metodos de Apoyo
     */
    private void cargarTabla() {

        Lista = model.SelectAll(paginaActual * 50);

        Lista.forEach((obj) -> {
            agregarFila(obj);
        });
        view.getLbResultados().setText(Lista.size() + " Resultados");
    }

    private void borrarTabla() {
        if (!modelT.getDataVector().isEmpty()) {
            for (int i = 0; i < modelT.getDataVector().size() + 1; i++) {
                modelT.removeRow(0);
            }
        }

    }

    private void cargarTablaBusqueda(String Aguja) {
        Lista = model.SelectOne(Aguja);
        Lista.forEach((obj) -> {
            agregarFila(obj);
        });
    }

    private void agregarFila(Producto obj) {
        modelT.addRow(new Object[]{
            obj.getCodigo(),
            obj.getNombre(),
            obj.getDescripcion(),
            obj.getPrecio(),
            obj.getStock()
        });
    }

    private void setPaginas() {
        paginas = model.SelectCount();
        view.getLbPaginas().setText(paginaActual + 1 + "/" + paginas);
    }

    /*
    Procesadores de Eventos
     */
    private void btnBuscarActionPerformance(ActionEvent e) {
        borrarTabla();
        cargarTablaBusqueda(view.getTxtBuscar().getText());

    }

    private void btnSiguienteActionPerformance(ActionEvent e) {

        if ((paginaActual + 1) < paginas) {
            if (paginas > 1) {
                paginaActual++;
                borrarTabla();
                cargarTabla();
                setPaginas();
            }
        }

    }

    private void btnAnterioActionPerformace(ActionEvent e) {

        if (paginas > 1) {
            if (paginaActual != 0) {
                paginaActual--;
                borrarTabla();
                cargarTabla();
                setPaginas();
            }
        }

    }

}
