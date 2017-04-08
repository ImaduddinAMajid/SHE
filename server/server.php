<?php

$server = "";
$username = "";
$password = "";
$database = "";

mysql_connect($server, $username, $password) or die("<h1>Koneksi Mysql Error : </h1>" . mysql_error());
mysql_select_db($database) or die("<h1>Koneksi Kedatabase Error : </h1>" . mysql_error());

@$operasi = $_GET['operasi'];

function detectRequestBody() {
    $rawInput = fopen('php://input', 'r');
    $tempStream = fopen('php://temp', 'r+');
    stream_copy_to_stream($rawInput, $tempStream);
    rewind($tempStream);

    return $tempStream;
}


switch ($operasi) {
    case "view":
        /* Source code untuk Menampilkan Biodata */

        $query_tampil_biodata = mysql_query("SELECT * FROM Pekerja") or die(mysql_error());
        $data_array = array();
        while ($data = mysql_fetch_assoc($query_tampil_biodata)) {
            $data_array[] = $data;
        }
        echo json_encode($data_array);

        //print json_encode($data_array);
        //[{"id":"1","nama":"Jhohannes H Purba","alamat":"Kabanjahe"},{"id":"2","nama":"Berkat Junaidi Banurea","Alamat":"Sidikalang"},{"id":"3","nama":"Totok BluesMan Silalahi","Alamat":"Medan"}]

        break;
    case "insert":
        /* Source code untuk Insert data */
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


        $query_insert_data = mysql_query("INSERT INTO Alat_Berat (jenisAlat, tanggal, tipe, noIdentitas, pemilik, operator, catatan, fotoDepan, fotoBelakang, fotoKanan, fotoKiri) 
VALUES('$jenisAlat', '$tanggal','$tipe','$noIdentitas','$pemilik','$operator','$catatan','$fotoDepan','$fotoBelakang','$fotoKanan','$fotoKiri')");
        if ($query_insert_data) {
            echo "Data Berhasil Disimpan";
        } else {
            echo "Error Inser Biodata " . mysql_error();
        }

        break;

    case "list_alat_berat":
        /* Source code untuk Menampilkan Biodata */

        $query_tampil_biodata = mysql_query("SELECT * FROM Alat_Berat") or die(mysql_error());
        $data_array = array();
        while ($data = mysql_fetch_assoc($query_tampil_biodata)) {
            $data_array[] = $data;
        }
        echo json_encode($data_array);

        //print json_encode($data_array);
        //[{"id":"1","nama":"Jhohannes H Purba","alamat":"Kabanjahe"},{"id":"2","nama":"Berkat Junaidi Banurea","Alamat":"Sidikalang"},{"id":"3","nama":"Totok BluesMan Silalahi","Alamat":"Medan"}]

        break;


    case "alat_berat":
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


        $query_insert_data = mysql_query("INSERT INTO Alat_Berat (jenisAlat, tanggal, tipe, noIdentitas, pemilik, operator, catatan, fotoDepan, fotoBelakang, fotoKanan, fotoKiri) 
VALUES('$jenisAlat', '$tanggal','$tipe','$noIdentitas','$pemilik','$operator','$catatan','$fotoDepan','$fotoBelakang','$fotoKanan','$fotoKiri')");
        if ($query_insert_data) {
            echo "Data Berhasil Disimpan";
        } else {
            echo "Error Inser Biodata " . mysql_error();
        }

        break;



    case "get_biodata_by_id":
        /* Source code untuk Edit data dan mengirim data berdasarkan id yang diminta */
        @$id = $_GET['id'];

        $query_tampil_biodata = mysql_query("SELECT * FROM Pekerja WHERE pekerja_id='$id'") or die(mysql_error());
        $data_array = array();
        $data_array = mysql_fetch_assoc($query_tampil_biodata);
        //echo "[" . json_encode($data_array) . "]";
        echo json_encode($data_array);

        break;
    case "update":
        /* Source code untuk Update Biodata */
        @$nama = $_GET['nama'];
        @$jabatan = $_GET['jabatan'];
        @$id = $_GET['id'];
        $query_update_biodata = mysql_query("UPDATE Pekerja SET nama_pekerja='$nama', jabatan='$jabatan' WHERE pekerja_id='$id'");
        if ($query_update_biodata) {
            echo "Update Data Berhasil";
        } else {
            echo mysql_error();
        }
        break;
    case "delete":
        /* Source code untuk Delete Biodata */
        @$id = $_GET['id'];
        $query_delete_biodata = mysql_query("DELETE FROM Pekerja WHERE pekerja_id='$id'");
        if ($query_delete_biodata) {
            echo "Delete Data Berhasil";
        } else {
            echo mysql_error();
        }

        break;

    default:
        break;
}

?>