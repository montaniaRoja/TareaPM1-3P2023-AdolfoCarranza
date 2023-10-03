package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText resultado;
    EditText nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        String nombre=getIntent().getStringExtra("nombre");
        int resultado = getIntent().getIntExtra("resultado", 0); // 0 es un valor predeterminado si no se encuentra el extra

        // Encontrar el EditText en la segunda actividad
        EditText txtResultado = findViewById(R.id.txtResultado);
        EditText txtNombreOp = findViewById(R.id.txtNombreOp);


        // Mostrar el resultado en el EditText
        txtResultado.setText(String.valueOf(resultado));
        txtNombreOp.setText(nombre);


    }
}