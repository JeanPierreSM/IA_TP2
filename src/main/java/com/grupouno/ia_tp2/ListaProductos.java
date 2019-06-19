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
class ListaProductos {

    ArrayList<Producto> lista;

    public ListaProductos() {
        this.lista = new ArrayList<>();

        Producto p = new Producto("Samsung Galaxy S10e");
        p.setCaracteristicas(new ArrayList<String>() {
            {
                add("smartphone");
                add("alta gamma");
                add("portable");
                }
            }
        );
        lista.add(p);
        
        p = new Producto("Samsung Galaxy S10");
        p.setCaracteristicas(new ArrayList<String>() {
            {
                add("smartphone");
                add("alta gamma");
                add("grande");
                }
            }
        );
        lista.add(p);
        
    }

    public ArrayList<Producto> getLista() {
        return lista;
    }

}
