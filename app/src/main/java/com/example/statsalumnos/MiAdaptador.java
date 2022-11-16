package com.example.statsalumnos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {
    ArrayList<Alumno>lista;

    public MiAdaptador(ArrayList<Alumno> lista) {
        this.lista = lista;
    }
    public static class MiViewHolder extends RecyclerView.ViewHolder{
        TextView txtid,txtusuario, txtgrupo, txtsexo, txtedad,txtflex1,txtflex3,txtfuer1,txtfuer3,txtvel1,txtvel3,txtres1,txtres3;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            txtusuario = itemView.findViewById(R.id.txt_usuario);
            txtgrupo = itemView.findViewById(R.id.txt_grupo);
            txtsexo = itemView.findViewById(R.id.txt_sexo);
            txtedad = itemView.findViewById(R.id.txt_edad);
            txtflex1 = itemView.findViewById(R.id.txt_flex1);
            txtflex3 = itemView.findViewById(R.id.txt_flex3);
            txtfuer1 = itemView.findViewById(R.id.txt_fuer1);
            txtfuer3 = itemView.findViewById(R.id.txt_fuer3);
            txtvel1 = itemView.findViewById(R.id.txt_vel1);
            txtvel3 = itemView.findViewById(R.id.txt_vel3);
            txtres1 = itemView.findViewById(R.id.txt_res1);
            txtres3 = itemView.findViewById(R.id.txt_res3);
            txtid = itemView.findViewById(R.id.txt_id);


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    AlertDialog.Builder ab = new AlertDialog.Builder(itemView.getContext());
                    ab.setTitle("Borrar alumno");
                    ab.setMessage("¿Seguro que desea borrar el alumno " + txtusuario.getText().toString() + "?");
                    ab.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SQLiteDatabase myDB = itemView.getContext().openOrCreateDatabase(itemView.getContext().getResources().getString(R.string.miDB), itemView.getContext().MODE_PRIVATE, null);
                            myDB.execSQL("DELETE FROM alumno WHERE id=" + txtid.getText().toString());
                            Toast.makeText(itemView.getContext(), "Alumno: " + txtusuario.getText().toString() + " borrado correctamente", Toast.LENGTH_SHORT).show();
                            ((Activity) itemView.getContext()).recreate();


                        }
                    });
                    ab.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(itemView.getContext(), "Alumno no borrado", Toast.LENGTH_SHORT).show();
                        }
                    });
                    ab.show();


                    return false;
                }
            });
        }
    }
    @NonNull
    @Override
    public MiAdaptador.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflador = LayoutInflater.from(parent.getContext());
        View v = inflador.inflate(R.layout.elemento,parent,false);

        MiViewHolder mvh = new MiViewHolder(v);

        return mvh;
    }
    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.MiViewHolder holder, int position) {

        holder.txtid.setText(""+lista.get(position).getId());
        holder.txtusuario.setText(lista.get(position).getUsuario());
        holder.txtgrupo.setText(lista.get(position).getGrupo());
        holder.txtsexo.setText(lista.get(position).getSexo());
        holder.txtedad.setText(""+lista.get(position).getEdad());
        holder.txtflex1.setText(""+lista.get(position).getFlex1());
        holder.txtflex3.setText(""+lista.get(position).getFlex3());
        holder.txtfuer1.setText(""+lista.get(position).getFuer1());
        holder.txtfuer3.setText(""+lista.get(position).getFuer3());
        holder.txtvel1.setText(""+lista.get(position).getVel1());
        holder.txtvel3.setText(""+lista.get(position).getVel3());
        holder.txtres1.setText(""+lista.get(position).getRes1());
        holder.txtres3.setText(""+lista.get(position).getRes3());

    }
    @Override
    public int getItemCount() {
        return lista.size();
    }
}
