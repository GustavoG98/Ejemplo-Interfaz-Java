/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import Controllers.Libraries.ImgLib;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ResourceManager;
import model.dto.Producto;

/**
 *
 * @author MrRainx
 */
public class ProductoImp extends Producto implements ProductoDAO {

    public ProductoImp(String codigo, String nombre, String descripcion, Image foto, float precio, int stock) {
        super(codigo, nombre, descripcion, foto, precio, stock);
    }

    public ProductoImp() {
    }

    @Override
    public boolean insertar() {

        String INSERT = "INSERT INTO "
                + " productos (codigo,nombre,descripcion,foto,precio,stock) "
                + " VALUES( "
                + " '" + getCodigo() + "', "
                + " '" + getNombre() + "', "
                + " '" + getDescripcion() + "', "
                + " '" + ImgLib.setImageInBase64(getFoto()) + "', "
                + " " + getPrecio() + ", "
                + " " + getStock()
                + " ) ";

        return ResourceManager.Statement(INSERT) == null;
    }

    @Override
    public List<Producto> SelectAll(int puntero) {

        String SELECT = "SELECT * FROM productos ORDER BY codigo LIMIT 50 OFFSET " + puntero;

        List<Producto> Lista = new ArrayList<>();

        try {

            try (ResultSet rs = ResourceManager.Query(SELECT)) {
                while (rs.next()) {
                    Lista.add(getProductoFromBD(rs));
                }
                rs.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Lista;
    }

    @Override
    public List<Producto> SelectOne(String Aguja) {

        String SELECT = " SELECT * FROM productos "
                + " WHERE "
                + " codigo LIKE '%" + Aguja + "%' "
                + " OR "
                + " nombre LIKE '%" + Aguja + "%' "
                + " ORDER BY codigo "
                + " LIMIT 50 "
                + " OFFSET 0";

        List<Producto> Lista = new ArrayList<>();

        try {

            try (ResultSet rs = ResourceManager.Query(SELECT)) {
                while (rs.next()) {

                    Lista.add(getProductoFromBD(rs));

                }
                rs.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Lista;
    }

    @Override
    public int SelectCount() {
        String SELECT = "SELECT count(*) AS registros FROM productos";
        
        int registros = 0;
        
        try {
            
            ResultSet rs = ResourceManager.Query(SELECT);
            while (rs.next()) {
                
                registros = rs.getInt("registros");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        if (registros > 50){
            
            if (registros % 50 == 0){
                registros = registros/50;
            } else {
                registros = (registros/50)+1;
            }
            
        } else {
            registros = 1;
        }
        
        return registros;
    }

    @Override
    public boolean editar(String Pk) {
        String foto;

        if (getFoto() == null) {
            foto = null;
        } else {
            foto = ImgLib.setImageInBase64(getFoto());
        }

        String UPDATE = "UPDATE productos SET "
                + " codigo = '" + getCodigo() + "', "
                + " nombre = '" + getNombre() + "', "
                + " descripcion = '" + getDescripcion() + "', "
                + " foto = '" + foto + "', "
                + " precio = " + getPrecio() + ", "
                + " stock = " + getStock()
                + " WHERE "
                + " codigo = '" + Pk + "'"
                + " "
                + "";

        return ResourceManager.Statement(UPDATE) == null;

    }

    @Override
    public boolean eliminar(String Pk) {

        String DELETE = "DELETE FROM productos "
                + " WHERE codigo = '" + Pk + "'";

        return ResourceManager.Statement(DELETE) == null;
    }

    private Producto getProductoFromBD(ResultSet rs) {

        Producto producto = new Producto();
        try {

            byte[] bytefoto;
            producto.setCodigo(rs.getString("codigo"));
            producto.setNombre(rs.getString("nombre"));
            producto.setDescripcion(rs.getString("descripcion"));

            bytefoto = rs.getBytes("foto");
            
            
            
            if (bytefoto != null) {
                if (bytefoto.length > 4){
                    producto.setFoto(ImgLib.ByteToImage(bytefoto));
                } else {
                    producto.setFoto(null);
                }

            } else {
                producto.setFoto(null);
            }

            producto.setPrecio(rs.getFloat("precio"));
            producto.setStock(rs.getInt("stock"));
        } catch (SQLException ex) {
            Logger.getLogger(ProductoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }
    
    
    public static void main(String[] args) {
        
        for (int i = 2; i < 60; i++) {
            
            
            if (i % 2 == 0){
                ProductoImp prod = new ProductoImp("PRO-000"+i, "carne ---"+i, "carne", null, (float) (5.50+i), i*10);
                prod.insertar();
            } else {
                
                ProductoImp prod = new ProductoImp("PRO-000"+i, "leche ---"+i, "carne", null, (float) (5.50+i), i*10);
                prod.insertar();
            }
            
        }
        
        
    }
    
    
}
