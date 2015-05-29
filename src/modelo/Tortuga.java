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
public class Tortuga extends Personaje {

    private int limiteInicio, limiteFinal;

    public Tortuga(int vidas, int posX, int posY, int limiteInicio, int limiteFinal) throws IOException {
        super(vidas, posX, posY, "src/img/enemigo_izquierda.gif", "src/img/enemigo_derecha.gif", null, null, null, null, null, null);
        this.limiteInicio = limiteInicio;
        this.limiteFinal = limiteFinal;
    }

    public int getLimiteInicio() {
        return this.limiteInicio;
    }

    public void setLimiteInicio(int limiteInicio) {
        this.limiteInicio = limiteInicio;
    }

    public int getLimiteFinal() {
        return this.limiteFinal;
    }

    public void setLimiteFinal(int limiteFinal) {
        this.limiteFinal = limiteFinal;
    }

    public void pintarPersonaje(Graphics g) {
        g.drawImage(this.getImgPers(), this.getPosX(), this.getPosY(), 50, 50, null);
    }
}
