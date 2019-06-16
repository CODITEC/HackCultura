package com.example.culturio;

import android.location.Location;

import java.util.HashMap;

public class Common {
    public static Location mLastLocation = null;
    public static Integer positionQuiz = 0;

    public static final HashMap<Integer, String> listaPreguntas = new HashMap<Integer, String>();
    static {
        listaPreguntas.put(1,"¿Hasta finales de que período existieron los ammonites?|Jurásico|Triásico|Cretásico|3");
        listaPreguntas.put(2,"¿Qué cultura se caracterizaba por sus cerámicas modeladas con variedad de forma decorativa?|Moche|Paracas caverna|Inca|2");
        listaPreguntas.put(3,"¿Qué cultura se desarrolló entre los valles de Fortaleza, Pativilca, Supe?|Cultura Chancay|Cultura Tiahuanaco|Cultura Lima|1");
    }
}
