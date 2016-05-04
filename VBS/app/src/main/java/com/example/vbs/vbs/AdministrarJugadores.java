package com.example.vbs.vbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdministrarJugadores extends AppCompatActivity {
    Button agregarJug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_jugadore);
        agregarJug = (Button) findViewById(R.id.btnAgregar);
        agregarJug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevaActivity = new Intent(AdministrarJugadores.this,agregarJugador.class);
                startActivity(nuevaActivity);
            }
        });
    }
}
