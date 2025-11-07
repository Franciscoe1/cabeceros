package services;

import modelos.Producto;
import java.util.Arrays;
import java.util.List;
/**
 * Author = Francisco Escobar
 * Fecha = 06/11/2025
 * Implementación simple de la interfaz ProductoService.
 *
 * Esta clase proporciona una implementación en memoria
 * del método listar que devuelve una lista de productos de ejemplo.
 *
 */
public class ProductoServiceImplement implements ProductoService{
    /**
     * Devuelve una lista de productos de ejemplo.
     * @return lista de productos de ejemplo
     */
    @Override
    public List<Producto> listar() {
        // Creamos tres productos de ejemplo.
        Producto p1 = new Producto(1L, "laptop", "computacion", 523.21);
        Producto p2 = new Producto(2L, "Mouse", "inalambrico", 15.25);
        Producto p3 = new Producto(3L, "Impresora", "tinta continua", 256.25);

        // Devolvemos una lista fija con los productos creados.
        // Arrays.asList devuelve una lista soportada por tamaño fijo; si se necesita
        return Arrays.asList(p1, p2, p3);
    }
}

