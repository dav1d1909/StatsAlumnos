package com.example.statsalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroAlumnoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumno);
    }
    public void registrar(View v){
        EditText usuario = findViewById(R.id.textUsuario);
        Spinner spnGrupo = (Spinner) findViewById(R.id.spinnerGrupo);
        Spinner spnSexo = (Spinner) findViewById(R.id.spinnerSexo);
        EditText edad = findViewById(R.id.textEdad);

        String txt_usuario = usuario.getText().toString();
        String  txt_grupo = spnGrupo.getSelectedItem().toString();
        String  txt_sexo = spnSexo.getSelectedItem().toString();
        String txt_edad = edad.getText().toString();
        if (txt_usuario == null || txt_usuario.trim().equals("")) {
            usuario.requestFocus();
            usuario.setBackgroundTintList(getColorStateList(R.color.red));
            Toast.makeText(this, "campo obligatorio", Toast.LENGTH_SHORT).show();
        } else if (txt_grupo == null || txt_grupo.trim().equals("")){
            spnGrupo.requestFocus();
            spnGrupo.setBackgroundTintList(getColorStateList(R.color.red));
            Toast.makeText(this, "campo obligatorio", Toast.LENGTH_SHORT).show();
        } else if(txt_sexo == null || txt_sexo.trim().equals("")){
            spnSexo.requestFocus();
            spnSexo.setBackgroundTintList(getColorStateList(R.color.red));
            Toast.makeText(this, "campo obligatorio", Toast.LENGTH_SHORT).show();
        } else if (txt_edad == null || txt_usuario.trim().equals("")){
            edad.requestFocus();
            edad.setBackgroundTintList(getColorStateList(R.color.red));
            Toast.makeText(this, "campo obligatorio", Toast.LENGTH_SHORT).show();
        } else {
            Alumno a = new Alumno(txt_usuario,txt_grupo,txt_sexo,Integer.parseInt(txt_edad));
            guardarAlumno(a);
        }







        Toast.makeText(this,"Registro guardado",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,RegistroAlumnoActivity.class);

        startActivity(i);
    }
    public void guardarAlumno(Alumno a){
        ContentValues cv = new ContentValues();
        cv.put("usuario",a.getUsuario());
        cv.put("grupo",a.getGrupo());
        cv.put("sexo",a.getSexo());
        cv.put("edad",a.getEdad());
        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.miDB),MODE_PRIVATE,null);
        myDB.insert("alumno",null,cv);
        Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, this.getClass());
        startActivity(i);


    }
    public void volver(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}