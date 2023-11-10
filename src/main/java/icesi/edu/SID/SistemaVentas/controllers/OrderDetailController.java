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

import icesi.edu.SID.SistemaVentas.models.Customer;
import icesi.edu.SID.SistemaVentas.models.OrderDetail;
import icesi.edu.SID.SistemaVentas.services.CustomerService;
import icesi.edu.SID.SistemaVentas.services.OrderDetailService;

public class OrderDetailController {
    
    private OrderDetailService service;

    @GetMapping("/listOrderDetail")
    public ResponseEntity<List<OrderDetail>> listOrderDetails(){
        List<OrderDetail> orderDetails = new ArrayList<>();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @GetMapping("/getOrderDetail")
    public ResponseEntity<OrderDetail> getOrderDetail(@RequestParam("orderNumber") long orderNumber, @RequestParam("productId") long productId){
        OrderDetail orderDetail = new OrderDetail();
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);

    }

    @PostMapping("/postOrderDetail")
    public ResponseEntity<OrderDetail> postOrderDetail(@RequestBody OrderDetail orderDetail){
        OrderDetail orderDetailAdded = new OrderDetail();
        return new ResponseEntity<>(orderDetailAdded, HttpStatus.OK);
    }

    @PutMapping("/updateOrderDetail")
    public ResponseEntity<OrderDetail> updateOrderDetail(@RequestBody OrderDetail orderDetail){
        OrderDetail orderDetailUpdated = new OrderDetail();
        return new ResponseEntity<>(orderDetailUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrderDetail")
    public ResponseEntity<Void> deleteOrderDetail(@RequestParam("orderNumber") long orderNumber, @RequestParam("productId") long productId){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
