package com.example.angelus.sqliteestudiantesprofesores;

import java.util.ArrayList;


public class Personas {
    private ArrayList<Estudiante> misEstudiantes;
    private ArrayList<Profesor> misProfesores;
    private ArrayList<Persona> misPersonas;
    public Personas(){

    }
    public Personas(ArrayList<Estudiante> misEstudiantes, ArrayList<Profesor> misProfesores){//Recibo 1 array de estudiantes y 1 array de profesores que luego tratare...
        this.misEstudiantes = misEstudiantes;
        this.misProfesores = misProfesores;
        //Object miObject = misEstudiantes.get(0);



    }
    public ArrayList<Persona> devuelvoUnArrayListParaElListView(){//tratare... para crearme un ArrayDe personas y así mostrar todos.

        misPersonas = new ArrayList<Persona>();
        Persona persona;
        for(int i = 0; i<misEstudiantes.size(); i++){
            persona = new Persona(misEstudiantes.get(i).getNombre(), misEstudiantes.get(i).getEdad(), misEstudiantes.get(i).getCiclo(), misEstudiantes.get(i).getCurso()
            , misEstudiantes.get(i).getNotaMedia(), "Estudiante"); //vease ademas que el ultimo atributo de Persona es Tipo, y le ponemos un String diferente según del array de donde venga

            misPersonas.add(persona);

        }
        for(int i = 0; i< misProfesores.size();i++){

            persona = new Persona(misProfesores.get(i).getNombre(), misProfesores.get(i).getEdad(), misProfesores.get(i).getCiclo(), misProfesores.get(i).getCurso()
                    , misProfesores.get(i).getDespacho(), "Profesor");


            misPersonas.add(persona);
        }


     return  misPersonas;
    }

}
