/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupouno.ia_tp2;

import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class Respuesta {
    public String oracion;
    public ArrayList<String> palabrasClave;

    public Respuesta(String oracion) {
        this.oracion = oracion;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getOracion() {
        return oracion;
    }

    public void setOracion(String oracion) {
        this.oracion = oracion;
    }
    

    
}
