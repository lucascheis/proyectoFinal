package com.example.bva.pruebaagregarjugador;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RegistrarActivity extends AppCompatActivity {

    ProyectoFinalBD accesoBaseDatos;
    SQLiteDatabase baseDatos;
    Integer cantidadRegistros =0;
    EditText nombre,edad,posicion,altura;
    Button btnEnviar;
    ArrayList<String> Lista;
    Cursor MisRegistros;
    Integer CantidadRegistros=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        ObtenerReferencias();

        btnEnviar = (Button) findViewById(R.id.btnRegister);
        btnEnviar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //BOTON AGREGAR
                AgregarJugador(nombre.getText().toString(),edad.getText().toString(),altura.getText().toString(),posicion.getText().toString());

            }
        });

            }



    Boolean AbrirBaseDatos()
    {
        Boolean Responder;

        Log.d("SQLite", "Inicializo el accesor de la base dandole por nombre el nombre de la base en el segundo parametro");
        accesoBaseDatos = new ProyectoFinalBD(this, "BaseBVA", null, 1);
        Log.d("SQLite", "Abro el modo escritura");
        baseDatos=accesoBaseDatos.getWritableDatabase();
        Log.d("SQLite", "Verifico que se abrio la base");

        if(baseDatos!=null)
        {
            Log.d("SQLite","Base Datos abierta");
            Responder=true;
        }
        else {

            Log.d("SQLite", "Base no abierta");
            Responder = false;
        }
        return Responder;
    }
    private void AgregarJugador(String nombre,String edad,String altura,String posicion)
    {
        if(AbrirBaseDatos()==true)
        {
            Log.d("SQLite", "Creo a mi jugador");

            ContentValues MiJugador = new ContentValues();
            MiJugador.put("nombre",nombre);
            MiJugador.put("edad", edad);
            MiJugador.put("altura", altura);
            MiJugador.put("posicion", posicion);
            baseDatos.insert("Jugadores", null, MiJugador);


            Toast msg = Toast.makeText(getApplicationContext(),nombre,Toast.LENGTH_LONG);
            msg.show();


        }
    }


    private void ObtenerReferencias()
    {
        nombre = (EditText) findViewById(R.id.txtNombre);
        edad = (EditText) findViewById(R.id.txtEdad);
        posicion = (EditText) findViewById(R.id.txtposicion);
        altura = (EditText) findViewById(R.id.txtAltura);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registrar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
