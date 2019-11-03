package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Creamos los botones
    Button btnAC, btnDEL,btnMas,btnMenos,
            btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnDivision,btnMultiplicacion, btnIgual,
            btnAbrir,btnCerrar,btnPunto;

    // creamos las etiquetas
    TextView lblResultado;
    EditText lblOperarcion;

    // Cremoas variables para guardar las operaciones y el resultado.
    double num1, num2, Resultado;
    String abrirParentesis, cerrarParentesis;
    String StringNum1, StringNum2;
    String Operacion;

    int charIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos los controles

        // TextViews
        lblOperarcion = findViewById(R.id.lblOperarcion);
        lblResultado = findViewById(R.id.lblResultado);

        // Buttons
        btnAC = findViewById(R.id.btnAC);
        btnDEL = findViewById(R.id.btnDEL);
        btnMas = findViewById(R.id.btnMas);
        btnMenos = findViewById(R.id.btnMenos);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnIgual = findViewById(R.id.btnIgual);

        // Titulo
        setTitle("QC15-I04-001");

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Se cumple que sea Landscape entonces llamo a mis controles
            btnAbrir = findViewById(R.id.btnAbrir);
            btnCerrar = findViewById(R.id.btnCerrar);
            btnPunto = findViewById(R.id.btnPunto);

            btnAbrir.setOnClickListener(this);
            btnCerrar.setOnClickListener(this);
            btnPunto.setOnClickListener(this);
        }

        btnAC.setOnClickListener(this);
        btnDEL.setOnClickListener(this);
        btnMas.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnMultiplicacion.setOnClickListener(this);
        btnIgual.setOnClickListener(this);

        num1=0;
        num2=0;
        Resultado=0;
        abrirParentesis = "(";
        cerrarParentesis = ")";
        StringNum1="";
        StringNum2="";
        Operacion="";

        charIndex = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAC:{
                lblOperarcion.setText("");

                Operacion = "";
                StringNum1 = "";
                StringNum2 = "";
                Resultado = 0;
                lblOperarcion.setText("");
                lblResultado.setText("");
                num1 = 0;
                num2 = 0;
            }
            break;
            case R.id.btnDEL:{
                if (lblOperarcion.getText().length() != 0){
                    String text = lblOperarcion.getText().toString();
                    text = text.substring(0, text.length()-1);
                    lblOperarcion.setText(text);
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    if (StringNum2 != ""){
                        String Text2 = StringNum2;
                        StringNum2 = Text2.substring(0, Text2.length()-1);
                    }else if (!StringNum1.isEmpty()){
                        String Text1 = StringNum1;
                        StringNum1 = Text1.substring(0, Text1.length()-1);
                    }
                }
            }
            break;
            case R.id.btnMas:{
                if (lblOperarcion.getText().length() != 0){
                    String text = lblOperarcion.getText().toString();
                    if (text.charAt(text.length()-1) == '/' || text.charAt(text.length()-1) == '-' || text.charAt(text.length()-1) == '*'){

                        text = text.substring(0, text.length()-1);
                        lblOperarcion.setText(text + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }else {
                        lblOperarcion.setText(lblOperarcion.getText() + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }
                }else {
                    if (Resultado == 0){
                        StringNum1 = "0";
                        lblOperarcion.setText(StringNum1 + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }else {
                        StringNum1 = lblResultado.getText().toString();
                        lblOperarcion.setText(StringNum1 + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }
                }
                Operacion = "+";

                /*if (StringNum2 != "" && Resultado != 0){
                    num2 = Double.parseDouble(StringNum2);

                    Resultado = Resultado + num2;
                    lblResultado.setText(String.valueOf(Resultado));
                    num1 = 0;
                    num2 = 0;
                    StringNum1 = "";
                    StringNum2 = "";
                }*/
            }
            break;

            case R.id.btnMenos:{
                if (lblOperarcion.getText().length() != 0){
                    String text = lblOperarcion.getText().toString();
                    if (text.charAt(text.length()-1) == '/' || text.charAt(text.length()-1) == '+' || text.charAt(text.length()-1) == '*'){

                        text = text.substring(0, text.length()-1);
                        lblOperarcion.setText(text + "-");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }else {
                        lblOperarcion.setText(lblOperarcion.getText() + "-");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }
                }else {
                    if (Resultado == 0){
                        StringNum1 = "0";
                        lblOperarcion.setText(StringNum1 + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }else {
                        StringNum1 = lblResultado.getText().toString();
                        lblOperarcion.setText(StringNum1 + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }
                }
                Operacion = "-";

                /*if (StringNum2 != "" && Resultado != 0){
                    num2 = Double.parseDouble(StringNum2);

                    Resultado = Resultado - num2;
                    lblResultado.setText(String.valueOf(Resultado));
                    num1 = 0;
                    num2 = 0;
                    StringNum1 = "";
                    StringNum2 = "";
                }*/
            }
            break;
            case R.id.btn0:{
                if (Operacion == ""){
                    lblOperarcion.setText(lblOperarcion.getText() + "0");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 0;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "0");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 0;
                }
            }
            break;
            case R.id.btn1:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "1");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 1;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "1");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 1;
                }
            }
            break;
            case R.id.btn2:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "2");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + "2";
                }else if (StringNum1 != ""){
                    lblOperarcion.setText(lblOperarcion.getText() + "2");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + "2";
                }
            }
            break;
            case R.id.btn3:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "3");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 3;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "3");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 3;
                }
            }
            break;
            case R.id.btn4:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "4");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 4;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "4");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 4;
                }
            }
            break;
            case R.id.btn5:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "5");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 5;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "5");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 5;
                }
            }
            break;
            case R.id.btn6:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "6");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 6;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "6");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 6;
                }
            }
            break;
            case R.id.btn7:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "7");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 7;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "7");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 7;
                }
            }
            break;
            case R.id.btn8:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "8");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 8;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "8");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 8;
                }
            }
            break;
            case R.id.btn9:{
                if (Operacion == "") {
                    lblOperarcion.setText(lblOperarcion.getText() + "9");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum1 = StringNum1 + 9;
                }else{
                    lblOperarcion.setText(lblOperarcion.getText() + "9");
                    lblOperarcion.setSelection(lblOperarcion.getText().length());

                    StringNum2 = StringNum2 + 9;
                }
            }
            break;
            case R.id.btnDivision:{
                if (lblOperarcion.getText().length() != 0){
                    String text = lblOperarcion.getText().toString();
                    if (text.charAt(text.length()-1) == '*' || text.charAt(text.length()-1) == '+' || text.charAt(text.length()-1) == '-'){

                        text = text.substring(0, text.length()-1);
                        lblOperarcion.setText(text + "/");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }else {
                        lblOperarcion.setText(lblOperarcion.getText() + "/");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }
                }else {
                    if (Resultado == 0){
                        StringNum1 = "0";
                        lblOperarcion.setText(StringNum1 + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }else {
                        StringNum1 = lblResultado.getText().toString();
                        lblOperarcion.setText(StringNum1 + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }
                }
                Operacion = "/";

                /*if (StringNum2 != "" && Resultado != 0){
                    num2 = Double.parseDouble(StringNum2);

                    Resultado = Resultado / num2;
                    lblResultado.setText(String.valueOf(Resultado));
                    num1 = 0;
                    num2 = 0;
                    StringNum1 = "";
                    StringNum2 = "";
                }*/
            }
            break;
            case R.id.btnMultiplicacion:{
                if (lblOperarcion.getText().length() != 0){
                    String text = lblOperarcion.getText().toString();
                    if (text.charAt(text.length()-1) == '/' || text.charAt(text.length()-1) == '+' || text.charAt(text.length()-1) == '-'){

                        text = text.substring(0, text.length()-1);
                        lblOperarcion.setText(text + "*");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }else {
                        lblOperarcion.setText(lblOperarcion.getText() + "*");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }
                }else {
                    if (Resultado == 0){
                        StringNum1 = "0";
                        lblOperarcion.setText(StringNum1 + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }else {
                        StringNum1 = lblResultado.getText().toString();
                        lblOperarcion.setText(StringNum1 + "+");
                        lblOperarcion.setSelection(lblOperarcion.getText().length());
                    }
                }
                Operacion = "*";

                /*if (StringNum2 == "" && Resultado != 0){
                    num2 = Double.parseDouble(StringNum2);

                    Resultado = Resultado * num2;
                    lblResultado.setText(String.valueOf(Resultado));
                    num1 = 0;
                    num2 = 0;
                    StringNum1 = "";
                    StringNum2 = "";
                }*/
            }
            break;
            case R.id.btnIgual:{
                if (Operacion == "+"){
                    //if (Resultado == 0) {
                        if (StringNum1 != "" && StringNum2 != "") {
                            num1 = Double.parseDouble(StringNum1);
                            num2 = Double.parseDouble(StringNum2);

                            Resultado = num1 + num2;
                            lblResultado.setText(Escribe(Resultado));
                            num1 = 0;
                            num2 = 0;
                            StringNum1 = "";
                            StringNum2 = "";
                            Operacion = "";
                        }
                    /*}else{
                        if (StringNum2 != "") {
                            num2 = Double.parseDouble(StringNum2);

                            Resultado = Resultado + num2;
                            lblResultado.setText(String.valueOf(Resultado));
                            num1 = 0;
                            num2 = 0;
                            StringNum1 = "";
                            StringNum2 = "";
                        }
                    }*/
                }else if (Operacion == "-"){
                    //if (Resultado == 0) {
                        if (StringNum1 != "" && StringNum2 != "") {
                            num1 = Double.parseDouble(StringNum1);
                            num2 = Double.parseDouble(StringNum2);

                            Resultado = num1 - num2;
                            lblResultado.setText(Escribe(Resultado));
                            num1 = 0;
                            num2 = 0;
                            StringNum1 = "";
                            StringNum2 = "";
                            Resultado = 0;
                            Operacion = "";
                        }
                    /*}else{
                        if (StringNum2 != "") {
                            num2 = Double.parseDouble(StringNum2);

                            Resultado = Resultado - num2;
                            lblResultado.setText(Escribe(Resultado));
                            num1 = 0;
                            num2 = 0;
                            StringNum1 = "";
                            StringNum2 = "";
                        }
                    }*/
                }else if (Operacion == "*"){
                    //if (Resultado == 0) {
                        if (StringNum1 != "" && StringNum2 != "") {
                            num1 = Double.parseDouble(StringNum1);
                            num2 = Double.parseDouble(StringNum2);

                            Resultado = num1 * num2;
                            lblResultado.setText(Escribe(Resultado));
                            num1 = 0;
                            num2 = 0;
                            StringNum1 = "";
                            StringNum2 = "";
                            Operacion = "";
                        }
                    /*}else{
                        if (StringNum2 != "") {
                            num2 = Double.parseDouble(StringNum2);

                            Resultado = Resultado * num2;
                            lblResultado.setText(Escribe(Resultado));
                            num1 = 0;
                            num2 = 0;
                            StringNum1 = "";
                            StringNum2 = "";
                        }
                    }*/
                }else if (Operacion == "/"){
                    //if (Resultado == 0) {
                        if (StringNum1 != "" && StringNum2 != "") {
                            num1 = Double.parseDouble(StringNum1);
                            num2 = Double.parseDouble(StringNum2);

                            Resultado = num1 / num2;
                            lblResultado.setText(Escribe(Resultado));
                            num1 = 0;
                            num2 = 0;
                            StringNum1 = "";
                            StringNum2 = "";
                            Operacion = "";
                        }
                    /*}else{
                        if (StringNum2 != "") {
                            num2 = Double.parseDouble(StringNum2);

                            Resultado = Resultado / num2;
                            lblResultado.setText(Escribe(Resultado));
                            num1 = 0;
                            num2 = 0;
                            StringNum1 = "";
                            StringNum2 = "";
                        }
                    }*/
                }
                lblOperarcion.setText("");
            }
            break;
            case R.id.btnAbrir:{
                lblOperarcion.setText(lblOperarcion.getText() + "(");
                lblOperarcion.setSelection(lblOperarcion.getText().length());
            }
            break;
            case R.id.btnCerrar:{
                lblOperarcion.setText(lblOperarcion.getText() + ")");
                lblOperarcion.setSelection(lblOperarcion.getText().length());
            }
            break;
            case R.id.btnPunto:{
                if (Operacion.isEmpty()) {
                    if (lblOperarcion.getText().length() != 0) {
                        String text = lblOperarcion.getText().toString();
                        if (text.charAt(text.length() - 1) != '*' && text.charAt(text.length() - 1) != '+' && text.charAt(text.length() - 1) != '-' && text.charAt(text.length() - 1) != '/' && text.charAt(text.length() - 1) != '(' && text.charAt(text.length() - 1) != ')'&& text.charAt(text.length() - 1) != '.') {
                            if (StringNum1.contains(".") == false){
                                lblOperarcion.setText(lblOperarcion.getText() + ".");
                                lblOperarcion.setSelection(lblOperarcion.getText().length());
                                StringNum1 = StringNum1 + ".";
                            }
                        }
                    }
                }else{
                    if (lblOperarcion.getText().length() != 0) {
                        String text = lblOperarcion.getText().toString();
                        if (text.charAt(text.length() - 1) != '*' && text.charAt(text.length() - 1) != '+' && text.charAt(text.length() - 1) != '-' && text.charAt(text.length() - 1) != '/' && text.charAt(text.length() - 1) != '(' && text.charAt(text.length() - 1) != ')'&& text.charAt(text.length() - 1) != '.') {
                            if (StringNum2.contains(".") == false) {
                                lblOperarcion.setText(lblOperarcion.getText() + ".");
                                lblOperarcion.setSelection(lblOperarcion.getText().length());
                                StringNum2 = StringNum2 + ".";
                            }
                        }
                    }
                }
            }
            break;
            default:{

            }
            break;
        }
    }
    public String Escribe(double d) {
        NumberFormat nf = new DecimalFormat("##.###");
        return nf.format(d);
    }
}
