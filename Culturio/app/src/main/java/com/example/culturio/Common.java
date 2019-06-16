package com.example.culturio;

import android.location.Location;

import java.util.HashMap;

public class Common {
    public static Location mLastLocation = null;
    public static Integer positionQuiz = 0;
    public static Integer puntajeTotal = 0;
    public static Integer preg1 = 0;
    public static Integer preg2 = 0;
    public static Integer preg3 = 0;
    public static Integer returnHome = 0;



    public static final HashMap<Integer, String> listaPreguntas = new HashMap<Integer, String>();
    static {
        listaPreguntas.put(1,"¿Hasta finales de que período existieron los ammonites?-Jurásico-Triásico-Cretásico-3-colmillo-Cretásico-Fósil de ammonite entero y semipulido");
        listaPreguntas.put(2,"¿Qué cultura se caracterizaba por sus cerámicas modeladas con variedad de forma decorativa?-Moche-Paracas caverna-Inca-2-paracas-Paracas caverna-Botella de cuerpo globular achatado y asa puente");
        listaPreguntas.put(3,"¿Qué cultura se desarrolló entre los valles de Fortaleza, Pativilca, Supe Huaura,Chancay entre los años 1200 y 1470 d.c.?-Cultura Chancay-Cultura Tiahuanaco-Cultura Lima-1-canino-Cultura Chancay-Vasija escultórica que representa un ser zoomorfo");
    }

    public static final HashMap<Integer, String> datosPersona = new HashMap<Integer, String>();
    static {
        datosPersona.put(1,"Franco Cóndor");
        datosPersona.put(2,"franco.condor");
        datosPersona.put(3,"photo_male_1");
        datosPersona.put(4,"#2");
        datosPersona.put(5,"Barranco, LI");
        datosPersona.put(6,"350");
        datosPersona.put(7,"180");
    }

}
