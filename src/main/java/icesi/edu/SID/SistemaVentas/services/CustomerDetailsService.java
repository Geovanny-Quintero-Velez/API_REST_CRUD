package icesi.edu.SID.SistemaVentas.services;

import icesi.edu.SID.SistemaVentas.models.CustomerDetails;

public interface CustomerDetailsService {
    CustomerDetails getCustomerDetailsById(String id);
    CustomerDetails createCustomerDetails(CustomerDetails customerDetails);
    CustomerDetails updateCustomerDetails(String id, CustomerDetails customerDetails);
    void deleteCustomerDetails(String id);
}
