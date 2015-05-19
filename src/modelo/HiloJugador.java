/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.PanelJuego;

/**
 *
 * @author francisco
 */
public class HiloJugador extends Thread {

    private PanelJuego panelJuego;
    private Jugador jugador;
    public static int direccionX;
    public static int direccionY;

    public HiloJugador(PanelJuego panelJuego, Jugador jugador) {
        this.panelJuego = panelJuego;
        this.jugador = jugador;
        this.jugador.setImgPers(jugador.imgPersIzq);
    }

    public void run() {
        while (true) {
            try {
                sleep(20);
                this.jugador.setPosX(jugador.getPosX() + direccionX * 3);
                for (int i = 0; i < 163; i++) {
                    this.jugador.setPosY(jugador.getPosY() + direccionY);
                }
                direccionX = 0;
                direccionY = 0;
            } catch (InterruptedException ex) {
            }
            this.panelJuego.repaint();
        }
    }
}
