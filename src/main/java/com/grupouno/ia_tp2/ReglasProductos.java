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
        
        
        //PRODUCTOS SMARTPHONES.
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
        
        
        //PRODUCTOS TELEVISORES.
        p = new Regla("Smart TV 32 HD Samsung J4300");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("tv");
                add("smart");
                add("samsung");
                add("32");
                add("hd");
                }
            }
        );
        lista.add(p);
        
        p = new Regla("Smart TV 32 HD TCL L32s6500");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("tv");
                add("smart");
                add("tcl");
                add("32");
                add("hd");
                }
            }
        );
        lista.add(p);
        
        p = new Regla("Smart TV 32 HD LG 32lj600b");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("tv");
                add("smart");
                add("lg");
                add("32");
                add("hd");
                }
            }
        );
        lista.add(p);
        
        p = new Regla("Smart TV Philips 32 HD 32phg5102/77-5813");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("tv");
                add("smart");
                add("philips");
                add("32");
                add("hd");
                }
            }
        );
        lista.add(p);
        
        
        //PRODUCTOS TABLETS
        p = new Regla("Tablet Gadnic Fenix Phone Dual Chip");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("tablet");
                add("mala camara");
                add("pantalla grande");
                add("2gb");
                add("mucho almacenamiento");
                }
            }
        );
        lista.add(p);
        
        p = new Regla("Tablet samsung Galaxy Tab 4 SM-T560");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("tablet");
                add("buena camara");
                add("pantalla pequeña");
                add("8gb");
                add("poco almacenamiento");
                }
            }
        );
        lista.add(p);
        
    }

    public ArrayList<Regla> getLista() {
        return lista;
    }

}
