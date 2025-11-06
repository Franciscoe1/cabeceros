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

// **ASIGNAR EL MAPEO FALTANTE:**
@WebServlet("/productojson")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImplement();
        List<Producto> productos = service.listar();

        // 1. Establecer el Content Type para JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            // 2. Convertir la lista de Productos a una cadena JSON
            // (Necesitas una librería como Gson para hacer esto fácilmente)
            // String json = new Gson().toJson(productos);

            // **Ejemplo simple sin librería (solo para demostrar el mapeo):**
            out.println("[");
            for (int i = 0; i < productos.size(); i++) {
                Producto p = productos.get(i);
                out.println("  {");
                out.println("    \"id\": " + p.getId() + ",");
                out.println("    \"nombre\": \"" + p.getNombre() + "\",");
                out.println("    \"tipo\": \"" + p.getTipo() + "\",");
                out.println("    \"precio\": " + p.getPrecio());
                out.println("  }" + (i < productos.size() - 1 ? "," : ""));
            }
            out.println("]");
        }
    }
}