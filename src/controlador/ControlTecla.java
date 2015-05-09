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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelo.HiloJugador;
import modelo.Jugador;
import vista.PanelJuego;

/**
 *
 * @author francisco
 */
public class ControlTecla implements KeyListener {

    PanelJuego panelJuego;
    private Jugador jugador;
HiloJugador hilo = new HiloJugador(panelJuego, jugador);

    public ControlTecla(PanelJuego panel) {
        this.panelJuego = panel;
        try {
            jugador = new Jugador(600, 100, 3, ImageIO.read(new File("jugador1_derecha.png")));

        } catch (IOException ex) {

        }
        panelJuego.setJugador(jugador);
        HiloJugador hilo = new HiloJugador(panelJuego, jugador);
        hilo.start();

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
hilo.movIzquierda();
        }
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hilo.movDerecha();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
