package services;

import modelos.Producto;
import java.util.List;
/**
 * Author = Francisco Escobar
 * Fecha = 06/11/2025
 * Interfaz que define las operaciones sobre productos que el ejemplo expone.
 *
 */
public interface ProductoService {
    /**
     * Devuelve los productos disponibles.
     *
     * @return lista de {@link Producto} (no nula; puede estar vacía)
     */
    List<Producto> listar();
}
