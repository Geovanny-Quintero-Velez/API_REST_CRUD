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
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.SID.SistemaVentas.models.CategoryProduct;
import icesi.edu.SID.SistemaVentas.models.Customer;
import icesi.edu.SID.SistemaVentas.services.CategoryProductService;
import icesi.edu.SID.SistemaVentas.services.CustomerService;

public class CustomerController {
    
    private CustomerService service;

    @GetMapping("/listCustomers")
    public ResponseEntity<List<Customer>> listCustomers(){
        List<Customer> customers = new ArrayList<>();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<Customer> getCustomer(@RequestParam("id") long id){
        Customer customer = new Customer();
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @PostMapping("/postCustomer")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        Customer customerAdded = new Customer();
        return new ResponseEntity<>(customerAdded, HttpStatus.OK);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer customerUpdated = new Customer();
        return new ResponseEntity<>(customerUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<Void> deleteCustomer(@RequestParam("id") long id){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
