package icesi.edu.SID.SistemaVentas.services.Impl;

import icesi.edu.SID.SistemaVentas.models.Product;
import icesi.edu.SID.SistemaVentas.repositories.ProductRepository;
import icesi.edu.SID.SistemaVentas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        // Puedes realizar validaciones u operaciones adicionales antes de guardar en la base de datos
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            // Actualiza los campos según sea necesario
            existingProduct.setCategory(product.getCategory());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setQuantityAvailable(product.getQuantityAvailable());
            existingProduct.setCost(product.getCost());
            existingProduct.setSellingPrice(product.getSellingPrice());
            // Actualiza otros campos según sea necesario

            // Guarda los cambios en la base de datos
            return productRepository.save(existingProduct);
        }

        return null; // Manejar el caso donde no se encuentra el producto con el ID proporcionado
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}