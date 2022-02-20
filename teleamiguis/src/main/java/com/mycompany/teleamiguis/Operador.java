/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.teleamiguis;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import modules.RegistroPago;
import java.time.LocalDateTime;
import modules.AdministradorUsuarios;

/**
 *
 * @author gyron
 */
public class Operador extends javax.swing.JFrame {
    private AdministradorUsuarios admUser;
    int xMouse;
    int yMouse;
    private RegistroPago rPago;
    String idUsuario;
    String tipoidUsuario;

   
    public Operador(String id, String tipoid, String nombreUser) {
        
        initComponents();
        
        
        idUsuario = id;
        tipoidUsuario = tipoid;

        tituloSuperior.setText("Usuario " + nombreUser);
        
        
        txf_expedido.setEditable(false);
        txf_caduca.setEditable(false);
        txf_total_a_pagar.setEditable(false);
        txf_num_contrato.setEditable(false);
        txf_pagado.setEditable(false);
        txf_abonado.setEditable(false);
        
        try {
            // Hacemos invisibles todos los jlabel de abajo del tab de gestionUsuario
            admUser = new AdministradorUsuarios(); // se crea una instancia de la clase
                                                   // AdministradorUsuarios
        } catch (IOException | SQLException e) {
            System.out.println("Hubo un problema al crear la clase administradorUsuario");
        }
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
        horaSesion = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        cont_reg = new javax.swing.JPanel();
        registrarPago = new javax.swing.JButton();
        cont_sal = new javax.swing.JPanel();
        salida1 = new javax.swing.JButton();
        panel_inv = new javax.swing.JPanel();
        barraTitulo = new javax.swing.JPanel();
        tituloSuperior = new javax.swing.JLabel();
        panelDer = new javax.swing.JPanel();
        Fondo = new javax.swing.JLabel();
        tabsPagoOperador = new javax.swing.JTabbedPane();
        tabPago = new javax.swing.JPanel();
        label_registrarPago = new javax.swing.JLabel();
        lbl_num_factura = new javax.swing.JLabel();
        txf_buscar_factura = new javax.swing.JTextField();
        lbl_num_contrato = new javax.swing.JLabel();
        txf_num_contrato = new javax.swing.JTextField();
        lbl_abonado = new javax.swing.JLabel();
        txf_abonado = new javax.swing.JTextField();
        txf_total_a_pagar = new javax.swing.JTextField();
        lbl_expedido = new javax.swing.JLabel();
        txf_expedido = new javax.swing.JTextField();
        lbl_pagado = new javax.swing.JLabel();
        txf_pagado = new javax.swing.JTextField();
        lbl_caduca = new javax.swing.JLabel();
        txf_caduca = new javax.swing.JTextField();
        lbl_total_a_pagar = new javax.swing.JLabel();
        estado_factura = new javax.swing.JLabel();
        lbl_abonar = new javax.swing.JLabel();
        txf_abonar = new javax.swing.JTextField();
        cont_bus = new javax.swing.JPanel();
        buscar = new javax.swing.JButton();
        cont_pag = new javax.swing.JPanel();
        abonar = new javax.swing.JButton();

        setUndecorated(true);
        setResizable(false);

        panelGeneral.setBackground(new java.awt.Color(98, 197, 255));
        panelGeneral.setPreferredSize(new java.awt.Dimension(850, 450));
        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelIzq.setBackground(new java.awt.Color(22, 49, 92));
        panelIzq.setPreferredSize(new java.awt.Dimension(300, 450));
        panelIzq.setLayout(new java.awt.GridBagLayout());

        nombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("OPERADOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(13, 5, 13, 5);
        panelIzq.add(nombre, gridBagConstraints);

        horaSesion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        horaSesion.setForeground(new java.awt.Color(255, 255, 255));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        horaSesion.setText(dtf.format(now));
        horaSesion.setText(dtf.format(now));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 36, 5);
        panelIzq.add(horaSesion, gridBagConstraints);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/Logo.png"))); // NOI18N
        panelIzq.add(Logo, new java.awt.GridBagConstraints());

        cont_reg.setBackground(new java.awt.Color(189, 210, 219));
        cont_reg.setForeground(new java.awt.Color(0, 0, 0));
        cont_reg.setPreferredSize(new java.awt.Dimension(131, 25));
        cont_reg.setLayout(new java.awt.BorderLayout());

        registrarPago.setBackground(new java.awt.Color(255, 255, 255));
        registrarPago.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        registrarPago.setForeground(new java.awt.Color(0, 0, 0));
        registrarPago.setText("Registrar pago");
        registrarPago.setContentAreaFilled(false);
        registrarPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarPagoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarPagoMouseExited(evt);
            }
        });
        registrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPagoActionPerformed(evt);
            }
        });
        cont_reg.add(registrarPago, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        panelIzq.add(cont_reg, gridBagConstraints);

        cont_sal.setBackground(new java.awt.Color(102, 102, 102));
        cont_sal.setPreferredSize(new java.awt.Dimension(72, 25));
        cont_sal.setLayout(new java.awt.BorderLayout());

        salida1.setBackground(new java.awt.Color(255, 255, 255));
        salida1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        salida1.setForeground(new java.awt.Color(255, 255, 255));
        salida1.setText("Salida");
        salida1.setContentAreaFilled(false);
        salida1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salida1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salida1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salida1MouseExited(evt);
            }
        });
        salida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salida1ActionPerformed(evt);
            }
        });
        cont_sal.add(salida1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 18, 0);
        panelIzq.add(cont_sal, gridBagConstraints);

        javax.swing.GroupLayout panel_invLayout = new javax.swing.GroupLayout(panel_inv);
        panel_inv.setLayout(panel_invLayout);
        panel_invLayout.setHorizontalGroup(
            panel_invLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_invLayout.setVerticalGroup(
            panel_invLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        panelIzq.add(panel_inv, gridBagConstraints);

        panelGeneral.add(panelIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 150, 450));

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

        tituloSuperior.setBackground(new java.awt.Color(0, 0, 0));
        tituloSuperior.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tituloSuperior.setForeground(new java.awt.Color(255, 255, 255));
        tituloSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloSuperior.setText("Operador");

        javax.swing.GroupLayout barraTituloLayout = new javax.swing.GroupLayout(barraTitulo);
        barraTitulo.setLayout(barraTituloLayout);
        barraTituloLayout.setHorizontalGroup(
            barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        barraTituloLayout.setVerticalGroup(
            barraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelGeneral.add(barraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        panelDer.setBackground(new java.awt.Color(255,255,255,150));
        panelDer.setPreferredSize(new java.awt.Dimension(500, 450));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/fondo2.jpg"))); // NOI18N
        Fondo.setToolTipText("");
        Fondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabsPagoOperador.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        tabPago.setBackground(new java.awt.Color(255, 255, 255, 150));
        tabPago.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_registrarPago.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        label_registrarPago.setForeground(new java.awt.Color(0, 0, 0));
        label_registrarPago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_registrarPago.setText("Registrar Pago");
        label_registrarPago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tabPago.add(label_registrarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, -1));

        lbl_num_factura.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbl_num_factura.setForeground(new java.awt.Color(0, 0, 0));
        lbl_num_factura.setText("Seleccione numero de la facura:");
        tabPago.add(lbl_num_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 230, 30));

        txf_buscar_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_buscar_facturaActionPerformed(evt);
            }
        });
        tabPago.add(txf_buscar_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 130, -1));

        lbl_num_contrato.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbl_num_contrato.setForeground(new java.awt.Color(0, 0, 0));
        lbl_num_contrato.setText("Numero de contrato");
        tabPago.add(lbl_num_contrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, 30));

        txf_num_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_num_contratoActionPerformed(evt);
            }
        });
        tabPago.add(txf_num_contrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, -1));

        lbl_abonado.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbl_abonado.setForeground(new java.awt.Color(0, 0, 0));
        lbl_abonado.setText("Abonado");
        tabPago.add(lbl_abonado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 230, 30));

        txf_abonado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_abonadoActionPerformed(evt);
            }
        });
        tabPago.add(txf_abonado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 230, -1));

        txf_total_a_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_total_a_pagarActionPerformed(evt);
            }
        });
        tabPago.add(txf_total_a_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 230, -1));

        lbl_expedido.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbl_expedido.setForeground(new java.awt.Color(0, 0, 0));
        lbl_expedido.setText("Expedido");
        tabPago.add(lbl_expedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 70, 30));

        txf_expedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_expedidoActionPerformed(evt);
            }
        });
        tabPago.add(txf_expedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 140, -1));

        lbl_pagado.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbl_pagado.setForeground(new java.awt.Color(0, 0, 0));
        lbl_pagado.setText("Pagado");
        tabPago.add(lbl_pagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 60, 30));

        txf_pagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_pagadoActionPerformed(evt);
            }
        });
        tabPago.add(txf_pagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 140, -1));

        lbl_caduca.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbl_caduca.setForeground(new java.awt.Color(0, 0, 0));
        lbl_caduca.setText("Caduca");
        tabPago.add(lbl_caduca, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 60, 30));

        txf_caduca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_caducaActionPerformed(evt);
            }
        });
        tabPago.add(txf_caduca, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 140, -1));

        lbl_total_a_pagar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbl_total_a_pagar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_total_a_pagar.setText("Total a pagar");
        tabPago.add(lbl_total_a_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 180, 30));

        estado_factura.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        estado_factura.setForeground(new java.awt.Color(0, 0, 0));
        estado_factura.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        tabPago.add(estado_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 230, 30));

        lbl_abonar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbl_abonar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_abonar.setText("Abonar");
        tabPago.add(lbl_abonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 230, 30));

        txf_abonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_abonarActionPerformed(evt);
            }
        });
        tabPago.add(txf_abonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 170, 30));

        cont_bus.setBackground(new java.awt.Color(0, 10, 85));
        cont_bus.setLayout(new java.awt.BorderLayout());

        buscar.setBackground(new java.awt.Color(0, 10, 85));
        buscar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar");
        buscar.setContentAreaFilled(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarMouseExited(evt);
            }
        });
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        cont_bus.add(buscar, java.awt.BorderLayout.CENTER);

        tabPago.add(cont_bus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 72, 22));

        cont_pag.setBackground(new java.awt.Color(0, 10, 85));
        cont_pag.setLayout(new java.awt.BorderLayout());

        abonar.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        abonar.setForeground(new java.awt.Color(0, 128, 0));
        abonar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usedPictures/pagar.png"))); // NOI18N
        abonar.setContentAreaFilled(false);
        abonar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        abonar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abonarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abonarMouseExited(evt);
            }
        });
        abonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abonarActionPerformed(evt);
            }
        });
        cont_pag.add(abonar, java.awt.BorderLayout.CENTER);

        tabPago.add(cont_pag, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 60, 30));

        tabsPagoOperador.addTab("Registro de pago", tabPago);

        javax.swing.GroupLayout panelDerLayout = new javax.swing.GroupLayout(panelDer);
        panelDer.setLayout(panelDerLayout);
        panelDerLayout.setHorizontalGroup(
            panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabsPagoOperador)
            .addGroup(panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDerLayout.createSequentialGroup()
                    .addComponent(Fondo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelDerLayout.setVerticalGroup(
            panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabsPagoOperador, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addGroup(panelDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDerLayout.createSequentialGroup()
                    .addComponent(Fondo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelGeneral.add(panelDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 700, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txf_buscar_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_buscar_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_buscar_facturaActionPerformed

    private void txf_num_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_num_contratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_num_contratoActionPerformed

    private void txf_total_a_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_total_a_pagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_total_a_pagarActionPerformed

    private void txf_expedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_expedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_expedidoActionPerformed

    private void txf_pagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_pagadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_pagadoActionPerformed

    private void txf_caducaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_caducaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_caducaActionPerformed

    private void txf_abonadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_abonadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_abonadoActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            // TODO add your handling code here:
            rPago = new RegistroPago();
            String[] datos = rPago.mostrarFactura( Integer.parseInt(txf_buscar_factura.getText()) );
            
            txf_buscar_factura.setText(datos[0]);
            txf_num_contrato.setText(datos[1]);
            txf_abonado.setText(datos[2]);
            txf_total_a_pagar.setText(datos[3]);
            txf_expedido.setText(datos[4]);
            txf_pagado.setText(datos[5]);
            txf_caduca.setText(datos[6]);
            estado_factura.setText(datos[7]);
            
            if(datos[2].equals(datos[3]))
            {
                estado_factura.setForeground(new Color(0,128,0));
                
            }else 
            {
                estado_factura.setForeground(new Color(255,0,0));
            }
            
            repaint();
            revalidate();
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void abonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abonarActionPerformed
        // TODO add your handling code here:
        
                try {
            // TODO add your handling code here:
            rPago = new RegistroPago();
            String [] datos = new String[2];
            
            datos[0] = txf_buscar_factura.getText();
            datos[1] = txf_abonar.getText();
            
            System.out.println(datos[0]);
            System.out.println(datos[1]);
            
            rPago.registrarPago(datos);
            
        } catch (IOException ex) {
            Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Operador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_abonarActionPerformed

    private void txf_abonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_abonarActionPerformed

    }//GEN-LAST:event_txf_abonarActionPerformed

    private void registrarPagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarPagoMouseEntered
        // TODO add your handling code here:
        cont_reg.setBackground(new Color(0, 10, 85));
        registrarPago.setForeground(new Color(255, 255, 255)); 
    }//GEN-LAST:event_registrarPagoMouseEntered

    private void registrarPagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarPagoMouseExited
        // TODO add your handling code here:
        cont_reg.setBackground(new Color(189, 210, 219));
        registrarPago.setForeground(new Color(0, 0, 0)); 
    }//GEN-LAST:event_registrarPagoMouseExited

    private void salida1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salida1MouseEntered
        // TODO add your handling code here:
        cont_sal.setBackground(new Color(0, 0, 0)); 
        salida1.setForeground(new Color(255, 255, 255)); 
    }//GEN-LAST:event_salida1MouseEntered

    private void salida1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salida1MouseExited
        // TODO add your handling code here:
        cont_sal.setBackground(new Color(102, 102, 102)); 
        salida1.setForeground(new Color(255, 255, 255)); 
    }//GEN-LAST:event_salida1MouseExited

    private void buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseEntered
        // TODO add your handling code here:
        cont_bus.setBackground(new Color(41, 35, 92)); 
        buscar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_buscarMouseEntered

    private void buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseExited
        // TODO add your handling code here:
        cont_bus.setBackground(new Color(0, 10, 85)); 
    }//GEN-LAST:event_buscarMouseExited

    private void abonarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abonarMouseEntered
        // TODO add your handling code here:
        cont_pag.setBackground(new Color(41, 35, 92)); 
    }//GEN-LAST:event_abonarMouseEntered

    private void abonarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abonarMouseExited
        // TODO add your handling code here:
        cont_pag.setBackground(new Color(0, 10, 85));
    }//GEN-LAST:event_abonarMouseExited

    
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
        try {
            admUser.cerrarConexion(idUsuario, tipoidUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                new Operador("2141234","C.C","papito pierna larga").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton abonar;
    private javax.swing.JPanel barraTitulo;
    private javax.swing.JButton buscar;
    private javax.swing.JPanel cont_bus;
    private javax.swing.JPanel cont_pag;
    private javax.swing.JPanel cont_reg;
    private javax.swing.JPanel cont_sal;
    private javax.swing.JLabel estado_factura;
    private javax.swing.JLabel horaSesion;
    private javax.swing.JLabel label_registrarPago;
    private javax.swing.JLabel lbl_abonado;
    private javax.swing.JLabel lbl_abonar;
    private javax.swing.JLabel lbl_caduca;
    private javax.swing.JLabel lbl_expedido;
    private javax.swing.JLabel lbl_num_contrato;
    private javax.swing.JLabel lbl_num_factura;
    private javax.swing.JLabel lbl_pagado;
    private javax.swing.JLabel lbl_total_a_pagar;
    private javax.swing.JLabel nombre;
    private javax.swing.JPanel panelDer;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelIzq;
    private javax.swing.JPanel panel_inv;
    private javax.swing.JButton registrarPago;
    private javax.swing.JButton salida1;
    private javax.swing.JPanel tabPago;
    private javax.swing.JTabbedPane tabsPagoOperador;
    private javax.swing.JLabel tituloSuperior;
    private javax.swing.JTextField txf_abonado;
    private javax.swing.JTextField txf_abonar;
    private javax.swing.JTextField txf_buscar_factura;
    private javax.swing.JTextField txf_caduca;
    private javax.swing.JTextField txf_expedido;
    private javax.swing.JTextField txf_num_contrato;
    private javax.swing.JTextField txf_pagado;
    private javax.swing.JTextField txf_total_a_pagar;
    // End of variables declaration//GEN-END:variables
}
