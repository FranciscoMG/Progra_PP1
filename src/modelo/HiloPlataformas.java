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
    private ArrayList<Rectangle> colisionadorPlataformas = new ArrayList<>();

    public HiloPlataformas(Jugador jugador, HiloJugador hilo) {
        this.jugador = jugador;
        this.hiloJugador = hilo;
        this.colisionadorJugador = new Rectangle();
        this.colisionadorPlataformas.add(new Rectangle(5, 634, 801, 52));
        this.colisionadorPlataformas.add(new Rectangle(5, 474, 293, 27));
        this.colisionadorPlataformas.add(new Rectangle(512, 474, 293, 27));
        this.colisionadorPlataformas.add(new Rectangle(0, 0, 293, 27));
    }

    public void run() {
        while (true) {
            try {
                sleep(150);
                this.colisionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 60);

                if (colisionadorJugador.intersects(colisionadorPlataformas.get(0))) {
                    hiloJugador.caida = false;
                }
                if (colisionadorJugador.intersects(colisionadorPlataformas.get(1)) || colisionadorJugador.intersects(colisionadorPlataformas.get(2)) && hiloJugador.altura >= 54) {
                    hiloJugador.caida = false;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
