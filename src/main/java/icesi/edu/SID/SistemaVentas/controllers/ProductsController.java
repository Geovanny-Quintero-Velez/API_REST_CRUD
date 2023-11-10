package icesi.edu.SID.SistemaVentas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.SID.SistemaVentas.models.Order;
import icesi.edu.SID.SistemaVentas.models.Product;
import icesi.edu.SID.SistemaVentas.services.OrderService;
import icesi.edu.SID.SistemaVentas.services.ProductService;

public class ProductsController {
    
    private ProductService service;

    @GetMapping("/listProducts")
    public ResponseEntity<List<Product>> listProducts(){
        List<Product> products = new ArrayList<>();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<Product> getProduct(@RequestParam("productId") long productId){
        Product product = new Product();
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PostMapping("/postProduct")
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        Product productAdded = new Product();
        return new ResponseEntity<>(productAdded, HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product productUpdated = new Product();
        return new ResponseEntity<>(productUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<Void> deleteProduct(@RequestParam("productId") long productId){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
