 package com.tac.translatetext;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import java.io.File;
import java.util.ArrayList;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

 public class browseActivity extends AppCompatActivity {
    private String filepath = "MyFileStorage";
     File file;
     ListView      listView;
     TextView textView ;
     Button home ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main5);
        textView = findViewById(R.id.text) ;
        listView  =  findViewById(R.id.listView);


        home = findViewById(R.id.home);

        home .setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent  intent = new Intent ( browseActivity.this,beginActivity.class);
                startActivity(intent);
            }});
          file = new File(String.valueOf(getExternalFilesDir(filepath)));
        final Intent intent = new Intent(browseActivity.this, readActivity.class);

          int n=0;
        final ArrayList<String>    dir = new   ArrayList<String> () ;
        String[] mmm      ;

            mmm = file.list();



        for ( String a: mmm) {

            System.out.println(a);

            dir.add(a ) ;
            System.out.println(dir.get(n));
            n++;
        }

        ArrayAdapter< String >arrayAdapter = new ArrayAdapter< String >(this, android.R.layout.simple_list_item_1, dir);



    try {
        listView.setAdapter(arrayAdapter);
    }
    catch(Exception e){}
        try {
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView< ? > adapterView, View view, int i, long l) {
            String m = dir.get(i);


            textView.setText(m);
            intent.putExtra("file",m);
            intent.putExtra("source",5);
            startActivity(intent);
        }
    });

}
catch(Exception e){}



        }






    }
