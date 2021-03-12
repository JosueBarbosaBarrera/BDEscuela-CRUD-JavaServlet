
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumnos;
import modelo.AlumnosDAO;

@WebServlet(name = "AlumnosController", urlPatterns = {"/AlumnosController"})
public class AlumnosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("Alumnos/index.jsp");
            List<Alumnos> listaAlumnos = alumnosDAO.listarAlumnos();
            request.setAttribute("lista", listaAlumnos);
        }else if("nuevo".equals(accion)){
            dispatcher = request.getRequestDispatcher("Alumnos/nuevo.jsp");
        }else if("insertar".equals(accion)){
            
            int nc = Integer.parseInt(request.getParameter("nc"));
            String nombre = request.getParameter("nombre");
            String domicilio = request.getParameter("domicilio");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            
            Alumnos alumno = new Alumnos(0, nc, nombre, domicilio, telefono);
            
            alumnosDAO.insertar(alumno);
            
            dispatcher = request.getRequestDispatcher("Alumnos/index.jsp");
            List<Alumnos> listaAlumnos = alumnosDAO.listarAlumnos();
            request.setAttribute("lista", listaAlumnos);
        }else if("modificar".equals(accion)){
            dispatcher = request.getRequestDispatcher("Alumnos/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Alumnos alumno = alumnosDAO.mostrarAlumno(id);
            request.setAttribute("alumno", alumno);
            
        }else if("actualizar".equals(accion)){
            
            int id = Integer.parseInt(request.getParameter("id"));
            int nc = Integer.parseInt(request.getParameter("nc"));
            String nombre = request.getParameter("nombre");
            String domicilio = request.getParameter("domicilio");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            
            Alumnos alumno = new Alumnos(id, nc, nombre, domicilio, telefono);
            
            alumnosDAO.actualizar(alumno);
            
            dispatcher = request.getRequestDispatcher("Alumnos/index.jsp");
            List<Alumnos> listaAlumnos = alumnosDAO.listarAlumnos();
            request.setAttribute("lista", listaAlumnos);
        }else if("eliminarar".equals(accion)){
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            alumnosDAO.eliminar(id);
            
            dispatcher = request.getRequestDispatcher("Alumnos/index.jsp");
            List<Alumnos> listaAlumnos = alumnosDAO.listarAlumnos();
            request.setAttribute("lista", listaAlumnos);
        }else{
            dispatcher = request.getRequestDispatcher("Alumnos/index.jsp");
            List<Alumnos> listaAlumnos = alumnosDAO.listarAlumnos();
            request.setAttribute("lista", listaAlumnos);
        }
        
        dispatcher.forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
