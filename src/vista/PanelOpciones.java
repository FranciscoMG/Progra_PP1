/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author francisco
 */
public class PanelOpciones extends javax.swing.JPanel {

    /**
     * Creates new form PanelOpciones
     */
    public PanelOpciones() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpOpciones = new javax.swing.JTabbedPane();
        PanelUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbExistente = new javax.swing.JRadioButton();
        cboUsuarios = new javax.swing.JComboBox();
        rbNuevo = new javax.swing.JRadioButton();
        txtNuevo = new javax.swing.JTextField();
        btnEmpezar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        PanelPartida = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        cboPartidas = new javax.swing.JComboBox();
        btnCargar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel1.setText("¡Bienvienido!");

        jLabel2.setText("Identificate para poder jugar:");

        rbExistente.setText("Usuario existente:");
        rbExistente.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbExistenteStateChanged(evt);
            }
        });

        cboUsuarios.setEnabled(false);

        rbNuevo.setText("Nuevo usuario:");
        rbNuevo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbNuevoStateChanged(evt);
            }
        });

        txtNuevo.setEnabled(false);

        btnEmpezar.setText("Empezar");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout PanelUsuarioLayout = new javax.swing.GroupLayout(PanelUsuario);
        PanelUsuario.setLayout(PanelUsuarioLayout);
        PanelUsuarioLayout.setHorizontalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelUsuarioLayout.createSequentialGroup()
                        .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelUsuarioLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel1)))
                            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelUsuarioLayout.createSequentialGroup()
                                        .addComponent(rbNuevo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelUsuarioLayout.createSequentialGroup()
                                        .addComponent(rbExistente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUsuarioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEmpezar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        PanelUsuarioLayout.setVerticalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbExistente)
                    .addComponent(cboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNuevo)
                    .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEmpezar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpOpciones.addTab("Usuarios", PanelUsuario);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel3.setText("Cargar partida");

        jLabel4.setText("Nombre de usuario:");

        jLabel5.setText("Partidas guardadas:");

        txtUsuario.setEnabled(false);

        btnCargar.setText("Cargar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout PanelPartidaLayout = new javax.swing.GroupLayout(PanelPartida);
        PanelPartida.setLayout(PanelPartidaLayout);
        PanelPartidaLayout.setHorizontalGroup(
            PanelPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPartidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(PanelPartidaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(PanelPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPartidaLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboPartidas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelPartidaLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPartidaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        PanelPartidaLayout.setVerticalGroup(
            PanelPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPartidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(PanelPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCargar))
                .addContainerGap())
        );

        tpOpciones.addTab("Partidas", PanelPartida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpOpciones)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpOpciones)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbExistenteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbExistenteStateChanged
        if (this.rbExistente.isSelected()) {
            this.cboUsuarios.setEnabled(true);
            this.rbNuevo.setSelected(false);
            this.txtNuevo.setEnabled(false);
            this.txtNuevo.setText("");
        }
    }//GEN-LAST:event_rbExistenteStateChanged

    private void rbNuevoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbNuevoStateChanged
        if (this.rbNuevo.isSelected()) {
            this.txtNuevo.setEnabled(true);
            this.rbExistente.setSelected(false);
            this.cboUsuarios.setEnabled(false);
        }
    }//GEN-LAST:event_rbNuevoStateChanged

    public void setTabActiva(boolean tabActiva) {
        if (tabActiva) {
            this.tpOpciones.setEnabledAt(0, true);
            this.tpOpciones.setEnabledAt(1, false);
            this.tpOpciones.setSelectedIndex(0);
        } else {
            this.tpOpciones.setEnabledAt(0, false);
            this.tpOpciones.setEnabledAt(1, true);
            this.tpOpciones.setSelectedIndex(1);
        }
    }

    public String getCboUsuarios() {
        if (this.cboUsuarios.getSelectedIndex() == -1) {
            return null;
        }
        return this.cboUsuarios.getSelectedItem().toString();
    }

    public void setCboUsuarios(ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            this.cboUsuarios.addItem(usuario.getNombre());
        }
    }

    public void setCboUsuarios(String usuario) {
        this.cboUsuarios.setSelectedItem(usuario);
    }

    public boolean getRbExistente() {
        return this.rbExistente.isSelected();
    }

    public boolean getRbNuevo() {
        return this.rbNuevo.isSelected();
    }

    public String getTxtNuevo() {
        if (this.txtNuevo.getText().trim().equalsIgnoreCase("")) {
            return null;
        }
        return this.txtNuevo.getText();
    }

    public void setTxtUsuario(String nombre) {
        this.txtUsuario.setText(nombre);
    }

    public String getTxtUsuario() {
        return this.txtUsuario.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPartida;
    private javax.swing.JPanel PanelUsuario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEmpezar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboPartidas;
    private javax.swing.JComboBox cboUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton rbExistente;
    private javax.swing.JRadioButton rbNuevo;
    private javax.swing.JTabbedPane tpOpciones;
    private javax.swing.JTextField txtNuevo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public static final String BTN_EMPEZAR = "Empezar";
    public static final String BTN_CARGAR = "Cargar";
    public static final String BTN_CANCELAR = "Cancelar";
    public static final String BTN_SALIR = "Salir";

    public void listenPanel(ActionListener control) {
        this.btnEmpezar.addActionListener(control);
        this.btnSalir.addActionListener(control);
        this.btnCargar.addActionListener(control);
        this.btnCancelar.addActionListener(control);
    }
}