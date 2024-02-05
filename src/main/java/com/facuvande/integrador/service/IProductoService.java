package com.facuvande.integrador.service;

import com.facuvande.integrador.model.Producto;
import java.util.List;

public interface IProductoService {
    
    // Traer un producto por id
    public Producto getProductById(Long code);
    // Traer todos los productos
    public List<Producto> getProducts();
    // Creacion
    public void save(Producto product);
    // Eliminacion
    public String deleteById(Long code);
    // Edicion
    public Producto editProduct(Producto product);
    
}
