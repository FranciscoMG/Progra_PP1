/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PanelJuego;

/**
 *
 * @author vini
 */
public class HiloBala extends Thread {

    private int x;
    private int y;
    private Bala bala;
    private Personaje personaje;
    private boolean disparar;
    private PanelJuego panelJuego;

    public HiloBala(int x, int y, Bala bala, Personaje personaje, PanelJuego panelJuego) {
        this.x = x;
        this.y = y;
        this.bala = bala;
        this.panelJuego =panelJuego;
        this.personaje = personaje;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bala getBala() {
        return bala;
    }

    public void setBala(Bala bala) {
        this.bala = bala;
    }

    public boolean isDisparar() {
        return disparar;
    }

    public void setDisparar(boolean disparar) {
        this.disparar = disparar;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public void run() {
        try {
            while (true) {

                sleep(50);

                if (disparar) {
                    bala.setX(personaje.getPosX());
                    bala.setY(personaje.getPosY()-20);

                    if (personaje.isDerecha()) {
                        while (bala.getX() < 840) {
                            sleep(20);
                            bala.setX(bala.getX() + 10);
                            panelJuego.repaint();
                        }
                    } else {
                        while (bala.getX() > -50) {
                            sleep(20);
                            bala.setX(bala.getX() - 10);
                            panelJuego.repaint();
                        }
                    }
                    disparar = false;
                }
                panelJuego.repaint();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloBala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
