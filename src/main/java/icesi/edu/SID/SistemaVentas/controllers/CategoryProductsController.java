package icesi.edu.SID.SistemaVentas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.SID.SistemaVentas.models.CategoryProduct;
import icesi.edu.SID.SistemaVentas.models.Customer;
import icesi.edu.SID.SistemaVentas.services.CategoryProductService;

@RestController
@RequestMapping("/CategoryProducts")
public class CategoryProductsController {
    
    private CategoryProductService service;

    @GetMapping("/listCategoryProducts")
    public ResponseEntity<List<CategoryProduct>> listCategoryProducts(){
        List<CategoryProduct> categoryProducts = new ArrayList<>();
        return new ResponseEntity<>(categoryProducts, HttpStatus.OK);
    }

    @GetMapping("/getCategoryProduct")
    public ResponseEntity<CategoryProduct> getCategoryProduct(@RequestParam("code") long code){
        CategoryProduct categoryProduct = new CategoryProduct();
        return new ResponseEntity<>(categoryProduct, HttpStatus.OK);
    }

    @PostMapping("/postCategoryProduct")
    public ResponseEntity<CategoryProduct> postCategoryProduct(@RequestBody CategoryProduct categoryProduct){
        CategoryProduct categoryProductAdded = new CategoryProduct();
        return new ResponseEntity<>(categoryProductAdded, HttpStatus.OK);
    }

    @PutMapping("/updateCategoryProduct")
    public ResponseEntity<CategoryProduct> updateCategoryProduct(@RequestBody CategoryProduct categoryProduct){
        CategoryProduct categoryProductUpdated = new CategoryProduct();
        return new ResponseEntity<>(categoryProductUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCategoryProduct")
    public ResponseEntity<CategoryProduct> deleteCategoryProduct(@RequestParam("code") long code){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
