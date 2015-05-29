/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControlJuego;
import java.awt.Rectangle;
import java.util.ArrayList;
import vista.GUIJuego;
import vista.PnlInfoJuego;

/**
 *
 * @author vini
 */
public class HiloColisionador extends Thread {

    private ArrayList<Tortuga> listaT;
    private Jugador jugador;
    private Rectangle colisionadorTortugas;
    private Rectangle colisionadorJugador;
    private int cantidadColiciones = 0;
    private PnlInfoJuego panelInfo;
    private ControlJuego controlJuego;

    ///----------------------------------------------------------------------
    public HiloColisionador(PnlInfoJuego panelInfo, ArrayList<Tortuga> listaTortugas, Jugador jugador, ControlJuego controlJuego) {
        this.listaT = listaTortugas;
        this.jugador = jugador;
        this.panelInfo = panelInfo;
        this.colisionadorJugador = new Rectangle(jugador.getPosX(), jugador.getPosY(), 50, 50);
        this.colisionadorTortugas = new Rectangle();
        this.controlJuego = controlJuego;
    }

    //////////////////////////////////////////////////////////////////////////
    public boolean isColision() {
        return this.colisionadorJugador.intersects(this.colisionadorTortugas);
    }

    //////////////////////////////////////////////////////////////////////////
    public void run() {
        try {
            while (true) {
                sleep(200);
                this.colisionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 60);
                for (int index = 0; index < listaT.size(); index++) {
                    this.colisionadorTortugas.setBounds(listaT.get(index).getPosX(), listaT.get(index).getPosY(), 50, 50);
                    if (isColision()) {
                        this.cantidadColiciones++;
                        jugador.setVidas(jugador.getVidas() - 1);
                        panelInfo.setLblVida(String.valueOf(jugador.getVidas()));
                        if (jugador.getIsFirstPlayer()) {
                            jugador.setPosX(670);
                            jugador.setPosY(578);
                        } else {
                            jugador.setPosX(150);
                            jugador.setPosY(95);
                        }
                        if (this.cantidadColiciones == 3) {
                            GUIJuego.mensaje("Ya no tienes más vidas ¡Juego terminado!", 0, 1);
                            controlJuego.muestraPantallaInicio(true);
                        }
                        sleep(1000);
                    }
                } // fin de for
            }
        } catch (InterruptedException ex) {
        }
    } // Fin de metodo run
} // fin de clase
