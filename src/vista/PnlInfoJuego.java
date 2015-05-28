/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionListener;
import modelo.Usuario;

/**
 *
 * @author francisco
 */
public class PnlInfoJuego extends javax.swing.JPanel {

    private Usuario usuarioActual;

    /**
     * Creates new form PanelInfoJuego
     */
    public PnlInfoJuego() {
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

        jLabel1 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPrimerMT = new javax.swing.JLabel();
        lblSegundoMT = new javax.swing.JLabel();
        lblTercerMT = new javax.swing.JLabel();
        lblCuartoMT = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        btnGuardarPartida = new javax.swing.JButton();
        btnCargarPartida = new javax.swing.JButton();
        btnNuevaPartida = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Purisa", 0, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        lblNombreUsuario.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lblNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreUsuario.setText("##########");
        lblNombreUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Purisa", 0, 14)); // NOI18N
        jLabel2.setText("Tiempo:");

        lblTiempo.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lblTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTiempo.setText("0:00");
        lblTiempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Purisa", 0, 14)); // NOI18N
        jLabel3.setText("Mejores tiempos:");

        lblPrimerMT.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblPrimerMT.setText("1. #:##");

        lblSegundoMT.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblSegundoMT.setText("2. #:##");

        lblTercerMT.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblTercerMT.setText("3. #:##");

        lblCuartoMT.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCuartoMT.setText("4. #:##");

        btnGuardarPartida.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnGuardarPartida.setText("Guardar partida");
        btnGuardarPartida.setFocusable(false);

        btnCargarPartida.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnCargarPartida.setText("Cargar partida");
        btnCargarPartida.setFocusable(false);

        btnNuevaPartida.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnNuevaPartida.setText("Nueva partida");
        btnNuevaPartida.setFocusable(false);

        btnSalir.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnSalir.setText("Salir del juego");
        btnSalir.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Purisa", 0, 14)); // NOI18N
        jLabel4.setText("Vidas:");

        lblVida.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lblVida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVida.setText("0");
        lblVida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblVida, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevaPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCargarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCuartoMT, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(lblSegundoMT, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblTercerMT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(lblPrimerMT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblVida))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTiempo))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPrimerMT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSegundoMT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTercerMT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCuartoMT)
                .addGap(18, 18, 18)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarPartida)
                .addGap(18, 18, 18)
                .addComponent(btnCargarPartida)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaPartida)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getLblNombreUsuario() {
        return this.lblNombreUsuario.getText().trim();
    }

    public void setLblNombreUsuario(String nombre) {
        this.lblNombreUsuario.setText(nombre);
    }

    public void setLblVida(String vida) {
        this.lblVida.setText(vida);
    }

    public String getLblTiempo() {
        return this.lblTiempo.getText().trim();
    }

    public void setLblTiempo(String tiempo) {
        this.lblTiempo.setText(tiempo);
    }

    public void setMejoresTiempos(String[] tiempos) {
        this.lblPrimerMT.setText("1. " + tiempos[0]);
        this.lblSegundoMT.setText("2. " + tiempos[1]);
        this.lblTercerMT.setText("3. " + tiempos[2]);
        this.lblCuartoMT.setText("4. " + tiempos[3]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarPartida;
    private javax.swing.JButton btnGuardarPartida;
    private javax.swing.JButton btnNuevaPartida;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JLabel lblCuartoMT;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPrimerMT;
    private javax.swing.JLabel lblSegundoMT;
    private javax.swing.JLabel lblTercerMT;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblVida;
    // End of variables declaration//GEN-END:variables

    public static final String BTN_CARGAR = "Cargar partida";
    public static final String BTN_GUARDAR = "Guardar partida";
    public static final String BTN_NUEVA = "Nueva partida";
    public static final String BTN_SALIR = "Salir del juego";

    public void listenPanel(ActionListener control) {
        this.btnCargarPartida.addActionListener(control);
        this.btnGuardarPartida.addActionListener(control);
        this.btnNuevaPartida.addActionListener(control);
        this.btnSalir.addActionListener(control);
    }

    public void cargarUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
        this.lblNombreUsuario.setText(usuario.getNombre());
        setMejoresTiempos(usuario.getMejoresTiempos());
    }
}
