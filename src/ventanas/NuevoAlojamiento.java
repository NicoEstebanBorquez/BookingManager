package ventanas;

import clases.BD;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.WindowConstants;

public class NuevoAlojamiento extends javax.swing.JFrame {

    BD bd;
    String nombre_usuario, apellidos_usuario, terraza, piscina, parking;
    int id_usuario, pax, dormitorios, baños;
    int IDNuevoAlojamiento = 0;

    public NuevoAlojamiento() {
        initComponents();

        setSize(790, 545);
        setResizable(false);
        setTitle("New accommodation");
        setLocationRelativeTo(null);

        //Evite que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        bd = new BD();

        nombre_usuario = InicioAdmin.nombre_usuario;
        apellidos_usuario = InicioAdmin.apellidos_usuario;
        label_gestionadoPor.setText(nombre_usuario + " " + apellidos_usuario);

        id_usuario = bd.obtenerIDusuario(nombre_usuario, apellidos_usuario);

        //Obtencion del ID del alojamiento desde la BD
        IDNuevoAlojamiento = bd.obtenerSiguienteIDAlojamiento();
        label_id.setText("" + IDNuevoAlojamiento);

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        txt_direccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        label_gestionadoPor = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        check_parking = new javax.swing.JCheckBox();
        check_piscina = new javax.swing.JCheckBox();
        check_terraza = new javax.swing.JCheckBox();
        combo_dormitorios = new javax.swing.JComboBox<>();
        combo_baños = new javax.swing.JComboBox<>();
        combo_pax = new javax.swing.JComboBox<>();
        label_id = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 33, 123));
        jLabel1.setText("Add new accommodation:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 33, 123));
        jLabel2.setText("PAX:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(29, 33, 123));
        jLabel3.setText("Swimming pool:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 33, 123));
        jLabel4.setText("Address:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 255, -1, -1));

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 33, 123));
        jLabel6.setText("Ref.:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 155, -1, -1));

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(29, 33, 123));
        jLabel7.setText("Bedrooms:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        btn_guardar.setBackground(new java.awt.Color(29, 33, 123));
        btn_guardar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btn_guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar.setText("Add");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 350, 83, -1));

        txt_direccion.setBackground(new java.awt.Color(240, 240, 240));
        txt_direccion.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(29, 33, 123));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 255, 340, -1));

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(29, 33, 123));
        jLabel8.setText("Assigned to:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 125, -1, -1));

        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(29, 33, 123));
        jLabel9.setText("Balcony/Terrace:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(29, 33, 123));
        jLabel10.setText("Bathrooms:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(29, 33, 123));
        jLabel11.setText("Parking:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));

        label_gestionadoPor.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        label_gestionadoPor.setForeground(new java.awt.Color(29, 33, 123));
        label_gestionadoPor.setText("usuario");
        getContentPane().add(label_gestionadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(29, 33, 123));
        jLabel12.setText("Name:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 205, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(240, 240, 240));
        txt_nombre.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(29, 33, 123));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 205, 340, -1));

        btn_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(29, 33, 123));
        btn_cancelar.setText("Cancel");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 390, 83, -1));
        getContentPane().add(check_parking, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 445, -1, -1));
        getContentPane().add(check_piscina, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 405, -1, -1));
        getContentPane().add(check_terraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 365, -1, -1));

        combo_dormitorios.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        combo_dormitorios.setForeground(new java.awt.Color(29, 33, 123));
        combo_dormitorios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4" }));
        getContentPane().add(combo_dormitorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        combo_baños.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        combo_baños.setForeground(new java.awt.Color(29, 33, 123));
        combo_baños.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4" }));
        getContentPane().add(combo_baños, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        combo_pax.setFont(new java.awt.Font("Gadugi", 0, 16)); // NOI18N
        combo_pax.setForeground(new java.awt.Color(29, 33, 123));
        combo_pax.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(combo_pax, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        label_id.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        label_id.setForeground(new java.awt.Color(29, 33, 123));
        label_id.setText("ref");
        getContentPane().add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 156, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 365, 10, 98));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 5, 170));

        jLabel15.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(29, 33, 123));
        jLabel15.setText("Accommodation details");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 340, 342, -1));

        jLabel16.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(29, 33, 123));
        jLabel16.setText("Facilities");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 330, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 135, 265, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 800, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        //ComboBox PAX
        if (combo_pax.getSelectedIndex() == 0) {
            pax = 0;
        } else if (combo_pax.getSelectedIndex() == 1) {
            pax = 1;
        } else if (combo_pax.getSelectedIndex() == 2) {
            pax = 2;
        } else if (combo_pax.getSelectedIndex() == 3) {
            pax = 3;
        } else if (combo_pax.getSelectedIndex() == 4) {
            pax = 4;
        } else if (combo_pax.getSelectedIndex() == 5) {
            pax = 5;
        } else if (combo_pax.getSelectedIndex() == 6) {
            pax = 6;
        } else if (combo_pax.getSelectedIndex() == 7) {
            pax = 7;
        } else if (combo_pax.getSelectedIndex() == 8) {
            pax = 8;
        }

        //ComboBox dormitorios
        if (combo_dormitorios.getSelectedIndex() == 0) {
            dormitorios = 0;
        } else if (combo_dormitorios.getSelectedIndex() == 1) {
            dormitorios = 1;
        } else if (combo_dormitorios.getSelectedIndex() == 2) {
            dormitorios = 2;
        } else if (combo_dormitorios.getSelectedIndex() == 3) {
            dormitorios = 3;
        } else if (combo_dormitorios.getSelectedIndex() == 4) {
            dormitorios = 4;
        }

        //ComboBox baños
        if (combo_baños.getSelectedIndex() == 0) {
            baños = 0;
        } else if (combo_baños.getSelectedIndex() == 1) {
            baños = 1;
        } else if (combo_baños.getSelectedIndex() == 2) {
            baños = 2;
        } else if (combo_baños.getSelectedIndex() == 3) {
            baños = 3;
        } else if (combo_baños.getSelectedIndex() == 4) {
            baños = 4;
        }

        //CheckBox terraza
        if (check_terraza.isSelected()) {
            terraza = "YES";
        } else {
            terraza = "NO";
        }

        //CheckBox piscina
        if (check_piscina.isSelected()) {
            piscina = "YES";
        } else {
            piscina = "NO";
        }

        //CheckBox parking
        if (check_parking.isSelected()) {
            parking = "YES";
        } else {
            parking = "NO";
        }

        bd.altaAlojamiento(
                IDNuevoAlojamiento,
                txt_nombre.getText().trim(),
                txt_direccion.getText().trim(),
                pax,
                dormitorios,
                baños,
                terraza,
                piscina,
                parking,
                id_usuario);

        Alojamientos a = new Alojamientos();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        Alojamientos a = new Alojamientos();
        a.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(NuevoAlojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoAlojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoAlojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoAlojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoAlojamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JCheckBox check_parking;
    private javax.swing.JCheckBox check_piscina;
    private javax.swing.JCheckBox check_terraza;
    private javax.swing.JComboBox<String> combo_baños;
    private javax.swing.JComboBox<String> combo_dormitorios;
    private javax.swing.JComboBox<String> combo_pax;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel label_gestionadoPor;
    private javax.swing.JLabel label_id;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
