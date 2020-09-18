package com.example.quiz_covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nameDone;
    private Button btnRegistrar;
    private int myCont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameDone = findViewById(R.id.nameDone);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(this);

       /*String info = getSharedPreferences("registros",MODE_PRIVATE).getString("registro", "");
        String puntajeNexo = getSharedPreferences("puntaje",MODE_PRIVATE).getString("puntajes", "");
        String puntajeSintomas = getSharedPreferences("puntajess", MODE_PRIVATE).getString("puntajess", "");
        String todo = info+ " " + puntajeNexo + " " + puntajeSintomas;*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("registros", MODE_PRIVATE);
        String todoName = preferences.getString("names", "");

        /*SharedPreferences myPreferences = getSharedPreferences("puntaje", MODE_PRIVATE);
        int puntajeNexo = myPreferences.getInt("seleccion", 0);
        SharedPreferences otherPreferences = getSharedPreferences("puntajess", MODE_PRIVATE);
        //String puntajeSintomas = otherPreferences.getString("valores", "");
        int puntajeSintomas = otherPreferences.getInt("valor", 0);
        //String sumaPuntajes = puntajeNexo + puntajeSintomas;
        int sumaPuntajes = puntajeNexo + puntajeSintomas;
        String todito = todoName + sumaPuntajes;*/

        SharedPreferences youPreferences = getSharedPreferences("puntos", MODE_PRIVATE);
        String myTotal = youPreferences.getString("sumaLetra", "");


        String[] usuarios = todoName.split(",");
        String[] hecho = myTotal.split(",");


    //    Log.d("MEMAMEEEEEEEEEE", ""+valueTotal);



        nameDone.setText("");


          for (int j = 0; j < usuarios.length; j++) {
                myCont = j;
               nameDone.append(usuarios[j]+" "+hecho[myCont]+"\n");
            }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrar:

                Intent i = new Intent(this, NewRegister.class);

                startActivity(i);
        }
    }
}