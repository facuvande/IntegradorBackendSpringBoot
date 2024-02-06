package com.facuvande.integrador.controller;

import com.facuvande.integrador.model.Cliente;
import com.facuvande.integrador.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienServ;
    
    @PostMapping("/clientes/crear")
    public Cliente save(Cliente clien){
        return clienServ.save(clien);
    }
    
}
