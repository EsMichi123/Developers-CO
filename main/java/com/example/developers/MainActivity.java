package com.example.developers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView titulo = (TextView) findViewById(R.id.titulo);
        Button calculo = (Button) findViewById(R.id.calculo);
        EditText ededad = (EditText) findViewById(R.id.edad);
        EditText edpeso = (EditText) findViewById(R.id.peso);
        EditText edestatura = (EditText) findViewById(R.id.estatura);
        RadioButton rbf = findViewById(R.id.femenino);

        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(edpeso.getText().toString());
                double edad = Double.parseDouble(ededad.getText().toString());
                double estatura = Double.parseDouble(edestatura.getText().toString());
                boolean esFemenino = rbf.isChecked();
                double metabolismo = 0;
                if (esFemenino==true) {
                    metabolismo = (10*peso)+(6.25*estatura)-(5*edad)-161;
                }
                else {
                    metabolismo = (10*peso)+(6.25*estatura)-(5*edad)+5;
                }
                double IMC = peso/(estatura*estatura)*10000;
                String mb = Double.toString(metabolismo);
                String imc = Double.toString(IMC);
                Intent intencalculo = new Intent(MainActivity.this, Calculo.class);
                intencalculo.putExtra("imc", imc);
                intencalculo.putExtra("mb", mb);
                startActivity(intencalculo);
            }
        });



    }
}