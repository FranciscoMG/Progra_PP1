/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Graphics;

/**
 *
 * @author vini
 */
public class Alas extends Personaje {

    public Alas(int posX, int posY) {
        super(0, 100, 100, "src/img/pow0.png", "src/img/alas.gif", null, null, null, null, null, null);
    }

    public void pintarPersonaje(Graphics g) {
        g.drawImage(this.getImgPers(), this.getPosX(), this.getPosY(), 140, 100, null);
    }

}
