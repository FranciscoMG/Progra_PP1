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
 * @author vini
 */
public class HiloColisionDisparo extends Thread {

    private Bala bala;
    private ArrayList<Tortuga> listaTortugas;
    private Rectangle colisionadorBala;
    private Rectangle colisionadorTortuga;
    private ArrayList<HiloTortuga> hiloTortugas;

    public HiloColisionDisparo(Bala bala, ArrayList<Tortuga> listaTortugas, ArrayList<HiloTortuga> hiloTortugas) {
        this.bala = bala;
        this.listaTortugas = listaTortugas;
        this.hiloTortugas = hiloTortugas;
        this.colisionadorBala = new Rectangle();
        this.colisionadorTortuga = new Rectangle();
    }

    //////////////////////////////////////////////////////////////////////////
    public boolean isColision() {
        return this.colisionadorBala.intersects(colisionadorTortuga);
    }

    public void run() {
        while (true) {
            try {
                sleep(10);
                for (int index = 0; index < listaTortugas.size(); index++) {
                    this.colisionadorBala.setBounds(bala.getX(), bala.getY(), 50, 25);
                    this.colisionadorTortuga.setBounds(listaTortugas.get(index).getPosX(), listaTortugas.get(index).getPosY(), 50, 50);
                    if (isColision()) {
                        listaTortugas.remove(index);
                        hiloTortugas.get(index).stop();
                        hiloTortugas.remove(index);
                        sleep(3000);
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
