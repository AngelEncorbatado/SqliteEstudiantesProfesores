package com.example.angelus.sqliteestudiantesprofesores;

/**
 * Created by Angelus on 16/12/2017.
 */

public class Persona  {
private String nombre, edad, ciclo, curso, nMediaODespacho, tipo;

    public Persona(){

         }

    public Persona(String nombre, String edad, String ciclo, String curso, String nMediaODespacho, String tipo){
         this.nombre = nombre;
         this.edad = edad;
         this.ciclo = ciclo;
         this. curso = curso;
         this.nMediaODespacho = nMediaODespacho;
         this.tipo = tipo;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getnMediaODespacho() {
        return nMediaODespacho;
    }

    public void setnMediaODespacho(String nMediaODespacho) {
        this.nMediaODespacho = nMediaODespacho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
