 package com.tac.translatetext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
//import ktmt.k52.viettts.FileChooser.FileChooser;

import android.content.Intent;
import android.os.Bundle;

import org.w3c.dom.Text;

 public class readActivity extends AppCompatActivity {
    Button next, flip, previ, speak , home,delete, rename;
    TextToSpeech mTTS;
    ArrayList< String > en = new ArrayList< String >();
    TextView text, check;
    private String filepath = "MyFileStorage";
    File myExternalFile;
    ArrayList< String > vn = new ArrayList< String >();
    ArrayList< String > readarray = new ArrayList< String >();
    int warn =0;
    int n = 0, namecheck = 0;
    ArrayList< String > enarray, vnarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        text = findViewById(R.id.textView);
        check = findViewById(R.id.check);
        home = findViewById(R.id.home);
        delete = findViewById(R.id.delete);

        delete.setVisibility(View.GONE);

        home.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(readActivity.this, beginActivity.class);
                startActivity(intent);
            }
        });
        if (intent.getIntExtra("source", 0) == 5) {
            try {
                String name = intent.getStringExtra("file");
                myExternalFile = new File(getExternalFilesDir(filepath), name);

                FileInputStream fis = new FileInputStream(myExternalFile);
                DataInputStream in = new DataInputStream(fis);
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(in));
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    readarray.add(strLine);

                }
                en = doalll.spliten(readarray);
                vn = doalll.splitvn(readarray);
                in.close();
                text.setText(en.get(n));


                delete.setVisibility(View.VISIBLE);

            } catch (IOException e) {
            }


        } else if (intent.getIntExtra("source", 0) == 1) {
            try {
                enarray = intent.getStringArrayListExtra("english");
                vnarray = intent.getStringArrayListExtra("vietnamese");
            } catch (Exception ee) {
            }

            try {
                en.addAll(enarray);
                vn.addAll(vnarray);
                text.setText(en.get(n));

            } catch (Exception eee) {

            }
        } else if (intent.getIntExtra("source", 3) == 3) {
            en.addAll(Arrays.asList("god", "pendulum", "million", "nobody", "heart"));
            vn.addAll(Arrays.asList("chúa", "con lắc", "1 triệu", "không ai cả", "trái tim"));
            text.setText(en.get(n));
        }


        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {


            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        speak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        next = findViewById(R.id.next);
        flip = findViewById(R.id.flip);
        previ = findViewById(R.id.previ);
        speak = findViewById(R.id.speak);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    if (n < en.size() - 1) {
                        n++;
                        text.setText(en.get(n));


                    }
                } catch (Exception e) {
                }

                check.setText("card " + (n + 1) + " of " + en.size());


            }
        });
        previ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (n > 0) {
                    n--;
                    text.setText(en.get(n));

                }

                check.setText("card " + (n + 1) + " of " + en.size());
            }
        });

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (text.getText() == en.get(n)) {
                        text.setText(vn.get(n));


                    } else {
                        text.setText(en.get(n));

                    }
                } catch (Exception e) {
                }


            }


        });
        speak.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String txt = (String) text.getText();
                mTTS.speak(txt, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {


                                      @Override
                                      public void onClick(View v) {
                                    if   (   myExternalFile.exists()){
                                          if (warn == 0) {
                                              check.setText("do you want to delete file");
                                              warn++;
                                              text.setText("press again to continue");
                                          }
                                    else      if (warn == 1) {

                                              myExternalFile.delete();

                                              check.setText("file is deleted");
                                          }
                                       else   warn = 0;} else  text.setText("no file here");
                                      }
                                  }
        );



    }}


