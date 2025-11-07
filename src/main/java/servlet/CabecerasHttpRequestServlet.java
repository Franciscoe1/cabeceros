package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Author = Francisco Escobar
 * Fecha = 06/11/2025
 * Servlet que muestra información de la petición HTTP: método, URL, cabeceras,
 * dirección IP y otros datos relevantes.
 *
 * Está mapeado en /cabeceros-request y sirve para depuración y para
 * ilustrar cómo acceder a datos de la petición mediante HttpServletRequest.
 */
@WebServlet("/cabeceros-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Establecemos el tipo de contenido y la codificación para la respuesta HTML.
        resp.setContentType("text/html;charset=UTF-8");

        // Obtenemos información de la petición usando los métodos del HttpServletRequest.
        String metodoHttp = req.getMethod(); // GET, POST, etc.
        String requestUri = req.getRequestURI(); // /context/servlet
        String requestUrl = req.getRequestURL().toString(); // URL completa construida por el contenedor
        String contextPath = req.getContextPath(); // Context path de la aplicación
        String servletPath = req.getServletPath(); // Path del servlet
        String ip= req.getLocalAddr(); // IP local del servidor
        int port = req.getLocalPort(); // Puerto del servidor
        String scheme = req.getScheme(); // http o https
        String host = req.getHeader("host"); // cabecera Host enviada por el cliente
        // Construimos dos formas de URL para mostrar diferencias entre usar host y usar ip local.
        String url=scheme+"://"+host+":"+contextPath+servletPath;
        String url2=scheme+"://"+ip+":"+port+contextPath+servletPath;
        String ipCLiente=req.getRemoteAddr(); // IP del cliente que hizo la petición

        try (PrintWriter out = resp.getWriter()) {
            // Construimos una respuesta HTML básica con los datos obtenidos.
            out.print("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>Cabeceras Http Request</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");
            out.println("<li>Obtenniendo el método"+ metodoHttp+"</li>");
            out.println("<li>Request uri: "+ requestUri +"</li>");
            out.println("<li>Request url: "+ requestUrl+"</li>");
            out.println("<li>Context Path: "+ contextPath+"</li>");
            out.println("<li>Servlet Path: "+ servletPath+ "</li>");
            out.println("<li>IP "+ ip +"</li>");
            out.println("<li>Port :"+port+"</li>");
            out.println("<li>Scheme :"+ scheme+"</li>");
            out.println("<li>Host :"+ host+"</li>");
            out.println("<li>URL :"+ url+"</li>");
            out.println("<li>URL2 :"+ url2+"</li>");
            out.println("<li>REMOTE CLIENTE :"+ ipCLiente+"</li>");

            // Recorremos todas las cabeceras y las mostramos en la lista.
            Enumeration<String> headerNames=req.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String cabecera = headerNames.nextElement();
                // Cada cabecera se imprime con su valor obtenido de la request.
                out.println("<li>" +cabecera + ": " +req.getHeader(cabecera)+"</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
