package com.example.basiccalculator;

public class Operacion {
    int resultado;
    public Operacion(int primerNumero, int segundoNumero, String calculoSolicitado){

        realizarCalculo(primerNumero,segundoNumero,calculoSolicitado);

    }

    private void realizarCalculo(int a, int b, String calculo){
        switch(calculo){
            case "S":
                resultado=a+b;
                break;
            case "R":
                resultado=a-b;
                break;
            case "D":
                if (b != 0) {
                    resultado = a / b;
                } else {

                }
                break;
            case "M":
                resultado=a*b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculo);
        }

    }

    public int getResultado() {
        return resultado;
    }
}

