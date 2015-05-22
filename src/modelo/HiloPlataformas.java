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
    private Rectangle suelo = new Rectangle(5, 634, 801, 52);
    private Rectangle plataforma1 = new Rectangle(5, 474, 293, 27);
    private Rectangle plataforma2 = new Rectangle(512, 474, 293, 27);

    public HiloPlataformas(Jugador jugador, HiloJugador hilo) {
        this.jugador = jugador;
        this.hiloJugador = hilo;
        this.colisionadorJugador = new Rectangle();
    }

    public void run() {
        while (true) {
            try {
                sleep(150);
                this.colisionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 60);

                if (colisionadorJugador.intersects(suelo)) {
                    hiloJugador.caida = false;
                }
                if (colisionadorJugador.intersects(plataforma1) || colisionadorJugador.intersects(plataforma2) && hiloJugador.altura >= 54) {
                    hiloJugador.caida = false;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
