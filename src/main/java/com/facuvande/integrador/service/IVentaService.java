package com.facuvande.integrador.service;

import com.facuvande.integrador.model.Venta;
import java.util.List;

public interface IVentaService {
    
     // Traer una venta por id
    public Venta getPurchaseById(Long code);
    
    // Traer todas las ventas
    public List<Venta> getPurchases();
    
    // Creacion
    public Venta save(Venta purch);
    
    // Eliminacion
    public void deleteById(Long code);
    
    // Edicion
    public Venta editPurchase(Venta purch);
    
}
