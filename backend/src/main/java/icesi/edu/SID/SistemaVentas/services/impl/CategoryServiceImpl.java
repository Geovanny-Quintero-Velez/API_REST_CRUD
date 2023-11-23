package icesi.edu.SID.SistemaVentas.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icesi.edu.SID.SistemaVentas.models.postgres.Categoria;
import icesi.edu.SID.SistemaVentas.repositories.CategoriaRepository;
import icesi.edu.SID.SistemaVentas.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerTodosLasCategorias() {
        return categoriaRepository.findAll();
    }
}