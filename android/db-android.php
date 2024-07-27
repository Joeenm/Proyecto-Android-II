<?php
// Datos de conexión a la base de datos
$servername = "localhost";
$username = "d62024";
$password = "123456";
$database = "android";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $database);

// Verificar conexión
if ($conn->connect_error) {
    die("Conexión Fallida: " . $conn->connect_error);
}
?>