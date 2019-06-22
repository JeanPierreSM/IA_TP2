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
class ReglasProductos {

    ArrayList<Regla> lista;

    public ReglasProductos() {
        this.lista = new ArrayList<>();

        Regla p = new Regla("Samsung Galaxy S10e");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("smartphone");
                add("alta gamma");
                add("portable");
                }
            }
        );
        lista.add(p);
        
        p = new Regla("Samsung Galaxy S10");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("smartphone");
                add("alta gamma");
                add("grande");
                }
            }
        );
        lista.add(p);
        
    }

    public ArrayList<Regla> getLista() {
        return lista;
    }

}
