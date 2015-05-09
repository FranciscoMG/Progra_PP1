/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelo.HiloJugador;
import modelo.HiloTortuga;
import modelo.Jugador;
import modelo.Tortuga;
import vista.PanelJuego;

/**
 *
 * @author francisco
 */
public class ControlTecla implements KeyListener {

    PanelJuego panelJuego;
    private ArrayList<Tortuga> jugador = new ArrayList<>();
    ArrayList<HiloTortuga> hilo = new ArrayList<>();
//HiloJugador hilo = new HiloJugador(panelJuego, jugador.get(0));

    public ControlTecla(PanelJuego panel) {
        this.panelJuego = panel;
        try {
            jugador.add(new Tortuga(3, 6, 423, 6, 248));
            jugador.add(new Tortuga(3, 514, 423, 514, 756));
            jugador.add(new Tortuga(3, 193, 263, 193, 569));
        } catch (IOException ex) {
            Logger.getLogger(ControlTecla.class.getName()).log(Level.SEVERE, null, ex);
        }

        panelJuego.setTortuga(jugador);

        for (int i = 0; i < jugador.size(); i++) {
            hilo.add(new HiloTortuga(panelJuego, jugador.get(i)));
            hilo.get(i).start();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

        }
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {

        }
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {

        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
//hilo.movIzquierda();
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //  hilo.movDerecha();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
