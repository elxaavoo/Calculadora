package es.ieslavereda.calculadora;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener {

    private Button uno;
    private Button dos;
    private Button tres;
    private Button cuatro;
    private Button cinco;
    private Button seis;
    private Button siete;
    private Button ocho;
    private Button nueve;
    private Button cero;
    private Button suma;
    private Button resta;
    private Button divi;
    private Button multi;
    private Button igual;
    private Button coma;
    private Button clear;
    private CheckBox mostrar;
    private RadioButton radioSuma;
    private RadioButton radioResta;
    private RadioButton radioMulti;
    private RadioButton radioDivi;
    private TextView vistaCalc;
    private RadioGroup radioGroup;
    private Float num1;
    private Float num2;
    private Character operador = null;
    private float resultado;
    private TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        siete = findViewById(R.id.siete);
        ocho = findViewById(R.id.ocho);
        nueve = findViewById(R.id.nueve);
        cero = findViewById(R.id.cero);
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        divi = findViewById(R.id.divi);
        multi = findViewById(R.id.multi);
        igual = findViewById(R.id.igual);
        coma = findViewById(R.id.coma);
        clear = findViewById(R.id.boton_clear);
        mostrar = findViewById(R.id.checkMostrar);
        radioSuma = findViewById(R.id.radioSuma);
        radioResta = findViewById(R.id.radioResta);
        radioMulti = findViewById(R.id.radioMulti);
        radioDivi = findViewById(R.id.radioDivi);
        vistaCalc = findViewById(R.id.vistaCalc);
        radioGroup = findViewById(R.id.groupBotones);
        showResult = findViewById(R.id.showResult);

        mostrar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mostrar.isChecked()){
                    radioGroup.setVisibility(View.VISIBLE);
                } else {
                    radioGroup.setVisibility(View.GONE);
                    radioGroup.clearCheck();
                }
            }
        });
        radioSuma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radioSuma.isChecked())
                    suma.setEnabled(false);
                else
                    suma.setEnabled(true);
            }
        });
        radioResta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radioResta.isChecked())
                    resta.setEnabled(false);
                else
                    resta.setEnabled(true);
            }
        });
        radioDivi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radioDivi.isChecked())
                    divi.setEnabled(false);
                else
                    divi.setEnabled(true);
            }
        });
        radioMulti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radioMulti.isChecked())
                    multi.setEnabled(false);
                else
                    multi.setEnabled(true);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaCalc.setText("");
                operador = null;
                showResult.setText("");
            }
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (operador == null) {
                    num1 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                    vistaCalc.setText("");
                    operador = '+';
                } else {
                    num2 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                    vistaCalc.setText("");
                    if (operador == '+')
                        resultado = num1+num2;
                    if (operador == '-')
                        resultado = num1-num2;
                    if (operador == '/')
                        resultado = num1/num2;
                    if (operador == '*')
                        resultado = num1*num2;
                    num1 = resultado;
                    vistaCalc.setText("");
                    showResult.setText(resultado+"");
                    operador = '+';
                }
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == null){
                    num1 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                    vistaCalc.setText("");
                    operador = '-';
                } else {
                    num2 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                    vistaCalc.setText("");
                    if (operador == '+')
                        resultado = num1+num2;
                    if (operador == '-')
                        resultado = num1-num2;
                    if (operador == '/')
                        resultado = num1/num2;
                    if (operador == '*')
                        resultado = num1*num2;
                    num1 = resultado;
                    vistaCalc.setText("");
                    showResult.setText(resultado+"");
                    operador = '-';
                }

            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == null){
                    num1 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                    vistaCalc.setText("");
                    operador = '*';
                } else {
                    num2 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                    vistaCalc.setText("");
                    if (operador == '+')
                        resultado = num1+num2;
                    if (operador == '-')
                        resultado = num1-num2;
                    if (operador == '/')
                        resultado = num1/num2;
                    if (operador == '*')
                        resultado = num1*num2;
                    num1 = resultado;
                    vistaCalc.setText("");
                    showResult.setText(resultado+"");
                    operador = '*';
                }

            }
        });

        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == null){
                    num1 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                    vistaCalc.setText("");
                    operador = '/';
                } else {
                    num2 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                    vistaCalc.setText("");
                    if (operador == '+')
                        resultado = num1+num2;
                    if (operador == '-')
                        resultado = num1-num2;
                    if (operador == '/')
                        resultado = num1/num2;
                    if (operador == '*')
                        resultado = num1/num2;
                    num1 = resultado;
                    vistaCalc.setText("");
                    showResult.setText(resultado+"");
                    operador = '/';
                }
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2 = Float.parseFloat(String.valueOf(vistaCalc.getText()));
                if (num2 != null){
                    if (operador == '+')
                        resultado = num1+num2;
                    if (operador == '-')
                        resultado = num1-num2;
                    if (operador == '/')
                        resultado = num1/num2;
                    if (operador == '*')
                        resultado = num1*num2;
                }
                    vistaCalc.setText(String.valueOf(resultado));
                    showResult.setText(resultado+"");
                    operador = null;
            }
        });



        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        cero.setOnClickListener(this);
        coma.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (vistaCalc.getText()=="0") {
            vistaCalc.setText("");
            vistaCalc.setText(String.valueOf(view.getTag()));
        }else
            vistaCalc.setText(vistaCalc.getText() + String.valueOf(view.getTag()));
    }
}