/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PanelJuego;

/**
 *
 * @author vini
 */
public class HiloColisionGanoPrimerJugador extends Thread {

    private Rectangle colisionadorJugador;
    private Rectangle meta1;
    private Rectangle meta2;
    private PanelJuego panelJuego;
    private Jugador jugador;

    //-------------------------------------------------------------------------
    public HiloColisionGanoPrimerJugador(PanelJuego panelJuego, Jugador jugador) {
        this.panelJuego = panelJuego;
        this.jugador = jugador;
        colisionadorJugador = new Rectangle();
        meta1 = new Rectangle(0, 30, 100, 100);
        meta2 = new Rectangle(710, 30, 100, 100);
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean isColision() {
        if (colisionadorJugador.intersects(meta1) || colisionadorJugador.intersects(meta2)) {
            return true;
        } else {
            return false;
        }
    }

    public void run() {
        while (true) {
            try {
                sleep(250);

                colisionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 108);

                if (isColision()) {
                    jugador.setIsFirstPlayer(false); // Si el jugador coliciona con la meta 
                    jugador.setPosX(150);
                    jugador.setPosY(95);
                    panelJuego.activarPow();
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(HiloColisionGanoPrimerJugador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
