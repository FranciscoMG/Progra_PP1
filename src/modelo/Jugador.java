/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author francisco
 */
public class Jugador extends Personaje {

    public Jugador(int vidas, int x, int y) throws IOException {
        super(vidas, x, y, ImageIO.read(new File("src/img/jugador1_izquierda.png")), ImageIO.read(new File("src/img/jugador1_derecha.png")));
    }

    public void pintarPersonaje(Graphics g) {
        g.drawImage(this.getImgPers(), this.getPosX(), this.getPosY(), 50, 50, null);
    }
}
