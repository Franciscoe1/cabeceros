package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Producto;
import services.ProductoService;
import services.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Author = Francisco Escobar
 * Fecha = 06/11/2025
 * Servlet que expone la lista de productos en formato JSON.
 *
 * Mapeado en productojson.
 */
@WebServlet("/productojson")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtenemos el servicio que proporciona los productos.
        ProductoService service = new ProductoServiceImplement();
        List<Producto> productos = service.listar();

        // 1. Establecer el Content Type para JSON y la codificación.
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            // 2. Convertir la lista de Productos a una cadena JSON.
            // En este ejemplo construimos manualmente el JSON. Puntos a considerar:
            // - No se escapan caracteres especiales en strings ("\n", comillas, etc.).
            // - Los nulls y tipos complejos deben manejarse correctamente.
            // - Usar Gson/Jackon evita estos problemas y simplifica el código.

            out.println("[");
            for (int i = 0; i < productos.size(); i++) {
                Producto p = productos.get(i);
                out.println("  {");
                out.println("    \"id\": " + p.getId() + ",");
                out.println("    \"nombre\": \"" + p.getNombre() + "\",");
                out.println("    \"tipo\": \"" + p.getTipo() + "\",");
                out.println("    \"precio\": " + p.getPrecio());
                // Si no es el último elemento agregamos la coma para seguir el formato JSON.
                out.println("  }" + (i < productos.size() - 1 ? "," : ""));
            }
            out.println("]");
        }
    }
}