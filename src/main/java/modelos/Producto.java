package modelos;
/*
 * Clase modelo para representar un producto.
 */
public class Producto {
    //encapsulamos y declaramos las variables del objeto producto
    private Long  idProducto;
    private String nombre;
    private Double precio;
    private String tipo;
    public Producto() {}
    /*
     * Constructor de la clase Producto.
     * @param idProducto Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param tipo Tipo o categoría del producto.
     */
    public Producto(Long idProducto, String nombre, Double precio, String tipo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }
    /*
     *Getters y Setters de la clase Producto, para acceder y modificar los atributos del producto.
     */

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
