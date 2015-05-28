/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vini
 */
public class HiloColisionador extends Thread {

    private ArrayList<Tortuga> listaT;
    private Jugador jugador;

    private Rectangle colicionadorTortugas;
//    private Rectangle colicionadorTortugas2;
//    private Rectangle colicionadorTortugas3;
    private Rectangle colicionadorJugador;
    private int cantidadColiciones = 0;

    ///----------------------------------------------------------------------
    public HiloColisionador(ArrayList<Tortuga> listaTortugas, Jugador jugador) {
        this.listaT = listaTortugas;
        this.jugador = jugador;

        this.colicionadorJugador = new Rectangle(jugador.getPosX(), jugador.getPosY(), 60, 108);
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
                sleep(500);

                this.colicionadorJugador.setBounds(jugador.getPosX(), jugador.getPosY(), 60, 108);

                for (int index = 0; index < listaT.size(); index++) {
                    colicionadorTortugas.setBounds(listaT.get(index).getPosX(), listaT.get(index).getPosY(), 50, 50);
                    if (isColision()) {
                        cantidadColiciones++;
                        jugador.setVidas(jugador.getVidas() - 1);
                        if (jugador.getVidas() == 0) {
                            //terminar juego
                        }
                        System.err.println("vidas del jugador " + jugador.getVidas());
                        sleep(5000);
                    }
                } // fin de for
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloColisionador.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // Fin de metodo run

} // fin de clase
