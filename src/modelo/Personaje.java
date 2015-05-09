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

    private int posX;
    private int posY;
    private int vidas;
    private Image imagenPersonaje;

    public Personaje(int x, int y, int vida, Image imagenPersonaje) {
        this.posX = x;
        this.posY = y;
        this.vidas = vida;
        this.imagenPersonaje = imagenPersonaje;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int x) {
        this.posX = x;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int y) {
        this.posY = y;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(byte vidas) {
        this.vidas = vidas;
    }

    public Image getImagenPersonaje() {
        return imagenPersonaje;
    }

    public void setImagenPersonaje(Image imagenPersonaje) {
        this.imagenPersonaje = imagenPersonaje;
    }

    public abstract void pintarPersonaje(Graphics g);
}
