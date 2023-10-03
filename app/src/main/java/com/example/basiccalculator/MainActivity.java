package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numeroUno,numeroDos;
    Button botonSuma, botonResta,botonMult,botonDiv;
    String opcion;
    int num1, num2;
    boolean ejecutar=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroUno=(EditText)findViewById(R.id.txtNoUno);
        numeroDos=(EditText)findViewById(R.id.txtNoDos);

        botonSuma=(Button)findViewById(R.id.btnSuma);
        botonResta=(Button)findViewById(R.id.btnResta);
        botonMult=(Button)findViewById(R.id.btnMult);
        botonDiv=(Button)findViewById(R.id.btnDiv);

        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarNumeros()) {
                num1=Integer.parseInt(String.valueOf(numeroUno.getText()));
                num2=Integer.parseInt(String.valueOf(numeroDos.getText()));
                opcion="S";
                Operacion operacion = new Operacion(num1, num2, opcion);
                String resultadoString = String.valueOf(operacion.getResultado());
                actividadDos(resultadoString, "Suma");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Por favor, complete ambos campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarNumeros()) {
                num1=Integer.parseInt(String.valueOf(numeroUno.getText()));
                num2=Integer.parseInt(String.valueOf(numeroDos.getText()));
                opcion="R";
                Operacion operacion=new Operacion(num1,num2,opcion);

                String resultadoString = String.valueOf(operacion.getResultado());
                actividadDos(resultadoString, "Resta");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Por favor, complete ambos campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        botonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarNumeros()) {
                    num1 = Integer.parseInt(numeroUno.getText().toString());
                    num2 = Integer.parseInt(numeroDos.getText().toString());

                    if (num2 != 0) {
                        opcion = "D";
                        Operacion operacion = new Operacion(num1, num2, opcion);
                        String resultadoString = String.valueOf(operacion.getResultado());
                        actividadDos(resultadoString, "Division");
                    } else {
                        Toast.makeText(getApplicationContext(), "Error: División por cero.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Favor complete ambos campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        botonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarNumeros()) {
                num1=Integer.parseInt(String.valueOf(numeroUno.getText()));
                num2=Integer.parseInt(String.valueOf(numeroDos.getText()));
                opcion="M";
                Operacion operacion=new Operacion(num1,num2,opcion);
                String resultadoString = String.valueOf(operacion.getResultado());
                actividadDos(resultadoString, "Multiplicacion");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Por favor, complete ambos campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //llamar a la nueva pantalla
    private void actividadDos(String resultado, String opName){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("nombre","El resultado de la "+opName+" es");
        intent.putExtra("resultado", Integer.parseInt(resultado));

        startActivity(intent);
        numeroUno.setText("");
        numeroDos.setText("");
    }

    //verificar que los texts esten llenos

    private boolean validarNumeros(){
        String textoNumeroUno = numeroUno.getText().toString();
        String textoNumeroDos = numeroDos.getText().toString();
        if (TextUtils.isEmpty(textoNumeroUno) || TextUtils.isEmpty(textoNumeroDos)) {
            return false;
        }
        return true;
    }

}
