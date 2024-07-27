<?php
include 'db-android.php'; // Incluir el archivo de conexión

if (isset($_GET['cedula'])) {
    $cedula = $_GET['cedula'];
    $sql = "SELECT email FROM personal WHERE cedula='$cedula'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            echo $row['email'];
        }
    } else {
        echo "Usuario no existente.";
    }
} else {
    echo "Cédula no proporcionada";
}

$conn->close();
?>