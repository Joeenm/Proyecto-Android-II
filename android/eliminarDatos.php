<?php
include 'db-android.php';

if (isset($_POST['cedula'])) {
    $cedula = $_POST['cedula'];

    // Verificar si la cédula existe en la base de datos
    $checkSql = "SELECT * FROM personal WHERE cedula='$cedula'";
    $checkResult = $conn->query($checkSql);

    if ($checkResult->num_rows > 0) {
        // La cédula existe, proceder con la eliminación
        $sql = "DELETE FROM personal WHERE cedula='$cedula'";
        if ($conn->query($sql) === TRUE) {
            echo json_encode(array("message" => "Datos eliminados exitosamente"));
        } else {
            echo json_encode(array("error" => "Error al eliminar los datos: " . $conn->error));
        }
    } else {
        // La cédula no existe
        echo json_encode(array("error" => "La cédula no existe"));
    }
} else {
    echo json_encode(array("error" => "Cédula no proporcionada"));
}

$conn->close();
?>