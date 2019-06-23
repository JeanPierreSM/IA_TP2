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
        

        //INICIO SECCION CLIENTE - NOTEBOOK.
        Regla regla = new Regla("¿Está buscando un producto de gama básica, media o premium?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("comprar");
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
        siNo1 = new PreguntaSiNo("¿Considera de utilidad que el ordenador esté equipado con una unidad de estado sólido (SSD)?");
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
        //FIN SECCION CLIENTE - NOTEBOOK.
        
        
        
        //INICIO SECCION CLIENTE - TV.
        siNo1 = new PreguntaSiNo("¿Necesita un televisor Smart?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("comprar");
                add("necesitar");
                add("televisor");
            }
        }
        );
        siNo1.setIfSi(new ArrayList<String>() {
            {
                add("smart");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        siNo1 = new PreguntaSiNo("¿Quiere un televisor Smart?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("comprar");
                add("necesitar");
                add("televisor");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("smart");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        regla = new Regla("¿Quiere un televisor de alguna marca en particular?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("smart");
                add("televisor");
            }
        }
        );
        lista.add(regla);
        
        regla = new Regla("¿Está buscando una marca de televisor específica?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("smart");
                add("televisor");
            }
        }
        );
        lista.add(regla);
        
        siNo1 = new PreguntaSiNo("¿Considera suficiente un televisor de 32 pulgadas?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("samsung");
                add("lg");
                add("tcl");
                add("philips");
                add("igual");
                add("marca");
                add("diez");
                add("veinte");
                add("importa");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("suficiente");
                add("bien");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        siNo1 = new PreguntaSiNo("¿Un televisor de 32 pulgadas le parece bien?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("samsung");
                add("lg");
                add("tcl");
                add("philips");
                add("igual");
                add("marca");
                add("diez");
                add("veinte");
                add("importa");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("suficiente");
                add("bien");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        regla = new Regla("¿Qué resolución de pantalla necesita?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("32");
                add("suficiente");
                add("mas");
                add("televisor");
            }
        }
        );
        lista.add(regla);
        
        regla = new Regla("¿Quiere un televisor HD, Full HD o 4K?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("32");
                add("suficiente");
                add("mas");
                add("televisor");
            }
        }
        );
        lista.add(regla);
        
        regla = new Regla("¿Cuánto esta dispuesto a pagar?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("hd");
                add("fullhd");
                add("4k");
                add("televisor");
            }
        }
        );
        lista.add(regla);
        
        regla = new Regla("¿Cuál es su limite económico para gastar?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("hd");
                add("fullhd");
                add("4k");
                add("televisor");
            }
        }
        );
        lista.add(regla);
        //FIN SECCION CLIENTE - TV.
        
        
        
        //INICIO SECCION CLIENTE - TABLET.
        regla = new Regla("¿Qué uso le vas a dar a la tablet?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("comprar");
                add("necesitar");
                add("tablet");
            }
        }
        );
        lista.add(regla);
        
        regla = new Regla("¿Para qué vas a utilizar la tablet?", Regla.Prioridad.ALTA);
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buscar");
                add("comprar");
                add("necesitar");
                add("tablet");
            }
        }
        );
        lista.add(regla);
        
        siNo1 = new PreguntaSiNo("¿Prefiere una tablet con al menos 2GB de RAM?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("redes");
                add("jugar");
                add("videojuegos");
                add("estudiar");
                add("tablet");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("2gb");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        siNo1 = new PreguntaSiNo("¿Necesita una tablet que tenga, como mínimo, 2GB de RAM?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("redes");
                add("jugar");
                add("videojuegos");
                add("estudiar");
                add("tablet");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("2gb");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        siNo1 = new PreguntaSiNo("¿Quiere una tablet con buena cámara?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("mas");
                add("2gb");
                add("tablet");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("buena camara");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        siNo1 = new PreguntaSiNo("¿Es relevante para usted la calidad de la cámara?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("mas");
                add("2gb");
                add("tablet");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("buena camara");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        regla = new Regla("¿Qué tamaño de pantalla esta necesitando?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buena");
                add("potente");
                add("decente");
                add("camara");
                add("importa");
                add("tablet");
            }
        }
        );
        lista.add(regla);
        
        regla = new Regla("¿De que tamaño de pantalla es la tablet que está buscando?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("buena");
                add("potente");
                add("decente");
                add("camara");
                add("importa");
                add("tablet");
            }
        }
        );
        lista.add(regla);
        
        siNo1 = new PreguntaSiNo("¿Necesita una tablet con gran capacidad de almacenamiento interno?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("al");
                add("menos");
                add("7");
                add("9");
                add("11");
                add("tablet");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("mucho almacenamiento");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        siNo1 = new PreguntaSiNo("¿Quiere una tablet con mucha capacidad de almacenamiento?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("al");
                add("menos");
                add("7");
                add("9");
                add("11");
                add("tablet");
            }
        }
        );
         siNo1.setIfSi(new ArrayList<String>() {
            {
                add("mucho almacenamiento");
            }
        }
        );
        siNo1.setSiguientes(new ArrayList<>());
        siNo1.getSiguientes().add(siNo2);
        lista.add(siNo1);
        
        regla = new Regla("¿Cuánto esta dispuesto a pagar?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("mucho");
                add("poco");
                add("almacenamiento");
                add("tablet");
            }
        }
        );
        lista.add(regla);
        
        regla = new Regla("¿Cuál es su limite económico para gastar?");
        regla.setAntecedentes(new ArrayList<String>() {
            {
                add("mucho");
                add("poco");
                add("almacenamiento");
                add("tablet");
            }
        }
        );
        lista.add(regla);
        //FIN SECCION CLIENTE - TABLET.
        
        
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
