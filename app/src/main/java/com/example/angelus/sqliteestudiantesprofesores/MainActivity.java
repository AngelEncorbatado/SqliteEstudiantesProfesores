package com.example.angelus.sqliteestudiantesprofesores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private MyDBAdapter dbAdapter;//clase que contiene los metodos de la Base de datos
    private Button miButonNewProfe, miButonNewEstu, miButtonBuscarAlumnosYProfes;
    static final int REQUEST_CODE = 0;//este es el codigo identificador para el intento de starActivityForResult de profesor
    static final int REQUEST_CODE2 = 1;//este es el codigo identificador para el intento de starActivityForResult de estudiante
    static final int REQUEST_CODE3 = 2;//este es el codigo identificador para el intento de starActivityForResult de estudiante

    private Intent miIntento; //Aquí declaro mi intento que luego lanzaré en el starActivityForResult

    private Button miButtonNewAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miButonNewProfe = (Button)findViewById(R.id.buttonNewProfe);
        miButonNewEstu = (Button)findViewById(R.id.buttonNewEstu);
        miButtonBuscarAlumnosYProfes =(Button)findViewById(R.id.buttonBuscarAlumnosYProfes);

        miButtonNewAsignatura = (Button)findViewById(R.id.buttonNuevaAsginatura);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();



        //dbAdapter.insertarProfe("Juan", "31", "DAM", "2do", "Despacho1");
        //dbAdapter.insertarProfe("Pepe", "34", "DOM", "1ero", "Despacho2");
        //dbAdapter.insertarEstud("Lil Peep", "21", "DAM", "2do", "9");
        //dbAdapter.insertarEstud("Donald Trump", "53", "DAMN", "5to", "7");


        //Implementando metodos
        llamoAProfesor();
        llamoaEstudiante();
        llamoaAsignatura();//EXAMEN

        llamoActivityBusqueda();


    }



    private void llamoAProfesor(){


        this.miButonNewProfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miIntento = new Intent(getApplicationContext(), ProfesoresVista.class);
                startActivityForResult(miIntento, REQUEST_CODE);

            }
        });
    }

    private void llamoaEstudiante(){
        this.miButonNewEstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                miIntento = new Intent(getApplicationContext(), EstudiantesVista.class);

                startActivityForResult(miIntento, REQUEST_CODE2);
            }
        });
    }

    private void llamoaAsignatura(){
        this.miButtonNewAsignatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                miIntento = new Intent(getApplicationContext(), AsignaturasVista.class);

                startActivityForResult(miIntento, REQUEST_CODE3);

            }
        });
    }

    private void llamoActivityBusqueda(){
        this.miButtonBuscarAlumnosYProfes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miIntento = new Intent(getApplicationContext(), BusquedaEstudProfes.class);
                startActivity(miIntento);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            Bundle miBundle = data.getExtras();

        //Toast.makeText(this, "He vuelto", Toast.LENGTH_SHORT).show();

//DEPENDIENDO DEL REQUEST CODE NOS VENDRA UN BUNDLE U OTRO, Y INSERTAREMOS UN PROFESOR O UN ESTUDIANTE DEPENDIENDO DE DONDE VENGAMOS

        // Check which request we're responding to
       if (requestCode == 0 && resultCode == RESULT_OK) {
            // Make sure the request was successful
            String miNombreP = miBundle.getString("nombre");
            String miEdadP = miBundle.getString("edad");
            String miCicloP = miBundle.getString("ciclo");
            String miCursoP = miBundle.getString("curso");
            String miDespachoP = miBundle.getString("despacho");

            dbAdapter.insertarProfe(miNombreP,miEdadP,miCicloP,miCursoP,miDespachoP);
            Toast.makeText(this, miNombreP+" : "+miEdadP + "  Soy un Profesor", Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Make sure the request was successful
            String miNombreE = miBundle.getString("nombre");
            String miEdadE = miBundle.getString("edad");
            String miCicloE = miBundle.getString("ciclo");
            String miCursoE = miBundle.getString("curso");
            String miNotaMediaE = miBundle.getString("notaMedia");

            dbAdapter.insertarEstud(miNombreE,miEdadE,miCicloE,miCursoE,miNotaMediaE);
            Toast.makeText(this, miNombreE+" : "+miEdadE + "  Soy un Estudiante", Toast.LENGTH_SHORT).show();
        }

        //AQUI ME POSICIONO PARA EL EXAMEN
        if (requestCode == 2 && resultCode == RESULT_OK) {
            // Make sure the request was successful
            String miId = miBundle.getString("id");
            String miNombre = miBundle.getString("nombre");
            String miHoras = miBundle.getString("horas");

            dbAdapter.insertarAsignatura(miId,miNombre,miHoras);
            Toast.makeText(this, miId+" : "+miNombre + " : "+miHoras + "  Es una asignatura", Toast.LENGTH_SHORT).show();
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}


