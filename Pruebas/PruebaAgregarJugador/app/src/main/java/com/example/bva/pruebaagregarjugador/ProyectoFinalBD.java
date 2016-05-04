package com.example.bva.pruebaagregarjugador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 41710122 on 20/04/2016.
 */
public class ProyectoFinalBD extends SQLiteOpenHelper {

    public ProyectoFinalBD(Context contexto,String Nombre,SQLiteDatabase.CursorFactory fabrica, int Version)
    {
        super(contexto, Nombre, fabrica, Version);
    }

    public void onCreate(SQLiteDatabase BaseDatos)
    {
        Log.d("SQLite","Declaro e Incializo la tabla Jugadores");
        String SQLCrearTablaJugadores = "create table Jugadores(nombre text,edad text,altura text,posicion text)";
        Log.d("SQLite","Declaro e Invoco al creador de la tabla");
        BaseDatos.execSQL(SQLCrearTablaJugadores);
        Log.d("SQLite", "TablaCreada");
    }
    public void onUpgrade(SQLiteDatabase BaseDatos, int VersionAnterior, int NuevaVersion)
    {

    }
}
