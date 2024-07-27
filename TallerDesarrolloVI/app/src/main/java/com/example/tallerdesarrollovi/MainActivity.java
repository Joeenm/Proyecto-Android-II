package com.example.tallerdesarrollovi;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText campoA, campoB, campoC;
    private TextView resultado1, resultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoA = findViewById(R.id.campoA);
        campoB = findViewById(R.id.campoB);
        campoC = findViewById(R.id.campoC);
        resultado1 = findViewById(R.id.resultado1);
        resultado2 = findViewById(R.id.resultado2);

        findViewById(R.id.botonCalcular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularRaices();
            }
        });
    }

    private void calcularRaices() {
        double a = Double.parseDouble(campoA.getText().toString());
        double b = Double.parseDouble(campoB.getText().toString());
        double c = Double.parseDouble(campoC.getText().toString());

        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            resultado1.setText(String.format("x1 = %.2f", x1));
            resultado2.setText(String.format("x2 = %.2f", x2));
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            resultado1.setText(String.format("x = %.2f", x));
            resultado2.setText("");
        } else {
            resultado1.setText("No hay solución real");
            resultado2.setText("");
        }
    }
}