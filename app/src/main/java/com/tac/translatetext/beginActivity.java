package com.tac.translatetext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class beginActivity extends AppCompatActivity {
TextView textView ;
Button newa, move,read,close ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
newa = findViewById(R.id.button);
close =  findViewById(R.id.close) ;
        move = findViewById(R.id.button2);
        read = findViewById(R.id.read);
        newa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(beginActivity.this, cardmakeActivity.class);
                startActivity(intent);
            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(beginActivity.this, readActivity.class);

                intent.putExtra("source",3);
                startActivity(intent);
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(beginActivity.this, browseActivity.class);
                startActivity(intent);

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginActivity.this.finishAffinity();
System.exit(0);
            }
        });


    }
}