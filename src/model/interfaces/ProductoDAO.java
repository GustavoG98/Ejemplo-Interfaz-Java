/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

import java.util.List;
import model.dto.Producto;

/**
 *
 * @author MrRainx
 */
public interface ProductoDAO {

    public boolean insertar();

    public List<Producto> SelectAll();

    public List<Producto> SelectOne(String Aguja);

    public boolean editar(String Pk);

    public boolean eliminar(String Pk);

}
