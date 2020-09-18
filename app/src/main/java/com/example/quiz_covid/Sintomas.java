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

public class Sintomas extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private CheckBox boxFiebre;
    private CheckBox boxDolor;
    private CheckBox boxNasal;
    private CheckBox boxTos;
    private CheckBox boxFatiga;
    private CheckBox boxRespirar;
    private CheckBox boxNinguno;
    private Button btnFinal;
    private int puntaje = 0;
    private boolean siChequeo = false;
    private String lastSuma;
    private String todaSuma;
    private String sumaLetra;
    private int sumaPuntaje;
    private int puntajeNexo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        boxFiebre = findViewById(R.id.boxFiebre);
        boxDolor = findViewById(R.id.boxDolor);
        boxNasal = findViewById(R.id.boxNasal);
        boxTos = findViewById(R.id.boxTos);
        boxFatiga = findViewById(R.id.boxFatiga);
        boxRespirar = findViewById(R.id.boxRespirar);
        boxNinguno = findViewById(R.id.boxNinguno);
        btnFinal = findViewById(R.id.btnFinal);


        btnFinal.setOnClickListener(this);

        boxFiebre.setOnCheckedChangeListener(this);
        boxDolor.setOnCheckedChangeListener(this);
        boxNasal.setOnCheckedChangeListener(this);
        boxTos.setOnCheckedChangeListener(this);
        boxFatiga.setOnCheckedChangeListener(this);
        boxRespirar.setOnCheckedChangeListener(this);
        boxNinguno.setOnCheckedChangeListener(this);

        puntajeNexo =  getIntent().getExtras().getInt("nexoPuntaje");

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFinal:

                chequeado();




                puntaje += puntajeNexo;


                /*//String myPuntajes = Integer.toString(puntaje);
                int myPuntajes = puntaje;
                SharedPreferences preferences = getSharedPreferences("puntajess", MODE_PRIVATE);
               // String thisPuntaje = preferences.getString("valores", "");
                int thisPuntaje = preferences.getInt("valores", puntaje);
                //String morePuntaje = thisPuntaje+","+" "+myPuntajes;
                int morePuntaje = thisPuntaje + myPuntajes;
                preferences.edit().putInt("valores", morePuntaje).apply();*/




                if (siChequeo == true) {

                    SharedPreferences youPreferences = getSharedPreferences("puntos", MODE_PRIVATE);
                    lastSuma = youPreferences.getString("sumaLetra", "");
                    sumaLetra = ""+puntaje;
                    todaSuma = lastSuma+","+sumaLetra;

                    Log.d("SUUUUUUUMALETRA", ""+sumaLetra);


                    youPreferences.edit().putString("sumaLetra", todaSuma).apply();

                    Intent i = new Intent(this, MainActivity.class);

                   Log.e("TODAAAALETRAAAAAAAAA", ""+todaSuma);
                   Log.e("LASTSUMAAAAAAAAAAA", ""+lastSuma);

                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(this, "Debes seleccionar al menos una casilla", Toast.LENGTH_LONG).show();
                }

        }
    }

    public void chequeado () {

        if (boxFatiga.isChecked()) {
            puntaje = puntaje + 4;
            siChequeo = true;
        }

        if (boxDolor.isChecked()) {
            puntaje = puntaje + 4;
            siChequeo = true;
        }

        if (boxFiebre.isChecked()) {
            puntaje = puntaje + 4;
            siChequeo = true;
        }

        if (boxRespirar.isChecked()) {
            puntaje = puntaje + 4;
            siChequeo = true;
        }

        if (boxNasal.isChecked()) {
            puntaje = puntaje + 4;
            siChequeo = true;
        }

        if (boxTos.isChecked()) {
            puntaje = puntaje + 4;
            siChequeo = true;
        }

        if (boxNinguno.isChecked()) {
            puntaje = puntaje + 0;
            siChequeo = true;
        }
        Log.d("SINTOMAAAAAAS", ""+puntaje);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) { switch (compoundButton.getId()) {
        case R.id.boxFatiga:
            if (b == true){
                btnFinal.setBackgroundColor(Color.rgb(240,24,86));
            } else {
                btnFinal.setBackgroundColor(Color.rgb(222,222,222));
            }

            break;

        case R.id.boxFiebre:
            if (b == true){
                btnFinal.setBackgroundColor(Color.rgb(240,24,86));
            } else {
                btnFinal.setBackgroundColor(Color.rgb(222,222,222));
            }
            break;

        case R.id.boxDolor:
            if (b == true){
                btnFinal.setBackgroundColor(Color.rgb(240,24,86));
            } else {
                btnFinal.setBackgroundColor(Color.rgb(222,222,222));
            }
            break;

        case R.id.boxNasal:
            if (b == true){
                btnFinal.setBackgroundColor(Color.rgb(240,24,86));
            } else {
                btnFinal.setBackgroundColor(Color.rgb(222,222,222));
            }
            break;

        case R.id.boxRespirar:
            if (b == true){
                btnFinal.setBackgroundColor(Color.rgb(240,24,86));
            } else {
                btnFinal.setBackgroundColor(Color.rgb(222,222,222));
            }
            break;

        case R.id.boxTos:
            if (b == true){
                btnFinal.setBackgroundColor(Color.rgb(240,24,86));
            } else {
                btnFinal.setBackgroundColor(Color.rgb(222,222,222));
            }
            break;

        case R.id.boxNinguno:
            if (b == true){
                btnFinal.setBackgroundColor(Color.rgb(240,24,86));
            } else {
                btnFinal.setBackgroundColor(Color.rgb(222,222,222));
            }
            break;
    }
    }
}