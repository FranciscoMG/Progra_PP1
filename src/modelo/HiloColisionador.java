/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Rectangle;
import java.util.ArrayList;
import vista.PnlInfoJuego;

/**
 *
 * @author vini
 */
public class HiloColisionador extends Thread {

    private ArrayList<Tortuga> listaT;
    private Jugador jugador;
    private Rectangle colicionadorTortugas;
    private Rectangle colicionadorJugador;
    private int cantidadColiciones = 0;
    private final PnlInfoJuego panelInfo;

    ///----------------------------------------------------------------------
    public HiloColisionador(PnlInfoJuego panelInfo, ArrayList<Tortuga> listaTortugas, Jugador jugador) {
        this.listaT = listaTortugas;
        this.jugador = jugador;
        this.panelInfo = panelInfo;
        this.colicionadorJugador = new Rectangle(jugador.getPosX(), jugador.getPosY(), 50, 50);
        this.colicionadorTortugas = new Rectangle();
    }

    //////////////////////////////////////////////////////////////////////////
    public boolean isColision() {
        return colicionadorJugador.intersects(colicionadorTortugas);
    }

    //////////////////////////////////////////////////////////////////////////
    public void run() {

        try {
            while (true) {
                sleep(200);
                this.colicionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 60);
                for (int index = 0; index < listaT.size(); index++) {
                    colicionadorTortugas.setBounds(listaT.get(index).getPosX(), listaT.get(index).getPosY(), 50, 50);
                    if (isColision()) {
                        cantidadColiciones++;
                        jugador.setVidas(jugador.getVidas() - 1);
                        panelInfo.setLblVida(String.valueOf(jugador.getVidas()));
                        if (jugador.getIsFirstPlayer()) {
                            jugador.setPosX(670);
                            jugador.setPosY(578);
                        } else {
                            jugador.setPosX(150);
                            jugador.setPosY(95);
                        }
                        
                        sleep(1000);
                    }
                } // fin de for
            }
        } catch (InterruptedException ex) {
        }
    } // Fin de metodo run

} // fin de clase
