<?php
$nombre=$_POST["email_user"];
$apellido=$_POST["xp_user"];

$cont=0;
include("cn.php");

$q=mysqli_query($c,"INSERT INTO usuario(email_user, xp_user) VALUES ('$nombre', '$apellido')");

if($q){
    echo "Registro insertado exitoso";
}
else{
    echo "Fallo en el registro";
}
?>