
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnosDAO {
    
    Connection conexion;
    
    public AlumnosDAO(){
        Conexion con = new Conexion();
        conexion = con.getConnection();
    }
    
    public List<Alumnos> listarAlumnos(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Alumnos> lista = new ArrayList<>();
        
        try {
            ps = conexion.prepareStatement("SELECT id, nc, nombre, domicilio, telefono FROM alumnos");
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                int nc = rs.getInt("nc");
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                int telefono = rs.getInt("telefono");
                
                Alumnos alumno = new Alumnos(id, nc, nombre, domicilio, telefono);
                
                lista.add(alumno);
                        
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Alumnos mostrarAlumno(int _id){
        
        PreparedStatement ps;
        ResultSet rs;
        
        Alumnos alumno = null;
        
        try {
            ps = conexion.prepareStatement("SELECT id, nc, nombre, domicilio, telefono FROM alumnos WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                int nc = rs.getInt("nc");
                String nombre = rs.getString("nombre");
                String domicilio = rs.getString("domicilio");
                int telefono = rs.getInt("telefono");
                
                alumno = new Alumnos(id, nc, nombre, domicilio, telefono);
                        
            }
            return alumno;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }   
    }
    
    public boolean insertar(Alumnos alumno){
        
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("INSERT INTO alumnos (nc, nombre, domicilio, telefono) VALUES (?,?,?,?)");
            ps.setInt(1, alumno.getNc());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getDomicilio());
            ps.setInt(4, alumno.getTelefono());
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean actualizar(Alumnos alumno){
        
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("UPDATE alumnos SET nc=?, nombre=?, domicilio=?, telefono=? WHERE id=?");
            ps.setInt(1, alumno.getNc());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getDomicilio());
            ps.setInt(4, alumno.getTelefono());
            ps.setInt(5, alumno.getId());
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }   
    }
    
    public boolean eliminar(int _id){
        
        PreparedStatement ps;
        
        try {
            ps = conexion.prepareStatement("DELETE FROM alumnos WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }   
    }
}