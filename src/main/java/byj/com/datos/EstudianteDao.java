package byj.com.datos;

import byj.com.conexion.conexion;
import byj.com.modelo.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {
    public List<Estudiante> listar(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY idestudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var estudiante = new Estudiante(rs.getInt("idestudiante"), rs.getString("estudiante"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Ocurrión un error al seleccionar datos");
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ocurrio un error al cerrar la conexión " + e.getMessage());
            }
        }
        return estudiantes;
    }
    public boolean buscarEstudiantePorId(Estudiante estudiante) {
        boolean encontrado = false;
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM estudiante WHERE idestudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()) {
                encontrado = true;
                estudiante.setNoombre(rs.getString("estudiante"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                System.out.println(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Error en la busqueda " + e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexión " + e.getMessage());
            }
        }
        return encontrado;
    }
    public boolean addEstudiante(Estudiante estudiante) {
        boolean agregado = false;
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conexion.getConexion();
        String sql = "insert into estudiante(estudiante, apellido, telefono, email) values(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,estudiante.getNoombre());
            ps.setString(2,estudiante.getApellido());
            ps.setString(3,estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.execute();
            agregado = true;
            System.out.println("Estudiante agregadado");
        } catch (Exception e) {
            System.out.println("Error al agregar estudiante " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión " + e.getMessage());
            }
        }

        return agregado;
    }
    public boolean actualizarEstudiante(Estudiante estudiante){
        boolean actualizado= false;
        Connection con=conexion.getConexion();
        PreparedStatement ps;
        String sql="update estudiante set estudiante=?,apellido=?,telefono=?, email=? where idestudiante=?";
        try {
         ps=con.prepareStatement(sql);
         ps.setString(1,estudiante.getNoombre());
         ps.setString(2,estudiante.getApellido());
         ps.setString(3,estudiante.getTelefono());
         ps.setString(4,estudiante.getEmail());
         ps.setInt(5,estudiante.getIdEstudiante());
         ps.execute();
         actualizado=true;
        } catch (Exception e) {
            System.out.println("Error al actualizar estudiante "+e.getMessage());
        }
        return actualizado;
    }
    public boolean eliminar(Estudiante estudiante){
        boolean eliminado=false;
        Connection con=conexion.getConexion();
        PreparedStatement ps;
        String sql="delete from estudiante where idestudiante=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,estudiante.getIdEstudiante());
            ps.execute();
            eliminado=true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el estudiante "+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion "+e.getMessage());
            }
        }
        return eliminado;
    }

}
