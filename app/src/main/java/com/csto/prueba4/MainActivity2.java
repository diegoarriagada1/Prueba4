package com.csto.prueba4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button v;
    TextView txt_bl,txt_nulo,txt_boric,txt_kast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v=(Button) findViewById(R.id.button);
        txt_bl= (TextView)findViewById(R.id.txt_bl);
        txt_nulo= (TextView)findViewById(R.id.txt_nulos);
        txt_boric= (TextView)findViewById(R.id.txt_b);
        txt_kast= (TextView)findViewById(R.id.txt_k);
        Integer Totalbl=0,TotalN=0,TotalB=0,TotalK=0;
        SQLiteDatabase db;
        Dbhelper conn=new Dbhelper(getApplicationContext());
        db= conn.getReadableDatabase();
        Cursor C =db.query("voto",null,null,null,null,null,null);
        if(C!=null)
        {
            if(C.moveToFirst())
            {
                do{
                    if(C.getString(2).equals(""))
                    {
                        Totalbl++;

                    }
                    if(C.getString(2).equals("Nulo"))
                    {
                        TotalN++;

                    }
                    if(C.getString(2).equals("Gabriel Boric"))
                    {
                        TotalB++;

                    }
                    if(C.getString(2).equals("Jose Antonio Kast"))
                    {
                        TotalK++;

                    }

                }
                while(C.moveToNext());
            }

        }
        txt_bl.setText(""+Totalbl);
        txt_nulo.setText(""+TotalN);
        txt_boric.setText(""+TotalB);
        txt_kast.setText(""+TotalK);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);
            }
        });
    }
}