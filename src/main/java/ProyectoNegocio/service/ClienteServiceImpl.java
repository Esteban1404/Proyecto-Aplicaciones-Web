/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoNegocio.service;

import ProyectoNegocio.dao.ClienteDao;
import ProyectoNegocio.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author esteb
 */

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteDao clienteDao;

    /* @Autowired
    CreditoDao creditoDao;*/
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {

        return (List<Cliente>) clienteDao.findAll(); // METODO PARA BUSCAR TODA LA LISTA
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null); //BUSCAR UN UNICO CLIENTE
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {  //MODIFICAR O INSERATR UN NUEVO CLIENTE
      
        clienteDao.save(cliente);
        
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {

        clienteDao.deleteById(cliente.getIdCliente());   //ELIMINAR CLIENTE
    }

}
