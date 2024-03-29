/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.teleamiguis;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modules.LoginBack;

/**
 *
 * @author gyron
 */
public class Login extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    private LoginBack loginBack;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        try {
            loginBack = new LoginBack();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        barraTitulo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        loginelement = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        LoginIcon = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        cont_sal = new javax.swing.JPanel();
        salida = new javax.swing.JButton();
        cont_ent1 = new javax.swing.JPanel();
        iniciarsesion = new javax.swing.JButton();
        loginPanel = new javax.swing.JPanel();
        fondologin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        panelGeneral.setPreferredSize(new java.awt.Dimension(415, 591));
        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        barraTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraTituloMouseDragged(evt);
            }
        });
        barraTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraTituloMousePressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");

        javax.swing.GroupLayout barraTituloLayout = new javax.swing.GroupLayout(barraTitulo);
        barraTitulo.setLayout(barraTituloLayout);
        barraTituloLayout.setHorizontalGroup(
            barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraTituloLayout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(185, 185, 185))
        );
        barraTituloLayout.setVerticalGroup(
            barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelGeneral.add(barraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        loginelement.setBackground(new java.awt.Color(22, 49, 92, 220));
        loginelement.setPreferredSize(new java.awt.Dimension(208, 400));
        loginelement.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre.setText("Usuario");
        nombre.setPreferredSize(new java.awt.Dimension(138, 21));
        loginelement.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 100, 30));

        LoginIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/login.png"))); // NOI18N
        loginelement.add(LoginIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        username.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        username.setPreferredSize(new java.awt.Dimension(207, 26));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        loginelement.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 180, 31));

        password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        loginelement.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 180, 29));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Contraseña");
        loginelement.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 100, 30));

        cont_sal.setBackground(new java.awt.Color(189, 210, 219));
        cont_sal.setPreferredSize(new java.awt.Dimension(72, 27));
        cont_sal.setLayout(new java.awt.BorderLayout());

        salida.setBackground(new java.awt.Color(255, 255, 255));
        salida.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        salida.setForeground(new java.awt.Color(0, 0, 0));
        salida.setText("Salir");
        salida.setContentAreaFilled(false);
        salida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salidaMouseExited(evt);
            }
        });
        salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaActionPerformed(evt);
            }
        });
        cont_sal.add(salida, java.awt.BorderLayout.CENTER);

        loginelement.add(cont_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        cont_ent1.setBackground(new java.awt.Color(189, 210, 219));
        cont_ent1.setPreferredSize(new java.awt.Dimension(72, 27));
        cont_ent1.setLayout(new java.awt.BorderLayout());

        iniciarsesion.setBackground(new java.awt.Color(255, 255, 255));
        iniciarsesion.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        iniciarsesion.setForeground(new java.awt.Color(0, 0, 0));
        iniciarsesion.setText("Entrar");
        iniciarsesion.setContentAreaFilled(false);
        iniciarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iniciarsesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iniciarsesionMouseExited(evt);
            }
        });
        iniciarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarsesionActionPerformed(evt);
            }
        });
        cont_ent1.add(iniciarsesion, java.awt.BorderLayout.CENTER);

        loginelement.add(cont_ent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));
        cont_ent1.getAccessibleContext().setAccessibleName("");

        panelGeneral.add(loginelement, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 65, 327, 460));

        loginPanel.setBackground(new java.awt.Color(98, 197, 255));
        loginPanel.setPreferredSize(new java.awt.Dimension(415, 550));
        loginPanel.setLayout(new java.awt.GridBagLayout());

        fondologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/Fondo.png"))); // NOI18N
        loginPanel.add(fondologin, new java.awt.GridBagConstraints());

        panelGeneral.add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 591));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salidaMouseEntered
        // TODO add your handling code here:
        cont_sal.setBackground(new Color(0, 10, 85));
        salida.setForeground(new Color(255, 255, 255)); 
    }//GEN-LAST:event_salidaMouseEntered

    private void salidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salidaMouseExited
        // TODO add your handling code here:
        cont_sal.setBackground(new Color(189, 210, 219)); 
        salida.setForeground(new Color(0, 0, 0)); 
    
    }//GEN-LAST:event_salidaMouseExited

    private void iniciarsesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarsesionMouseEntered
        // TODO add your handling code here:
        cont_ent1.setBackground(new Color(0, 10, 85));
        iniciarsesion.setForeground(new Color(255, 255, 255)); 
    }//GEN-LAST:event_iniciarsesionMouseEntered

    private void iniciarsesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarsesionMouseExited
        // TODO add your handling code here:
        cont_ent1.setBackground(new Color(189, 210, 219));
        iniciarsesion.setForeground(new Color(0, 0, 0)); 
    }//GEN-LAST:event_iniciarsesionMouseExited

    
    
    private void barraTituloMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_barraTituloMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }// GEN-LAST:event_barraTituloMouseDragged

    private void barraTituloMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_barraTituloMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }// GEN-LAST:event_barraTituloMousePressed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_passwordActionPerformed

    private void salidaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_salidaActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }// GEN-LAST:event_salidaActionPerformed

    private void salidaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_salidaMouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_salidaMouseClicked

    private void iniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_iniciarsesionActionPerformed
        try {
            // TODO add your handling code here:
            String resul[] = loginBack.usuarioIngreso(username.getText(),
                    String.valueOf(password.getPassword()));
            if ("si".equals(resul[0])) {
                dispose();
                try {
                    loginBack.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                switch (resul[1]) {
                    case "Administrador":
                        Administrador admin = new Administrador(resul[2], resul[3], resul[4]);
                        admin.setVisible(true);
                        break;
                    case "Operador":
                        Operador operador = new Operador(resul[2], resul[3], resul[4]);
                        operador.setVisible(true);
                        break;
                    case "Gerente":
                        Gerente gerente = new Gerente(resul[2], resul[3], resul[4]);
                        gerente.setVisible(true);
                        break;
                }
                loginBack.cerrarConexion();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesión", "Advertencia",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_iniciarsesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and
         * feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginIcon;
    private javax.swing.JPanel barraTitulo;
    private javax.swing.JPanel cont_ent1;
    private javax.swing.JPanel cont_sal;
    private javax.swing.JLabel fondologin;
    private javax.swing.JButton iniciarsesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel loginelement;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton salida;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
