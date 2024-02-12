package com.facuvande.integrador.service;

import com.facuvande.integrador.model.Producto;
import com.facuvande.integrador.model.Venta;
import com.facuvande.integrador.repository.IProductoRepository;
import com.facuvande.integrador.repository.IVentaRepository;
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
    
}
