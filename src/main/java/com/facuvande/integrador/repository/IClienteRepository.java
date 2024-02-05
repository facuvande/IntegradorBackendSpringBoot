package com.facuvande.integrador.repository;

import com.facuvande.integrador.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    
}
