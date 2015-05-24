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
    public int direccionY;
    public int altura = 0;
    public static boolean salto;
    public boolean caida;

    public HiloJugador(PanelJuego panelJuego, Jugador jugador) {
        this.panelJuego = panelJuego;
        this.jugador = jugador;
        this.jugador.setImgPers(jugador.imgPersIzq);
    }

    public void setDireccionX(int direccionx) {
        this.direccionX = direccionx;
    }

    public void run() {
        while (true) {
            try {
                sleep(25);
                if (salto) {
                    altura++;
                    direccionY = -1;
                    this.jugador.setPosY(jugador.getPosY() + direccionY * 3);
                    if (altura == 65) {
                        salto = false;
                        caida = true;
                    }
                }
                if (caida) {
                    altura--;
                    direccionY = 1;
                    this.jugador.setPosY(jugador.getPosY() + direccionY * 3);
                    if (altura == 0) {
                        caida = false;
                    }
                }
                this.jugador.setPosX(jugador.getPosX() + direccionX*5);
         
                direccionY = 0;

                if (jugador.getPosX() < 0) { // evita que se salga de -x
                    this.jugador.setPosX(jugador.getPosX() + 10);
                }
                if (jugador.getPosX() > 760) { // evita que se salga de +x
                    this.jugador.setPosX(jugador.getPosX() - 10);
                }

            } catch (InterruptedException ex) {
            }
            this.panelJuego.repaint();
        }
    }
}
