package icesi.edu.SID.SistemaVentas.services;

import icesi.edu.SID.SistemaVentas.models.CustomerDetails;

import java.util.List;

public interface CustomerDetailsService {
    CustomerDetails getCustomerDetailsById(String id);
    CustomerDetails createCustomerDetails(CustomerDetails customerDetails);
    CustomerDetails updateCustomerDetails(String id, CustomerDetails customerDetails);
    List<CustomerDetails> getAllCustomerDetails();
    void deleteCustomerDetails(String id);
}
