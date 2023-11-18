package icesi.edu.SID.SistemaVentas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import icesi.edu.SID.SistemaVentas.models.postgres.Cliente;
import icesi.edu.SID.SistemaVentas.models.postgres.Producto;
import icesi.edu.SID.SistemaVentas.models.postgres.Categoria;
import icesi.edu.SID.SistemaVentas.repositories.CategoriaRepository;
import icesi.edu.SID.SistemaVentas.repositories.ClienteRepository;
import icesi.edu.SID.SistemaVentas.repositories.ProductoRepository;

import javax.annotation.PostConstruct;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.sql.Date;

@Component
public class DataInitializer {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @PostConstruct
    public void init() {
        Categoria categoria1 = new Categoria(1L, "Ropa");
        Categoria categoria2 = new Categoria(2L, "Electrónicos");
        Categoria categoria3 = new Categoria(3L, "Aseo");
        Categoria categoria4 = new Categoria(4L, "Comida");

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4));

        Categoria ropa = categoriaRepository.findById(1L).orElseThrow();
        Categoria electronicos = categoriaRepository.findById(2L).orElseThrow();
        Categoria aseo = categoriaRepository.findById(3L).orElseThrow();
        Categoria comida = categoriaRepository.findById(4L).orElseThrow();

        Producto producto1 = new Producto(101L, electronicos, "Teléfono", 10L, 200.0, 300.0);
        Producto producto2 = new Producto(102L, ropa, "Camiseta", 50L, 20.0, 40.0);
        Producto producto3 = new Producto(103L, electronicos, "Laptop", 5L, 800.0, 1200.0);
        Producto producto4 = new Producto(104L, ropa, "Pantalón", 30L, 25.0, 50.0);
        Producto producto5 = new Producto(105L, electronicos, "Tablet", 8L, 150.0, 250.0);
        Producto producto6 = new Producto(106L, ropa, "Zapatos", 20L, 40.0, 80.0);
        Producto producto7 = new Producto(107L, aseo, "Jabón", 20L, 4.0, 9.0);
        Producto producto8 = new Producto(108L, comida, "Arroz", 20L, 8.0, 13.0);

        productoRepository.saveAll(Arrays.asList(producto1, producto2, producto3, producto4, producto5, producto6, producto7, producto8));

        // Crear clientes de ejemplo y guardarlos en el repositorio al iniciar la aplicación
        Cliente cliente1 = new Cliente(1L, "Nombre1", "Apellido1", "Dirección1", dateParser("1990-11-17"), "correo1@example.com", "1234567890");
        Cliente cliente2 = new Cliente(2L, "Nombre2", "Apellido2", "Dirección2", dateParser("1998-06-21"), "correo2@example.com", "9876543210");
        
        // Guardar los clientes en el repositorio
        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        
    }

    /**
     * This method parses a String to an SQL Date so it matches with the type of data of Client
     * @param date, String, this is a string that contains a date in the form yyyy-MM-dd
     * @return Date (from java.sql.Date)
     */
    private Date dateParser(String date){
        try {
            // Formato de la fecha en el String
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

            // Parsear el String a un objeto java.util.Date
            java.util.Date utilDate = formatoFecha.parse(date);

            // Convertir el java.util.Date a java.sql.Date
            Date sqlDate = new Date(utilDate.getTime());

            // Imprimir el resultado
            return sqlDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}