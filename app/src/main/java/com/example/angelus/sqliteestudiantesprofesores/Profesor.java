package com.example.angelus.sqliteestudiantesprofesores;



public class Profesor {
String nombre, edad, ciclo, curso, despacho;
    public Profesor(String nombre, String edad, String ciclo, String curso, String despacho){
      this.nombre = nombre;
      this.edad = edad;
      this.ciclo = ciclo;
      this.curso = curso;
      this.despacho = despacho;
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

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }
}
