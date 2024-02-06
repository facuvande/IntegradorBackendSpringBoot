package com.facuvande.integrador.controller;

import com.facuvande.integrador.model.Producto;
import com.facuvande.integrador.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productService;
    
    // Creacion
    @PostMapping("/productos/crear")
    public Producto createProduct(@RequestBody Producto product){
        return productService.save(product);
    }
    
    // Lista completa
    @GetMapping("/productos")
    public List<Producto> getProducts(){
        return productService.getProducts();
    }
    
    // Traer producto en particular
    @GetMapping("/productos/{code}")
    public Producto getProductById(@PathVariable Long code){
        return productService.getProductById(code);
    }
    
    // Eliminacion
    @DeleteMapping("/productos/eliminar/{code}")
    public void deleteProduct(@PathVariable Long code){
        productService.deleteById(code);
    }
    
    @PutMapping("/productos/editar/{code}")
    public Producto editProduct(@PathVariable Long code){
        Producto productToEdit = this.getProductById(code);
        return productService.editProduct(productToEdit);
    }
}
