/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import modelo.Bala;
import modelo.Jugador;
import modelo.Tortuga;

/**
 *
 * @author vini
 */
public class PanelJuego extends javax.swing.JPanel {

    private Jugador jugador;
    private ArrayList<Tortuga> tortugas;
    private Bala bala;
    private Image pow;
    private Image alas;

    /**
     * Creates new form PanelJuego1
     */
    public PanelJuego() {
        initComponents();
        pow = new ImageIcon(getClass().getResource("/img/pow0.png")).getImage();
        alas = new ImageIcon(getClass().getResource("/img/alas.gif")).getImage();
    }

    public void activarPow() {
        this.pow = new ImageIcon(getClass().getResource("/img/pow.png")).getImage();
    }

    public void activarPuntos() {
        pow = new ImageIcon(getClass().getResource("/img/1.gif")).getImage();
    }
    public void activarAlas () {
            alas = new ImageIcon(getClass().getResource("/img/alas.gif")).getImage();
    }
    public void desactivarAlas () {
    
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(pow, 383, 473, this);
        g.drawImage(alas, 100, 550, 140,100, this);
        jugador.pintarPersonaje(g);
        for (int i = 0; i < tortugas.size(); i++) {
            tortugas.get(i).pintarPersonaje(g);
        }
        bala.pintarBala(g);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fond.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setTortuga(ArrayList<Tortuga> tortugas) {
        this.tortugas = tortugas;
    }

    public void setBala(Bala bala) {
        this.bala = bala;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
