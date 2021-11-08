package co.edu.unab.desarrolladoresco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editEdad;
    EditText editEstatura;
    EditText editPeso;
    Button btnCalcular;
    RadioButton rbMasculino;
    RadioButton rbFemenino;
    TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editEdad = findViewById(R.id.editEdad);
        editEstatura = findViewById(R.id.editEstatura);
        editPeso = findViewById(R.id.editPeso);
        btnCalcular = findViewById(R.id.btnCalcular);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(editPeso.getText().toString());
                double edad = Double.parseDouble(editEdad.getText().toString());
                double estatura = Double.parseDouble(editEstatura.getText().toString());
                boolean esFemenino = rbFemenino.isChecked();
                double metabolismo = 0;
                if (esFemenino==true) {
                    metabolismo = (10*peso)+(6.25*estatura)-(5*edad)-161;
                }
                else {
                    metabolismo = (10*peso)+(6.25*estatura)-(5*edad)+5;
                }
                double imc = peso/(estatura*estatura)*10000;
                String respuesta = "tu imc es "+String.format("%.1f",imc)+" y tu metabolismo basal es "+ String.format("%.1f",metabolismo);
                txtResultado.setText(respuesta);
            }
        });
    }
}