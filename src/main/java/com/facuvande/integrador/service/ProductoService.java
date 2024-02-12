package com.facuvande.integrador.service;

import com.facuvande.integrador.model.Producto;
import com.facuvande.integrador.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productRepository;
    
    @Override
    public Producto getProductById(Long code) {
        return productRepository.findById(code).orElse(null);
    }

    @Override
    public List<Producto> getProducts() {
        List<Producto> myProducts = productRepository.findAll();
        return myProducts;
    }

    @Override
    public Producto save(Producto product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long code) {
        productRepository.deleteById(code);
    }

    @Override
    public Producto editProduct(Producto product) {
        return this.save(product);
    }

    @Override
    public List<Producto> getProductsLowStock() {
        List<Producto> myProducts = this.getProducts();
        List<Producto> listProductsLowStock = new ArrayList<>();
        for(Producto prod : myProducts){
            if(prod.getCantidad_disponible() < 5){
                listProductsLowStock.add(prod);
            }
        }
        
        return listProductsLowStock;
    }
    
}
