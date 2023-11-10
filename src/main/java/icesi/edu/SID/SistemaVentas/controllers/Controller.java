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

import icesi.edu.SID.SistemaVentas.models.CategoryProduct;
import icesi.edu.SID.SistemaVentas.models.Customer;
import icesi.edu.SID.SistemaVentas.models.Order;
import icesi.edu.SID.SistemaVentas.models.OrderDetail;
import icesi.edu.SID.SistemaVentas.models.Product;
import icesi.edu.SID.SistemaVentas.services.CategoryProductService;
import icesi.edu.SID.SistemaVentas.services.CustomerService;
import icesi.edu.SID.SistemaVentas.services.OrderDetailService;
import icesi.edu.SID.SistemaVentas.services.OrderService;
import icesi.edu.SID.SistemaVentas.services.ProductService;

public class Controller {
    
    private CategoryProductService categoryProductService;
    private CustomerService customerService;
    private OrderDetailService orderDetailService;
    private OrderService orderService;
    private ProductService productService;

    public Controller(){

    }

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
