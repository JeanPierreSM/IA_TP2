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
class ReglasRespuestas {

    ArrayList<Regla> lista;
    ArrayList<Regla> genericas;

    public ReglasRespuestas() {

        this.lista = new ArrayList<>();
        //Sección Cliente - Notebook

        Regla r = new PreguntaSiNo("¿Está buscando un producto de gama básica, media o premium?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("compar");
                add("necesitar");
                add("notebook");
            }
        }
        );
        lista.add(r);

        r = new Regla("¿Necesita un ordenador de gama baja, media o alta?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("compar");
                add("necesitar");
                add("notebook");
            }
        }
        );
        lista.add(r);

        r = new Regla("¿Está buscando un equipo portable o prioriza una pantalla mas grande?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("baja");
                add("basica");
                add("media");
                add("alta");
            }
        }
        );
        lista.add(r);

        r = new Regla("¿Prefiere un equipo con pantalla grande? ¿O prioriza algo más pequeño?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("baja");
                add("basica");
                add("media");
                add("alta");
            }
        }
        );
        lista.add(r);

        r = new Regla("¿Quiere un equipo último modelo o prefiere economizar comprando modelos anteriores?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("pantalla");
                add("grande");
                add("notebook");
                add("portable");
                add("pequeña");
            }
        }
        );
        lista.add(r);

        PreguntaSiNo p = new PreguntaSiNo("¿Necesita un ordenador que salió recientemente en el mercado?");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("pantalla");
                add("grande");
                add("notebook");
                add("portable");
                add("pequeña");
            }
        }
        );
        p.setIfSi(new ArrayList<String>() {
            {
                add("reciente");
                add("ultimo");
                add("nuevo");
            }
        }
        );
        p.setIfNo(new ArrayList<String>() {
            {
                add("viejo");
                add("economizar");
            }
        }
        );
        lista.add(p);

        r = new Regla("¿Realiza trabajos de edición de imagenes/video?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("ultimo");
                add("modelo");
                add("notebook");
                add("reciente");
                add("nuevo");
                add("economizar");
                add("viejo");
                add("nuevo");
            }
        }
        );
        lista.add(r);

        r = new Regla("¿Está buscando un equipo con al menos 8GB de RAM?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
            }
        }
        );
        lista.add(r);

        r = new Regla("¿Necesita una PC con 8GB de RAM como mínimo?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
            }
        }
        );
        lista.add(r);

        /*ver que pasa con cadenas compuestas "mas de una palabra"
        r = new Regla("¿Necesita un ordenador con grandes capacidades de almacenamiento?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
                }
            }
        );
        lista.add(r);
         */
        r = new Regla("¿Considera de utilidad que el ordenador este equipado con una unidad de estado sólido (SDD)?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("mucho");
                add("almacenamiento");
                add("notebook");
                add("gran");
            }
        }
        );
        lista.add(r);

        p = new PreguntaSiNo("¿Necesita un ordenador con SSD?");
        p.setAntecedentes(new ArrayList<String>() {
            {
                add("mucho");
                add("almacenamiento");
                add("notebook");
                add("gran");
            }
        }
        );
        p.setIfSi(new ArrayList<String>() {
            {
                add("ssd");
            }
        }
        );
        p.setIfNo(new ArrayList<String>() {
            {
            }
        }
        );
        lista.add(p);

        r = new Regla("De acuerdo a sus necesidades, ¿cree que necesita un microprocesador potente?");
        r.setAntecedentes(new ArrayList<String>() {
            {
                add("querer");
                add("ssd");
                add("necesitar");
            }
        }
        );
        lista.add(r);

        //Ultimas dos filas
        this.genericas = new ArrayList<>();
        r = new Regla("Perfecto!");
        genericas.add(r);
        r = new Regla("Excelente!");
        genericas.add(r);
        r = new Regla("Entendido!");
        genericas.add(r);

    }

    public ArrayList<Regla> getGenericas() {
        return genericas;
    }

    public ArrayList<Regla> getLista() {
        return lista;
    }
}
