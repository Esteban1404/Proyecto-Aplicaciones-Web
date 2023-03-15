/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoNegocio.service;

import ProyectoNegocio.dao.InventarioDao;
import ProyectoNegocio.domain.Inventario;
import ProyectoNegocio.domain.Inventario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author esteb
 */
@Service
public class InventarioServiceImpl implements InventarioService{

   @Autowired
    InventarioDao inventarioDao;

    /* @Autowired
    CreditoDao creditoDao;*/
    
    @Override
    @Transactional(readOnly = true)
    public List<Inventario> getInventarios(boolean par) {

        return (List<Inventario>) inventarioDao.findAll(); // METODO PARA BUSCAR TODA LA LISTA
    }

    @Override
    @Transactional(readOnly = true)
    public Inventario getInventario(Inventario inventario) {
        return inventarioDao.findById(inventario.getIdInventario()).orElse(null); //BUSCAR UN UNICO CLIENTE
    }

    @Override
    @Transactional
    public void save(Inventario inventario) {  //MODIFICAR O INSERATR UN NUEVO CLIENTE
      
        inventarioDao.save(inventario);
        
    }

    @Override
    @Transactional
    public void delete(Inventario inventario) {

        inventarioDao.deleteById(inventario.getIdInventario());   //ELIMINAR CLIENTE
    }

}
    
    
    

