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
        plataformas.add(new Rectangle(5, 474, 293, 27));
        plataformas.add(new Rectangle(512, 474, 293, 27));
        plataformas.add(new Rectangle(5, 340, 80, 27));
        plataformas.add(new Rectangle(725, 340, 80, 27));
        plataformas.add(new Rectangle(194, 314, 424, 27));
        plataformas.add(new Rectangle (5, 153, 344, 27));
        plataformas.add(new Rectangle (461, 153, 344, 27));
    }
    
    public void run() {
        while (true) {
            try {
                sleep(50);
                this.colisionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 60);
                if (colisionadorJugador.intersects(suelo)) {
                    hiloJugador.caida = false;
                }
                for (Rectangle plataforma : plataformas) {
                    if (colisionadorJugador.intersects(plataforma)) {
                        hiloJugador.caida = false;
                        hiloJugador.salto = false;
                        hiloJugador.altura = 0;
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
