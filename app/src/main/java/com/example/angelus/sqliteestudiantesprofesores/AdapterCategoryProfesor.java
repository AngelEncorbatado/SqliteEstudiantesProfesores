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


public class AdapterCategoryProfesor extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Profesor> items;

    public AdapterCategoryProfesor (Activity activity, ArrayList<Profesor> items) {
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

    public void addAll(ArrayList<Profesor> category) {
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
            v = inf.inflate(R.layout.item_category, null);
        }

        Profesor dir = items.get(position);

        TextView nombre = (TextView) v.findViewById(R.id.textViewNombre);
        nombre.setText("Nombre: "+dir.getNombre());

        TextView edad = (TextView) v.findViewById(R.id.textViewEdad);
        edad.setText("Edad: "+dir.getEdad());

        TextView ciclo = (TextView) v.findViewById(R.id.textViewCiclo);
        ciclo.setText("Ciclo: "+dir.getCiclo());
        ciclo.setTextColor(Color.GRAY);

        TextView curso = (TextView) v.findViewById(R.id.textViewCurso);
        curso.setText("Curso: "+dir.getCurso());
        curso.setTextColor(Color.GRAY);

        TextView notaODespacho = (TextView) v.findViewById(R.id.textViewNotaOdespacho);
        notaODespacho.setText("Despacho: "+dir.getDespacho());

        TextView tipo = (TextView) v.findViewById(R.id.textViewTipo);
        tipo.setText("Tipo: Profesor");



        return v;
    }
}

