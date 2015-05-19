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
public class HiloColicionador extends Thread {

    private ArrayList<Tortuga> listaT;
    private Jugador jugador;

    private Rectangle colicionadorTortugas;
    private Rectangle colicionadorJugador;
    private int cantidadColiciones = 0;

    
    ///----------------------------------------------------------------------
    public HiloColicionador(ArrayList<Tortuga> listaTortugas, Jugador jugador) {
        this.listaT = listaTortugas;
        this.jugador = jugador;

        this.colicionadorJugador = new Rectangle(jugador.getPosX(), jugador.getPosY(), 60, 108);
    }

    //////////////////////////////////////////////////////////////////////////
    public boolean isColision() {
        return colicionadorJugador.intersects(colicionadorTortugas);
    }

    //////////////////////////////////////////////////////////////////////////
    public void run() {

        try {
            while (true) {
                sleep(10);

                for (int index = 0; index < listaT.size(); index++) {
                    colicionadorTortugas = new Rectangle(listaT.get(index).getPosX(), listaT.get(index).getPosY(), 60, 108);
                    if (isColision()) {
                        cantidadColiciones++;
                        System.err.println("======>> "+cantidadColiciones);
                    }
                } // fin de for
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloColicionador.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // Fin de metodo run

} // fin de clase
