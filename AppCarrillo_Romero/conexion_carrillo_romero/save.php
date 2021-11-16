<?php
    if ($_SERVER['REQUEST_METHOD']=='POST'){
        require_once("db.php");

        $email_user = $_POST['email_user'];
        $xp_user = $_POST['xp_user'];

        $query = "INSERT INTO usuario (email_user, xp_user) VALUES ('$email_user', '$xp_user')";
        $result = $mysql ->query($query);

        if ($result === TRUE){
            echo "Funciono";
        }else {
            echo "ERROR";
        }

        $mysql -> close();
    }