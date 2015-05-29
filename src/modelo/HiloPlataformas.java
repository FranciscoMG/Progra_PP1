/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author francisco
 */
public class HiloPlataformas extends Thread {

    private Jugador jugador;
    private HiloJugador hiloJugador;
    private Rectangle colisionadorJugador;
    private Rectangle suelo = new Rectangle(5, 634, 802, 53);
    private ArrayList<Rectangle> plataformas = new ArrayList<>();

    public HiloPlataformas(Jugador jugador, HiloJugador hilo) {
        this.jugador = jugador;
        this.hiloJugador = hilo;
        this.colisionadorJugador = new Rectangle();
        this.plataformas.add(new Rectangle(5, 474, 293, 27));
        this.plataformas.add(new Rectangle(512, 474, 293, 27));
        this.plataformas.add(new Rectangle(5, 340, 80, 27));
        this.plataformas.add(new Rectangle(725, 340, 80, 27));
        this.plataformas.add(new Rectangle(194, 314, 424, 27));
        this.plataformas.add(new Rectangle(5, 153, 344, 27));
        this.plataformas.add(new Rectangle(461, 153, 344, 27));
    }

    public void run() {
        while (true) {
            try {
                sleep(20);
                this.colisionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 60);
                if (this.colisionadorJugador.intersects(this.suelo)) {
                    hiloJugador.caida = false;
                }
                for (Rectangle plataforma : plataformas) {
                    if (this.colisionadorJugador.intersects(plataforma)) {
                        if (jugador.getPosY() == 500 || jugador.getPosY() == 365 || jugador.getPosY() == 338 || jugador.getPosY() == 179) {
                            hiloJugador.salto = false;
                            hiloJugador.caida = true;
                        } else {
                            if (((jugador.getPosX() < 280 || jugador.getPosX() > 480) && jugador.getPosY() == 416) || ((jugador.getPosX() < 60 || jugador.getPosX() > 700) && jugador.getPosY() == 281) || ((jugador.getPosX() > 160 && jugador.getPosX() < 600) && jugador.getPosY() == 257) || ((jugador.getPosX() < 330 || jugador.getPosX() > 430) && jugador.getPosY() == 95)) {
                                hiloJugador.caida = false;
                                hiloJugador.salto = false;
                            } else {
                                hiloJugador.caida = true;
                                hiloJugador.salto = false;
                            }
                        }
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
