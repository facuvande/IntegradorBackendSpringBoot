package com.facuvande.integrador.controller;

import com.facuvande.integrador.model.Producto;
import com.facuvande.integrador.model.Venta;
import com.facuvande.integrador.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService saleService;
    
    // Creacion
    @PostMapping("/ventas/crear")
    public Venta createSale(@RequestBody Venta sale){
        return saleService.save(sale);
    }
    
    // Lista completa
    @GetMapping("/ventas")
    public List<Venta> getSales(){
        return saleService.getSales();
    }
    
    // Traer producto en particular
    @GetMapping("/ventas/{code}")
    public Venta getSaleById(@PathVariable Long code){
        return saleService.getSaleById(code);
    }
    
    // Eliminacion
    @DeleteMapping("/ventas/eliminar/{code}")
    public void deleteSale(@PathVariable Long code){
        saleService.deleteById(code);
    }
    
    // Edicion
    @PutMapping("/ventas/editar/{code}")
    public Venta editSale(@PathVariable Long code, @RequestBody Venta newSale){
        Venta saleToEdit = this.getSaleById(code);
        saleToEdit.setUnCliente(newSale.getUnCliente());
        saleToEdit.setTotal(newSale.getTotal());
        saleToEdit.setListaProductos(newSale.getListaProductos());
        saleToEdit.setFecha_venta(newSale.getFecha_venta());
        saleToEdit.setCodigo_venta(newSale.getCodigo_venta());

        return saleService.editSale(saleToEdit);
    }
    
    // Traer productos de venta
    @GetMapping("/ventas/productos/{code}")
    public List<Producto> getProductsBySale(@PathVariable Long code){
        return saleService.getProductBySale(code);
    }
    
    // Traer sumatoria de monto y cantidad total de ventas de un dia
    @GetMapping("/ventas/fecha/{fecha_venta}")
    public String getDataSales(@PathVariable LocalDate fecha_venta){
        return saleService.getDataSales(fecha_venta);
    }
}
