package com.uso.guia1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnSuma;
    Button btnResta;
    Button btnMultiplicacion;
    Button btnDivision;
    Button btnIgual;
    Button btnAC;
    Button btnDEL;
    TextView txvEntrada;
    TextView txvSalida;

    Button btnB1;
    Button btnB2;
    Button btnPunto;

    Integer cAbre;
    Integer cCierra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn0 = findViewById(R.id.btn0);
        this.btn0.setOnClickListener(this);
        this.btn1 = findViewById(R.id.btn1);
        this.btn1.setOnClickListener(this);
        this.btn2 = findViewById(R.id.btn2);
        this.btn2.setOnClickListener(this);
        this.btn3 = findViewById(R.id.btn3);
        this.btn3.setOnClickListener(this);
        this.btn4 = findViewById(R.id.btn4);
        this.btn4.setOnClickListener(this);
        this.btn5 = findViewById(R.id.btn5);
        this.btn5.setOnClickListener(this);
        this.btn6 = findViewById(R.id.btn6);
        this.btn6.setOnClickListener(this);
        this.btn7 = findViewById(R.id.btn7);
        this.btn7.setOnClickListener(this);
        this.btn8 = findViewById(R.id.btn8);
        this.btn8.setOnClickListener(this);
        this.btn9 = findViewById(R.id.btn9);
        this.btn9.setOnClickListener(this);
        this.btnSuma = findViewById(R.id.btnSuma);
        this.btnSuma.setOnClickListener(this);
        this.btnResta = findViewById(R.id.btnResta);
        this.btnResta.setOnClickListener(this);
        this.btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        this.btnMultiplicacion.setOnClickListener(this);
        this.btnDivision = findViewById(R.id.btnDivision);
        this.btnDivision.setOnClickListener(this);
        this.btnIgual = findViewById(R.id.btnIgual);
        this.btnIgual.setOnClickListener(this);
        this.btnAC = findViewById(R.id.btnAC);
        this.btnAC.setOnClickListener(this);
        this.btnDEL = findViewById(R.id.btnDEL);
        this.btnDEL.setOnClickListener(this);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            this.btnB1 = findViewById(R.id.btnB1);
            this.btnB1.setOnClickListener(this);
            this.btnB2 = findViewById(R.id.btnB2);
            this.btnB2.setOnClickListener(this);
            this.btnPunto = findViewById(R.id.btnPunto);
            this.btnPunto.setOnClickListener(this);
        }


        this.txvEntrada = findViewById(R.id.txvEntrada);
        this.txvSalida = findViewById(R.id.txvSalida);
        this.txvEntrada.setText("");
        this.txvSalida.setText("");

        this.cAbre = 0;
        this.cCierra = 0;

    }

    @Override
    public void onClick(View v) {
        StringBuilder entrada = new StringBuilder();
        entrada.append(this.txvEntrada.getText().toString());

        switch (v.getId()){
            case R.id.btn0:
                entrada.append(0);
                break;
            case R.id.btn1:
                entrada.append(1);
                break;
            case R.id.btn2:
                entrada.append(2);
                break;
            case R.id.btn3:
                entrada.append(3);
                break;
            case R.id.btn4:
                entrada.append(4);
                break;
            case R.id.btn5:
                entrada.append(5);
                break;
            case R.id.btn6:
                entrada.append(6);
                break;
            case R.id.btn7:
                entrada.append(7);
                break;
            case R.id.btn8:
                entrada.append(8);
                break;
            case R.id.btn9:
                entrada.append(9);
                break;
            case R.id.btnSuma:
                if(entrada.length() > 0 ) {
                    entrada.append("+");
                }
                break;
            case R.id.btnResta:
                if(entrada.length() > 0 ) {
                    entrada.append("-");
                }
                break;
            case R.id.btnMultiplicacion:
                if(entrada.length() > 0 ) {
                    entrada.append("*");
                }
                break;
            case R.id.btnDivision:
                if(entrada.length() > 0 ) {
                    entrada.append("/");
                }
                break;
            case R.id.btnAC:
                entrada.delete(0,entrada.length());
                txvSalida.setText("");
                break;
            case R.id.btnDEL:
                if(entrada.length() > 0 ) {
                    if((entrada.charAt(entrada.length() - 1)) == ')'){
                        cCierra--;
                    }
                    entrada.deleteCharAt(entrada.length() - 1);
                }
                break;
            case R.id.btnIgual:
                if(entrada.length() > 0 ) {
                    Expression e = new ExpressionBuilder(entrada.toString()).build();
                    txvSalida.setText(String.valueOf(e.evaluate()));
                }
                else
                    txvSalida.setText("0");
                break;
            case R.id.btnB1:
                entrada.append("(");
                cAbre++;
                break;
            case R.id.btnB2:
                if (cAbre > cCierra){
                    entrada.append(")");
                    cCierra++;
                }
                break;
            case R.id.btnPunto:
                if(entrada.length() > 0 ) {
                    entrada.append(".");
                }
                break;
        }
        txvEntrada.setText(entrada.toString());

    }
}