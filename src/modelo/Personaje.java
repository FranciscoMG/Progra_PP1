/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author francisco
 */
public abstract class Personaje {

    private int vidas;
    private int posX;
    private int posY;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Image imgPers;
    public Image imgPersIzq;
    public Image imgPersDer;
    public Image imagPersIzq2;
    public Image imgPerDer2;
    private Boolean isFirstPlayer = true;

    private boolean derecha;

    public Personaje(int vidas, int posX, int posY, String imgPersIzq, String imgPersDer, String imgP2Izquierda, String imgP2Derecha) {
        this.vidas = vidas;
        this.posX = posX;
        this.posY = posY;
        this.imgPersIzq = toolkit.createImage(imgPersIzq);
        this.imgPersDer = toolkit.createImage(imgPersDer);
        this.imgPerDer2 = toolkit.createImage(imgP2Derecha);
        this.imagPersIzq2 = toolkit.createImage(imgP2Izquierda);
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
