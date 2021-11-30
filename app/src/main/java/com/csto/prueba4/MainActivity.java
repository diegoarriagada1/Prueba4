package com.csto.prueba4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button resultado,voto;
    RadioButton nulo,boric,kast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado=(Button) findViewById(R.id.button_resultado);
        voto=(Button) findViewById(R.id.button_votar);
        nulo=(RadioButton) findViewById(R.id.rb_n);
        boric=(RadioButton) findViewById(R.id.rb_gabrielboric);
        kast=(RadioButton) findViewById(R.id.rb_joseantoniokast);


        voto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db;
                Dbhelper conn = new Dbhelper(getApplicationContext());
                db= conn.getReadableDatabase();
                ContentValues CV = new ContentValues();
                if(nulo.isChecked()==false && boric.isChecked()==false && kast.isChecked()==false) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("¿Seguro que quiere dejar en blanco el voto?")
                            .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SQLiteDatabase db;
                                    Dbhelper conn = new Dbhelper(getApplicationContext());
                                    db = conn.getReadableDatabase();
                                    db.insert("Voto",null,CV);
                                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                                    startActivity(I);
                                }
                            })
                            .setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    builder.create();
                    builder.show();
                }
                    if (nulo.isChecked() == true) {
                        CV.put("rb_n", nulo.getText().toString());
                        db.insert("voto", null, CV);
                        Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(I);

                    }
                    if (boric.isChecked()) {
                        CV.put("rb_gabrielboric", boric.getText().toString());
                        Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(I);
                    }
                    if (kast.isChecked()) {
                        CV.put("rb_joseantoniokast", kast.getText().toString());
                        Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(I);
                    }





                }

        });
        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(I);
            }
        });
    }
}