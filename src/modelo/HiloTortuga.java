/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.PanelJuego;

/**
 *
 * @author francisco
 */
public class HiloTortuga extends Thread {

    private PanelJuego panelJuego;
    public Tortuga tortuga;
    public int direccionX;
    public boolean lado;

    public HiloTortuga(PanelJuego panelJuego, Tortuga tortuga) {
        this.panelJuego = panelJuego;
        this.tortuga = tortuga;
    }

    public void run() {
        while (true) {
            try {
                HiloTortuga.sleep(20);
                if (this.tortuga.getPosX() == this.tortuga.getLimiteInicio()) {
                    lado = true;
                    direccionX = 1;
                    this.tortuga.setImgPers(tortuga.imgPersDer);
                }
                if (this.tortuga.getPosX() == this.tortuga.getLimiteFinal()) {
                    lado = false;
                    direccionX = -1;
                    this.tortuga.setImgPers(tortuga.imgPersIzq);
                }
                this.tortuga.setPosX(this.tortuga.getPosX() + direccionX);
            } catch (InterruptedException ex) {
            }
            this.panelJuego.repaint();
        }
    }
}
