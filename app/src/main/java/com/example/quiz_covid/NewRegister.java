package com.example.quiz_covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InlineSuggestionsRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.InetAddress;

public class NewRegister extends AppCompatActivity implements View.OnClickListener {

    private EditText ingresaName;
    private EditText ingresaID;
    private Button btnContinuarUno;
    private boolean relleno = false;
    private boolean igual = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        ingresaName = findViewById(R.id.ingresaName);
        ingresaID = findViewById(R.id.ingresaID);
        btnContinuarUno = findViewById(R.id.btnContinuarUno);

        btnContinuarUno.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch  (view.getId()) {
            case R.id.btnContinuarUno:

                String myNames = ingresaName.getText().toString();
                String myId = ingresaID.getText().toString();

                SharedPreferences preferences = getSharedPreferences("registros", MODE_PRIVATE);
                String nameIngresado = preferences.getString("names", "");
                String idIngresado = preferences.getString("idd", "");

                if (idIngresado.contains(myId)){
                    Toast.makeText(this, "Este ID ya está registrado", Toast.LENGTH_LONG).show();
                } else {
                    String nombre = nameIngresado+","+" "+myNames;
                    String identificacion = idIngresado+","+" "+myId;

                    preferences.edit().putString("names",nombre).apply();
                    preferences.edit().putString("idd", identificacion).apply();


                    Intent i = new Intent(this, NexoEpidemiologico.class);

                    startActivity(i);
                    finish();
                    Log.d("MIIIIIIIIIIII" ,""+identificacion);
                }




        }

    }
}