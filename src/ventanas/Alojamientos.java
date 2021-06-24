package ventanas;

import clases.BD;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.Clientes.cliente;

public class Alojamientos extends javax.swing.JFrame {

    //Variable que contiene el cliente seleccionado
    public static String alojamiento;

    //Permite acceder a los metodos necesarios para añadir filas, columnas, dar nombre a las columnas, etc.
    DefaultTableModel modelo = new DefaultTableModel();

    public Alojamientos() {
        initComponents();

        setSize(1000, 730);
        setResizable(false);
        setTitle("Alojamientos");
        setLocationRelativeTo(null);

        //Evite que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Obtener listado de reservas
        listadoAlojamientos();
    
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_alojamientos = new javax.swing.JTable();
        btn_nuevoAlojamiento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 880, -1));

        btn_nuevoAlojamiento.setText("Nuevo alojamiento");
        btn_nuevoAlojamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoAlojamientoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevoAlojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoAlojamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoAlojamientoActionPerformed
        NuevoAlojamiento nuevoAl = new NuevoAlojamiento();
        nuevoAl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_nuevoAlojamientoActionPerformed

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
            java.util.logging.Logger.getLogger(Alojamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alojamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alojamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alojamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alojamientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_nuevoAlojamiento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_alojamientos;
    // End of variables declaration//GEN-END:variables

    public void listadoAlojamientos() {
        
        //Consulta a la BD para obtener listado de alojamientos
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT id_alojamiento, nombre, plazas, dormitorios, direccion, propietario FROM alojamientos");
            ResultSet rs = pst.executeQuery();

            table_alojamientos = new JTable(modelo);
            jScrollPane1.setViewportView(table_alojamientos);

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Capacidad");
            modelo.addColumn("Nº dormitorios");
            modelo.addColumn("Dirección");
            modelo.addColumn("Propietario");

            while (rs.next()) {
                Object[] fila = new Object[6];

                for (int i = 0; i < 6; i++) {
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

        //Obtener el alojamiento seleccionado
        table_alojamientos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = table_alojamientos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    alojamiento = (String) modelo.getValueAt(fila_point, columna_point);
                    verInfoAlojamiento();
                }
            }
        });

    }

    public void verInfoAlojamiento() {

        InfoAlojamiento ia = new InfoAlojamiento();
        ia.setVisible(true);
        this.dispose();
    }

}
