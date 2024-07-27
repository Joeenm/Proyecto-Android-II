<?php
include 'db-android.php'; // Incluir el archivo de conexión

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $cedula = $_POST['cedula'];
    $nombre1 = $_POST['nombre1'];
    $nombre2 = $_POST['nombre2'];
    $apellido1 = $_POST['apellido1'];
    $apellido2 = $_POST['apellido2'];
    $direccion = $_POST['direccion'];
    $telefono = $_POST['telefono'];
    $email = $_POST['email'];

    // Verificar si la cédula ya está registrada
    $checkSql = "SELECT * FROM personal WHERE cedula='$cedula'";
    $checkResult = $conn->query($checkSql);

    if ($checkResult->num_rows > 0) {
        // La cédula ya existe
        echo json_encode(["error" => "La cédula ya está registrada"]);
    } else {
        // Proceder con la inserción
        $sql = "INSERT INTO personal (cedula, nombre1, nombre2, apellido1, apellido2, direccion, telefono, email) VALUES ('$cedula', '$nombre1', '$nombre2', '$apellido1', '$apellido2', '$direccion', '$telefono', '$email')";
        if ($conn->query($sql) === TRUE) {
            echo json_encode(["message" => "Registro exitoso"]);
        } else {
            echo json_encode(["error" => "Error: " . $sql . "<br>" . $conn->error]);
        }
    }
} else {
    echo json_encode(["error" => "Método de solicitud no permitido"]);
}

$conn->close();
?>