package com.example.vbs.vbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAdmJug;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdmJug = (Button) findViewById(R.id.btnAdmJugadores);
        btnAdmJug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevaActivity = new Intent(MainActivity.this,AdministrarJugadores.class);
                startActivity(nuevaActivity);
            }
        });
    }
}
