package com.example.angelus.sqliteestudiantesprofesores;

/**
 * Created by Angelus on 22/01/2018.
 */

public class Asignatura {
    private String id;
    private String nombre;
    private String horas;

    public Asignatura(){

    }

    public Asignatura(String id, String nombre, String horas) {
        this.id = id;
        this.nombre = nombre;
        this.horas = horas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
}
