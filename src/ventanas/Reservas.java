package ventanas;

import clases.BD;
import java.awt.Color;
import java.awt.Image;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static ventanas.Clientes.cliente;

public class Reservas extends javax.swing.JFrame {

    //Variable que contiene el cliente seleccionado
    public static int reserva;

    //Permite acceder a los metodos necesarios para añadir filas, columnas, dar nombre a las columnas, etc.
    DefaultTableModel modelo = new DefaultTableModel();

    public Reservas() {
        initComponents();

        setSize(970, 700);
        setResizable(false);
        setTitle("Bookings");
        setLocationRelativeTo(null);

        //Impide que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Obtener listado de reservas
        listadoReservas();

        //Imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_reservas = new javax.swing.JTable();
        btn_nuevaReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDate_desde = new com.toedter.calendar.JDateChooser();
        jDate_hasta = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_buscarAlojamiento = new javax.swing.JButton();
        btn_buscarFechas = new javax.swing.JButton();
        txt_alojamientoBusqueda = new javax.swing.JTextField();
        btn_verTodas = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_reservas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_reservas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 871, 220));

        btn_nuevaReserva.setBackground(new java.awt.Color(29, 33, 123));
        btn_nuevaReserva.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btn_nuevaReserva.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevaReserva.setText("Add new booking");
        btn_nuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaReservaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevaReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 590, -1, -1));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 33, 123));
        jLabel1.setText("Bookings:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 33, 123));
        jLabel2.setText("Accommodation:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 285, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 33, 123));
        jLabel3.setText("From:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 33, 123));
        jLabel4.setText("To:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 195, -1, -1));

        jDate_desde.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        getContentPane().add(jDate_desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 150, 30));

        jDate_hasta.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        getContentPane().add(jDate_hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 195, 150, 30));

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 33, 123));
        jLabel5.setText("Search by accommodation ID:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 33, 123));
        jLabel6.setText("Search by Check-In date:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 125, -1, -1));

        btn_buscarAlojamiento.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscarAlojamiento.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btn_buscarAlojamiento.setForeground(new java.awt.Color(29, 33, 123));
        btn_buscarAlojamiento.setText("Search");
        btn_buscarAlojamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarAlojamientoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscarAlojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        btn_buscarFechas.setBackground(new java.awt.Color(255, 255, 255));
        btn_buscarFechas.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btn_buscarFechas.setForeground(new java.awt.Color(29, 33, 123));
        btn_buscarFechas.setText("Search");
        btn_buscarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarFechasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscarFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        txt_alojamientoBusqueda.setBackground(new java.awt.Color(240, 240, 240));
        txt_alojamientoBusqueda.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        txt_alojamientoBusqueda.setForeground(new java.awt.Color(29, 33, 123));
        txt_alojamientoBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_alojamientoBusqueda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_alojamientoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 285, 100, -1));

        btn_verTodas.setBackground(new java.awt.Color(255, 255, 255));
        btn_verTodas.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btn_verTodas.setForeground(new java.awt.Color(29, 33, 123));
        btn_verTodas.setText("Show all bookings");
        btn_verTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verTodasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_verTodas, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaReservaActionPerformed
        NuevaReserva nr = new NuevaReserva();
        nr.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btn_nuevaReservaActionPerformed

    private void btn_buscarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarFechasActionPerformed
        int validacion = 0;
        java.sql.Date desde = new java.sql.Date(1 / 1 / 1);
        java.sql.Date hasta = new java.sql.Date(1 / 1 / 1);

        //Validación fecha de inicio y fin
        Date comprobacionEntrada;
        comprobacionEntrada = jDate_desde.getDate();
        if (comprobacionEntrada == null) {
            validacion++;
        } else {
            // Obtención de fecha de inicio con formato SQL DATE
            Date entrada_input = jDate_desde.getDate();
            long entrada_l = entrada_input.getTime();
            desde = new java.sql.Date(entrada_l);
        }

        Date comprobacionSalida;
        comprobacionSalida = jDate_hasta.getDate();
        if (comprobacionSalida == null) {
            validacion++;
        } else {
            // Obtención de fecha de fin con formato SQL DATE
            Date salida_input = jDate_hasta.getDate();
            long salida_l = salida_input.getTime();
            hasta = new java.sql.Date(salida_l);
        }

        if (validacion > 0) {
            JOptionPane.showMessageDialog(null, "Please complete date fields.", "Empty fields", JOptionPane.WARNING_MESSAGE);
        } else {
            //Consulta a la BD para obtener listado de reservas
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

                PreparedStatement pst = cn.prepareStatement("SELECT id_reserva, fecha_confirmacion, entrada, salida, precio, id_alojamiento, id_cliente FROM reservas "
                        + "WHERE entrada BETWEEN ? AND ? ORDER BY entrada");
                pst.setDate(1, desde);
                pst.setDate(2, hasta);
                ResultSet rs = pst.executeQuery();

                table_reservas = new JTable(modelo);
                jScrollPane1.setViewportView(table_reservas);

                //Alto de filas
                table_reservas.setRowHeight(25);

                //Limpia la tabla
                modelo.setRowCount(0);

                //Añade las reservas del alojamiento indicado
                while (rs.next()) {
                    Object[] fila = new Object[7];

                    for (int i = 0; i < 7; i++) {
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
            obtenerReservaSeleccionada();
        }
    }//GEN-LAST:event_btn_buscarFechasActionPerformed

    private void btn_buscarAlojamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarAlojamientoActionPerformed
        int validacion = 0;

        if (txt_alojamientoBusqueda.getText().equals("")) {
            validacion++;
            txt_alojamientoBusqueda.setBackground(new Color(255, 82, 82));
        }

        if (validacion > 0) {
            JOptionPane.showMessageDialog(null, "Please introduce an accommodation ID.", "Empty field", JOptionPane.WARNING_MESSAGE);
        } else {
            txt_alojamientoBusqueda.setBackground(new Color(240, 240, 240));

            //Consulta a la BD para obtener listado de reservas
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

                PreparedStatement pst = cn.prepareStatement("SELECT id_reserva,fecha_confirmacion, entrada, salida, precio, id_alojamiento, id_cliente FROM reservas WHERE id_alojamiento=? ORDER BY entrada");
                pst.setString(1, txt_alojamientoBusqueda.getText().trim());
                ResultSet rs = pst.executeQuery();

                table_reservas = new JTable(modelo);
                jScrollPane1.setViewportView(table_reservas);

                //Alto de filas
                table_reservas.setRowHeight(25);

                //Limpia la tabla
                modelo.setRowCount(0);

                //Añade las reservas del alojamiento indicado
                while (rs.next()) {
                    Object[] fila = new Object[7];

                    for (int i = 0; i < 7; i++) {
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
            obtenerReservaSeleccionada();
            txt_alojamientoBusqueda.setText("");
        }


    }//GEN-LAST:event_btn_buscarAlojamientoActionPerformed

    private void btn_verTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verTodasActionPerformed

        //Consulta a la BD para obtener listado de reservas
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT id_reserva, fecha_confirmacion, entrada, salida, precio, id_alojamiento, id_cliente FROM reservas ORDER BY entrada");
            ResultSet rs = pst.executeQuery();

            table_reservas = new JTable(modelo);
            jScrollPane1.setViewportView(table_reservas);
            //Alto de filas
            table_reservas.setRowHeight(25);

            //Limpia la tabla
            modelo.setRowCount(0);
            while (rs.next()) {
                Object[] fila = new Object[7];

                for (int i = 0; i < 7; i++) {
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
        obtenerReservaSeleccionada();
    }//GEN-LAST:event_btn_verTodasActionPerformed

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
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscarAlojamiento;
    private javax.swing.JButton btn_buscarFechas;
    private javax.swing.JButton btn_nuevaReserva;
    private javax.swing.JButton btn_verTodas;
    private com.toedter.calendar.JDateChooser jDate_desde;
    private com.toedter.calendar.JDateChooser jDate_hasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_reservas;
    private javax.swing.JTextField txt_alojamientoBusqueda;
    // End of variables declaration//GEN-END:variables

    public void listadoReservas() {
        //Consulta a la BD para obtener listado de reservas
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT id_reserva, fecha_confirmacion, entrada, salida, precio, id_alojamiento, id_cliente FROM reservas ORDER BY entrada");
            ResultSet rs = pst.executeQuery();

            table_reservas = new JTable(modelo);
            jScrollPane1.setViewportView(table_reservas);

            modelo.addColumn("Ref.");
            modelo.addColumn("Booking date");
            modelo.addColumn("Check-In");
            modelo.addColumn("Check-Out");
            modelo.addColumn("Amount (€)");
            modelo.addColumn("Accommodation");
            modelo.addColumn("Customer");

            //Alto de filas
            table_reservas.setRowHeight(25);

            while (rs.next()) {
                Object[] fila = new Object[7];

                for (int i = 0; i < 7; i++) {
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
        obtenerReservaSeleccionada();
    }

    public void verInfoReserva() {

        InfoReserva ir = new InfoReserva();
        ir.setVisible(true);
        this.dispose();
    }

    public void obtenerReservaSeleccionada() {
        //Obtener la reserva seleccionada
        table_reservas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = table_reservas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    reserva = (int) modelo.getValueAt(fila_point, columna_point);
                    verInfoReserva();
                }

            }
        });
    }
;
}
