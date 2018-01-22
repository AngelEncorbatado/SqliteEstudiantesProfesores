package com.example.angelus.sqliteestudiantesprofesores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AsignaturasVista extends AppCompatActivity {
    private EditText miEditextId, miEditextNombre, miEditextHoras;
    private Button miButtonGuardarAsginatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas_vista);

        miEditextId = (EditText) findViewById(R.id.editTextIdASginatura);
        miEditextNombre = (EditText) findViewById(R.id.editTextNombreAsignatura);
        miEditextHoras = (EditText) findViewById(R.id.editTextHorasAsignatura);
        miButtonGuardarAsginatura = (Button) findViewById(R.id.buttonGuardarAsignatura);


        guardarDatosAsig();
    }

    public void guardarDatosAsig() {
        miButtonGuardarAsginatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    Intent miIntento = getIntent();
                    miIntento.putExtra("id", miEditextId.getText().toString());
                    miIntento.putExtra("nombre", miEditextNombre.getText().toString());
                    miIntento.putExtra("horas", miEditextHoras.getText().toString());


                    setResult(RESULT_OK, miIntento);
                    finish();

                }catch (Exception e){
                    Toast.makeText(AsignaturasVista.this, "Falta algun campo, ocurre un error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}