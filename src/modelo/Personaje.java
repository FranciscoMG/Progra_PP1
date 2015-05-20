/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author francisco
 */
public abstract class Personaje {

    private int vidas;
    private int posX;
    private int posY;
    private Image imgPers;
    public Image imgPersIzq;
    public Image imgPersDer;
    
    private boolean derecha;

    public Personaje(int vidas, int posX, int posY, Image imgPersIzq, Image imgPersDer) {
        this.vidas = vidas;
        this.posX = posX;
        this.posY = posY;
        this.imgPersIzq = imgPersIzq;
        this.imgPersDer = imgPersDer;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPosX() {
        return posX;
    }
    
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Image getImgPers() {
        return imgPers;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }
    
    

    public void setImgPers(Image imgPers) {
        this.imgPers = imgPers;
    }

    public abstract void pintarPersonaje(Graphics g);
}
