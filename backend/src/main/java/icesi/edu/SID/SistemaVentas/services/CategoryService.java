package icesi.edu.SID.SistemaVentas.services;

import java.util.*;

import icesi.edu.SID.SistemaVentas.models.postgres.Categoria;

public interface CategoryService {

    public List<Categoria> obtenerTodosLasCategorias();
} 
