package com.example.proyectoandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private EditText campoCedula;
    private Button botonBuscar;
    private TextView campoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoCedula = findViewById(R.id.campoCedula);
        botonBuscar = findViewById(R.id.botonBuscar);
        campoEmail = findViewById(R.id.campoEmail);

        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarEmail();
            }
        });
    }

    private void buscarEmail() {
        String cedula = campoCedula.getText().toString().trim();
        if (cedula.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese una cédula", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://192.168.85.233/android/buscarDatos.php?cedula=" + cedula;

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        campoEmail.setText(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }
}