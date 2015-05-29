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

    public HiloTortuga(PanelJuego panelJuego, Tortuga tortuga) {
        this.panelJuego = panelJuego;
        this.tortuga = tortuga;
    }

    public void run() {
        while (true) {
            try {
                HiloTortuga.sleep(20);
                if (tortuga.getPosX() == tortuga.getLimiteInicio()) {
                    tortuga.setLado(true);
                    this.direccionX = 1;
                    tortuga.setImgPers(tortuga.imgPersDer);
                }
                if (tortuga.getPosX() == tortuga.getLimiteFinal()) {
                    tortuga.setLado(false);
                    this.direccionX = -1;
                    tortuga.setImgPers(tortuga.imgPersIzq);
                }
                tortuga.setPosX(tortuga.getPosX() + this.direccionX);
            } catch (InterruptedException ex) {
            }
            this.panelJuego.repaint();
        }
    }
}
