package com.facuvande.integrador.service;

import com.facuvande.integrador.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    // Traer un cliente por id
    public Cliente getClientById(Long code);
    
    // Traer todos los clientes
    public List<Cliente> getClient();
    
    // Creacion
    public Cliente save(Cliente clien);
    
    // Eliminacion
    public void deleteById(Long code);
    
    // Edicion
    public Cliente editClient(Cliente clien);
}
