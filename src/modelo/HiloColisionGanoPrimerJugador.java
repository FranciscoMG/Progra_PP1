/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Rectangle;
import vista.PanelJuego;

/**
 *
 * @author vini
 */
public class HiloColisionGanoPrimerJugador extends Thread {

    private Rectangle colisionadorJugador;
    private Rectangle meta1;
    private Rectangle meta2;
    private Rectangle pow;
    private PanelJuego panelJuego;
    private Jugador jugador;

    //-------------------------------------------------------------------------
    public HiloColisionGanoPrimerJugador(PanelJuego panelJuego, Jugador jugador) {
        this.panelJuego = panelJuego;
        this.jugador = jugador;
        colisionadorJugador = new Rectangle();
        meta1 = new Rectangle(0, 30, 100, 100);
        meta2 = new Rectangle(710, 30, 100, 100);
        pow = new Rectangle(385, 474, 50, 50);
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean isColisionDerecha() {
        if (colisionadorJugador.intersects(meta2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isColisionIzquierda() {
        if (colisionadorJugador.intersects(meta1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isColicionPow() {
        return colisionadorJugador.intersects(pow);
    }

    public void run() {
        while (true) {
            try {
                sleep(250);
                colisionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 60);
                if (jugador.getIsFirstPlayer()) {
                    if (isColisionDerecha()) {
                        jugador.setIsFirstPlayer(false); // Si el jugador coliciona con la meta 
                        jugador.setPosX(150);
                        jugador.setPosY(95);
                        jugador.setImgPers(jugador.imgPersDer2);
                        panelJuego.activarPow();
                    }
                    if (isColisionIzquierda()) {
                        jugador.setIsFirstPlayer(false); // Si el jugador coliciona con la meta 
                        jugador.setPosX(600);
                        jugador.setPosY(95);
                        jugador.setImgPers(jugador.imgPersIzq2);
                        panelJuego.activarPow();
                    }
                }
                if (jugador.getIsFirstPlayer() == false) {
                    if (isColicionPow()) {
                        panelJuego.activarPuntos();
                        System.err.println("Estrella  <== HiloColicionGanoPrimero");
                        sleep(2500);
                        panelJuego.activarPow();
                    }
                }

            } catch (InterruptedException ex) {
            }

        }

    }

}
