package ventanas;

import clases.BD;

import javax.swing.WindowConstants;

public class InfoAlojamiento extends javax.swing.JFrame {

    String alojamiento;
    String nombre, propietario, direccion, plazas, dormitorios, baños, terraza, piscina, aparcamiento = "";
    BD bd;

    public InfoAlojamiento() {
        initComponents();

        alojamiento = Alojamientos.alojamiento;

        setSize(820, 510);
        setResizable(false);
        setTitle("Información de alojamiento " + alojamiento);
        setLocationRelativeTo(null);

        //Evite que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        bd = new BD();

        //Muestra la info del alojamiento al abrir la ventana
        mostrarInfoAlojamiento();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        label_terraza = new javax.swing.JLabel();
        label_piscina = new javax.swing.JLabel();
        label_aparcamiento = new javax.swing.JLabel();
        label_baños = new javax.swing.JLabel();
        label_dormitorios = new javax.swing.JLabel();
        label_capacidad = new javax.swing.JLabel();
        label_direccion = new javax.swing.JLabel();
        label_propietario = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_id = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Alojamiento:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel2.setText("ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel4.setText("Propietario/a:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel5.setText("Direccion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel6.setText("Capacidad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel7.setText("Dormitorios:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel8.setText("Baños:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jLabel9.setText("Piscina:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));

        jLabel10.setText("Parking:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, -1, -1));

        jLabel11.setText("Terraza:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        btn_cerrar.setText("Cerrar");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, -1, -1));

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, -1, -1));

        label_terraza.setText("...");
        getContentPane().add(label_terraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, -1));

        label_piscina.setText("...");
        getContentPane().add(label_piscina, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        label_aparcamiento.setText("...");
        getContentPane().add(label_aparcamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, -1, -1));

        label_baños.setText("...");
        getContentPane().add(label_baños, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        label_dormitorios.setText("...");
        getContentPane().add(label_dormitorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        label_capacidad.setText("...");
        getContentPane().add(label_capacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, -1));

        label_direccion.setText("...");
        getContentPane().add(label_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        label_propietario.setText("...");
        getContentPane().add(label_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        label_nombre.setText("...");
        getContentPane().add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        label_id.setText("...");
        getContentPane().add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        ModificarAlojamiento ma = new ModificarAlojamiento();
        ma.setVisible(true);
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
            java.util.logging.Logger.getLogger(InfoAlojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoAlojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoAlojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoAlojamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoAlojamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_aparcamiento;
    private javax.swing.JLabel label_baños;
    private javax.swing.JLabel label_capacidad;
    private javax.swing.JLabel label_direccion;
    private javax.swing.JLabel label_dormitorios;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_piscina;
    private javax.swing.JLabel label_propietario;
    private javax.swing.JLabel label_terraza;
    // End of variables declaration//GEN-END:variables

    public void mostrarInfoAlojamiento() {
        String[] infoCliente = bd.obtenerInfoAlojamiento(alojamiento);

        nombre = infoCliente[0];
        propietario = infoCliente[1];
        direccion = infoCliente[2];
        plazas = infoCliente[3];
        dormitorios = infoCliente[4];
        baños = infoCliente[5];
        terraza = infoCliente[6];
        piscina = infoCliente[7];
        aparcamiento = infoCliente[8];

        label_id.setText(alojamiento);
        label_nombre.setText(nombre);
        label_propietario.setText(propietario);
        label_direccion.setText(direccion);
        label_capacidad.setText(plazas);
        label_dormitorios.setText(dormitorios);
        label_baños.setText(baños);
        label_terraza.setText(terraza);
        label_piscina.setText(piscina);
        label_aparcamiento.setText(aparcamiento);
    }
}