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
    private Alas alas;
    public int direccionX;
    public int direccionY;
    public int altura = 0;
    public boolean salto;
    public boolean caida;

    public HiloJugador(PanelJuego panelJuego, Jugador jugador, Alas alas) {
        this.panelJuego = panelJuego;
        this.jugador = jugador;
        this.jugador.setImgPers(jugador.imgPersIzq);
        this.alas = alas;
    }

    public void setDireccionX(int direccionx) {
        this.direccionX = direccionx;
    }

    public void run() {
        while (true) {
            try {
                sleep(20);
                if (this.salto) {
                    this.altura++;
                    this.direccionY = -1;
                    jugador.setPosY(jugador.getPosY() + this.direccionY * 3);
                    if (this.altura == 65) {
                        this.salto = false;
                        this.caida = true;
                    }
                }
                if (this.caida) {
                    this.altura--;
                    this.direccionY = 1;
                    jugador.setPosY(jugador.getPosY() + this.direccionY * 3);
                }
                jugador.setPosX(jugador.getPosX() + this.direccionX * 5);
                this.direccionY = 0;
                if (jugador.getPosX() < 0) { // evita que se salga de -x
                    jugador.setPosX(jugador.getPosX() + 10);
                }
                if (jugador.getPosX() > 760) { // evita que se salga de +x
                    jugador.setPosX(jugador.getPosX() - 10);
                }
                if (this.salto || this.caida) {
                    alas.setImgPers(alas.imgPersDer);
                    alas.setPosX(jugador.getPosX() - 40);
                    alas.setPosY(jugador.getPosY() - 24);
                } else {
                    alas.setImgPers(alas.imgPersIzq);
                }

            } catch (InterruptedException ex) {
            }
            panelJuego.repaint();
        }
    }
}
