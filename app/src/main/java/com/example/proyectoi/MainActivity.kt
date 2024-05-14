@file:Suppress("DEPRECATION")

package com.example.proyectoi

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.Connection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ejecuta la AsyncTask para probar la conexión a la base de datos
        TestDBConnectionTask().execute()
    }

    @SuppressLint("StaticFieldLeak")
    inner class TestDBConnectionTask : AsyncTask<Void, Void, Connection?>() {
        @Deprecated("Deprecated in Java", ReplaceWith("DBConnection.getConnection()"))
        override fun doInBackground(vararg params: Void?): Connection? {
            // Obtener la conexión a la base de datos
            return DBConnection.getConnection()
        }

        @Deprecated("Deprecated in Java")
        override fun onPostExecute(connection: Connection?) {
            if (connection != null) {
                Toast.makeText(this@MainActivity, "Conexión exitosa a la base de datos", Toast.LENGTH_SHORT).show()

                // Realizar consultas a la base de datos
                val query = "SELECT * FROM personal"
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery(query)

                // Procesar los resultados de la consulta
                while (resultSet.next()) {
                    val cedula = resultSet.getInt(/* columnLabel = */ "cedula")
                    val nombre = resultSet.getString(/* columnLabel = */ "nombre1")
                    // Hacer algo con los datos obtenidos
                    println("Cédula: $cedula, Nombre: $nombre")
                }

                // Cerrar la conexión
                connection.close()
            } else {
                Toast.makeText(this@MainActivity, "Error al conectar a la base de datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}