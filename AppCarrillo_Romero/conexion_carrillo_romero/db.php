<?php
    $mysql = new mysqli(
        "localhost",
        "root",
        "",
        "app_carrillo_romero"
    );
    if ($mysql->connect_error){
        die("Failed to connect" . $mysql->connect_error);
    }
    else{
        echo "Succesfully";
    }