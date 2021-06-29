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

public class NuevaReserva extends javax.swing.JFrame {

    BD bd;
    String nombre_usuario, apellidos_usuario, alojamiento_seleccionado = "";
    int id_usuario;
    int cliente_seleccionado = 0;
    int IDNuevaReserva = 0;

    java.sql.Date fecha_actual;

    //Permite acceder a los metodos necesarios para añadir filas, columnas, dar nombre a las columnas, etc.
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo_clientes = new DefaultTableModel();

    public NuevaReserva() {
        initComponents();
        setSize(800, 720);
        setResizable(false);
        setTitle("New booking");
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

        //Obtencion del ID del alojamiento desde la BD
        IDNuevaReserva = bd.obtenerSiguienteIDReserva();
        label_id.setText("" + IDNuevaReserva);

        //Obtención de fecha actual
        long fecha_miliseconds = new Date().getTime();
        fecha_actual = new java.sql.Date(fecha_miliseconds);
        label_fechaActual.setText("" + fecha_actual);

        //Consulta a la BD para obtener listado de reservas
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT id_alojamiento, nombre FROM alojamientos");
            ResultSet rs = pst.executeQuery();

            table_alojamientos = new JTable(modelo);
            jScrollPane1.setViewportView(table_alojamientos);

            modelo.addColumn("Ref");
            modelo.addColumn("Name");

            //Alto de filas
            table_alojamientos.setRowHeight(25);
            //Ancho de columnas
            TableColumnModel modeloColumna = table_alojamientos.getColumnModel();
            modeloColumna.getColumn(0).setPreferredWidth(10);
            modeloColumna.getColumn(1).setPreferredWidth(290);

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

            modelo_clientes.addColumn("Ref");
            modelo_clientes.addColumn("First name");
            modelo_clientes.addColumn("Last name");

            //Alto de filas
            table_clientes.setRowHeight(25);
            //Ancho de columnas
            TableColumnModel modeloColumna2 = table_clientes.getColumnModel();
            modeloColumna2.getColumn(0).setPreferredWidth(10);
            modeloColumna2.getColumn(1).setPreferredWidth(80);
            modeloColumna2.getColumn(2).setPreferredWidth(150);

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
        txt_precio = new javax.swing.JTextField();
        label_gestionadoPor = new javax.swing.JLabel();
        jDate_entrada = new com.toedter.calendar.JDateChooser();
        jDate_salida = new com.toedter.calendar.JDateChooser();
        label_fechaActual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_alojamientos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_clientes = new javax.swing.JTable();
        btn_cancelar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        label_id = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

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
        jLabel1.setText("Add new booking:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 33, 123));
        jLabel2.setText("Ref.:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 155, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 33, 123));
        jLabel3.setText("Booking date:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 215, -1, -1));

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 33, 123));
        jLabel4.setText("Check-In date:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 205, -1, -1));

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 33, 123));
        jLabel5.setText("Check-Out date:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 255, -1, -1));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 33, 123));
        jLabel6.setText("Amount:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 305, -1, -1));

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(29, 33, 123));
        jLabel7.setText("Accommodation:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 355, -1, -1));

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(29, 33, 123));
        jLabel8.setText("Customer:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 505, -1, -1));

        btn_guardarReserva.setBackground(new java.awt.Color(29, 33, 123));
        btn_guardarReserva.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btn_guardarReserva.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardarReserva.setText("Add");
        btn_guardarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarReservaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, 83, -1));

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(29, 33, 123));
        jLabel10.setText("Created by:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 155, -1, -1));

        txt_precio.setBackground(new java.awt.Color(240, 240, 240));
        txt_precio.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        txt_precio.setForeground(new java.awt.Color(29, 33, 123));
        txt_precio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 305, 150, -1));

        label_gestionadoPor.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_gestionadoPor.setForeground(new java.awt.Color(29, 33, 123));
        label_gestionadoPor.setText("usuario");
        getContentPane().add(label_gestionadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        jDate_entrada.setForeground(new java.awt.Color(29, 33, 123));
        jDate_entrada.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        getContentPane().add(jDate_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 205, 150, 30));

        jDate_salida.setForeground(new java.awt.Color(29, 33, 123));
        jDate_salida.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        getContentPane().add(jDate_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 255, 150, 30));

        label_fechaActual.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_fechaActual.setForeground(new java.awt.Color(29, 33, 123));
        label_fechaActual.setText("Fecha actual");
        getContentPane().add(label_fechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));

        jScrollPane1.setForeground(new java.awt.Color(29, 33, 123));

        table_alojamientos.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        table_alojamientos.setForeground(new java.awt.Color(29, 33, 123));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 440, 108));

        table_clientes.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        table_clientes.setForeground(new java.awt.Color(29, 33, 123));
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

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 535, 440, 108));

        btn_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(29, 33, 123));
        btn_cancelar.setText("Cancel");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 570, 83, -1));

        jLabel15.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(29, 33, 123));
        jLabel15.setText("Booking details");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 135, 285, -1));

        label_id.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_id.setForeground(new java.awt.Color(29, 33, 123));
        label_id.setText("ref");
        getContentPane().add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 155, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 5, 475));

        jLabel9.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(29, 33, 123));
        jLabel9.setText("€");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 305, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 870, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarReservaActionPerformed
        int validacion = 0;

        java.sql.Date entrada = new java.sql.Date(1 / 1 / 1);
        java.sql.Date salida = new java.sql.Date(1 / 1 / 1);

        //Validación fecha entrada y salida
        Date comprobacionEntrada;
        comprobacionEntrada = jDate_entrada.getDate();
        if (comprobacionEntrada == null) {
            validacion++;
        } else {
            // Obtención de fecha de entrada con formato SQL DATE
            Date entrada_input = jDate_entrada.getDate();
            long entrada_l = entrada_input.getTime();
            entrada = new java.sql.Date(entrada_l);
        }

        Date comprobacionSalida;
        comprobacionSalida = jDate_salida.getDate();
        if (comprobacionSalida == null) {
            validacion++;
        } else {
            // Obtención de fecha de salida con formato SQL DATE
            Date salida_input = jDate_salida.getDate();
            long salida_l = salida_input.getTime();
            salida = new java.sql.Date(salida_l);
        }

        //Validacion precio
        double precio = 0;
        int comprobacionDouble;

        try {
            precio = Double.parseDouble(txt_precio.getText());
            comprobacionDouble = 0;

        } catch (NumberFormatException e) {
            txt_precio.setBackground(new Color(255, 82, 82));
            JOptionPane.showMessageDialog(null, "Introduce a number with format 999 or 999.99", "Format error", JOptionPane.INFORMATION_MESSAGE);
            comprobacionDouble = 1;
            validacion++;
        }

        if (comprobacionDouble > 0) {
            validacion++;
        }

        if (alojamiento_seleccionado.equals("")) {
            validacion++;
        }
        if (cliente_seleccionado == 0) {
            validacion++;
        }

        
        if (validacion > 0) {
            JOptionPane.showMessageDialog(null, "Please complete all fields.", "Empty fields", JOptionPane.WARNING_MESSAGE);

        } else {
            txt_precio.setBackground(new Color(240, 240, 240));

            if (bd.altaReserva(
                    IDNuevaReserva,
                    fecha_actual,
                    entrada,
                    salida,
                    precio,
                    alojamiento_seleccionado,
                    cliente_seleccionado,
                    id_usuario
            ) == 0) {
                JOptionPane.showMessageDialog(null, "Error occurred while adding new booking.");
            } else {
                JOptionPane.showMessageDialog(null, "New booking successfully added.");
            }

            this.dispose();
            Reservas r = new Reservas();
            r.setVisible(true);
        }
    }//GEN-LAST:event_btn_guardarReservaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        /*
        this.dispose();
        Reservas r = new Reservas();
        r.setVisible(true);
         */
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel label_fechaActual;
    private javax.swing.JLabel label_gestionadoPor;
    private javax.swing.JLabel label_id;
    private javax.swing.JTable table_alojamientos;
    private javax.swing.JTable table_clientes;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
