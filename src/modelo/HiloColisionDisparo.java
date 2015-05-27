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
public class HiloColisionDisparo extends Thread {

    private Bala bala;
    private ArrayList<Tortuga> listaTortugas;
    private Rectangle colicionadorBala;
    private Rectangle colicionadorTortuga;
    private ArrayList<HiloTortuga> hiloTortugas;

    public HiloColisionDisparo(Bala bala, ArrayList<Tortuga> listaTortugas, ArrayList<HiloTortuga> hiloTortugas) {
        this.bala = bala;
        this.listaTortugas = listaTortugas;
        this.hiloTortugas = hiloTortugas;
        colicionadorBala = new Rectangle();
        colicionadorTortuga = new Rectangle();
    }

    //////////////////////////////////////////////////////////////////////////
    public boolean isColision() {
        return colicionadorBala.intersects(colicionadorTortuga);
    }

    public void run() {
        while (true) {
            try {

                sleep(10);

                for (int index = 0; index < listaTortugas.size(); index++) {
                    colicionadorBala.setBounds(bala.getX(), bala.getY(), 50, 25);
                    colicionadorTortuga.setBounds(listaTortugas.get(index).getPosX(), listaTortugas.get(index).getPosY(), 60, 40);
                    if (isColision()) {
                        System.err.println(" la bala colisiono");
                        listaTortugas.remove(index);
                        hiloTortugas.get(index).stop();
                        sleep(3000);
                    }
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(HiloColisionDisparo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
