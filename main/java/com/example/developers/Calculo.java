package com.example.developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        TextView IMC = (TextView) findViewById(R.id.IMC);
        TextView MB = (TextView) findViewById(R.id.MB);
        Button volver = (Button) findViewById(R.id.volver);

        String mb = getIntent().getStringExtra("mb");
        String imc = getIntent().getStringExtra("imc");
        MB.setText("Metabolismo Basal: " + mb);
        IMC.setText("IMC " + imc);



        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}