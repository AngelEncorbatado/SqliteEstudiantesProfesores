package com.example.angelus.sqliteestudiantesprofesores;



public class Estudiante {

String nombre, edad, ciclo, curso, notaMedia;

public Estudiante(){

}

public Estudiante(String nombre, String edad, String ciclo, String curso, String notaMedia){
this.nombre = nombre;
this.edad = edad;
this.ciclo = ciclo;
this.curso = curso;
this.notaMedia = notaMedia;
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

    public String getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(String notaMedia) {
        this.notaMedia = notaMedia;
    }
}
