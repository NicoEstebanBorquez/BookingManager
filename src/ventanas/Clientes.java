package ventanas;

import clases.BD;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Clientes extends javax.swing.JFrame {

    //Variable que contiene el cliente seleccionado
    public static int cliente;

    //Permite acceder a los metodos necesarios para añadir filas, columnas, dar nombre a las columnas, etc.
    DefaultTableModel modelo = new DefaultTableModel();

    public Clientes() {
        initComponents();

        setSize(980, 500);
        setResizable(false);
        setTitle("Customers");
        setLocationRelativeTo(null);

        //Evite que el programa se cierre al cerrar la ventana
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Obtener listado de clientes
        listadoClientes();

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
        table_clientes = new javax.swing.JTable();
        btn_nuevoCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        table_clientes.setMinimumSize(new java.awt.Dimension(5, 64));
        jScrollPane1.setViewportView(table_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 125, 862, 252));

        btn_nuevoCliente.setBackground(new java.awt.Color(29, 33, 123));
        btn_nuevoCliente.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btn_nuevoCliente.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevoCliente.setText("Add new customer");
        btn_nuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 395, -1, -1));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 33, 123));
        jLabel1.setText("Customers:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 990, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoClienteActionPerformed
        NuevoCliente ncl = new NuevoCliente();
        ncl.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btn_nuevoClienteActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_nuevoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_clientes;
    // End of variables declaration//GEN-END:variables

    public void listadoClientes() {

        //Consulta a la BD para obtener listado de clientes
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/on_reservationssoftware", "root", "");

            PreparedStatement pst = cn.prepareStatement("SELECT id_cliente, nombre, apellidos, DNI, pasaporte, telefono, email FROM clientes");
            ResultSet rs = pst.executeQuery();

            table_clientes = new JTable(modelo);
            jScrollPane1.setViewportView(table_clientes);

            modelo.addColumn("Ref.");
            modelo.addColumn("First name");
            modelo.addColumn("Last name");
            modelo.addColumn("ID Card");
            modelo.addColumn("Passport");
            modelo.addColumn("Phone");
            modelo.addColumn("E-mail");

            //Alto de filas
            table_clientes.setRowHeight(25);
            //Ancho de columnas
            TableColumnModel modeloColumna = table_clientes.getColumnModel();
            modeloColumna.getColumn(0).setPreferredWidth(10);
            modeloColumna.getColumn(1).setPreferredWidth(50);
            modeloColumna.getColumn(2).setPreferredWidth(100);
            modeloColumna.getColumn(3).setPreferredWidth(20);
            modeloColumna.getColumn(4).setPreferredWidth(20);
            modeloColumna.getColumn(5).setPreferredWidth(20);
            modeloColumna.getColumn(6).setPreferredWidth(120);


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

        //Obtener el usuario seleccionado
        table_clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = table_clientes.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    cliente = (int) modelo.getValueAt(fila_point, columna_point);
                    verInfoCliente();
                }
            }
        });
    }

    public void verInfoCliente() {

        InfoCliente ic = new InfoCliente();
        ic.setVisible(true);
        this.dispose();
    }
}
