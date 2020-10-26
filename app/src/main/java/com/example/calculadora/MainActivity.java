package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    double total;
    String operador;
    String muestra;
    String reserva,validar;
    Integer entero;
    NumberFormat nf= new DecimalFormat("##.###");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    public void miClick(View view) {
        Button boton=(Button)view;
        String digito=boton.getText().toString();
        if(Integer.parseInt(resultado.getText().toString())==0)
        {
            muestra=digito;
        }
        else
        {
            muestra = resultado.getText().toString();
            muestra = muestra + digito;
        }
        resultado.setText(muestra);
    }

    public void operador(View view) {
        switch (view.getId()) {
            case R.id.suma:
                operador = "+";
                reserva=resultado.getText().toString();
                resultado.setText("0");
                break;
            case R.id.resta:
                operador = "-";
                reserva=resultado.getText().toString();
                resultado.setText("0");
                break;
            case R.id.division:
                operador = "/";
                reserva=resultado.getText().toString();
                resultado.setText("0");
                break;
            case R.id.multiplicacion:
                operador = "*";
                reserva=resultado.getText().toString();
                resultado.setText("0");
                break;
        }
    }

    public void validacion(View view)
    {
            muestra = resultado.getText().toString();
            muestra = muestra + "1";
            switch (operador)
            {
                case "+":
                    total= Double.parseDouble(reserva)+Double.parseDouble(resultado.getText().toString());
                    validador(total);
                    break;
                case "-":
                    total= Double.parseDouble(reserva)-Double.parseDouble(resultado.getText().toString());
                    validador(total);
                    break;
                case "/":
                    total= Double.parseDouble(reserva)/Double.parseDouble(resultado.getText().toString());
                    validador(total);
                    break;
                case "*":
                    total= Double.parseDouble(reserva)*Double.parseDouble(resultado.getText().toString());
                    validador(total);
                    break;
            }

    }
    public void validador(Double xd)
    {
        if (xd%1==0)
        {
            resultado.setText(String.valueOf(nf.format(total)));
        }
        else
        {
            resultado.setText(String.valueOf(xd));
        }
    }
    public void limpieza(View view)
    {
        switch (view.getId())
        {
            case R.id.limpiar:
                muestra="";
                resultado.setText("0");
                reserva="";
                operador="";
                break;
            case R.id.borrar:
                if(muestra.length()==0)
                {
                    muestra="";
                    resultado.setText(muestra);
                }
                else
                {
                    muestra=resultado.getText().toString();
                    muestra=muestra.substring(0,muestra.length()-1);
                    resultado.setText(muestra);
                }
                break;
            case R.id.limpiarPantalla:
                resultado.setText("0");
                break;
        }
    }
}