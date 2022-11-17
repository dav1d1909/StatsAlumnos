package com.example.statsalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NombreAlumnoListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre_alumno_lista);
    }
    public void consultarUsuario(View v){

        EditText text_user = findViewById(R.id.text_usuarioL);
        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.miDB),MODE_PRIVATE,null);

        Cursor cursor = myDB.rawQuery("SELECT * FROM alumno WHERE usuario = '" + text_user.getText().toString()+"'",null);


        if (!cursor.moveToNext()){
            Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_SHORT).show();
        } else{
            Intent i = new Intent(this,ListarStatsAlumno.class);
            i.putExtra("id",cursor.getInt(0));
            startActivity(i);
        }

    }
    public void volver(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}