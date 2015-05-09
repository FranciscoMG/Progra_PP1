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
public class Jugador extends Personaje {

    public Jugador(int x, int y, int vidas, Image imagen) {
        super(x, y, vidas, imagen);
    }

    public void pintarPersonaje(Graphics g) {
        g.drawImage(this.getImagenPersonaje(), this.getPosX(), this.getPosY(), 50, 50, null);
    }
}
