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

    public void run() {
        while (true) {
            try {
                sleep(20);
                if (salto) {
                    altura++;
                    direccionY = -1;
                    this.jugador.setPosY(jugador.getPosY() + direccionY * 3);
                    if (altura == 58) {
                        //altura = 0;
                        salto = false;
                        caida = true;
                    }
                }
                if (jugador.getPosY() == 413 && jugador.getPosX() <= 268 || jugador.getPosX() >= 484) {
                    caida = false;
                } else {
                    if (jugador.getPosY() != 578) {
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
                this.jugador.setPosX(jugador.getPosX() + direccionX * 3);
                //System.out.println(jugador.getPosX() + "," + jugador.getPosY());
                direccionX = 0;
                direccionY = 0;
            } catch (InterruptedException ex) {
            }
            this.panelJuego.repaint();
        }
    }
}
