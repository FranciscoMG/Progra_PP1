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

    private String imagenDerP1 = "src/img/p1_izquierda.png";
    private String imagenIzqP1 = "src/img/p1_derecha.png";
    private String imagenDerP2 = "src/img/p2_izquierda.png";
    private String imagenIzqP2 = "src/img/p2_derecha.png";

    public Jugador(int vidas, int posX, int posY) throws IOException {
        super(vidas, posX, posY, "src/img/p1_izquierda.png", "src/img/p1_derecha.png",
                "src/img/p2_izquierda.png", "src/img/p2_derecha.png", "src/img/p1_izquierda.gif", "src/img/p1_derecha.gif",
                "src/img/p2_izquierda.gif", "src/img/p2_derecha.gif");
    }

    public void camina(boolean camina) {

    }

    public void pintarPersonaje(Graphics g) {
        g.drawImage(this.getImgPers(), this.getPosX(), this.getPosY(), 60, 60, null);
    }
}
