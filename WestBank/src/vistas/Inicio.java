/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import conexion.BaseDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Cliente;
import negocio.Cuenta;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Italo UN
 */
public class Inicio extends javax.swing.JFrame {

 private Cliente cliente;
    private Cuenta cuenta;

    // Constructor que recibe una instancia de Cliente
    public Inicio(Cliente cliente) {
        initComponents();      
       this.cliente = cliente;
       
       Mnthistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorialTransferencias();
            }

            private void mostrarHistorialTransferencias() {
                Historial registrar = new Historial();
                registrar.setLocationRelativeTo(null);
                registrar.setVisible(true);
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
       
     MnjSalir.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Botón 'Salir' presionado en Inicio");
        confirmarSalida();
    }


        private void confirmarSalida() {
            int opcion = JOptionPane.showConfirmDialog(
                    Inicio.this, "¿Está seguro de que desea salir de la aplicación?",
                    "Confirmar salida", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(Inicio.this, "Ha salido de la aplicación", "Salida", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cierra la vista Inicio
            System.exit(0); // Cierra la aplicación si es necesario
}
        }
    });

        // Establecer el nombre completo en el label
        lblNombreCompleto.setText(cliente.getNombre() + " " +
                cliente.getApellidoPaterno() + " " +
                cliente.getApellidoMaterno());

        // Crear una instancia de Cuenta y obtener sus datos
        this.cuenta = new Cuenta();
        cuenta.setRut(cliente.getRut());
        try {
            cuenta.obtenerDatosCuenta(new BaseDatos().obtenerConexion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Establecer el monto en el label
        lblMonto.setText(String.valueOf(cuenta.getMonto()));
    }

    Inicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreCompleto = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        inicio = new javax.swing.JMenu();
        transferir = new javax.swing.JMenu();
        Mnthistorial = new javax.swing.JMenu();
        MnjSalir = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("West Bank");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tu saldo es: ");

        lblMonto.setForeground(new java.awt.Color(255, 255, 255));
        lblMonto.setText("-");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Bienvenido(a):");

        lblNombreCompleto.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCompleto.setText("-");

        inicio.setText("Inicio    ");
        jMenuBar1.add(inicio);

        transferir.setText("Transferir   ");
        jMenuBar1.add(transferir);

        Mnthistorial.setText("Historial de Transferencias  ");
        jMenuBar1.add(Mnthistorial);

        MnjSalir.setText("Salir");
        jMenuBar1.add(MnjSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

       
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnjSalir;
    private javax.swing.JMenu Mnthistorial;
    private javax.swing.JMenu inicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JMenu transferir;
    // End of variables declaration//GEN-END:variables
}
