package com.tac.translatetext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class cardmakeActivity extends AppCompatActivity {
    EditText enbox, vnbox;
    TextView warn;
Button home ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save, move, filesave, fill, read;
        save = findViewById(R.id.save);


        move = findViewById(R.id.move);
        filesave = findViewById(R.id.filesave);
        warn = findViewById(R.id.textView);

        final ArrayList< String > arrayen = new ArrayList< String >();
        final ArrayList< String > arrayvn = new ArrayList< String >();

        //(Arrays.asList(new String[]{"Asasa", "Adasa"})) ;
        TextView text;
        enbox = findViewById(R.id.entext);
        vnbox = findViewById(R.id.viettext);
        enbox.setHint("english");
        vnbox.setHint("vietnamese");
        final EditText enbox = findViewById(R.id.entext), vnbox = findViewById(R.id.viettext);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = enbox.getText().toString();
                String b = vnbox.getText().toString();


                vnbox.setText("");
                enbox.setText("");
                if (a.isEmpty() || b.isEmpty()) {
                    warn.setText("one of the box is empty");
                } else {
                    arrayen.add(a);
                    arrayvn.add(b);
                    warn.setText("");
                }


            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardmakeActivity.this, readActivity.class);

                intent.putStringArrayListExtra("english", arrayen);

                intent.putStringArrayListExtra("vietnamese", arrayvn);
                intent.putExtra("source",1);
                startActivity(intent);


            }
        });


        filesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardmakeActivity.this, nameActivity.class);


                intent.putStringArrayListExtra("english", arrayen);

                intent.putStringArrayListExtra("vietnamese", arrayvn);

intent.putExtra("from","make");

                startActivity(intent);


            }
        });

        fill = findViewById(R.id.fill);

        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        String       source = enbox.getText().toString();
            //    String text =  ;
              new translate(source,vnbox);


            }
        });

        home = findViewById(R.id.home);

        home .setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent  intent = new Intent ( cardmakeActivity.this,beginActivity.class);
                startActivity(intent);
            }});
    }















}