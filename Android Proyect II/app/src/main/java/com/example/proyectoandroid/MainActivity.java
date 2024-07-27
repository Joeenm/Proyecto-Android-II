package com.example.proyectoandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText campoCedula, campoNombre1, campoNombre2, campoApellido1, campoApellido2, campoDireccion, campoTelefono, campoEmail;
    private Button botonBuscar;
    private ImageButton imageButtonGuardar, imageButtonActualizar, imageButtonEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoCedula = findViewById(R.id.campoCedula);
        botonBuscar = findViewById(R.id.botonBuscar);
        imageButtonGuardar = findViewById(R.id.imageButtonGuardar);
        imageButtonActualizar = findViewById(R.id.imageButtonActualizar);
        imageButtonEliminar = findViewById(R.id.imageButtonEliminar);
        campoNombre1 = findViewById(R.id.campoNombre1);
        campoNombre2 = findViewById(R.id.campoNombre2);
        campoApellido1 = findViewById(R.id.campoApellido1);
        campoApellido2 = findViewById(R.id.campoApellido2);
        campoDireccion = findViewById(R.id.campoDireccion);
        campoTelefono = findViewById(R.id.campoTelefono);
        campoEmail = findViewById(R.id.campoCorreo);

        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscarDatos();
            }
        });

        imageButtonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos();
            }
        });

        imageButtonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarDatos();
            }
        });

        imageButtonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarDatos();
            }
        });
    }

    private void buscarDatos() {
        String cedula = campoCedula.getText().toString().trim();
        if (cedula.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese una cédula", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://172.29.66.164/android/buscarDatos.php?cedula=" + cedula;
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.has("error")) {
                                Toast.makeText(MainActivity.this, jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            } else {
                                if (jsonObject.has("message")) {
                                    Toast.makeText(MainActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                }
                                campoNombre1.setText(jsonObject.getString("nombre1"));
                                campoNombre2.setText(jsonObject.getString("nombre2"));
                                campoApellido1.setText(jsonObject.getString("apellido1"));
                                campoApellido2.setText(jsonObject.getString("apellido2"));
                                campoDireccion.setText(jsonObject.getString("direccion"));
                                campoTelefono.setText(jsonObject.getString("telefono"));
                                campoEmail.setText(jsonObject.getString("email"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error en el formato de respuesta", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);
    }

    private void guardarDatos() {
        String cedula = campoCedula.getText().toString().trim();
        String nombre1 = campoNombre1.getText().toString().trim();
        String nombre2 = campoNombre2.getText().toString().trim();
        String apellido1 = campoApellido1.getText().toString().trim();
        String apellido2 = campoApellido2.getText().toString().trim();
        String direccion = campoDireccion.getText().toString().trim();
        String telefono = campoTelefono.getText().toString().trim();
        String email = campoEmail.getText().toString().trim();

        if (cedula.isEmpty() || nombre1.isEmpty() || apellido1.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://172.29.66.164/android/guardarDatos.php";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.has("message")) {
                                Toast.makeText(MainActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                limpiarCampos();
                            } else if (jsonObject.has("error")) {
                                Toast.makeText(MainActivity.this, jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error en el formato de respuesta", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("cedula", cedula);
                params.put("nombre1", nombre1);
                params.put("nombre2", nombre2);
                params.put("apellido1", apellido1);
                params.put("apellido2", apellido2);
                params.put("direccion", direccion);
                params.put("telefono", telefono);
                params.put("email", email);
                return params;
            }
        };

        queue.add(stringRequest);
    }

    private void actualizarDatos() {
        String cedula = campoCedula.getText().toString().trim();
        String nombre1 = campoNombre1.getText().toString().trim();
        String nombre2 = campoNombre2.getText().toString().trim();
        String apellido1 = campoApellido1.getText().toString().trim();
        String apellido2 = campoApellido2.getText().toString().trim();
        String direccion = campoDireccion.getText().toString().trim();
        String telefono = campoTelefono.getText().toString().trim();
        String email = campoEmail.getText().toString().trim();

        if (cedula.isEmpty() || nombre1.isEmpty() || apellido1.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://172.29.66.164/android/actualizarDatos.php";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.has("message")) {
                                Toast.makeText(MainActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                limpiarCampos();
                            } else if (jsonObject.has("error")) {
                                Toast.makeText(MainActivity.this, jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error en el formato de respuesta", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("cedula", cedula);
                params.put("nombre1", nombre1);
                params.put("nombre2", nombre2);
                params.put("apellido1", apellido1);
                params.put("apellido2", apellido2);
                params.put("direccion", direccion);
                params.put("telefono", telefono);
                params.put("email", email);
                return params;
            }
        };

        queue.add(stringRequest);
    }

    private void eliminarDatos() {
        String cedula = campoCedula.getText().toString().trim();

        if (cedula.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese una cédula", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://172.29.66.164/android/eliminarDatos.php";
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.has("message")) {
                                Toast.makeText(MainActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                limpiarCampos(); // Limpiar campos después de eliminar
                            } else if (jsonObject.has("error")) {
                                Toast.makeText(MainActivity.this, jsonObject.getString("error"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error en el formato de respuesta", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("cedula", cedula);
                return params;
            }
        };

        queue.add(stringRequest);
    }

    private void limpiarCampos() {
        campoCedula.setText("");
        campoNombre1.setText("");
        campoNombre2.setText("");
        campoApellido1.setText("");
        campoApellido2.setText("");
        campoDireccion.setText("");
        campoTelefono.setText("");
        campoEmail.setText("");
    }
}