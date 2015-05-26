/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author francisco
 */
public class Usuario {

    private String nombre;
    private String[] mejoresTiempos = {"9:59", "9:59", "9:59", "9:59", null};

    ;

    public Usuario(String nombre, String[] tiempos) {
        this.nombre = nombre;
        if (tiempos != null) {
            this.mejoresTiempos = tiempos;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getMejoresTiempos() {
        return mejoresTiempos;
    }

    public void setMejoresTiempos(String[] tiempos) {
        this.mejoresTiempos = tiempos;
    }

    public void nuevoTiempo(String tiempo) {
        String aux;
        mejoresTiempos[4] = tiempo;
        for (int i = 0; i < mejoresTiempos.length; i++) {
            for (int k = 0; k < mejoresTiempos.length - 1; k++) {
                if (Integer.parseInt(this.mejoresTiempos[k].split(":")[0]) > Integer.parseInt(this.mejoresTiempos[k + 1].split(":")[0])) {
                    aux = mejoresTiempos[k];
                    mejoresTiempos[k] = mejoresTiempos[k + 1];
                    mejoresTiempos[k + 1] = aux;
                }
            }
        }
        for (int i = 0; i < mejoresTiempos.length; i++) {
            for (int k = 0; k < mejoresTiempos.length - 1; k++) {
                if (Integer.parseInt(this.mejoresTiempos[k].split(":")[0]) == Integer.parseInt(this.mejoresTiempos[k + 1].split(":")[0]) && Integer.parseInt(this.mejoresTiempos[k].split(":")[1]) > Integer.parseInt(this.mejoresTiempos[k + 1].split(":")[1])) {
                    aux = mejoresTiempos[k];
                    mejoresTiempos[k] = mejoresTiempos[k + 1];
                    mejoresTiempos[k + 1] = aux;
                }
            }
        }
    }
}
