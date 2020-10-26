package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

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
        /*if(view.getId()==R.id.punto || Double.parseDouble(resultado.getText().toString())!=0)
        {*/
            muestra = resultado.getText().toString();
            muestra += digito;
        /*}
        else
        {*/
           // muestra=digito;
        //}
        resultado.setText(muestra);
    }

    public void operador(View view) {
        switch (view.getId()) {
            case R.id.suma:
                operador = "+";
                break;
            case R.id.resta:
                operador = "-";
                break;
            case R.id.division:
                operador = "/";
                break;
            case R.id.multiplicacion:
                operador = "*";
                break;
        }
        operaciones();
    }
    public void operaciones()
    {
        reserva=muestra;
        resultado.setText("");
    }
    public void validacion(View view)
    {
        try
        {
            muestra = resultado.getText().toString();
            muestra = muestra + "1";
            switch (operador)
            {
                case "+":
                    total = Double.parseDouble(reserva) + Double.parseDouble(resultado.getText().toString());
                    validador(total);
                    break;
                case "-":
                    total = Double.parseDouble(reserva) - Double.parseDouble(resultado.getText().toString());
                    validador(total);
                    break;
                case "/":
                    total = Double.parseDouble(reserva) / Double.parseDouble(resultado.getText().toString());
                    validador(total);
                    break;
                case "*":
                    total = Double.parseDouble(reserva) * Double.parseDouble(resultado.getText().toString());
                    validador(total);
                    break;
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Ha habido un error por favor introduzca numeros validos", Toast.LENGTH_SHORT).show();
            muestra="";
            resultado.setText("");
            reserva="";
            operador="";
        }
    }
    public void validador(Double xd)
    {
        if (xd%1==0)
        {
            resultado.setText(String.valueOf(nf.format(xd)));
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
                resultado.setText("");
                reserva="";
                operador="";
                break;
            case R.id.borrar:
                if(muestra.length()==0)
                {
                    muestra="0";
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
                resultado.setText("");
                break;
        }
    }
}