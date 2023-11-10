package icesi.edu.SID.SistemaVentas.services;

import icesi.edu.SID.SistemaVentas.models.CategoryProduct;

import java.util.List;

public interface CategoryProductService {
    List<CategoryProduct> getAllCategories();
    CategoryProduct getCategoryById(Long id);
    CategoryProduct createCategory(CategoryProduct categoryProduct);
    CategoryProduct updateCategory(Long id, CategoryProduct categoryProduct);
    void deleteCategory(Long id);
}
