<?php

require 'database.php';

$pdo = Database::connect();
$pdo-> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

@$operation = $_GET['operation'];

switch($operation){

    case induction:
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $pekerjaId = $obj -> pekerjaId;
        $namaPekerja = $obj -> namaPekerja;
        $tanggal = $obj -> tanggal;
        $telepon = $obj -> telepon;
        $jabatan = $obj -> jabatan;
        $unitKerja = $obj -> unitKerja;
        $noKTP = $obj -> noKTP;
        $fotoPeserta = $obj -> fotoPeserta;

        if(!empty($namaPekerja)){
            $sql = "INSERT INTO Pekerja (pekerjaId, namaPekerja, tanggal, telepon, jabatan, unitKerja, noKTP, fotoPeserta) VALUES (?,?,?,?,?,?,?,?)";
            $q = $pdo->prepare($sql);
            $q->execute(array($pekerjaId, $namaPekerja, $tanggal, $telepon, $jabatan, $unitKerja, $noKTP, $fotoPeserta));
            $data = '{"status":"success"}';
        }

        else{
            $data = '{"status":"failed"}';
        }

        echo $data;

        break;

    case insiden:
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $namaKorban = $obj->namaKorban;
        $TTLKorban = $obj->TTLKorban;
        $jabatan=$obj->jabatan;
        $unitKerja=$obj->unitKerja;
        $tipeInsiden=$obj->tipeInsiden;
        $kronologi=$obj->kronologi;
        $saksiKejadian=$obj->saksiKejadian;
        $waktuKejadian=$obj->waktuKejadian;
        $akibatInsiden=$obj->akibatInsiden;
        $estimasiKerugian=$obj->estimasiKerugian;
        $dokumentasi=$obj->dokumentasi;

        if(!empty($namaKorban)){
            $sql = "INSERT INTO Insiden (namaKorban, TTLKorban, jabatan, unitKerja, tipeInsiden, kronologi, saksiKejadian, waktuKejadian, akibatInsiden, estimasiKerugian, dokumentasi) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            $q = $pdo->prepare($sql);
            $q->execute(array($namaKorban,$TTLKorban,$jabatan, $unitKerja, $tipeInsiden, $kronologi, $saksiKejadian, $waktuKejadian, $akibatInsiden, $estimasiKerugian, $dokumentasi));
            $data = '{"status":"success"}';
        }

        else $data = '{"status":"success"}';

        echo $data;


        break;

    case list_pegawai_ijin:
        /*Source code for showing list of Pekerja*/
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $unitKerja = $obj->unitKerja;

        if(!empty($unitKerja)){
            $sql = "SELECT noKTP, namaPekerja, jabatan FROM Pekerja WHERE unitKerja = ? ";
            $q = $pdo->prepare($sql);
            $q->execute(array($unitKerja));
            $data = json_encode($q->fetchAll(PDO::FETCH_ASSOC));
        }
        else $data = '{"status":"failed"}';

        echo $data;

        break;

    case persetujuan_ijin:
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $pengaju = $obj->pengaju;
        $tanggal = $obj->tanggal;

        if(!empty($pengaju)){
            $sql = "UPDATE Ijin_Kerja SET persetujuan = '1' WHERE pengaju = ? AND tanggal = ?";
            $q = $pdo->prepare($sql);
            $q->execute(array($pengaju,$tanggal));
            $data = '{"status":"success"}';
        }
        else $data = '{"status":"failed"}';

        echo $data;

        break;

    case pengajuan_ijin:
        /*Source code for inserting data to Ijin_Kerja table*/
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $pengaju =                  $obj->pengaju;
        $tanggal =                  $obj->tanggal;
        $lokasiKerja =              $obj->lokasiKerja;
        $lingkupKerja =             $obj->lingkupKerja;
        $jamKerja =                 $obj->jamKerja;
        $kebutuhanAlatBerat =       $obj->kebutuhanAlatBerat;
        $pekerjaTerlibat =          $obj->pekerjaTerlibat;
        $kelengkapanKeselamatan =   $obj->kelengkapanKeselamatan;
        $perlengkapanKerja =        $obj->perlengkapanKerja;
        $izinKerjaKhusus =          $obj->izinKerjaKhusus;
        $catatan =                  $obj->catatan;
        $persetujuan =              $obj->persetujuan;

        if(!empty($pengaju)){
            $sql = "INSERT INTO Ijin_Kerja (pengaju, tanggal, lokasiKerja, lingkupKerja, jamKerja, kebutuhanAlatBerat, pekerjaTerlibat, kelengkapanKeselamatan, perlengkapanKerja, izinKerjaKhusus, catatan, persetujuan) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            $q = $pdo->prepare($sql);
            $q->execute(array($pengaju, $tanggal, $lokasiKerja,$lingkupKerja,$jamKerja,$kebutuhanAlatBerat,$pekerjaTerlibat,$kelengkapanKeselamatan, $perlengkapanKerja, $izinKerjaKhusus, $catatan, $persetujuan));
            $data = '{"status":"success"}';

        }

        else $data = '{"status":"failed"}';

        echo $data;

        break;

    case list_pengajuan_ijin:
        /*Source code for showing data of Ijin_Kerja table*/
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $pengaju = $obj->pengaju;
        $tanggal = $obj->tanggal;

        if(!empty($pengaju)){
            $sql = "SELECT * FROM Ijin_Kerja WHERE  pengaju = ? AND tanggal = ?";
            $q = $pdo->prepare($sql);
            $q->execute(array($pengaju,$tanggal));
            $data = json_encode($q->fetchAll(PDO::FETCH_ASSOC));
            echo $data;
        }

        break;
    case list_pengajuan_ijin_by_tanggal:
        /*Source code for showing data of Ijin_Kerja table*/
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $tanggal = $obj->tanggal;

        if(!empty($tanggal)){
            $sql = "SELECT * FROM Ijin_Kerja WHERE  tanggal = ?";
            $q = $pdo->prepare($sql);
            $q->execute(array($tanggal));
            $data = json_encode($q->fetchAll(PDO::FETCH_ASSOC));
            echo $data;
        }

        break;


    case alat_berat:
        /*Source code for inserting data to Alat_Berat table*/
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

        if(!empty($jenisAlat)){
            $sql = "INSERT INTO Alat_Berat (jenisAlat, tanggal, tipe, noIdentitas, pemilik, operator, catatan, fotoDepan, fotoBelakang, fotoKanan, fotoKiri)
VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            $q = $pdo->prepare($sql);
            $q->execute(array($jenisAlat,$tanggal,$tipe,$noIdentitas,$pemilik,$operator,$catatan,$fotoDepan,$fotoBelakang,$fotoKanan,$fotoKiri));
            $data = '{"status":"success"}';
        }

        else $data = '{"status":"failed"}';

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

        else $data = '{"status":"failed"}';

        break;


    default:
        break;

}

Database::disconnect();
