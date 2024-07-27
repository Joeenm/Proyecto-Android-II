<?php
include 'db-android.php'; // Incluir el archivo de conexión

if (isset($_POST['cedula']) && isset($_POST['nombre1']) && isset($_POST['nombre2']) && isset($_POST['apellido1']) && isset($_POST['apellido2']) && isset($_POST['direccion']) && isset($_POST['telefono']) && isset($_POST['email'])) {
    $cedula = $_POST['cedula'];
    $nombre1 = $_POST['nombre1'];
    $nombre2 = $_POST['nombre2'];
    $apellido1 = $_POST['apellido1'];
    $apellido2 = $_POST['apellido2'];
    $direccion = $_POST['direccion'];
    $telefono = $_POST['telefono'];
    $email = $_POST['email'];

    // Verificar si la cédula existe en la base de datos
    $checkSql = "SELECT * FROM personal WHERE cedula='$cedula'";
    $checkResult = $conn->query($checkSql);

    if ($checkResult->num_rows > 0) {
        // La cédula existe, proceder con la actualización
        $sql = "UPDATE personal SET nombre1='$nombre1', nombre2='$nombre2', apellido1='$apellido1', apellido2='$apellido2', direccion='$direccion', telefono='$telefono', email='$email' WHERE cedula='$cedula'";
        if ($conn->query($sql) === TRUE) {
            echo json_encode(array("message" => "Datos actualizados exitosamente"));
        } else {
            echo json_encode(array("error" => "Error al actualizar los datos: " . $conn->error));
        }
    } else {
        // La cédula no existe
        echo json_encode(array("error" => "La cédula no existe"));
    }
} else {
    echo json_encode(array("error" => "Datos incompletos"));
}

$conn->close();
?>