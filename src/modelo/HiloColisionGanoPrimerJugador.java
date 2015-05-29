/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControlJuego;
import java.awt.Rectangle;
import java.io.IOException;
import vista.GUIJuego;
import vista.PanelJuego;

/**
 *
 * @author vini
 */
public class HiloColisionGanoPrimerJugador extends Thread {

    private Rectangle colisionadorJugador;
    private Rectangle meta1;
    private Rectangle meta2;
    private Rectangle pow;
    private int contadorGane;
    private PanelJuego panelJuego;
    private Jugador jugador;
    private ControlJuego controlJuego;

    //-------------------------------------------------------------------------
    public HiloColisionGanoPrimerJugador(PanelJuego panelJuego, Jugador jugador, ControlJuego controlJuego) {
        this.panelJuego = panelJuego;
        this.jugador = jugador;
        this.colisionadorJugador = new Rectangle();
        this.controlJuego = controlJuego;
        this.meta1 = new Rectangle(0, 30, 100, 100);
        this.meta2 = new Rectangle(710, 30, 100, 100);
        this.pow = new Rectangle(385, 474, 50, 50);
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean isColisionDerecha() {
        if (this.colisionadorJugador.intersects(this.meta2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isColisionIzquierda() {
        if (this.colisionadorJugador.intersects(this.meta1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isColicionPow() {
        return this.colisionadorJugador.intersects(this.pow);
    }

    public void run() {
        while (true) {
            try {
                sleep(250);
                this.colisionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 60);
                if (jugador.getIsFirstPlayer()) {
                    if (isColisionDerecha()) {
                        jugador.setIsFirstPlayer(false); // Si el jugador coliciona con la meta 
                        jugador.setPosX(150);
                        jugador.setPosY(95);
                        jugador.setImgPers(jugador.imgPersDer2);
                        panelJuego.activarPow();
                    }
                    if (isColisionIzquierda()) {
                        jugador.setIsFirstPlayer(false); // Si el jugador coliciona con la meta 
                        jugador.setPosX(600);
                        jugador.setPosY(95);
                        jugador.setImgPers(jugador.imgPersIzq2);
                        panelJuego.activarPow();
                    }
                }
                if (jugador.getIsFirstPlayer() == false) {
                    if (isColicionPow()) {
                        panelJuego.activarPuntos();
                        sleep(2000);
                        this.contadorGane++;
                        if (this.contadorGane == 3) {
                            controlJuego.registroJuego.panelInfo.usuarioActual.nuevoTiempo(controlJuego.registroJuego.hiloTiempo.getTiempo());
                            controlJuego.registroJuego.panelInfo.registroUsuario.modificarUsuario(controlJuego.registroJuego.panelInfo.usuarioActual);
                            GUIJuego.mensaje("¡Felicidades! Ganó el juego.", 0, 1);
                            controlJuego.muestraPantallaInicio(true);
                        }
                        panelJuego.activarPow();
                    }
                }
            } catch (InterruptedException ex) {
            } catch (IOException ex) {
            }
        }
    }
}
