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

import icesi.edu.SID.SistemaVentas.models.Customer;
import icesi.edu.SID.SistemaVentas.models.Order;
import icesi.edu.SID.SistemaVentas.services.CustomerService;
import icesi.edu.SID.SistemaVentas.services.OrderService;

public class OrdersController {
    
    private OrderService service;

    @GetMapping("/listOrders")
    public ResponseEntity<List<Order>> listOrders(){
        List<Order> orders = new ArrayList<>();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<Order> getOrder(@RequestParam("orderNumber") long orderNumber){
        Order order = new Order();
        return new ResponseEntity<>(order, HttpStatus.OK);

    }

    @PostMapping("/postOrder")
    public ResponseEntity<Order> postOrder(@RequestBody Order order){
        Order orderAdded = new Order();
        return new ResponseEntity<>(orderAdded, HttpStatus.OK);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        Order orderUpdated = new Order();
        return new ResponseEntity<>(orderUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrder")
    public ResponseEntity<Void> deleteOrder(@RequestParam("orderNumber") long orderNumber){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
