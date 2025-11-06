package servlet;

import modelos.Producto;
import services.ProductoServices;
import services.ProductosServicesImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/*
 * Servlet que genera un archivo Excel con el listado de productos.

 */
@WebServlet({"/productos.xls"})

public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoServices services=new ProductosServicesImplement();
        List<Producto>productos= services.Listar();
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = resp.getWriter()){
            //CREAR PLANTILLA HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de productos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de productos</h1>");
            out.println("<table >");
            out.println("<tr>");
            out.println("<th>ID PRODUCTO</th>");
            out.println("<th>NOMBRE</th>");
            out.println("<th>PRECIO</th>");
            out.println("<th>TIPO</th>");
            out.println("</tr>");
            productos.forEach(p->{
                out.println("<tr>");
                out.println("<td>"+p.getIdProducto()+"</td>");
                out.println("<td>"+p.getNombre()+"</td>");
                out.println("<td>"+p.getPrecio()+"</td>");
                out.println("<td>"+p.getTipo()+"</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
