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
class ListaRespuestas {
    ArrayList<Respuesta> lista;
    ArrayList<Respuesta> genericas;
    
    public ListaRespuestas() {
        this.lista = new ArrayList<>();

        Respuesta r = new Respuesta("Hola!");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("hola");
                }
            }
        );
        lista.add(r);
        
        r = new Respuesta("Hola, que tal?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("hola");
                }
            }
        );
        lista.add(r);
        
        r = new Respuesta("Que haces, CAPO");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("hola");
                }
            }
        );
        lista.add(r);
        
        this.genericas = new ArrayList<>();
        r = new Respuesta("Perfecto!");
        genericas.add(r);
        r = new Respuesta("Excelente!");
        genericas.add(r);
        r = new Respuesta("Entendido!");
        genericas.add(r);
        
    }

    public ArrayList<Respuesta> getGenericas() {
        return genericas;
    }

    public ArrayList<Respuesta> getLista() {
        return lista;
    }
}
