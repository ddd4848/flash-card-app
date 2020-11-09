 package com.tac.translatetext;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class nameActivity extends AppCompatActivity {
    Intent intent;
TextView textView;
    ArrayList<String> VN, EN , merge;
    EditText text;
    Button button, home ;
    private String filepath = "MyFileStorage";
    File myExternalFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);
        intent = getIntent();
        text = findViewById(R.id.name);
        button = findViewById(R.id.button);

textView = findViewById(R.id .textView2) ;




        home = findViewById(R.id.home);

        home .setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent  intent = new Intent ( nameActivity.this,beginActivity.class);
                startActivity(intent);
            }});


        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                    EN = intent.getStringArrayListExtra("english");

                    VN = intent.getStringArrayListExtra("vietnamese");
                    merge = doalll.merge(EN, VN);
                    String filename = text.getText().toString();

                    try {
                        myExternalFile = new File(getExternalFilesDir(filepath), filename + ".txt");
                        System.out.println(filepath);
                        FileOutputStream fos = new FileOutputStream(myExternalFile);
                        for (String ds : merge) {
                            System.out.println(ds);
                            fos.write((ds + "\n").getBytes());
                        }
                        fos.close();



                        textView.setText("file is saved");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    






                }

        });
    }}