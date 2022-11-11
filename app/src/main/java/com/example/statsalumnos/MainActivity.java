package com.example.statsalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.miDB),MODE_PRIVATE,null);
        myDB.execSQL(
                "CREATE TABLE IF NOT EXISTS alumno " +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "usuario VARCHAR(50)," +
                        "sexo VARCHAR(50)," +
                        "grupo VARCHAR(20)," +
                        "edad INTEGER," +
                        "flex1 INTEGER DEFAULT -1," +
                        "flex2 INTEGER DEFAULT -1," +
                        "fuer1 INTEGER DEFAULT -1," +
                        "fuer2 INTEGER DEFAULT -1," +
                        "vel1 INTEGER DEFAULT -1," +
                        "vel2 INTEGER DEFAULT -1," +
                        "res1 INTEGER DEFAULT -1," +
                        "res2 INTEGER DEFAULT -1)"
        );
    }
    public void registrarAlumno(View v){
        Intent i = new Intent(this,RegistroAlumnoActivity.class);

        startActivity(i);
    }
    public void registrarStats(View v){
        Intent i = new Intent(this, NombreAlumnosStatsActivity.class);

        startActivity(i);
    }
    public void listarStatsAlumno(View v){
        Intent i = new Intent(this, NombreAlumnosListaActivity.class);

        startActivity(i);
    }
    public void listarStatsGeneral(View v){
        Intent i = new Intent(this,ListarStatsGeneral.class);

        startActivity(i);
    }
}