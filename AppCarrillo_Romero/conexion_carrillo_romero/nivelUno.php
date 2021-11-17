<?php
    include('functions.php');
    //$tipo = $_GET['txtTi'];
    $array = array();	
    if($resultset=getSQLResultSet("SELECT * FROM nivel_uno")){
        
        while ($row = $resultset->fetch_array(MYSQLI_NUM)){
            $e = array();
            $e['id_oracion_uno'] = $row[0];
            $e['sustantivo'] = $row[1];
            $e['prep'] = $row[2];
            $e['prep_dos'] = $row[3];
            $e['adjetivo'] = $row[4];
            $e['verbo'] = $row[5];
            $e['prep_art_sus'] = $row[6];
            $e['prep_sus'] = $row[7];
            array_push($array,$e);
        }
            echo json_encode($array);
    }
?>