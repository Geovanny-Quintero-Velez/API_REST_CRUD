package icesi.edu.SID.SistemaVentas.services.Impl;

import icesi.edu.SID.SistemaVentas.models.CategoryProduct;
import icesi.edu.SID.SistemaVentas.repositories.CategoryProductRepository;
import icesi.edu.SID.SistemaVentas.services.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {

    private final CategoryProductRepository categoryProductRepository;

    @Autowired
    public CategoryProductServiceImpl(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }

    @Override
    public List<CategoryProduct> getAllCategories() {
        return categoryProductRepository.findAll();
    }

    @Override
    public CategoryProduct getCategoryById(Long id) {
        Optional<CategoryProduct> optionalCategoryProduct = categoryProductRepository.findById(id);
        return optionalCategoryProduct.orElse(null);
    }

    @Override
    public CategoryProduct createCategory(CategoryProduct categoryProduct) {
        // Puedes realizar validaciones u operaciones adicionales antes de guardar en la base de datos
        return categoryProductRepository.save(categoryProduct);
    }

    @Override
    public CategoryProduct updateCategory(Long id, CategoryProduct categoryProduct) {
        Optional<CategoryProduct> optionalCategoryProduct = categoryProductRepository.findById(id);

        if (optionalCategoryProduct.isPresent()) {
            CategoryProduct existingCategoryProduct = optionalCategoryProduct.get();
            existingCategoryProduct.setDescription(categoryProduct.getDescription());
            // Actualiza otros campos según sea necesario

            // Guarda los cambios en la base de datos
            return categoryProductRepository.save(existingCategoryProduct);
        }

        return null; // Manejar el caso donde no se encuentra la categoría con el ID proporcionado
    }

    @Override
    public void deleteCategory(Long id) {
        categoryProductRepository.deleteById(id);
    }
}