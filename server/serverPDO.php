<?php

require 'database.php';

$pdo = Database::connect();
$pdo-> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

@$operation = $_GET['operation'];

switch($operation){

    case alat_berat:
        /*Pengisian data ke database Alat Berat*/
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $jenisAlat = $obj->jenisAlat;
        $tanggal = $obj->tanggal;
        $tipe = $obj->tipe;
        $noIdentitas = $obj->noIdentitas;
        $pemilik = $obj->pemilik;
        $operator = $obj->operator;
        $catatan = $obj->catatan;
        $fotoDepan = $obj->fotoDepan;
        $fotoBelakang = $obj->fotoBelakang;
        $fotoKanan = $obj->fotoKanan;
        $fotoKiri = $obj->fotoKiri;

        $sql = "INSERT INTO Alat_Berat (jenisAlat, tanggal, tipe, noIdentitas, pemilik, operator, catatan, fotoDepan, fotoBelakang, fotoKanan, fotoKiri) 
VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        $q = $pdo->prepare($sql);
        $q->execute(array($jenisAlat,$tanggal,$tipe,$noIdentitas,$pemilik,$operator,$catatan,$fotoDepan,$fotoBelakang,$fotoKanan,$fotoKiri));
        $data = '{"status":"success"}';
        echo $data;

        break;

    case list_alat_berat:
        /*Source code for showing list of alat berat*/
        $sql = "SELECT * FROM Alat_Berat";
        $q = $pdo->prepare($sql);
        $q->execute();
        $data = json_encode($q->fetchAll(PDO::FETCH_ASSOC));
        echo $data;

        break;

    case delete_alat_berat:
        /*Source code for delete all resource on alat_berat table*/
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $jenisAlat = $obj->jenisAlat;

        if(!empty($jenisAlat)){

            $sql = "DELETE FROM Alat_Berat WHERE jenisAlat= ?";
            $q = $pdo->prepare($sql);
            $q->execute(array($jenisAlat));
            $data = '{"status":"success"}';
            echo $data;

        }

        break;


    default:
        break;

}

Database::disconnect();

