package com.example.quiz_covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class NexoEpidemiologico extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Button btnContinue;
    private CheckBox boxCorona;
    private CheckBox boxInter;
    private CheckBox boxNacional;
    private CheckBox boxSalud;
    private CheckBox boxNone;
    private int puntaje = 0;
    private boolean siChequeado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nexo_epidemiologico);

        btnContinue = findViewById(R.id.btnContinue);
        boxCorona = findViewById(R.id.boxCorona);
        boxInter = findViewById(R.id.boxInter);
        boxNacional = findViewById(R.id.boxNacional);
        boxSalud = findViewById(R.id.boxSalud);
        boxNone = findViewById(R.id.boxNone);

        btnContinue.setOnClickListener(this);

        boxCorona.setOnCheckedChangeListener(this);
        boxInter.setOnCheckedChangeListener(this);
        boxNacional.setOnCheckedChangeListener(this);
        boxSalud.setOnCheckedChangeListener(this);
        boxNone.setOnCheckedChangeListener(this);







    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnContinue:

                chequeado();

                /*//String myPuntaje = Integer.toString(puntaje);
                int myPuntaje = puntaje;
                SharedPreferences preferences = getSharedPreferences("puntaje", MODE_PRIVATE);
                //String puntajee = preferences.getString("seleccion", "");
                int puntajee = preferences.getInt("seleccion", puntaje);
                //String allPuntaje = puntajee+","+" "+myPuntaje;
                int allPuntaje = puntajee + myPuntaje;
                preferences.edit().putInt("selección",allPuntaje).apply();
                Log.d("NOSEEEEE", ""+preferences);*/



                if (siChequeado == true) {
                    Intent i = new Intent(this, Sintomas.class);
                    i.putExtra("nexoPuntaje", puntaje);

                    startActivity(i);
                    finish();
                } else {
                   Toast.makeText(this, "Debes seleccionar al menos una casilla", Toast.LENGTH_LONG).show();
                }


        }
    }

    public void chequeado () {

        if (boxCorona.isChecked()) {
            puntaje = puntaje + 3;
            siChequeado = true;

        }

        if (boxInter.isChecked()) {
            puntaje = puntaje + 3;
            siChequeado = true;

        }

        if (boxNacional.isChecked()) {
            puntaje = puntaje + 3;
            siChequeado = true;

        }


        if (boxSalud.isChecked()) {
            puntaje = puntaje + 3;
            siChequeado = true;

        }

        if (boxNone.isChecked()) {
            puntaje = puntaje + 0;
            siChequeado = true;

        }
        Log.d("POVAFOOOO", ""+puntaje);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.boxCorona:
                if (b == true) {
                    btnContinue.setBackgroundColor(Color.rgb(240,24,86));
                } else {
                    btnContinue.setBackgroundColor(Color.rgb(222,222,222));
                }
                break;

            case R.id.boxInter:
                if (b == true) {
                    btnContinue.setBackgroundColor(Color.rgb(240,24,86));
                } else {
                    btnContinue.setBackgroundColor(Color.rgb(222,222,222));
        }

            case R.id.boxNacional:
                if (b == true) {
                    btnContinue.setBackgroundColor(Color.rgb(240,24,86));
                } else {
                    btnContinue.setBackgroundColor(Color.rgb(222,222,222));
                }

            case R.id.boxSalud:
                if (b == true) {
                    btnContinue.setBackgroundColor(Color.rgb(240,24,86));
                } else {
                    btnContinue.setBackgroundColor(Color.rgb(222,222,222));
                }

            case R.id.boxNone:
                if (b == true) {
                    btnContinue.setBackgroundColor(Color.rgb(240,24,86));
                } else {
                    btnContinue.setBackgroundColor(Color.rgb(222,222,222));
                }
        }
    }



   /* public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.boxCorona:
                if (checked) {
                    puntaje += 3;
                }
                break;

            case R.id.boxInter:
                if (checked) {
                    puntaje += 3;
                }
                break;

            case R.id.boxNacional:
                if (checked) {
                    puntaje += 3;
                }
                break;

            case R.id.boxSalud:
                if (checked) {
                    puntaje += 3;
                }
                break;

            case R.id.boxNone:
                if (checked) {
                    puntaje += 0;
                }
                break;
        }


    }*/


}