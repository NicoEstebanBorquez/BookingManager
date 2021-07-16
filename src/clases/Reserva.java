package clases;
import java.sql.Date;

public class Reserva {

    private int id_reserva;
    private java.sql.Date fecha_confirmacion;
    private Date entrada;
    private Date salida;
    private double precio;
    private int id_alojamiento;
    private int id_cliente;
    private int id_usuario;
    
    public int getId_reserva(){
        return id_reserva;
    }
    
    public void setId_reserva(int id_reserva){
        this.id_reserva = id_reserva;
    }

    public java.sql.Date getFecha_confirmacion() {
        return fecha_confirmacion;
    }

    public void setFecha_confirmacion(java.sql.Date fecha_confirmacion) {
        this.fecha_confirmacion = fecha_confirmacion;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_alojamiento() {
        return id_alojamiento;
    }

    public void setId_alojamiento(int id_alojamiento) {
        this.id_alojamiento = id_alojamiento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
