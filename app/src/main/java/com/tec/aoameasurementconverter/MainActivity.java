package com.tec.aoameasurementconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    protected void initComponents(){
        final RadioGroup radioGroup     = findViewById(R.id.radioGroup);
        final TextView ResultTextView   = findViewById(R.id.ResultMainTextView);
        final EditText editText         = findViewById(R.id.editText);
        Button button                   = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ResultTextView.setVisibility(View.GONE);
                double entrie;

                if (editText.getText().toString().isEmpty())
                    return;

                try{

                    entrie   = Double.parseDouble(editText.getText().toString());

                }catch(NumberFormatException numberFormatException){
                    Log.e("MainActivity",numberFormatException.getMessage());
                    return;
                }


                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.mtsMainRadioButton:
                        entrie  = entrie*0.01;
                        break;
                    case R.id.kmMainRadioButton:
                        entrie  = entrie*0.00001;
                        break;
                    case R.id.pMainRadioButton:
                        entrie  = entrie*0.393701;
                        break;
                }

                ResultTextView.setText("Conversion: "+entrie);
                ResultTextView.setVisibility(View.VISIBLE);
            }
        });
    }
}
