package com.example.angelus.sqliteestudiantesprofesores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfesoresVista extends AppCompatActivity {
    private EditText nombre, edad, ciclo, curso, despacho;
    private Button guardarListenerProfesor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores_vista);

        nombre =(EditText)findViewById(R.id.nombreProfe);
        edad = (EditText)findViewById(R.id.edadProfe);
        ciclo = (EditText)findViewById(R.id.cicloProfe);
        curso = (EditText)findViewById(R.id.cursoProfe);
        despacho = (EditText)findViewById(R.id.despachoProfe);
        guardarListenerProfesor = (Button)findViewById(R.id.buttonGuardarProfeAct2);

        guardarDatosProfe();

    }
    private void guardarDatosProfe(){
        guardarListenerProfesor.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent miIntento = getIntent();


                    miIntento.putExtra("nombre", nombre.getText().toString());
                    miIntento.putExtra("edad", edad.getText().toString());
                    miIntento.putExtra("ciclo", ciclo.getText().toString());
                    miIntento.putExtra("curso", curso.getText().toString());
                    miIntento.putExtra("despacho", despacho.getText().toString());

                    setResult(RESULT_OK, miIntento);
                    finish();



            }
        });
    }
}