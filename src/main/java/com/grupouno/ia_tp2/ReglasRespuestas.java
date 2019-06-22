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

        Regla regla = new Regla("¿Está buscando un producto de gama básica, media o premium?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("compar");
                add("necesitar");
                add("notebook");
            }
        }
        );
        lista.add(regla);

        regla = new Regla("¿Necesita un ordenador de gama baja, media o alta?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("compar");
                add("necesitar");
                add("notebook");
            }
        }
        );
        lista.add(regla);

        regla = new Regla("¿Está buscando un equipo portable o prioriza una pantalla mas grande?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("gamma baja");
                add("basica");
                add("gamma media");
                add("gamma alta");
            }
        }
        );
        lista.add(regla);

        regla = new Regla("¿Prefiere un equipo con pantalla grande? ¿O prioriza algo más pequeño?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("baja");
                add("basica");
                add("media");
                add("alta");
            }
        }
        );
        lista.add(regla);

        regla = new Regla("¿Quiere un equipo último modelo o prefiere economizar comprando modelos anteriores?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("pantalla");
                add("grande");
                add("notebook");
                add("portable");
                add("pequeña");
            }
        }
        );
        lista.add(regla);

        PreguntaSiNo siNo1 = new PreguntaSiNo("¿Necesita un ordenador que salió recientemente en el mercado?");
        siNo1.setAntecedentes(new ArrayList<String>() {
            {
                add("pantalla");
                add("grande");
                add("notebook");
                add("portable");
                add("pequeña");
            }
        }
        );
        siNo1.setIfSi(new ArrayList<String>() {
            {
                add("reciente");
                add("ultimo");
                add("nuevo");
            }
        }
        );
        siNo1.setIfNo(new ArrayList<String>() {
            {
                add("viejo");
                add("economizar");
            }
        }
        );
        lista.add(siNo1);

        PreguntaSiNo siNo2 = new PreguntaSiNo("¿Está buscando un equipo con al menos 8GB de RAM?");
        siNo2.setAntecedentes(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
            }
        }
        );
        lista.add(siNo2);

        siNo1 = new PreguntaSiNo("¿Realiza trabajos de edición de imagenes/video?");
        siNo1.setAntecedentes(new ArrayList<String>() {
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
        siNo1.setIfSi(new ArrayList<String>() {
            {
                add("edicion");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);

        regla = new Regla("¿Necesita una PC con 8GB de RAM como mínimo?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
            }
        }
        );
        lista.add(regla);

        /*ver que pasa con cadenas compuestas "mas de una palabra"
        regla = new Regla("¿Necesita un ordenador con grandes capacidades de almacenamiento?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("edicion");
                add("editar");
                }
            }
        );
        lista.add(regla);
         */
        siNo1 = new PreguntaSiNo("¿Considera de utilidad que el ordenador este equipado con una unidad de estado sólido (SDD)?");
        siNo1.setAntecedentes(new ArrayList<String>() {
            {
                add("mucho");
                add("almacenamiento");
                add("notebook");
                add("gran");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);

        siNo1 = new PreguntaSiNo("¿Necesita un ordenador con SSD?");
        siNo1.setAntecedentes(new ArrayList<String>() {
            {
                add("mucho");
                add("almacenamiento");
                add("notebook");
                add("gran");
            }
        }
        );
        siNo1.setIfSi(new ArrayList<String>() {
            {
                add("ssd");
            }
        }
        );

        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);

        regla = new Regla("De acuerdo a sus necesidades, ¿cree que necesita un microprocesador potente?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("querer");
                add("ssd");
                add("necesitar");
            }
        }
        );
        lista.add(regla);

        //Ultimas dos filas
        this.genericas = new ArrayList<>();
        regla = new Regla("Perfecto!");
        genericas.add(regla);
        regla = new Regla("Excelente!");
        genericas.add(regla);
        regla = new Regla("Entendido!");
        genericas.add(regla);

    }

    public ArrayList<Regla> getGenericas() {
        return genericas;
    }

    public ArrayList<Regla> getLista() {
        return lista;
    }
}
