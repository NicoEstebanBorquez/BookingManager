package clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventanas.InfoReserva;

public class BD {

    public void altaAlojamiento(int ID, String nombre, String propietario, String direccion, int capacidad, int dormitorios,
            int baños, String terraza, String piscina, String aparcamiento, int usuario) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            
            PreparedStatement pst = cn.prepareStatement("INSERT INTO alojamientos VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, ID);
            pst.setString(2, nombre);
            pst.setString(3, propietario);
            pst.setString(4, direccion);
            pst.setInt(5, capacidad);
            pst.setInt(6, dormitorios);
            pst.setInt(7, baños);
            pst.setString(8, terraza);
            pst.setString(9, piscina);
            pst.setString(10, aparcamiento);
            pst.setInt(11, usuario);
            pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaCliente(int ID, String nombre, String apellidos, String DNI, String pasaporte, String nacionalidad, int telefono, String email, int usuario) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, ID);
            pst.setString(2, nombre);
            pst.setString(3, apellidos);
            pst.setString(4, DNI);
            pst.setString(5, pasaporte);
            pst.setString(6, nacionalidad);
            pst.setInt(7, telefono);
            pst.setString(8, email);
            pst.setInt(9, usuario);
            pst.executeUpdate();

            pst.close();
            cn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaReserva(int ID, java.sql.Date fecha, java.sql.Date entrada, java.sql.Date salida, Double precio, String alojamiento, int cliente, int usuario) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("INSERT INTO reservas VALUES (?,?,?,?,?,?,?,?)");
            pst.setInt(1, ID);
            pst.setDate(2, fecha);
            pst.setDate(3, entrada);
            pst.setDate(4, salida);
            pst.setDouble(5, precio);
            pst.setString(6, alojamiento);
            pst.setInt(7, cliente);
            pst.setInt(8, usuario);
            pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int obtenerIDusuario(String nombre, String apellidos) {

        int ID = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT id_usuario FROM usuarios WHERE nombre=? AND apellidos=?");
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ID = rs.getInt(1);
            }
            pst.close();
            rs.close();
            cn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID;
    }

    public String[] obtenerInfoCliente(int ID) {

        String[] info = new String[7];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT nombre, apellidos, DNI, pasaporte, nacionalidad, telefono, email FROM clientes WHERE id_cliente = ?");
            pst.setInt(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                info[0] = rs.getString(1); //nombre
                info[1] = rs.getString(2); //apellidos, 
                info[2] = rs.getString(3); //DNI
                info[3] = rs.getString(4); //pasaporte
                info[4] = rs.getString(5); //nacionalidad
                info[5] = rs.getString(6); //telefono
                info[6] = rs.getString(7); //email
            }
            pst.close();
            rs.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }

    public String[] obtenerInfoAlojamiento(String ID) {

        String[] info = new String[9];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT nombre, propietario, direccion, plazas, dormitorios, baños, terraza, piscina, aparcamiento FROM alojamientos WHERE id_alojamiento = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                info[0] = rs.getString(1); //nombre
                info[1] = rs.getString(2); //propietario, 
                info[2] = rs.getString(3); //direccion
                info[3] = rs.getString(4); //plazas
                info[4] = rs.getString(5); //dormitorios
                info[5] = rs.getString(6); //baños
                info[6] = rs.getString(7); //terraza
                info[7] = rs.getString(8); //piscina
                info[8] = rs.getString(9); //aparcamiento
            }
            pst.close();
            rs.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }

    public String[] obtenerInfoReserva(int ID) {

        String[] info = new String[6];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT fecha_confirmacion, entrada, salida, precio, id_alojamiento, id_cliente FROM reservas WHERE id_reserva = ?");
            pst.setInt(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                info[0] = rs.getString(1); //fecha
                info[1] = rs.getString(2); //entrada 
                info[2] = rs.getString(3); //salida
                info[3] = rs.getString(4); //precio
                info[4] = rs.getString(5); //alojamiento
                info[5] = rs.getString(6); //cliente
            }
            pst.close();
            rs.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }

    public String obtenerNombreAlojamiento(String ID) {

        String nombre_alojamiento = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT nombre FROM alojamientos WHERE id_alojamiento = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre_alojamiento = rs.getString(1);
            }

            pst.close();
            rs.close();
            cn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InfoReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InfoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre_alojamiento;
    }

    public String obtenerNombreCliente(String ID) {

        String nombre_cliente = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT nombre, apellidos FROM clientes WHERE id_cliente = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre_cliente = rs.getString(1) + " " + rs.getString(2);
            }

            pst.close();
            rs.close();
            cn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InfoReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InfoReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre_cliente;
    }

    public void modificarAlojamiento(String ID, String nombre, String prop, String direccion, int plazas, int dormitorios, int baños, String terraza, String piscina, String aparcamiento) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE alojamientos SET nombre=?, propietario=?, direccion=?, plazas=?, dormitorios=?, baños=?, terraza=?, piscina=?, aparcamiento=? WHERE id_alojamiento=?");
            pst.setString(1, nombre);
            pst.setString(2, prop);
            pst.setString(3, direccion);
            pst.setInt(4, plazas);
            pst.setInt(5, dormitorios);
            pst.setInt(6, baños);
            pst.setString(7, terraza);
            pst.setString(8, piscina);
            pst.setString(9, aparcamiento);
            pst.setString(10, ID);
            pst.executeUpdate();

            pst.close();
            cn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarCliente(String ID, String nombre, String apellidos, String DNI, String pasaporte, String nacionalidad, String telefono, String email) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE clientes SET nombre=?, apellidos=?, DNI=?, pasaporte=?, nacionalidad=?, telefono=?, email=? WHERE id_cliente=?");
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, DNI);
            pst.setString(4, pasaporte);
            pst.setString(5, nacionalidad);
            pst.setString(6, telefono);
            pst.setString(7, email);
            pst.setString(8, ID);
            pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarReserva(String ID, java.sql.Date entrada, java.sql.Date salida, Double precio) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE reservas SET entrada=?, salida=?, precio=? WHERE id_reserva=?");

            pst.setDate(1, entrada);
            pst.setDate(2, salida);
            pst.setDouble(3, precio);
            pst.setString(4, ID);
            pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int obtenerSiguienteIDAlojamiento(){
        
        String maxID = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            
            PreparedStatement pst = cn.prepareStatement("SELECT MAX(id_alojamiento) FROM `alojamientos`");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                maxID = rs.getString(1);
            }
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return Integer.parseInt(maxID)+1;
    }
    
    public int obtenerSiguienteIDCliente(){
        
        String maxID = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            
            PreparedStatement pst = cn.prepareStatement("SELECT MAX(id_cliente) FROM `clientes`");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                maxID = rs.getString(1);
            }
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(maxID)+1;
    }
    
    public int obtenerSiguienteIDReserva(){
        
        String maxID = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            
            PreparedStatement pst = cn.prepareStatement("SELECT MAX(id_reserva) FROM `reservas`");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                maxID = rs.getString(1);
            }
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(maxID)+1;
    }
}
