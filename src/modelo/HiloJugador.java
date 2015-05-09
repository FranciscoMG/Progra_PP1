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
    private Personaje jugador;
    private static int direccionX = 0;
    private int direccionY = 0;

    public HiloJugador(PanelJuego panelJuego, Personaje jugador) {
        this.panelJuego = panelJuego;
        this.jugador = jugador;
        System.out.println("crea");
    }

    public void run() {
        while (true) {
            try {
                sleep(1);
                if (this.jugador.getPosX() == 0) {
                    direccionX = 1;
                }
                if (this.jugador.getPosY() == 0) {
                    direccionY = 1;
                }
                if (this.jugador.getPosX() == panelJuego.getWidth()) {
                    direccionX = -1;
                }
                if (this.jugador.getPosY() == panelJuego.getHeight()) {
                    direccionY = -1;

                }
                this.jugador.setPosX(jugador.getPosX() + direccionX);
                direccionX = 0;
            } catch (InterruptedException ex) {
            }
            this.panelJuego.repaint();
        }
    }

    public void movDerecha() {
        this.direccionX = 1;
    }

    public void movIzquierda() {
        this.direccionX = -1;
    }
}
