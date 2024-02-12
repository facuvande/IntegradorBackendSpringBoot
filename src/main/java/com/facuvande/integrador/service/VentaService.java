package com.facuvande.integrador.service;

import com.facuvande.integrador.dto.MayorVentaDTO;
import com.facuvande.integrador.model.Producto;
import com.facuvande.integrador.model.Venta;
import com.facuvande.integrador.repository.IProductoRepository;
import com.facuvande.integrador.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository saleRepository;
    
    @Autowired
    private IProductoRepository productRepository;
    
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
        
        List<Producto> productsToSale = sale.getListaProductos();
        
        for(Producto prod : productsToSale){
            Producto prodVenta = productRepository.findById(prod.getCodigo_producto()).orElse(null);
            if(prodVenta.getCantidad_disponible() <= 0){
                return null;
            }else{
                prodVenta.setCantidad_disponible(prodVenta.getCantidad_disponible() - 1);
                productRepository.save(prodVenta);
            }
        }
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

    @Override
    public List<Producto> getProductBySale(Long code) {
        Venta mySale = this.getSaleById(code);
        return mySale.getListaProductos();
    }

    @Override
    public String getDataSales(LocalDate sale) {
        List<Venta> mySales = this.getSales();
        int quantitySales = 0;
        int ammountTotal = 0;
        
        for(Venta sales : mySales){
            if(sales.getFecha_venta().equals(sale)){
                quantitySales++;
                ammountTotal += sales.getTotal();
            }
        }
        
        return "Fecha Ventas: " + sale + "\n" + "Cantidad de ventas: " + quantitySales + "\n" + "Monto total: " + ammountTotal;
    }

    @Override
    public MayorVentaDTO getSaleWithHighestAmountDetails() {
        List<Venta> mySales = this.getSales();
        Venta highSale = null;
        
        Double total = 0.0;
        
        for(Venta sale : mySales){
            if(sale.getTotal() > total){
                total = sale.getTotal();
                highSale = sale;
            }
        }
        
        List<Producto> productsToSale = this.getProductBySale(highSale.getCodigo_venta());
        
        
        MayorVentaDTO myDTO = new MayorVentaDTO();
        myDTO.setApellido_cliente(highSale.getUnCliente().getApellido());
        myDTO.setCantidad_productos(productsToSale.size());
        myDTO.setCodigo_venta(highSale.getCodigo_venta());
        myDTO.setNombre_cliente(highSale.getUnCliente().getNombre());
        myDTO.setTotal(total);
        
        return myDTO;
    }
    
}
