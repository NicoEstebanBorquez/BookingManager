package ventanas;

import clases.BD;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.Reservas.reserva;

public class NuevaReserva extends javax.swing.JFrame {

    BD bd;
    String nombre_usuario, apellidos_usuario;
    int id_usuario;
    String alojamiento_seleccionado;
    int cliente_seleccionado;
    java.sql.Date fecha_actual;

    //Permite acceder a los metodos necesarios para añadir filas, columnas, dar nombre a las columnas, etc.
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo_clientes = new DefaultTableModel();

    public NuevaReserva() {
        initComponents();
        setSize(1000, 730);
        setResizable(false);
        setTitle("Nueva reserva");
        setLocationRelativeTo(null);

        //Evite que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Objeto BD
        bd = new BD();

        //Obtención de nombre de usuario y apellidos
        nombre_usuario = InicioAdmin.nombre_usuario;
        apellidos_usuario = InicioAdmin.apellidos_usuario;
        label_gestionadoPor.setText(nombre_usuario + " " + apellidos_usuario);
        id_usuario = bd.obtenerIDusuario(nombre_usuario, apellidos_usuario);

        //Obtención de fecha actual
        long fecha_miliseconds = new Date().getTime();
        fecha_actual = new java.sql.Date(fecha_miliseconds);
        label_fechaActual.setText("" + fecha_actual);

        //Consulta a la BD para obtener listado de reservas
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT id_alojamiento, direccion FROM alojamientos");
            ResultSet rs = pst.executeQuery();

            table_alojamientos = new JTable(modelo);
            jScrollPane1.setViewportView(table_alojamientos);

            modelo.addColumn("ID");
            modelo.addColumn("Dirección");

            while (rs.next()) {
                Object[] fila = new Object[2];

                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Obtener el alojamiento seleccionada
        table_alojamientos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = table_alojamientos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    alojamiento_seleccionado = (String) modelo.getValueAt(fila_point, columna_point);
                }
            }
        });

        //Consulta a la BD para obtener listado de clientes
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT id_cliente, nombre, apellidos FROM clientes");
            ResultSet rs = pst.executeQuery();

            table_clientes = new JTable(modelo_clientes);
            jScrollPane3.setViewportView(table_clientes);

            modelo_clientes.addColumn("ID");
            modelo_clientes.addColumn("Nombre");
            modelo_clientes.addColumn("Apellidos");

            while (rs.next()) {
                Object[] fila = new Object[3];

                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo_clientes.addRow(fila);
            }
            pst.close();
            cn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Obtener el cliente seleccionado
        table_clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = table_clientes.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    cliente_seleccionado = (int) modelo_clientes.getValueAt(fila_point, columna_point);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_guardarReserva = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_cliente = new javax.swing.JTextField();
        txt_alojamiento = new javax.swing.JTextField();
        label_gestionadoPor = new javax.swing.JLabel();
        jDate_entrada = new com.toedter.calendar.JDateChooser();
        jDate_salida = new com.toedter.calendar.JDateChooser();
        label_fechaActual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_alojamientos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_clientes = new javax.swing.JTable();
        btn_cancelar = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 33, 123));
        jLabel1.setText("Add new reservation:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));

        jLabel2.setText("ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel3.setText("fecha de reserva:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        jLabel4.setText("Fecha entrada:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel5.setText("Fecha salida:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel6.setText("precio");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel7.setText("Alojamiento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        jLabel8.setText("Cliente:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        btn_guardarReserva.setText("Guardar");
        btn_guardarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarReservaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel10.setText("Realizada por:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, -1, -1));
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 150, -1));
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 150, -1));
        getContentPane().add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 150, -1));
        getContentPane().add(txt_alojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 220, 150, -1));

        label_gestionadoPor.setText("usuario");
        getContentPane().add(label_gestionadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));
        getContentPane().add(jDate_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));
        getContentPane().add(jDate_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        label_fechaActual.setText("Fecha actual");
        getContentPane().add(label_fechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, -1));

        table_alojamientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_alojamientos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 380, 90));

        table_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(table_clientes);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 380, 100));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarReservaActionPerformed

        // Obtención de fechas de entrada y salida con formato DATE
        Date entrada_input = jDate_entrada.getDate();
        Date salida_input = jDate_salida.getDate();

        long entrada_l = entrada_input.getTime();
        long salida_l = salida_input.getTime();

        java.sql.Date entrada = new java.sql.Date(entrada_l);
        java.sql.Date salida = new java.sql.Date(salida_l);
        try {
            bd.altaReserva(
                    Integer.parseInt(txt_id.getText().trim()),
                    fecha_actual,
                    entrada,
                    salida,
                    Double.parseDouble(txt_precio.getText().trim()),//Integer.parseInt(txt_precio.getText().trim())

                    alojamiento_seleccionado,
                    cliente_seleccionado,
                    id_usuario
            );

        } catch (Exception e) {
            System.out.println("EEEEEERROR! " +e);
        }

        this.dispose();
        Reservas r = new Reservas();
        r.setVisible(true);

    }//GEN-LAST:event_btn_guardarReservaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
        Reservas r = new Reservas();
        r.setVisible(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardarReserva;
    private com.toedter.calendar.JDateChooser jDate_entrada;
    private com.toedter.calendar.JDateChooser jDate_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel label_fechaActual;
    private javax.swing.JLabel label_gestionadoPor;
    private javax.swing.JTable table_alojamientos;
    private javax.swing.JTable table_clientes;
    private javax.swing.JTextField txt_alojamiento;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
