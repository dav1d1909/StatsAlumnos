package com.example.statsalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarStatsAlumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_stats_alumno);
        Toast.makeText(this,"Para borrar mantener pulsado",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Para modificar pulsar brevemente",Toast.LENGTH_SHORT).show();

        Intent i = getIntent();
        int id1 = i.getIntExtra("id",0);

        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.miDB),MODE_PRIVATE,null);

        Cursor cursor = myDB.rawQuery("select * from alumno where id="+id1,null);

        ArrayList<Alumno> lista = new ArrayList<Alumno>();

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String usuario = cursor.getString(1);
            String grupo = cursor.getString(2);
            String sexo = cursor.getString(3);
            int edad = cursor.getInt(4);
            int flex1 = cursor.getInt(5);
            int flex3 = cursor.getInt(6);
            int fuer1 = cursor.getInt(7);
            int fuer3 = cursor.getInt(8);
            int vel1 = cursor.getInt(9);
            int vel3 = cursor.getInt(10);
            int res1 = cursor.getInt(11);
            int res3 = cursor.getInt(12);

            lista.add(new Alumno(id,usuario,grupo,sexo,edad,flex1,flex3,fuer1,fuer3,vel1,vel3,res1,res3));
        }
        RecyclerView rv = findViewById(R.id.lista_alumno);
        rv.setHasFixedSize(true);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        MiAdaptador adaptador = new MiAdaptador(lista);
        rv.setAdapter(adaptador);

    }

    public void volver(View v){
        Intent i = new Intent(this,NombreAlumnoListaActivity.class);
        startActivity(i);
    }
}