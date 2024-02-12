package com.facuvande.integrador.service;

import com.facuvande.integrador.dto.MayorVentaDTO;
import com.facuvande.integrador.model.Producto;
import com.facuvande.integrador.model.Venta;
import java.time.LocalDate;
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
    
    // Traer productos de venta
    public List<Producto> getProductBySale(Long code);
    
    // Obtener sumatoria del monto y cantidad total de ventas de determinado dia
    public String getDataSales(LocalDate sale);
    
    // Obtener datos mayor venta
    public MayorVentaDTO getSaleWithHighestAmountDetails();
}
