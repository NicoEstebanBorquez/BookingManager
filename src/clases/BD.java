package clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventanas.InfoReserva;

public class BD {

    public int altaAlojamiento(Alojamiento alojamiento) {

        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("INSERT INTO alojamientos VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, "");
            pst.setString(2, alojamiento.getNombre());
            pst.setString(3, alojamiento.getDireccion());
            pst.setInt(4, alojamiento.getPlazas());
            pst.setInt(5, alojamiento.getDormitorios());
            pst.setInt(6, alojamiento.getBaños());
            pst.setString(7, alojamiento.getTerraza());
            pst.setString(8, alojamiento.getPiscina());
            pst.setString(9, alojamiento.getAparcamiento());
            pst.setInt(10, alojamiento.getId_usuario());
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public int altaCliente(Cliente cliente) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, 0);
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellidos());
            pst.setString(4, cliente.getDni());
            pst.setString(5, cliente.getPasaporte());
            pst.setString(6, cliente.getNacionalidad());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());
            pst.setInt(9, cliente.getId_usuario());
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public int altaReserva(Reserva reserva) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("INSERT INTO reservas VALUES (?,?,?,?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setDate(2, reserva.getFecha_confirmacion());
            pst.setDate(3, reserva.getEntrada());
            pst.setDate(4, reserva.getSalida());
            pst.setDouble(5, reserva.getPrecio());
            pst.setInt(6, reserva.getId_alojamiento());
            pst.setInt(7, reserva.getId_cliente());
            pst.setInt(8, reserva.getId_usuario());
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
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

    public String obtenerNombreUsuario(String ID) {

        String nombre = "";
        String apellidos = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT nombre, apellidos FROM usuarios WHERE id_usuario=?");
            pst.setString(1, ID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombre = rs.getString(1);
                apellidos = rs.getString(2);
            }
            pst.close();
            rs.close();
            cn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre + " " + apellidos;
    }

    public String[] obtenerInfoCliente(int ID) {

        String[] info = new String[8];

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT nombre, apellidos, DNI, pasaporte, nacionalidad, telefono, email, id_usuario FROM clientes WHERE id_cliente = ?");
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
                info[7] = rs.getString(8); //usuario
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

    public String[] obtenerInfoAlojamiento(int ID) {

        String[] info = new String[9];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT nombre, direccion, plazas, dormitorios, baños, terraza, piscina, aparcamiento, id_usuario FROM alojamientos WHERE id_alojamiento = ?");
            pst.setInt(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                info[0] = rs.getString(1); //nombre
                info[1] = rs.getString(2); //direccion
                info[2] = rs.getString(3); //plazas
                info[3] = rs.getString(4); //dormitorios
                info[4] = rs.getString(5); //baños
                info[5] = rs.getString(6); //terraza
                info[6] = rs.getString(7); //piscina
                info[7] = rs.getString(8); //aparcamiento
                info[8] = rs.getString(9); //usuario
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

        String[] info = new String[7];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT fecha_confirmacion, entrada, salida, precio, id_alojamiento, id_cliente, id_usuario FROM reservas WHERE id_reserva = ?");
            pst.setInt(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                info[0] = rs.getString(1); //fecha
                info[1] = rs.getString(2); //entrada 
                info[2] = rs.getString(3); //salida
                info[3] = rs.getString(4); //precio
                info[4] = rs.getString(5); //alojamiento
                info[5] = rs.getString(6); //cliente
                info[6] = rs.getString(7); //usuario
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

    public int modificarAlojamiento(Alojamiento alojamiento) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE alojamientos SET nombre=?, direccion=?, plazas=?, dormitorios=?, baños=?, terraza=?, piscina=?, aparcamiento=? WHERE id_alojamiento=?");
            pst.setString(1, alojamiento.getNombre());
            pst.setString(2, alojamiento.getDireccion());
            pst.setInt(3, alojamiento.getPlazas());
            pst.setInt(4, alojamiento.getDormitorios());
            pst.setInt(5, alojamiento.getBaños());
            pst.setString(6, alojamiento.getTerraza());
            pst.setString(7, alojamiento.getPiscina());
            pst.setString(8, alojamiento.getAparcamiento());
            pst.setInt(9, alojamiento.getId_alojamiento());
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public int modificarCliente(Cliente cliente) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE clientes SET nombre=?, apellidos=?, DNI=?, pasaporte=?, nacionalidad=?, telefono=?, email=? WHERE id_cliente=?");
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getDni());
            pst.setString(4, cliente.getPasaporte());
            pst.setString(5, cliente.getNacionalidad());
            pst.setString(6, cliente.getTelefono());
            pst.setString(7, cliente.getEmail());
            pst.setInt(8, cliente.getId_cliente());
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public int modificarReserva(Reserva reserva) {
        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("UPDATE reservas SET entrada=?, salida=?, precio=? WHERE id_reserva=?");

            pst.setDate(1, reserva.getEntrada());
            pst.setDate(2, reserva.getSalida());
            pst.setDouble(3, reserva.getPrecio());
            pst.setInt(4, reserva.getId_reserva());
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public int eliminarAlojamiento(int ID) {

        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("DELETE FROM alojamientos WHERE id_alojamiento = ?");
            pst.setInt(1, ID);
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al eliminar. El alojamiento tiene reservas pendientes.\nException: " + ex);
        }
        return resultado;
    }

    public int eliminarCliente(String ID) {

        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("DELETE FROM clientes WHERE id_cliente = ?");
            pst.setString(1, ID);
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al eliminar. El Cliente tiene reservas pendientes.\nException: " + ex);
        }
        return resultado;
    }

    public int eliminarReserva(String ID) {

        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("DELETE FROM reservas WHERE id_reserva = ?");
            pst.setString(1, ID);
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public int eliminarUsuario(int ID) {

        int resultado = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?");
            pst.setInt(1, ID);
            resultado = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al eliminar. El usuario tiene reservas pendientes.\nException: " + ex);
        }
        return resultado;
    }
}
