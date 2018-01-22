package com.example.angelus.sqliteestudiantesprofesores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EstudiantesVista extends AppCompatActivity {
    private EditText nombre, edad, ciclo, curso, notaMedia;
    private Button buttonGuardarEstudiante;// Definiciones y constantes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_vista);
        nombre = (EditText)findViewById(R.id.ediNombre);
        edad =(EditText)findViewById(R.id.ediEdad);
        ciclo = (EditText)findViewById(R.id.ediCiclo);
        curso = (EditText)findViewById(R.id.ediCurso);
        notaMedia = (EditText)findViewById(R.id.ediNotaMedia);
        buttonGuardarEstudiante = (Button)findViewById(R.id.buttonGuardarEstudiante);


        guardarDatosEstu();
    }

    public void guardarDatosEstu(){
        buttonGuardarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent miIntento = getIntent();
                miIntento.putExtra("nombre", nombre.getText().toString());
                miIntento.putExtra("edad", edad.getText().toString());
                miIntento.putExtra("ciclo", ciclo.getText().toString());
                miIntento.putExtra("curso", curso.getText().toString());
                miIntento.putExtra("notaMedia", notaMedia.getText().toString());

                setResult(RESULT_OK, miIntento);
                finish();


            }
        });
    }


}