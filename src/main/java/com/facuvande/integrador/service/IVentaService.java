package com.facuvande.integrador.service;

import com.facuvande.integrador.model.Venta;
import java.util.List;

public interface IVentaService {
    
     // Traer una venta por id
    public Venta getSaleById(Long code);
    
    // Traer todas las ventas
    public List<Venta> getSales();
    
    // Creacion
    public Venta save(Venta sale);
    
    // Eliminacion
    public void deleteById(Long code);
    
    // Edicion
    public Venta editSale(Venta sale);
    
}
