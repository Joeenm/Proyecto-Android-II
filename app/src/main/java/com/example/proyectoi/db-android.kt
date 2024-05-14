package com.example.proyectoi

import java.sql.Connection
import java.sql.DriverManager

object DBConnection {
    fun getConnection(): Connection? {
        val url = "jdbc:mysql://localhost:3306/android"
        val user = "root"
        val password = ""

        return try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            DriverManager.getConnection(url, user, password)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}