package com.example.angelus.sqliteestudiantesprofesores;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDBAdapter {

    // Definiciones y constantes
    private static final String DATABASE_NAME = "dbClases.db";
    private static final String DATABASE_TABLEPROFE = "profesores";
    private static final String DATABASE_TABLEESTUD = "estudiantes";
    private static final String DATABASE_TABLEASIG = "asignaturas";

    private static final int DATABASE_VERSION = 1;

    //PROFESOR
    private static final String NOMBREP = "nombre";
    private static final String EDADP = "edad";
    private static final String CICLOP = "ciclo";
    private static final String CURSOP = "curso";
    private static final String DESPACHO = "despacho";

    //ESTUDIANTE
    private static final String NOMBREE = "nombre";
    private static final String EDADE = "edad";
    private static final String CICLOE = "ciclo";
    private static final String CURSOE = "curso";
    private static final String NOTAMEDIA = "notaMedia";

    //ASIGNATURA
    private static final String IDASIG = "id";
    private static final String NOMBREASIG = "nombre";
    private static final String HORASASIG = "horas";


    private static final String DATABASE_CREATEPROFE = "CREATE TABLE "+DATABASE_TABLEPROFE+" (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, despacho text);";
    private static final String DATABASE_CREATEESTUD = "CREATE TABLE "+DATABASE_TABLEESTUD+" (_id integer primary key autoincrement, nombre text, edad text, ciclo text, curso text, notaMedia text);";
    private static  final String DATABASE_CREATEASIG = "CREATE TABLE "+DATABASE_TABLEASIG+" (_id text primary key, id text, nombre text, horas text);";

    private static final String DATABASE_DROPPROFE = "DROP TABLE IF EXISTS "+DATABASE_TABLEPROFE+";";
    private static final String DATABASE_DROPESTUD = "DROP TABLE IF EXISTS "+DATABASE_TABLEESTUD+";";
    private static final String DATABASE_DROPASIG =  "DROP TABLE IF EXISTS "+DATABASE_TABLEASIG+";";


    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        //OJO open();
    }

    public void open(){ //preparamos la base de datos para que pueda ser R/W

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }
    public void insertarAsignatura(String id, String nombre, String horas){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues(); //ContentValues es una clase asociada a SQLite que sirve para pasarle los indices de la tabla

        newValues.put(IDASIG,id);
        newValues.put(NOMBREASIG,nombre);
        newValues.put(HORASASIG,horas);

        db.insert(DATABASE_TABLEASIG, null, newValues);


    }
    public void insertarProfe(String nombre, String edad, String ciclo, String curso, String despacho){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues(); //ContentValues es una clase asociada a SQLite que sirve para pasarle los indices de la tabla
        //Asignamos los valores de cada campo
        newValues.put(NOMBREP,nombre);
        newValues.put(EDADP,edad);
        newValues.put(CICLOP,ciclo);
        newValues.put(CURSOP,curso);
        newValues.put(DESPACHO,despacho);

        db.insert(DATABASE_TABLEPROFE,null,newValues); //Insertamos en la tabla determinada esos valores

    }

    public void insertarEstud(String nombre, String edad, String ciclo, String curso, String notaMedia){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBREE,nombre);
        newValues.put(EDADE,edad);
        newValues.put(CICLOE,ciclo);
        newValues.put(CURSOE,curso);
        newValues.put(NOTAMEDIA,notaMedia);

        db.insert(DATABASE_TABLEESTUD,null,newValues);
    }

    public ArrayList<Estudiante> recuperarEstudiante(){
        Estudiante miEstudiante;
        ArrayList<Estudiante> miArrayEstud = new ArrayList<Estudiante>();

        Cursor miCursor = db.query(DATABASE_TABLEESTUD, null, null, null, null, null,null); //para recuperar informacion de SQlite usamos la clase Cursor
        if(miCursor != null && miCursor.moveToFirst()){ //si encuentra la tabla y puede moverseUno
            do{
                //Creamos un nuevo Estudiante con la informacion que nos da la tabla que se recoge con miCursor.getString(que es la columna que buscas)
                miEstudiante = new Estudiante(miCursor.getString(1), miCursor.getString(2), miCursor.getString(3), miCursor.getString(4), miCursor.getString(5));
                miArrayEstud.add(miEstudiante);

            }while(miCursor.moveToNext());//vamos iterando
        }


        return miArrayEstud;//devuelvo este Array porque luego lo utilizare para guardarlo en el ListView
    }

    public ArrayList<Profesor> recuperarProfesor(){
        Profesor miProfesor;
        ArrayList<Profesor> miArrayProfe = new ArrayList<Profesor>();

        Cursor miCursor = db.query(DATABASE_TABLEPROFE, null, null, null, null, null,null);
        if(miCursor != null && miCursor.moveToFirst()){
            do{

                miProfesor = new Profesor(miCursor.getString(1), miCursor.getString(2), miCursor.getString(3), miCursor.getString(4), miCursor.getString(5));
                miArrayProfe.add(miProfesor);

            }while(miCursor.moveToNext());
        }


        return miArrayProfe;//devuelvo este Array porque luego lo utilizare para guardarlo en el ListView
    }
    public ArrayList<Asignatura> recuperarASig(){
        Asignatura user;
        ArrayList<Asignatura> miArrayAsig = new ArrayList<Asignatura>();

        Cursor miCursor = db.query(DATABASE_TABLEASIG, null, null, null, null, null,null);
        if(miCursor != null && miCursor.moveToFirst()){
            do{

                user = new Asignatura(miCursor.getString(1), miCursor.getString(2), miCursor.getString(3));
                miArrayAsig.add(user);

            }while(miCursor.moveToNext());
        }


        return miArrayAsig;//devuelvo este Array porque luego lo utilizare para guardarlo en el ListView
    }

    private static class MyDbHelper extends SQLiteOpenHelper { //REaliza los cambios automáticos de creacion y actualizacion de tablas

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATEPROFE);
            db.execSQL(DATABASE_CREATEESTUD);
            db.execSQL(DATABASE_CREATEASIG);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROPPROFE);
            db.execSQL(DATABASE_DROPESTUD);
            db.execSQL(DATABASE_DROPASIG);

            onCreate(db);
        }

    }
}