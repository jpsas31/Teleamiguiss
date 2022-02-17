/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.teleamiguis;

/**
 *
 * @author gyron
 */
public class Operador extends javax.swing.JFrame {
    int xMouse;
    int yMouse;


    /**
     * Creates new form Operador
     */
    public Operador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelGeneral = new javax.swing.JPanel();
        panelIzq = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        rol = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        registrarPago = new javax.swing.JButton();
        salida1 = new javax.swing.JButton();
        panelDer = new javax.swing.JPanel();
        Fondo = new javax.swing.JLabel();
        barraTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setUndecorated(true);
        setResizable(false);

        panelGeneral.setBackground(new java.awt.Color(98, 197, 255));
        panelGeneral.setPreferredSize(new java.awt.Dimension(850, 450));
        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelIzq.setBackground(new java.awt.Color(22, 49, 92));
        panelIzq.setPreferredSize(new java.awt.Dimension(300, 450));
        panelIzq.setLayout(new java.awt.GridBagLayout());

        nombre.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("NOMBRE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelIzq.add(nombre, gridBagConstraints);

        rol.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        rol.setForeground(new java.awt.Color(255, 255, 255));
        rol.setText("Operador");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 77, 5);
        panelIzq.add(rol, gridBagConstraints);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/Logo.png"))); // NOI18N
        panelIzq.add(Logo, new java.awt.GridBagConstraints());

        registrarPago.setBackground(new java.awt.Color(255, 255, 255));
        registrarPago.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        registrarPago.setText("Registrar pago");
        registrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPagoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 38, 10);
        panelIzq.add(registrarPago, gridBagConstraints);

        salida1.setBackground(new java.awt.Color(102, 102, 102));
        salida1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        salida1.setForeground(new java.awt.Color(255, 255, 255));
        salida1.setText("Salida");
        salida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salida1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(80, 10, 10, 10);
        panelIzq.add(salida1, gridBagConstraints);

        panelGeneral.add(panelIzq,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 450));

        panelDer.setBackground(new java.awt.Color(255, 204, 204));
        panelDer.setOpaque(false);
        panelDer.setPreferredSize(new java.awt.Dimension(500, 450));

        Fondo.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/usedPictures/fondo2.jpg"))); // NOI18N
        Fondo.setToolTipText("");

        javax.swing.GroupLayout panelDerLayout = new javax.swing.GroupLayout(panelDer);
        panelDer.setLayout(panelDerLayout);
        panelDerLayout.setHorizontalGroup(
                panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDerLayout.createSequentialGroup()
                                .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        panelDerLayout.setVerticalGroup(
                panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        panelGeneral.add(panelDer,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 700, 450));
        panelDer.getAccessibleContext().setAccessibleDescription("");

        barraTitulo.setBackground(new java.awt.Color(43, 41, 40));
        barraTitulo.setForeground(new java.awt.Color(255, 255, 255));
        barraTitulo.setPreferredSize(new java.awt.Dimension(850, 30));
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

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Operador");

        javax.swing.GroupLayout barraTituloLayout = new javax.swing.GroupLayout(barraTitulo);
        barraTitulo.setLayout(barraTituloLayout);
        barraTituloLayout.setHorizontalGroup(
                barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(barraTituloLayout.createSequentialGroup().addGap(395, 395, 395)
                                .addComponent(jLabel1).addContainerGap(390, Short.MAX_VALUE)));
        barraTituloLayout.setVerticalGroup(barraTituloLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        barraTituloLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        panelGeneral.add(barraTitulo,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                        panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                        panelGeneral, javax.swing.GroupLayout.Alignment.TRAILING,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void registrarPagoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_registrarPagoActionPerformed


        panelGeneral.repaint();
        panelGeneral.revalidate();
        panelDer.repaint();
        panelDer.revalidate();
        registrarPago.setEnabled(false);

    }// GEN-LAST:event_registrarPagoActionPerformed

    private void salida1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_salida1ActionPerformed
        // TODO add your handling code here:
        dispose();
        Login login = new Login();
        login.setVisible(true);

    }// GEN-LAST:event_salida1ActionPerformed


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
            java.util.logging.Logger.getLogger(Operador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Operador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Operador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operador.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Operador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel barraTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel panelDer;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelIzq;
    private javax.swing.JButton registrarPago;
    private javax.swing.JLabel rol;
    private javax.swing.JButton salida1;
    // End of variables declaration//GEN-END:variables
}
