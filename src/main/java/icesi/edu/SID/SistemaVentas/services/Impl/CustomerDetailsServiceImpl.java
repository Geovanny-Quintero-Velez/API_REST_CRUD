package icesi.edu.SID.SistemaVentas.services.Impl;

import icesi.edu.SID.SistemaVentas.models.CustomerDetails;
import icesi.edu.SID.SistemaVentas.repositories.CustomerDetailsRepository;
import icesi.edu.SID.SistemaVentas.services.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    public CustomerDetailsServiceImpl(CustomerDetailsRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @Override
    public CustomerDetails getCustomerDetailsById(String id) {
        Optional<CustomerDetails> optionalCustomerDetails = customerDetailsRepository.findById(id);
        return optionalCustomerDetails.orElse(null);
    }

    @Override
    public CustomerDetails createCustomerDetails(CustomerDetails customerDetails) {
        // Puedes realizar validaciones u operaciones adicionales antes de guardar en la base de datos
        return customerDetailsRepository.save(customerDetails);
    }

    @Override
    public CustomerDetails updateCustomerDetails(String id, CustomerDetails customerDetails) {
        Optional<CustomerDetails> optionalCustomerDetails = customerDetailsRepository.findById(id);

        if (optionalCustomerDetails.isPresent()) {
            CustomerDetails existingCustomerDetails = optionalCustomerDetails.get();
            // Actualiza los campos según sea necesario
            existingCustomerDetails.setChildren(customerDetails.getChildren());
            existingCustomerDetails.setBirthplace(customerDetails.getBirthplace());
            existingCustomerDetails.setLocation(customerDetails.getLocation());
            // Actualiza otros campos según sea necesario

            // Guarda los cambios en la base de datos
            return customerDetailsRepository.save(existingCustomerDetails);
        }

        return null; // Manejar el caso donde no se encuentra los detalles del cliente con el ID proporcionado
    }

    @Override
    public List<CustomerDetails> getAllCustomerDetails() {
        return customerDetailsRepository.findAll();
    }

    @Override
    public void deleteCustomerDetails(String id) {
        customerDetailsRepository.deleteById(id);
    }
}