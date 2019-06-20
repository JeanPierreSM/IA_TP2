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
        //Sección Cliente - Notebook

        Respuesta r = new Respuesta("¿Está buscando un producto de gama básica, media o premium?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("buscar");
                add("compar");
                add("necesitar");
                add("notebook");
            }
        }
        );
        lista.add(r);

        r = new Respuesta("¿Necesita un ordenador de gama baja, media o alta?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("buscar");
                add("compar");
                add("necesitar");
                add("notebook");
            }
        }
        );
        lista.add(r);

        r = new Respuesta("¿Está buscando un equipo portable o prioriza una pantalla mas grande?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("baja");
                add("basica");
                add("media");
                add("alta");
            }
        }
        );
        lista.add(r);

        r = new Respuesta("¿Prefiere un equipo con pantalla grande? ¿O prioriza algo más pequeño?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("baja");
                add("basica");
                add("media");
                add("alta");
            }
        }
        );
        lista.add(r);

        r = new Respuesta("¿Quiere un equipo último modelo o prefiere economizar comprando modelos anteriores?");
        r.setPalabrasClave(new ArrayList<String>() {
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

        r = new Respuesta("¿Necesita un ordenador que salió recientemente en el mercado?");
        r.setPalabrasClave(new ArrayList<String>() {
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

        r = new Respuesta("¿Realiza trabajos de edición de imagenes/video?");
        r.setPalabrasClave(new ArrayList<String>() {
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

        r = new Respuesta("¿Está buscando un equipo con al menos 8GB de RAM?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
            }
        }
        );
        lista.add(r);

        r = new Respuesta("¿Necesita una PC con 8GB de RAM como mínimo?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
            }
        }
        );
        lista.add(r);

        /*ver que pasa con cadenas compuestas "mas de una palabra"
        r = new Respuesta("¿Necesita un ordenador con grandes capacidades de almacenamiento?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
                }
            }
        );
        lista.add(r);
         */
        
        r = new Respuesta("¿Considera de utilidad que el ordenador este equipado con una unidad de estado sólido (SDD)?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("mucho");
                add("almacenamiento");
                add("notebook");
                add("gran");
            }
        }
        );
        lista.add(r);
        
        r = new Respuesta("¿Necesita un ordenador con SDD?");
        r.setPalabrasClave(new ArrayList<String>() {
            {
                add("mucho");
                add("almacenamiento");
                add("notebook");
                add("gran");
            }
        }
        );
        lista.add(r);
        
        r = new Respuesta("De acuerdo a sus necesidades, ¿cree que necesita un microprocesador potente?");
        r.setPalabrasClave(new ArrayList<String>() {
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
