package com.example.angelus.sqliteestudiantesprofesores;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BusquedaEstudProfes extends AppCompatActivity {
private RadioGroup miRadioGrupoMostrarTodos;
private EditText ciclo, curso;
private Button miButtonBusqueda;
private ListView miListView;
private MyDBAdapter miDbAdapter2;
private AdapterCategory miAdapterListView;
private AdapterCategoryProfesor miAdapterListViewProfesor;
private AdapterCategoryPersonas miAdapterListViewPersonas;
private Activity miActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_estud_profes);


        miActivity = this;

        miListView = (ListView)findViewById(R.id.ListViewZonaDeMuestra);
        miRadioGrupoMostrarTodos = (RadioGroup)findViewById(R.id.miRadioGrupoId);

        ciclo = (EditText)findViewById(R.id.editTextCiclo);
        curso = (EditText)findViewById(R.id.editTextCurso);
        miButtonBusqueda = (Button)findViewById(R.id.buttonBuscar);


        miDbAdapter2 = new MyDBAdapter(this);
        miDbAdapter2.open();

       miRadioGrupoMostrarTodos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {

               //CADA VEZ QUE CAMBIAMOS DE RADIOBUTTON HACEMOS INVISIBLE LOS VIEWS QUE NOS INTERESAN PARA DAR EL ACCESO JUSTO
               ciclo.setVisibility(View.INVISIBLE);
               miButtonBusqueda.setVisibility(View.INVISIBLE);
               curso.setVisibility(View.INVISIBLE);

               switch (radioGroup.getCheckedRadioButtonId()){


                   case R.id.radio_button_muestroEstudiantes: //TODOS LOS ESTUDIANTES


                       ArrayList<Estudiante> miArrayEstudiantes = miDbAdapter2.recuperarEstudiante();

                       miAdapterListView = new AdapterCategory(miActivity, miArrayEstudiantes);
                       miListView.setAdapter(miAdapterListView);

                       break;

                   case R.id.radio_button_muestroProfesores: //TODOS LOS PROFESORES
                       //Toast.makeText(miActivity, "He sidoPULSADO?!?!", Toast.LENGTH_SHORT).show();
                       ArrayList<Profesor> miArrayProfesores = miDbAdapter2.recuperarProfesor();
                       //Toast.makeText(miActivity, miArrayProfesores.get(1).getNombre()+" "+miArrayProfesores.get(1).getDespacho(), Toast.LENGTH_SHORT).show();

                       miAdapterListViewProfesor = new AdapterCategoryProfesor(miActivity, miArrayProfesores);

                       miListView.setAdapter(miAdapterListViewProfesor);
                       break;

                   case R.id.radio_button_muestroProfesYEstud: //TODOS LOS ESTUDIANTES Y PROFESORES

                       ArrayList<Estudiante> miArrayEstudiantess= miDbAdapter2.recuperarEstudiante();
                       ArrayList<Profesor> miArrayProfesoress = miDbAdapter2.recuperarProfesor();

                      Personas misPersonas = new Personas(miArrayEstudiantess, miArrayProfesoress);

                      miAdapterListViewPersonas = new AdapterCategoryPersonas(miActivity, misPersonas.devuelvoUnArrayListParaElListView());
                      miListView.setAdapter(miAdapterListViewPersonas);
                       break;

                   case R.id.radio_button_muestroEstudiantesXCiclo://BUSQUEDA DE ESTUDIANTES X CICLO

                       ciclo.setVisibility(View.VISIBLE);
                       miButtonBusqueda.setVisibility(View.VISIBLE);

                       miButtonBusqueda.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               ArrayList<Estudiante> misEstudiantesCiclo = miDbAdapter2.recuperarEstudiante();
                               ArrayList<Estudiante> misEstudiantesFinal = new ArrayList<Estudiante>();

                               for(int d = 0; d<misEstudiantesCiclo.size(); d++){
                                   //Log.d("myTag", misEstudiantesCiclo.get(d).getCiclo()+"");

                                   if((ciclo.getText().toString()).compareTo((misEstudiantesCiclo.get(d).getCiclo())) == 0) { //SI EL EdiText "ciclo" es igual a el atributo ciclo de la iteracion...
                                       Log.d("myTag", "<>"+misEstudiantesCiclo.get(d).getCiclo() + "<>"+ciclo.getText()+"<>");//MENSAJE PARA SABER QUE TOT VA BE
                                       misEstudiantesFinal.add(misEstudiantesCiclo.get(d));//... lo guardamos en el ArrayList que le pasaremos al ListView
                                   }
                               }
                               //Toast.makeText(miActivity, misEstudiantesCiclo.size()+"", Toast.LENGTH_SHORT).show();
                               miAdapterListView = new AdapterCategory(miActivity, misEstudiantesFinal);
                               miListView.setAdapter(miAdapterListView);
                           }
                       });

                       break;
                   case R.id.radio_button_muestroEstudiantesXCurso: //BUSQUEDA DE ESTUDIANTES X CURSO
                       curso.setVisibility(View.VISIBLE);
                       miButtonBusqueda.setVisibility(View.VISIBLE);

                       miButtonBusqueda.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               ArrayList<Estudiante> misEstudiantesCurso = miDbAdapter2.recuperarEstudiante();
                               ArrayList<Estudiante> misEstudiantesFinal = new ArrayList<Estudiante>();

                               for(int d = 0; d<misEstudiantesCurso.size(); d++){


                                   if((curso.getText().toString()).compareTo((misEstudiantesCurso.get(d).getCurso())) == 0) {

                                       misEstudiantesFinal.add(misEstudiantesCurso.get(d));
                                   }
                               }
                               //Toast.makeText(miActivity, misEstudiantesCurso.size()+"", Toast.LENGTH_SHORT).show();
                               miAdapterListView = new AdapterCategory(miActivity, misEstudiantesFinal);
                               miListView.setAdapter(miAdapterListView);
                           }
                       });

                       break;
                   case R.id.radio_button_muestroEstudiantesXCursoYCiclo: //BUSQUEDA DE ESTUDIANTES POR CURSO Y POR CICLO
                       ciclo.setVisibility(View.VISIBLE);
                       curso.setVisibility(View.VISIBLE);
                       miButtonBusqueda.setVisibility(View.VISIBLE);

                       miButtonBusqueda.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               ArrayList<Estudiante> misEstudiantesCicloCurso = miDbAdapter2.recuperarEstudiante();
                               ArrayList<Estudiante> misEstudiantesFinal = new ArrayList<Estudiante>();

                               for(int d = 0; d<misEstudiantesCicloCurso.size(); d++){


                                   if(((curso.getText().toString()).compareTo((misEstudiantesCicloCurso.get(d).getCurso())) == 0)
                                           && (ciclo.getText().toString()).compareTo((misEstudiantesCicloCurso.get(d).getCiclo())) == 0) { //doble comprobación de coincidencias entre EdiText y miArray de Estudiantes

                                       misEstudiantesFinal.add(misEstudiantesCicloCurso.get(d));
                                   }
                               }
                               //Toast.makeText(miActivity, misEstudiantesCicloCurso.size()+"", Toast.LENGTH_SHORT).show();
                               miAdapterListView = new AdapterCategory(miActivity, misEstudiantesFinal);
                               miListView.setAdapter(miAdapterListView);
                           }
                       });

                       break;
               case R.id.radio_button_muestroProfesoresXCiclo: //BUSQUEDA DE PROFESORES X CICLO

                   ciclo.setVisibility(View.VISIBLE); //volvemos visibles los campos que nos interesan
                   miButtonBusqueda.setVisibility(View.VISIBLE);
                   miButtonBusqueda.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           ArrayList<Profesor> misProfesoresXCiclo = miDbAdapter2.recuperarProfesor();
                           ArrayList<Profesor> misProfesoresFinal = new ArrayList<Profesor>();

                           for(int x = 0; x< misProfesoresXCiclo.size();x++){

                               if(ciclo.getText().toString().compareTo(misProfesoresXCiclo.get(x).getCiclo()) == 0){
                                   misProfesoresFinal.add(misProfesoresXCiclo.get(x));
                               }

                           }
                           miAdapterListViewProfesor = new AdapterCategoryProfesor(miActivity, misProfesoresFinal);
                           miListView.setAdapter(miAdapterListViewProfesor);



                       }
                   });

                       break;

                   case R.id.radio_button_muestroProfesoresXCurso: //BUSQUEDA DE PROFESORES X CURSO

                       curso.setVisibility(View.VISIBLE);
                       miButtonBusqueda.setVisibility(View.VISIBLE);
                       miButtonBusqueda.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {

                               ArrayList<Profesor> misProfesoresXCurso = miDbAdapter2.recuperarProfesor();
                               ArrayList<Profesor> misProfesoresFinal = new ArrayList<Profesor>();

                               for(int x = 0; x< misProfesoresXCurso.size();x++){

                                   if(curso.getText().toString().compareTo(misProfesoresXCurso.get(x).getCurso()) == 0){
                                       misProfesoresFinal.add(misProfesoresXCurso.get(x));
                                   }

                               }
                               miAdapterListViewProfesor = new AdapterCategoryProfesor(miActivity, misProfesoresFinal);
                               miListView.setAdapter(miAdapterListViewProfesor);

                           }
                       });
                       break;
                   case R.id.radio_button_muestroProfesoresXCursoYCiclo: //BUSQUEDA DE PROFESORES POR CURSO Y X CICLO

                       ciclo.setVisibility(View.VISIBLE);
                       curso.setVisibility(View.VISIBLE);
                       miButtonBusqueda.setVisibility(View.VISIBLE);
                       miButtonBusqueda.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               ArrayList<Profesor> misProfesoresXCursoYCiclo = miDbAdapter2.recuperarProfesor();
                               ArrayList<Profesor> misProfesoresFinal = new ArrayList<Profesor>();

                               for(int x = 0; x<misProfesoresXCursoYCiclo.size(); x++){

                                   if((curso.getText().toString().compareTo(misProfesoresXCursoYCiclo.get(x).getCurso()) == 00)
                                           && (ciclo.getText().toString().compareTo(misProfesoresXCursoYCiclo.get(x).getCiclo())== 00)){
                                       misProfesoresFinal.add(misProfesoresXCursoYCiclo.get(x));

                                   }
                                   miAdapterListViewProfesor = new AdapterCategoryProfesor(miActivity, misProfesoresFinal);
                                   miListView.setAdapter(miAdapterListViewProfesor);

                               }
                           }
                       });
                       break;

               }
           }
       });

    }
}
