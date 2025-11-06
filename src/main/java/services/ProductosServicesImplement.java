package services;

import modelos.Producto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
/*

 */
public class ProductosServicesImplement implements services.ProductoServices {
    @Override
    public List<Producto> Listar() {
        return Arrays.asList(new Producto(1L,"laptop",253.0,"electronico"),
                new Producto(2L,"mouse",23.5,"electronico"),
                new Producto(3L,"teclado",45.6,"electronico"),
                new Producto(4L,"monitor",123.9,"electronico"));
    }
}
