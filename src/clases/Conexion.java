package clases;

import java.sql.*;


public class Conexion {
    
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            return cn;
        }catch(SQLException e){
            System.out.println("Error en la conexión con la BD " + e);
        }
        return(null);
    }
    
}
