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
class Producto {
    public String nombre;
    public ArrayList<String> caracteristicas;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
}
