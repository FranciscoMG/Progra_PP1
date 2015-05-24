/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Graphics;
import java.io.IOException;

/**
 *
 * @author francisco
 */
public class Jugador extends Personaje {

    public Jugador(int vidas, int posX, int posY) throws IOException {
        super(vidas, posX, posY, "src/img/p1_izquierda.png", "src/img/p1_derecha.png",
                "src/img/p2_izquierda.png", "src/img/p2_derecha.png");
    }

    public void pintarPersonaje(Graphics g) {
        g.drawImage(this.getImgPers(), this.getPosX(), this.getPosY(), 60, 60, null);
    }
}
