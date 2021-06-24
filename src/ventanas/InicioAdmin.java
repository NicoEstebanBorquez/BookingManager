package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.sql.*;
import clases.Conexion;

public class InicioAdmin extends javax.swing.JFrame {
    
    String usuario;

    public static String nombre_usuario = "";
    public static String apellidos_usuario = "";
    
    public InicioAdmin() {
        initComponents();

        usuario = Login.usuario;
        
        setSize(1000,730);
        setResizable(false);
        setTitle("Inicio Admin. Conectado como: " + usuario);
        setLocationRelativeTo(null);
        
        //Evite que el programa se siga ejecutando en segundo plano despues de cerrar la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        //Imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
       //Consulta a la BD para saber el nombre del usuario
       try{
           Connection cn = Conexion.conectar();
           PreparedStatement pst = cn.prepareStatement("select nombre, apellidos from usuarios where username = '" + usuario + "'");
           
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
               apellidos_usuario = rs.getString("apellidos");
               nombre_usuario = rs.getString("nombre");
               jLabel_nombreUsuario.setText("Usuario: " + nombre_usuario + " " + apellidos_usuario);
           } 
           
       }catch(Exception e){
           System.out.println("Error en la conexión con la BD en la interfaz InicioAdmin.");
       }
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_nuevoUsuario = new javax.swing.JButton();
        btn_gestionarUsuarios = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_alojamientos = new javax.swing.JButton();
        btn_reservas = new javax.swing.JButton();
        btn_otros = new javax.swing.JButton();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel_nombreUsuario = new javax.swing.JLabel();
        btn_cerrarSesion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_nuevoUsuario.setBackground(new java.awt.Color(246, 246, 246));
        btn_nuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/nuevousuario.png"))); // NOI18N
        btn_nuevoUsuario.setBorder(null);
        btn_nuevoUsuario.setFocusable(false);
        btn_nuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 150, 150));

        btn_gestionarUsuarios.setBackground(new java.awt.Color(246, 246, 246));
        btn_gestionarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/gestionusuario.png"))); // NOI18N
        btn_gestionarUsuarios.setBorder(null);
        btn_gestionarUsuarios.setFocusable(false);
        btn_gestionarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gestionarUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_gestionarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 450, 150, 150));

        btn_clientes.setBackground(new java.awt.Color(246, 246, 246));
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/cliente.png"))); // NOI18N
        btn_clientes.setBorder(null);
        btn_clientes.setFocusable(false);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 150, 150));

        btn_alojamientos.setBackground(new java.awt.Color(246, 246, 246));
        btn_alojamientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/llaves.png"))); // NOI18N
        btn_alojamientos.setBorder(null);
        btn_alojamientos.setFocusable(false);
        btn_alojamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alojamientosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_alojamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 150, 150));

        btn_reservas.setBackground(new java.awt.Color(246, 246, 246));
        btn_reservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/maleta1.png"))); // NOI18N
        btn_reservas.setBorder(null);
        btn_reservas.setFocusable(false);
        btn_reservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reservasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 200, 150, 150));

        btn_otros.setBackground(new java.awt.Color(246, 246, 246));
        btn_otros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/reservas.png"))); // NOI18N
        btn_otros.setBorder(null);
        btn_otros.setFocusable(false);
        getContentPane().add(btn_otros, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 150, 150));

        jLabel_titulo.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(29, 33, 123));
        jLabel_titulo.setText("Administratotion Panel");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 350, 50));

        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 33, 123));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bookings");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 350, 150, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 33, 123));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add User");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 170, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 33, 123));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manage Users");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 600, 210, -1));

        jLabel4.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 33, 123));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customers");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 150, -1));

        jLabel5.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 33, 123));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Others");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, 150, -1));

        jLabel6.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 33, 123));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Accommodations");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 190, -1));

        jLabel_nombreUsuario.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        jLabel_nombreUsuario.setForeground(new java.awt.Color(29, 33, 73));
        getContentPane().add(jLabel_nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 340, 40));

        btn_cerrarSesion.setText("Cerrar sesión");
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LOGO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 210, 30));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoUsuarioActionPerformed
        AnadirUsuario au = new AnadirUsuario();
        au.setVisible(true);
    }//GEN-LAST:event_btn_nuevoUsuarioActionPerformed

    private void btn_gestionarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gestionarUsuariosActionPerformed
        GestionarUsuarios gu = new GestionarUsuarios();
        gu.setVisible(true);
    }//GEN-LAST:event_btn_gestionarUsuariosActionPerformed

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
    private javax.swing.JButton btn_gestionarUsuarios;
    private javax.swing.JButton btn_nuevoUsuario;
    private javax.swing.JButton btn_otros;
    private javax.swing.JButton btn_reservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_nombreUsuario;
    private javax.swing.JLabel jLabel_titulo;
    // End of variables declaration//GEN-END:variables
}
