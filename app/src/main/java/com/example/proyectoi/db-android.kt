package com.example.proyectoi

import java.sql.Connection
import java.sql.DriverManager

object DBConnection {
    private val servername = "localhost"
    private val username = "root"
    private val password = ""
    private val database = "android"

    fun getConnection(): Connection? {
        val url = "jdbc:mysql://$servername:3306/$database"
        return try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            DriverManager.getConnection(url, username, password)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}