package ventanas;
import clases.BD;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class InfoReserva extends javax.swing.JFrame {

    int reserva;
    String fecha, entrada, salida, precio, alojamiento, cliente, usuario = "";
    BD bd;

    public InfoReserva() {
        initComponents();

        reserva = Reservas.reserva;

        setSize(790, 510);
        setResizable(false);
        setTitle("Información de reserva " + reserva);
        setLocationRelativeTo(null);

        //Evita que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        bd = new BD();

        //Muestra la info de la reserva al abrir la ventana
        mostrarInfoReserva();
       
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

        jLabel1 = new javax.swing.JLabel();
        Close = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        label_alojamiento = new javax.swing.JLabel();
        label_precio = new javax.swing.JLabel();
        label_salida = new javax.swing.JLabel();
        label_entrada = new javax.swing.JLabel();
        label_id = new javax.swing.JLabel();
        label_cliente = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        label_gestionadoPor = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 33, 123));
        jLabel1.setText("Booking information:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));

        Close.setBackground(new java.awt.Color(255, 255, 255));
        Close.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        Close.setForeground(new java.awt.Color(23, 33, 123));
        Close.setText("Cerrar");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        btn_modificar.setBackground(new java.awt.Color(255, 255, 255));
        btn_modificar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(23, 33, 123));
        btn_modificar.setText("Modify");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, -1, -1));

        label_alojamiento.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_alojamiento.setForeground(new java.awt.Color(29, 33, 123));
        label_alojamiento.setText("...");
        getContentPane().add(label_alojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 355, -1, -1));

        label_precio.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_precio.setForeground(new java.awt.Color(29, 33, 123));
        label_precio.setText("...");
        getContentPane().add(label_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 305, -1, -1));

        label_salida.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_salida.setForeground(new java.awt.Color(29, 33, 123));
        label_salida.setText("...");
        getContentPane().add(label_salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        label_entrada.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_entrada.setForeground(new java.awt.Color(29, 33, 123));
        label_entrada.setText("...");
        getContentPane().add(label_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 205, -1, -1));

        label_id.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_id.setForeground(new java.awt.Color(29, 33, 123));
        label_id.setText("...");
        getContentPane().add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 155, -1, -1));

        label_cliente.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_cliente.setForeground(new java.awt.Color(29, 33, 123));
        label_cliente.setText("...");
        getContentPane().add(label_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 405, -1, -1));

        btn_eliminar.setBackground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(23, 33, 123));
        btn_eliminar.setText("Delete");
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 135, 285, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 5, 260));

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(29, 33, 123));
        jLabel10.setText("Created by:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 155, -1, -1));

        label_gestionadoPor.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_gestionadoPor.setForeground(new java.awt.Color(29, 33, 123));
        label_gestionadoPor.setText("...");
        getContentPane().add(label_gestionadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(29, 33, 123));
        jLabel8.setText("Booking date:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 215, -1, -1));

        label_fecha.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_fecha.setForeground(new java.awt.Color(29, 33, 123));
        label_fecha.setText("...");
        getContentPane().add(label_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 33, 123));
        jLabel2.setText("Ref.:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 155, -1, -1));

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

        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(29, 33, 123));
        jLabel9.setText("Customer:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 405, -1, -1));

        jLabel15.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(29, 33, 123));
        jLabel15.setText("Booking details");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        Reservas r = new Reservas();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        ModificarReserva mr = new ModificarReserva();
        mr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_modificarActionPerformed

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
            java.util.logging.Logger.getLogger(InfoReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel label_alojamiento;
    private javax.swing.JLabel label_cliente;
    private javax.swing.JLabel label_entrada;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_gestionadoPor;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_precio;
    private javax.swing.JLabel label_salida;
    // End of variables declaration//GEN-END:variables

    public void mostrarInfoReserva() {
        String[] infoReserva = bd.obtenerInfoReserva(reserva);

        fecha = infoReserva[0];
        entrada = infoReserva[1];
        salida = infoReserva[2];
        precio = infoReserva[3];
        alojamiento = infoReserva[4];
        cliente = infoReserva[5];
        usuario = infoReserva[6];

        label_id.setText(String.valueOf(reserva));
        label_fecha.setText(fecha);
        label_entrada.setText(entrada);
        label_salida.setText(salida);
        label_precio.setText(precio);
        label_alojamiento.setText(bd.obtenerNombreAlojamiento(alojamiento));
        label_cliente.setText(bd.obtenerNombreCliente(cliente));
        
        this.label_gestionadoPor.setText(bd.obtenerNombreUsuario(usuario));
    }

}
