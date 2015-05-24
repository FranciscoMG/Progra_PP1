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
    public Image imagPersIzq2;
    public Image imgPerDer2;
    private Boolean isFirstPlayer = true;
    
    private boolean derecha;

    public Personaje(int vidas, int posX, int posY, Image imgPersIzq, Image imgPersDer, Image imgP2Izquierda, Image imgP2Derecha) {
        this.vidas = vidas;
        this.posX = posX;
        this.posY = posY;
        this.imgPersIzq = imgPersIzq;
        this.imgPersDer = imgPersDer;
        this.imgPerDer2 = imgP2Derecha;
        this.imagPersIzq2 = imgP2Izquierda;
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

    public Boolean getIsFirstPlayer() {
        return isFirstPlayer;
    }

    public void setIsFirstPlayer(Boolean isFirstPlayer) {
        this.isFirstPlayer = isFirstPlayer;
    }
    
    

    public void setImgPers(Image imgPers) {
        this.imgPers = imgPers;
    }

    public abstract void pintarPersonaje(Graphics g);
}
