package byj.com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static Connection getConexion(){
        Connection conexion=null;
        var bdd= "estudiantes_db";
        var url= "jdbc:mysql://localhost:3306/"+bdd;
        var usuario= "root";
        var password= "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion= DriverManager.getConnection(url,usuario,password);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("ocurrio un error: "+e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        var conexion=getConexion();
        if (conexion!=null){
            System.out.println("¡conexion exitosa!"+conexion);
        }else {
            System.out.println("Error al conectarse");
        }
    }
}
