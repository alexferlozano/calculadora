package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    double total;
    String operador, muestra, reserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = (TextView) findViewById(R.id.resultado);
        muestra = "0";
    }

    public void miClick(View view) {
        Button boton=(Button)view;
        String digito=boton.getText().toString();
        muestra = resultado.getText().toString();
        muestra = muestra + digito;
        resultado.setText(muestra);

    }

    public void operador(View view) {
        switch (view.getId()) {
            case R.id.suma:
                reserva=resultado.getText().toString();
                operador = "+";
                resultado.setText("");
                break;
            case R.id.resta:
                reserva=resultado.getText().toString();
                operador = "-";
                resultado.setText("");
                break;
            case R.id.division:
                reserva=resultado.getText().toString();
                operador = "/";
                resultado.setText("");
                break;
            case R.id.multiplicacion:
                reserva=resultado.getText().toString();
                operador = "*";
                resultado.setText("");
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
                resultado.setText(String.valueOf(total));
                break;
            case "-":
                total= Double.parseDouble(reserva)-Double.parseDouble(resultado.getText().toString());
                resultado.setText(String.valueOf(total));
                break;
            case "/":
                total= Double.parseDouble(reserva)/Double.parseDouble(resultado.getText().toString());
                resultado.setText(String.valueOf(total));
                break;
            case "*":
                total= Double.parseDouble(reserva)*Double.parseDouble(resultado.getText().toString());
                resultado.setText(String.valueOf(total));
                break;
          }
    }

    public void limpieza(View view)
    {
        switch (view.getId())
        {
            case R.id.limpiar:
                muestra="";
                resultado.setText("");
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

        }
    }
}