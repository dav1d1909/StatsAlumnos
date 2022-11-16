package com.example.statsalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroStatsActivity extends AppCompatActivity {

    private int id;
    private int evaluacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_stats);

        Intent i = getIntent();

        this.id = i.getIntExtra("id",0);
        this.evaluacion = i.getIntExtra("evaluacion",0);
    }
    public void registrar(View v){
        EditText flex = findViewById(R.id.textFlex);
        EditText fuer = findViewById(R.id.textFuer);
        EditText vel = findViewById(R.id.textVel);
        EditText res = findViewById(R.id.textRes);

        String txt_flex = flex.getText().toString();
        String  txt_fuer = fuer.getText().toString();
        String  txt_vel = vel.getText().toString();
        String txt_res = res.getText().toString();

        if (txt_flex == null || txt_flex.trim().equals("")) {
            flex.requestFocus();
            flex.setBackgroundTintList(getColorStateList(R.color.red));
            Toast.makeText(this, "campo obligatorio", Toast.LENGTH_SHORT).show();
        } else if (txt_fuer == null || txt_fuer.trim().equals("")){
            fuer.requestFocus();
            fuer.setBackgroundTintList(getColorStateList(R.color.red));
            Toast.makeText(this, "campo obligatorio", Toast.LENGTH_SHORT).show();
        } else if(txt_vel == null || txt_vel.trim().equals("")){
            vel.requestFocus();
            vel.setBackgroundTintList(getColorStateList(R.color.red));
            Toast.makeText(this, "campo obligatorio", Toast.LENGTH_SHORT).show();
        } else if (txt_res == null || txt_res.trim().equals("")){
            res.requestFocus();
            res.setBackgroundTintList(getColorStateList(R.color.red));
            Toast.makeText(this, "campo obligatorio", Toast.LENGTH_SHORT).show();
        } else {
            ContentValues cv = new ContentValues();
            if (this.evaluacion ==1){
                cv.put("flex1",txt_flex);
                cv.put("fuer1",txt_fuer);
                cv.put("vel1",txt_vel);
                cv.put("res1",txt_res);
            } else if(this.evaluacion == 3) {
                cv.put("flex3", txt_flex);
                cv.put("fuer3", txt_fuer);
                cv.put("vel3", txt_vel);
                cv.put("res3", txt_res);
            }
            SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.miDB),MODE_PRIVATE,null);
            myDB.update("alumno",cv,"id = "+this.id,null);
            Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();
        }
}

    public void volver(View v){
        Intent i = new Intent(this, EvaluacionActivity.class);
        i.putExtra("id",this.id);
        startActivity(i);
    }

}