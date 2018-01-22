package com.example.angelus.sqliteestudiantesprofesores;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterCategory extends BaseAdapter { //Extiende de la clase BaseAdapter que dispone de los metodos predefinidos para inflar nuestro ListView

    protected Activity activity;
    protected ArrayList<Estudiante> items;

    public AdapterCategory (Activity activity, ArrayList<Estudiante> items) { //Personalizamos nuestro ListView con este Adapter(este en concreto para Estudiantes)
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Estudiante> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_category, null);//AQUI ESTA ALGO CLAVE QUE ES EL "R.LAYOUT.item_category", este layout es un layoutResourceFile en res/layout
                                                          //EL CUAL TIENE LA DISPOSICIÓN Y LOS VIEWS QUE LUEGO VEREMOS EN CADA ITEM
        }

        Estudiante dir = items.get(position);

        TextView nombre = (TextView) v.findViewById(R.id.textViewNombre);
        nombre.setText("Nombre: "+dir.getNombre()); //Cada vez que nos llega un item cogemos sus datos y los seteamos en nuestro View

        TextView edad = (TextView) v.findViewById(R.id.textViewEdad);
        edad.setText("Edad: "+dir.getEdad());

        TextView ciclo = (TextView) v.findViewById(R.id.textViewCiclo);
        ciclo.setText("Ciclo: "+dir.getCiclo());
        ciclo.setTextColor(Color.GRAY);

        TextView curso = (TextView) v.findViewById(R.id.textViewCurso);
        curso.setText("Curso: "+dir.getCurso());
        curso.setTextColor(Color.GRAY);

        TextView notaODespacho = (TextView) v.findViewById(R.id.textViewNotaOdespacho);
        notaODespacho.setText("N.Media: "+dir.getNotaMedia());

        TextView tipo = (TextView) v.findViewById(R.id.textViewTipo);
        tipo.setText("Tipo: Estudiante");





        return v;
    }
}
