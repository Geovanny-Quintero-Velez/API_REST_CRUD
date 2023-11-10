package icesi.edu.SID.SistemaVentas.controllers;

import java.util.List;

import icesi.edu.SID.SistemaVentas.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import icesi.edu.SID.SistemaVentas.services.Impl.*;

@RestController
@RequestMapping("/")
public class Controller {
    
    private CategoryProductServiceImpl categoryProductService;
    private CustomerServiceImpl customerService;
    private OrderDetailServiceImpl orderDetailService;
    private OrderServiceImpl orderService;
    private ProductServiceImpl productService;
    private CustomerDetailsServiceImpl customerDetailsService;

    @Autowired
    public Controller(CategoryProductServiceImpl categoryProductService, CustomerServiceImpl customerService,
                      OrderDetailServiceImpl orderDetailService, OrderServiceImpl orderService,
                      ProductServiceImpl productService, CustomerDetailsServiceImpl customerDetailsService) {
        this.categoryProductService = categoryProductService;
        this.customerService = customerService;
        this.orderDetailService = orderDetailService;
        this.orderService = orderService;
        this.productService = productService;
        this.customerDetailsService = customerDetailsService;
    }

    // Métodos para la entidad CategoryProduct
    @GetMapping("/categories")
    public List<CategoryProduct> getAllCategories() {
        return categoryProductService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public CategoryProduct getCategoryById(@PathVariable Long id) {
        return categoryProductService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public CategoryProduct createCategory(@RequestBody CategoryProduct categoryProduct) {
        return categoryProductService.createCategory(categoryProduct);
    }

    @PutMapping("/categories/{id}")
    public CategoryProduct updateCategory(@PathVariable Long id, @RequestBody CategoryProduct categoryProduct) {
        return categoryProductService.updateCategory(id, categoryProduct);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryProductService.deleteCategory(id);
    }

    // Métodos para la entidad Customer
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    // Métodos para la entidad OrderDetail
    @GetMapping("/orderdetails")
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    @GetMapping("/orderdetails/{orderId}/{productId}")
    public OrderDetail getOrderDetailById(@PathVariable Long orderId, @PathVariable Long productId) {
        OrderDetailId orderDetailId = new OrderDetailId(orderId, productId);
        return orderDetailService.getOrderDetailById(orderDetailId);
    }

    @PostMapping("/orderdetails")
    public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.createOrderDetail(orderDetail);
    }

    @PutMapping("/orderdetails/{orderId}/{productId}")
    public OrderDetail updateOrderDetail(@PathVariable Long orderId, @PathVariable Long productId, @RequestBody OrderDetail orderDetail) {
        OrderDetailId orderDetailId = new OrderDetailId(orderId, productId);
        return orderDetailService.updateOrderDetail(orderDetailId, orderDetail);
    }

    @DeleteMapping("/orderdetails/{orderId}/{productId}")
    public void deleteOrderDetail(@PathVariable Long orderId, @PathVariable Long productId) {
        OrderDetailId orderDetailId = new OrderDetailId(orderId, productId);
        orderDetailService.deleteOrderDetail(orderDetailId);
    }

    // Métodos para la entidad Order
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    // Métodos para la entidad Product
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Métodos para la entidad CustomerDetails
    @GetMapping("/customerdetails")
    public List<CustomerDetails> getAllCustomerDetails() {
        return customerDetailsService.getAllCustomerDetails();
    }

    @GetMapping("/customerdetails/{id}")
    public CustomerDetails getCustomerDetailsById(@PathVariable String id) {
        return customerDetailsService.getCustomerDetailsById(id);
    }

    @PostMapping("/customerdetails")
    public CustomerDetails createCustomerDetails(@RequestBody CustomerDetails customerDetails) {
        return customerDetailsService.createCustomerDetails(customerDetails);
    }

    @PutMapping("/customerdetails/{id}")
    public CustomerDetails updateCustomerDetails(@PathVariable String id, @RequestBody CustomerDetails customerDetails) {
        return customerDetailsService.updateCustomerDetails(id, customerDetails);
    }

    @DeleteMapping("/customerdetails/{id}")
    public void deleteCustomerDetails(@PathVariable String id) {
        customerDetailsService.deleteCustomerDetails(id);
    }

}
