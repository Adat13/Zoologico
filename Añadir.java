
package Ventanas;

import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.swing.JOptionPane;
import java.sql.SQLException;



public class Añadir extends javax.swing.JFrame {

    Conexion cx;
    public Añadir() {
        initComponents();
        this.setLocationRelativeTo(null);
        cx = new Conexion();
        cx.conectar();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombre = new javax.swing.JTextField();
        DNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AñadirBD = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("DNI : ");

        AñadirBD.setText("Añadir");
        AñadirBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirBDActionPerformed(evt);
            }
        });

        jLabel3.setText("Añadir personal ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(AñadirBD)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(AñadirBD)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void AñadirBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirBDActionPerformed
        
    String nombre = Nombre.getText();
    String dni = DNI.getText();
    String correo = GenerarCorreo(nombre,dni);
    String contraseña = generarContraseña(nombre, dni);

    try {
        
        String consulta = "INSERT INTO personal (nombre, correo, contraseña) VALUES (?, ?, ?)";
        
        try (Connection conn = cx.conectar();
             PreparedStatement preparedStatement = conn.prepareStatement(consulta)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, correo);
            preparedStatement.setString(3, contraseña);
            
            int filasAfectadas = preparedStatement.executeUpdate();
            
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Personal añadido correctamente");
                this.setVisible(false);
                Home home = new Home();
                home.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo añadir personal.");
                
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al añadir usuario: " + e.getMessage());
    }
    }//GEN-LAST:event_AñadirBDActionPerformed

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
            java.util.logging.Logger.getLogger(Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Añadir().setVisible(true);
            }
        });
    }
    private String generarContraseña(String nombre, String dni) {
    String[] palabras = nombre.split(" ");
    String nombre2 = String.join(".", palabras[0], palabras[1]).toLowerCase();
    String dnicorreo = dni.substring(dni.length() - 2);

    String mayusculas = palabras[0].toUpperCase();
    String minusculas = palabras[1].toLowerCase();
    return mayusculas + "-" + minusculas + "-" + dnicorreo + "$";
}
    public String GenerarCorreo(String nombre, String dni){
        
        
        String[] palabras = nombre.split(" ");
        String nombre2 = String.join(".",palabras[0],palabras[1]).toLowerCase();
                
        String dnicorreo= dni.substring(dni.length()-2);
        
        return nombre2+dnicorreo+"@zoo.com";
        
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñadirBD;
    private javax.swing.JTextField DNI;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
