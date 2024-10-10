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
    public List<Estudiante> listar() {
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY idestudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var estudiante = new Estudiante(rs.getByte("idestudiante"), rs.getString("estudiante"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Ocurrión un error al seleccionar datos");
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Ocurrio un error al cerrar la conexión "+ e.getMessage());
            }
        }
        return estudiantes;
    }
    public boolean buscarEstudiantePorId(int id){
        boolean encontrado= false;
        PreparedStatement ps;
        ResultSet rs;
        Connection con = conexion.getConexion();
        String sql = "SELECT * FROM estudiante WHERE idestudiante = "+id;
        try {
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            if (rs!=null){
                System.out.println("El estudiante "+rs+ "Ha sido encontrado");
                encontrado=true;
            }
        }catch (Exception e){
            System.out.println("Error en la busqueda "+ e);
        }

        return encontrado;
    }

    public static void main(String[] args) {
        var estudianteDao= new EstudianteDao();
        //listar estudiantes
        //System.out.println("Listado de estudiantes: ");
        //List<Estudiante> estudiantes=estudianteDao.listar();
        //estudiantes.forEach(System.out::println);
        System.out.println("Buscar estudiante de id 2");
        boolean encontrado= estudianteDao.buscarEstudiantePorId(2);
        System.out.println(encontrado);

    }
}
