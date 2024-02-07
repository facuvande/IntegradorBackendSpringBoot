package com.facuvande.integrador.controller;

import com.facuvande.integrador.model.Cliente;
import com.facuvande.integrador.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienServ;
    
    // Guardar cliente
    @PostMapping("/clientes/crear")
    public Cliente save(@RequestBody Cliente clien){
        return clienServ.save(clien);
    }
    
    // Lista completa
    @GetMapping("/clientes")
    public List<Cliente> getClients(){
        return clienServ.getClients();
    }
    
    // Traer cliente en particular
    @GetMapping("/clientes/{code}")
    public Cliente getClientById(@PathVariable Long code){
        return clienServ.getClientById(code);
    }
    
    // Eliminacion
    @DeleteMapping("/clientes/eliminar/{code}")
    public void deleteClient(@PathVariable Long code){
        clienServ.deleteById(code);
    }
    
    // Edicion
    @PutMapping("/clientes/editar/{code}")
    public Cliente editClient(@PathVariable Long code, @RequestBody Cliente newClient){
        Cliente clientToEdit = this.getClientById(code);
        clientToEdit.setNombre(newClient.getNombre());        
        clientToEdit.setDni(newClient.getDni());
        clientToEdit.setApellido(newClient.getApellido());

        return clienServ.editClient(clientToEdit);
    }
    
}
