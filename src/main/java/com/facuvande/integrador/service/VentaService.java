package com.facuvande.integrador.service;

import com.facuvande.integrador.model.Venta;
import com.facuvande.integrador.repository.IVentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository saleRepository;
    
    @Override
    public Venta getSaleById(Long code) {
        return saleRepository.findById(code).orElse(null);
    }

    @Override
    public List<Venta> getSales() {
        return saleRepository.findAll();
    }

    @Override
    public Venta save(Venta sale) {
        return saleRepository.save(sale);
    }

    @Override
    public void deleteById(Long code) {
        saleRepository.deleteById(code);
    }

    @Override
    public Venta editSale(Venta sale) {
        return saleRepository.save(sale);
    }
    
}
