package com.example.statsalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EvaluacionActivity extends AppCompatActivity {
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);
        Intent i = getIntent();

         this.id = i.getIntExtra("id",0);

    }
    public void regPrimera(View v){
        Intent i = new Intent(this,RegistroStatsActivity.class);
        i.putExtra("evaluacion",1);
        i.putExtra("id",this.id);
        startActivity(i);
    }
    public void regTercera(View v){
        Intent i = new Intent(this,RegistroStatsActivity.class);
        i.putExtra("evaluacion",3);
        i.putExtra("id",this.id);
        startActivity(i);
    }
    public void volver(View v){
        Intent i = new Intent(this, NombreAlumnoStatsActivity.class);
        startActivity(i);

    }
}