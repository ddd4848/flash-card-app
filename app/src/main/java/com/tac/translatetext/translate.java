 package com.tac.translatetext;


import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;
public  class      translate{


   public        translate(final String name, final EditText text){
          FirebaseTranslatorOptions options = new FirebaseTranslatorOptions.Builder()
        //from language
        .setSourceLanguage(FirebaseTranslateLanguage.EN)
        // to language
        .setTargetLanguage(FirebaseTranslateLanguage.VI)
        .build();

  final FirebaseTranslator translator = FirebaseNaturalLanguage.getInstance()
        .getTranslator(options);

        FirebaseModelDownloadConditions conditions = new FirebaseModelDownloadConditions.Builder()
        .build();


        translator.downloadModelIfNeeded(conditions).addOnSuccessListener(new OnSuccessListener<Void>() {
@Override
public void onSuccess(Void aVoid) {
        translator.translate(name).addOnSuccessListener(new OnSuccessListener<String>() {
@Override
public void onSuccess(String s) {
     text.setText(s);
    ;
    
        }
        });
        }
        });
 }


   }