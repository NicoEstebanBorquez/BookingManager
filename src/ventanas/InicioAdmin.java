package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.sql.*;

public class InicioAdmin extends javax.swing.JFrame {

    String usuario;

    public static String nombre_usuario = "";
    public static String apellidos_usuario = "";

    public InicioAdmin() {
        initComponents();

        usuario = Login.usuario;

        setSize(910, 530);
        setResizable(false);
        setTitle("Administration panel");
        setLocationRelativeTo(null);

        //Evite que el programa se siga ejecutando en segundo plano despues de cerrar la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        //Consulta a la BD para saber el nombre del usuario
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");
            PreparedStatement pst = cn.prepareStatement("select nombre, apellidos from usuarios where username = '" + usuario + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                apellidos_usuario = rs.getString("apellidos");
                nombre_usuario = rs.getString("nombre");
                jLabel_nombreUsuario.setText("User: " + nombre_usuario + " " + apellidos_usuario);
            }

        } catch (Exception e) {
            System.out.println("Error en la conexión con la BD en la interfaz InicioAdmin.");
        }
    }

    //Icono de ventana
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_nuevoUsuario = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_alojamientos = new javax.swing.JButton();
        btn_reservas = new javax.swing.JButton();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_nombreUsuario = new javax.swing.JLabel();
        btn_cerrarSesion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevoUsuario.setBackground(new java.awt.Color(246, 246, 246));
        btn_nuevoUsuario.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        btn_nuevoUsuario.setForeground(new java.awt.Color(29, 33, 123));
        btn_nuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/users.png"))); // NOI18N
        btn_nuevoUsuario.setText("                      Users  ");
        btn_nuevoUsuario.setBorder(null);
        btn_nuevoUsuario.setFocusable(false);
        btn_nuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 300, 315, 80));

        btn_clientes.setBackground(new java.awt.Color(246, 246, 246));
        btn_clientes.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        btn_clientes.setForeground(new java.awt.Color(29, 33, 123));
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/customers.png"))); // NOI18N
        btn_clientes.setText("              Customers  ");
        btn_clientes.setBorder(null);
        btn_clientes.setFocusable(false);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 200, 315, 80));

        btn_alojamientos.setBackground(new java.awt.Color(246, 246, 246));
        btn_alojamientos.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        btn_alojamientos.setForeground(new java.awt.Color(29, 33, 123));
        btn_alojamientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/accommodation.png"))); // NOI18N
        btn_alojamientos.setText("  Accommodations  ");
        btn_alojamientos.setBorder(null);
        btn_alojamientos.setFocusable(false);
        btn_alojamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alojamientosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_alojamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 200, 315, 80));

        btn_reservas.setBackground(new java.awt.Color(246, 246, 246));
        btn_reservas.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        btn_reservas.setForeground(new java.awt.Color(29, 33, 123));
        btn_reservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/bookings.png"))); // NOI18N
        btn_reservas.setText("                 Bookings ");
        btn_reservas.setBorder(null);
        btn_reservas.setFocusable(false);
        btn_reservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reservasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 300, 315, 80));

        jLabel_titulo.setFont(new java.awt.Font("Gadugi", 1, 26)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(29, 33, 123));
        jLabel_titulo.setText("Administration Panel");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 90, 350, 50));

        jLabel_nombreUsuario.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel_nombreUsuario.setForeground(new java.awt.Color(29, 33, 73));
        getContentPane().add(jLabel_nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 125, 340, 40));

        btn_cerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        btn_cerrarSesion.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        btn_cerrarSesion.setForeground(new java.awt.Color(29, 33, 123));
        btn_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/logout.png"))); // NOI18N
        btn_cerrarSesion.setText("Logout");
        btn_cerrarSesion.setBorder(null);
        btn_cerrarSesion.setFocusable(false);
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 410, 100, 38));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo/logo_small.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 350, 52));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoUsuarioActionPerformed
        GestionarUsuarios gu = new GestionarUsuarios();
        gu.setVisible(true);
    }//GEN-LAST:event_btn_nuevoUsuarioActionPerformed

    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
        this.dispose();
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed

    private void btn_alojamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alojamientosActionPerformed
        Alojamientos al = new Alojamientos();
        al.setVisible(true);
    }//GEN-LAST:event_btn_alojamientosActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        Clientes cl = new Clientes();
        cl.setVisible(true);
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_reservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reservasActionPerformed
        Reservas r = new Reservas();
        r.setVisible(true);
    }//GEN-LAST:event_btn_reservasActionPerformed

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
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alojamientos;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_nuevoUsuario;
    private javax.swing.JButton btn_reservas;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_nombreUsuario;
    private javax.swing.JLabel jLabel_titulo;
    // End of variables declaration//GEN-END:variables
}
