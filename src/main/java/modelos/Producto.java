package modelos;
/**
 * Author = Francisco Escobar
 * Fecha = 06/11/2025
 * Representa un producto simple con identificador, nombre, tipo y precio.
 *
 * Esta clase es un POJO usado por los servlets y
 * servicios del ejemplo para transferir información de productos.
 */
public class Producto {

    // Identificador del producto
    private Long id;

    // Nombre descriptivo del producto.
    private String nombre;

    // Tipo o categoría del producto.
    private String tipo;

    // Precio unitario del producto. Se usa double por simplicidad en el ejemplo.
    private double precio;

    // Constructor por defecto necesario para frameworks y serialización.
    public Producto() {
    }

    // Constructor de conveniencia para crear instancias con todos los campos.
    public Producto(Long id, String nombre, String tipo, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    /**
     * Devuelve el id del producto.
     * @return id del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del producto.
     * @param id identificador a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del producto.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del producto.
     * @param nombre nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el tipo/categoría del producto.
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna el tipo/categoría del producto.
     * @param tipo tipo a asignar
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve el precio del producto.
     * @return precio (double)
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Asigna el precio del producto.
     * @param precio precio a asignar
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
