/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoNegocio.service;

import ProyectoNegocio.domain.Inventario;
import java.util.List;

/**
 *
 * @author esteb
 */
public interface InventarioService {
    
     public List<Inventario> getInventarios(boolean par); //TRAER LISTA DE CLIENTES
    
    public Inventario getInventario(Inventario inventario);//UN UNICO CLIENTE
    
    public void save(Inventario inventario);// Para insertar o modificar (Si viene el idInventario o no)
    
    public void delete (Inventario inventario); //ELIMINAR CLIENTE
    
}
