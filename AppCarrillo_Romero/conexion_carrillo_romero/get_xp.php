<?php
    include('functions.php');
    $array = array();	
    if($resultset=getSQLResultSet("SELECT * FROM usuario")){
        
        while ($row = $resultset->fetch_array(MYSQLI_NUM)){
            $e = array();
            $e['id_user'] = $row[0];
            $e['email_user'] = $row[1];
            $e['xp_user'] = $row[2];
            array_push($array,$e);
        }
            echo json_encode($array);
    }
?>