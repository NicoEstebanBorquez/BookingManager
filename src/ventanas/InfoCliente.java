package ventanas;

import clases.BD;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;

public class InfoCliente extends javax.swing.JFrame {

    int cliente;
    BD bd;

    String nombre, apellidos, DNI, pasaporte, nacionalidad, telefono, email, usuario = "";

    public InfoCliente() {
        initComponents();

        cliente = Clientes.cliente;

        setSize(790, 660);
        setResizable(false);
        setTitle("Información de cliente " + cliente);
        setLocationRelativeTo(null);

        //Evite que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        bd = new BD();

        //Imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        //Muestra la info del cliente al abrir la ventana
        mostrarInfoCliente();
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

        btn_cerrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        label_email = new javax.swing.JLabel();
        label_telefono = new javax.swing.JLabel();
        label_nacionalidad = new javax.swing.JLabel();
        label_pasaporte = new javax.swing.JLabel();
        label_dni = new javax.swing.JLabel();
        label_apellidos = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_id = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        label_gestionadoPor = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cerrar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cerrar.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        btn_cerrar.setForeground(new java.awt.Color(29, 33, 123));
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/cancel.png"))); // NOI18N
        btn_cerrar.setText("Close");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 111, -1));

        btn_modificar.setBackground(new java.awt.Color(255, 255, 255));
        btn_modificar.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(29, 33, 123));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/edit.png"))); // NOI18N
        btn_modificar.setText("Edit");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 111, -1));

        label_email.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_email.setForeground(new java.awt.Color(29, 33, 123));
        label_email.setText("...");
        getContentPane().add(label_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, -1, -1));

        label_telefono.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_telefono.setForeground(new java.awt.Color(29, 33, 123));
        label_telefono.setText("...");
        getContentPane().add(label_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, -1, -1));

        label_nacionalidad.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_nacionalidad.setForeground(new java.awt.Color(29, 33, 123));
        label_nacionalidad.setText("...");
        getContentPane().add(label_nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 405, -1, -1));

        label_pasaporte.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_pasaporte.setForeground(new java.awt.Color(29, 33, 123));
        label_pasaporte.setText("...");
        getContentPane().add(label_pasaporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 355, -1, -1));

        label_dni.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_dni.setForeground(new java.awt.Color(29, 33, 123));
        label_dni.setText("...");
        getContentPane().add(label_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 305, -1, -1));

        label_apellidos.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_apellidos.setForeground(new java.awt.Color(29, 33, 123));
        label_apellidos.setText("...");
        getContentPane().add(label_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 255, -1, -1));

        label_nombre.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(29, 33, 123));
        label_nombre.setText("...");
        getContentPane().add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 205, -1, -1));

        label_id.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_id.setForeground(new java.awt.Color(29, 33, 123));
        label_id.setText("...");
        getContentPane().add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 155, -1, -1));

        btn_eliminar.setBackground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(29, 33, 123));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/remove.png"))); // NOI18N
        btn_eliminar.setText("Delete");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 111, -1));

        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(29, 33, 123));
        jLabel9.setText("Customer information:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 135, 305, -1));

        jLabel16.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(29, 33, 123));
        jLabel16.setText("Customer details");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 33, 123));
        jLabel2.setText("Ref.:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 155, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 33, 123));
        jLabel3.setText("First name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 205, -1, -1));

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 33, 123));
        jLabel4.setText("Last name:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 255, -1, -1));

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 33, 123));
        jLabel5.setText("ID Card:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 305, -1, -1));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 33, 123));
        jLabel6.setText("Passport:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 355, -1, -1));

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(29, 33, 123));
        jLabel7.setText("Nationality:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 405, -1, -1));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 315, -1));

        jLabel18.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(29, 33, 123));
        jLabel18.setText("Contact details");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(29, 33, 123));
        jLabel8.setText("Phone:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(29, 33, 123));
        jLabel10.setText("E-mail:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(29, 33, 123));
        jLabel11.setText("Assigned to:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 125, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 5, 265));

        label_gestionadoPor.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_gestionadoPor.setForeground(new java.awt.Color(29, 33, 123));
        label_gestionadoPor.setText("usuario");
        getContentPane().add(label_gestionadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        Clientes c = new Clientes();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        ModificarCliente mc = new ModificarCliente();
        mc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        int confirmacion = 0;
        confirmacion = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this customer?", "Delete",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (bd.eliminarCliente(String.valueOf(cliente)) == 0) {
                JOptionPane.showMessageDialog(null, "Impossible to delete this customer. \nThere are still bookings pending.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Customer successfully deleted.");
            }
        }
        Clientes c = new Clientes();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(InfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel label_apellidos;
    private javax.swing.JLabel label_dni;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_gestionadoPor;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_nacionalidad;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_pasaporte;
    private javax.swing.JLabel label_telefono;
    // End of variables declaration//GEN-END:variables

    public void mostrarInfoCliente() {
        String[] infoCliente = bd.obtenerInfoCliente(cliente);

        nombre = infoCliente[0];
        apellidos = infoCliente[1];
        DNI = infoCliente[2];
        pasaporte = infoCliente[3];
        nacionalidad = infoCliente[4];
        telefono = infoCliente[5];
        email = infoCliente[6];
        usuario = infoCliente[7];

        label_id.setText(String.valueOf(cliente));
        label_nombre.setText(nombre);
        label_apellidos.setText(apellidos);
        label_dni.setText(DNI);
        label_pasaporte.setText(pasaporte);
        label_nacionalidad.setText(nacionalidad);
        label_telefono.setText(telefono);
        label_email.setText(email);

        label_gestionadoPor.setText(bd.obtenerNombreUsuario(usuario));
    }

}
