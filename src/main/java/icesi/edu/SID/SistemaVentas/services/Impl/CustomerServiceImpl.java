package icesi.edu.SID.SistemaVentas.services.Impl;

import icesi.edu.SID.SistemaVentas.models.Customer;
import icesi.edu.SID.SistemaVentas.repositories.CustomerRepository;
import icesi.edu.SID.SistemaVentas.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        // Puedes realizar validaciones u operaciones adicionales antes de guardar en la base de datos
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            // Actualiza los campos según sea necesario
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setDateOfBirth(customer.getDateOfBirth());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setHomePhone(customer.getHomePhone());
            existingCustomer.setCellPhone(customer.getCellPhone());
            // Actualiza otros campos según sea necesario

            // Guarda los cambios en la base de datos
            return customerRepository.save(existingCustomer);
        }

        return null; // Manejar el caso donde no se encuentra el cliente con el ID proporcionado
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}