package ventanas;

import clases.BD;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static ventanas.Clientes.cliente;

public class Alojamientos extends javax.swing.JFrame {

    //Variable que contiene el alojamiento seleccionado
    public static int alojamiento;

    //Permite acceder a los metodos necesarios para añadir filas, columnas, dar nombre a las columnas, etc.
    DefaultTableModel modelo = new DefaultTableModel();

    public Alojamientos() {
        initComponents();

        setSize(980, 500);
        setResizable(false);
        setTitle("Accommodations");
        setLocationRelativeTo(null);

        //Evite que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Obtener listado de reservas
        listadoAlojamientos();

        //Imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/images/Wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_alojamientos = new javax.swing.JTable();
        btn_nuevoAlojamiento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 125, 862, 252));

        btn_nuevoAlojamiento.setBackground(new java.awt.Color(255, 255, 255));
        btn_nuevoAlojamiento.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        btn_nuevoAlojamiento.setForeground(new java.awt.Color(29, 33, 123));
        btn_nuevoAlojamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconos/save.png"))); // NOI18N
        btn_nuevoAlojamiento.setText("Add accommodation");
        btn_nuevoAlojamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoAlojamientoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevoAlojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 395, -1, -1));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 33, 123));
        jLabel1.setText("Accommodations:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 470));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_alojamientos;
    // End of variables declaration//GEN-END:variables

    public void listadoAlojamientos() {

        //Consulta a la BD para obtener listado de alojamientos
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://bfsa3sxsr1yktijoeled-mysql.services.clever-cloud.com/bfsa3sxsr1yktijoeled", "ut5cg3puxyn4x8k7", "dexvZuEzWRPF4siweVO2");

            PreparedStatement pst = cn.prepareStatement("SELECT id_alojamiento, nombre, plazas, dormitorios, direccion FROM alojamientos");
            ResultSet rs = pst.executeQuery();

            table_alojamientos = new JTable(modelo);
            jScrollPane1.setViewportView(table_alojamientos);

            modelo.addColumn("Ref.");
            modelo.addColumn("Name");
            modelo.addColumn("PAX");
            modelo.addColumn("Bedrooms");
            modelo.addColumn("Address");

            //Alto de filas
            table_alojamientos.setRowHeight(25);
            //Ancho de columnas
            TableColumnModel modeloColumna = table_alojamientos.getColumnModel();
            modeloColumna.getColumn(0).setPreferredWidth(40);
            modeloColumna.getColumn(1).setPreferredWidth(250);
            modeloColumna.getColumn(2).setPreferredWidth(20);
            modeloColumna.getColumn(3).setPreferredWidth(50);
            modeloColumna.getColumn(4).setPreferredWidth(350);

            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 5; i++) {
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
                    alojamiento = (int)modelo.getValueAt(fila_point, columna_point);
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
