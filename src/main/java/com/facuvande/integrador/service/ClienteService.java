package com.facuvande.integrador.service;

import com.facuvande.integrador.model.Cliente;
import com.facuvande.integrador.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clientRepo;
    
    @Override
    public Cliente getClientById(Long code) {
        return clientRepo.findById(code).orElse(null);
    }

    @Override
    public List<Cliente> getClient() {
        return clientRepo.findAll();
    }

    @Override
    public Cliente save(Cliente clien) {
        return clientRepo.save(clien);
    }

    @Override
    public void deleteById(Long code) {
        clientRepo.deleteById(code);
    }

    @Override
    public Cliente editClient(Cliente clien) {
        return this.save(clien);
    }
    
}
