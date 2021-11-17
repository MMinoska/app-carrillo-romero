<?php
    define('DB_HOST','localhost');
    define('DB_USER','root');
    define('DS_PASS','');
    define('DB_NAME','app_carrillo_romero');

    header('Content-Type: text/html;charset-utf-8');

    function ejecutarSQLCommand($comando) {
        $mysqli = mysqli_connect(DB_HOST,DB_USER,DS_PASS,DB_NAME) or die('unable to connect db');
        mysqli_set_charset($mysqli,'utf8');

        if ($mysqli->connect_errno){
            printf("Connect failed");
            exit();
        }
        if ($mysqli->multi_query($comando)) {
            if ($resulset = $mysqli->store_result()){
                while ($row = $resulset->fetch_array(MYSQLI_BOTH)){

                }
                $resulset->free();
            }
        }
        $mysqli->close();
    }

    function getSQLResultSet($comando) {
        $mysqli = mysqli_connect(DB_HOST,DB_USER,DS_PASS,DB_NAME) or die('unable to connect db');
        mysqli_set_charset($mysqli,'utf8');

        if ($mysqli->connect_errno) {
             printf("Connect failed: %s\n", $mysqli->connect_error);
             exit();
        }
        if ($mysqli->multi_query($comando)) {
            return $mysqli->store_result();
        }
        $mysqli->close();
    }
?>