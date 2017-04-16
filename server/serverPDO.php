<?php

require 'database.php';

$pdo = Database::connect();
$pdo-> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

@$operation = $_GET['operation'];

switch($operation){

    case induction:
        $json = file_get_contents('php://input');
        $obj = json_decode($json);
        $namaPekerja = $obj -> namaPekerja;
        $tanggal = $obj -> tanggal;
        $telepon = $obj -> telepon;
        $jabatan = $obj -> jabatan;
        $unitKerja = $obj -> unitKerja;
        $noKTP = $obj -> noKTP;
        $fotoPeserta =$obj -> fotoPeserta;

        if(!empty($namaPekerja)){

            $sql = "INSERT INTO Pekerja (namaPekerja, tanggal, telepon, jabatan, unitKerja, noKTP, fotoPeserta) VALUES (?,?,?,?,?,?,?)";
            $q = $pdo->prepare($sql);
            $q->execute(array($namaPekerja, $tanggal, $telepon, $jabatan, $unitKerja, $noKTP, $fotoPeserta));
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
        $kerugianWaktu=$obj->kerugianWaktu;
        $kerugianMaterial=$obj->kerugianMaterial;
        $dokumentasi=$obj->dokumentasi;

        if(!empty($namaKorban)){
            $sql = "INSERT INTO Insiden (namaKorban, TTLKorban, jabatan, unitKerja, tipeInsiden, kronologi, saksiKejadian, waktuKejadian, akibatInsiden, kerugianWaktu, kerugianMaterial, dokumentasi) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            $q = $pdo->prepare($sql);
            $q->execute(array($namaKorban,$TTLKorban,$jabatan, $unitKerja, $tipeInsiden, $kronologi, $saksiKejadian, $waktuKejadian, $akibatInsiden, $kerugianWaktu, $kerugianMaterial, $dokumentasi));
            $data = '{"status":"success"}';
        }

        else $data = '{"status":"failed"}';

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
        $jsonIterator = new RecursiveIteratorIterator(
        new RecursiveArrayIterator(json_decode($json, TRUE)), RecursiveIteratorIterator::SELF_FIRST);

        foreach ($jsonIterator as $key => $val) {
        if(!is_array($val)){

            if($key == 'pengaju') $pengaju = $val;

            elseif ($key == 'tanggal') $tanggal = $val;

            if(!empty($pengaju) && !empty($tanggal)){

                if(!empty($pengaju)){
                        $sql = "UPDATE Ijin_Kerja SET persetujuan = '1' WHERE pengaju = ? AND tanggal = ?";
                        $q = $pdo->prepare($sql);
                        $q->execute(array($pengaju,$tanggal));
                        $data = '{"status":"success"}';
                    }

                else $data = '{"status":"failed"}';

                    
            }
        }
        else{
            $pengaju = null;
            $tanggal = null;
        }
        }
        /*
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
        */
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
            $data = $q->fetchAll(PDO::FETCH_ASSOC);
            $i = 0;
            
            foreach ($data as $key ) {
                # code...

                $data[$i][persetujuan] = ($data[$i][persetujuan] == 0) ? false : true;
                $i++;
            }
            
            $jsonData = json_encode($data);
            echo $jsonData;
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
            $sql = "INSERT INTO Alat_Berat (jenisAlat, tanggal, tipe, noIdentitas, pemilik, operator, catatan, fotoDepan, fotoBelakang, fotoKanan, fotoKiri) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
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

    case upload_foto:
        @$src = $_GET['from'];
        switch ($src) {
            case induction:
                if(isset($_FILES['image'])){
                    
                    $folder = "uploads/induction/";
                    $uploadImg = $folder . basename($_FILES['image']['name']);
                    
                    if(!move_uploaded_file($_FILES['image']['tmp_name'], $uploadImg)){
                        $data = '{"status":"failed"}';
                    }
                    
                    $data = '{"status":"success"}';
                              
                }

                else $data = '{"status":"failed"}';;
                
                echo $data;
                break;
            
            case alat_berat:
                if(isset($_FILES['image'])){
                    
                    $folder = "uploads/alat_berat/";
                    $uploadImg = $folder . basename($_FILES['image']['name']);
                    
                    if(!move_uploaded_file($_FILES['image']['tmp_name'], $uploadImg)){
                        $data = '{"status":"failed"}';
                    }
                    
                    $data = '{"status":"success"}';
                              
                }

                else $data = '{"status":"failed"}';;
                
                echo $data;

                break;

            case insiden:
                if(isset($_FILES['image'])){
                    
                    $folder = "uploads/insiden/";
                    $uploadImg = $folder . basename($_FILES['image']['name']);
                    
                    if(!move_uploaded_file($_FILES['image']['tmp_name'], $uploadImg)){
                        $data = '{"status":"failed"}';
                    }
                    
                    $data = '{"status":"success"}';
                              
                }

                else $data = '{"status":"failed"}';;
                
                echo $data;
                break;

            default:
                echo '{"status":"failed"}';
                break;
        }
        break;

    case export_laporan:
        
        $folder = "laporan/";
        $sql = "SELECT pekerjaId, namaPekerja, fotoPeserta, tanggal, jabatan, unitKerja  FROM Pekerja ORDER BY pekerjaId";
        $result = $pdo->query($sql);
        $filename = $folder."excel-induction".".xlsx";
        $handle = fopen($filename, 'w+');
        fputcsv($handle, array('No','Nama Peserta','Foto Peserta','Tanggal Induksi', 'Jabatan', 'Unit Kerja'));

        foreach ($result as $row) {
            fputcsv($handle, array($row['pekerjaId'], $row['namaPekerja'],$row['fotoPeserta'],$row['tanggal'],$row['jabatan'],$row['unitKerja']));

        }

        if(fclose($handle)) $data = '{"status":"success"}';
        else $data = '{"status":"failed"}';

        $sql = "SELECT no, jenisAlat, tanggal, tipe, noIdentitas, pemilik, operator, catatan, fotoDepan, fotoKiri, fotoKanan, fotoBelakang FROM Alat_Berat ORDER BY no";
        $result = $pdo->query($sql);
        $filename = $folder."excel-alat-berat".".xlsx";
        $handle = fopen($filename, 'w+');
        fputcsv($handle, array('No','Jenis Alat','Tanggal','Tipe', 'No Identitas', 'Pemilik', 'Operator', 'Catatan', 'FOto Depan', 'Foto Kiri', 'Foto Kanan', 'Foto Belakang'));

        foreach ($result as $row) {
            fputcsv($handle, array($row['no'], $row['jenisAlat'],$row['tanggal'],$row['tipe'],$row['noIdentitas'],$row['pemilik'], $row['pemilik'], $row['operator'],$row['catatan'],$row['fotoDepan'],$row['fotoKiri'],$row['fotoKanan'],$row['fotoBelakang']));

        }

        if(fclose($handle)) $data = '{"status":"success"}';
        else $data = '{"status":"failed"}';
        
        $sql = "SELECT tanggal, pengaju, lokasiKerja, lingkupKerja, jamKerja, kebutuhanAlatBerat, pekerjaTerlibat, izinKerjaKhusus, persetujuan FROM Ijin_Kerja ORDER BY tanggal";
        $result = $pdo->query($sql);
        $filename = $folder."excel-pengajuan-ijin".".xlsx";
        $handle = fopen($filename, 'w+');
        fputcsv($handle, array('Tanggal','Diajukan Oleh','Lokasi Kerja','Lingkup Kerja', 'Selisih Jam Kerja', 'Daftar Alat Berat', 'Jumlah Pekerja Terlibat', 'Ijin Kerja Khusus', 'Persetujuan'));

        foreach ($result as $row) {
            fputcsv($handle, array($row['tanggal'], $row['pengaju'],$row['lokasiKerja'],$row['lingkupKerja'],$row['jamKerja'],$row['kebutuhanAlatBerat'], $row['pekerjaTerlibat'], $row['izinKerjaKhusus'],$row['persetujuan']));

        }

        if(fclose($handle)) $data = '{"status":"success"}';
        else $data = '{"status":"failed"}';

        $sql = "SELECT no, namaKorban, jabatan, unitKerja, tipeInsiden, kronologi, saksiKejadian, waktuKejadian, akibatInsiden, kerugianWaktu, kerugianMaterial, dokumentasi FROM Insiden ORDER BY no";
        $result = $pdo->query($sql);
        $filename = $folder."excel-insiden".".xlsx";
        $handle = fopen($filename, 'w+');
        fputcsv($handle, array('No','Nama Korban','Pekerjaan','Unit Kerja', 'Tipe Insiden', 'Kronologi', 'Saksi', 'Waktu Terjadi', 'Akibat', 'Kerugian Waktu', 'Kerugian Materil', 'Foto'));

        foreach ($result as $row) {
            fputcsv($handle, array($row['no'], $row['namaKorban'],$row['jabatan'],$row['unitKerja'],$row['tipeInsiden'],$row['kronologi'], $row['saksiKejadian'], $row['waktuKejadian'],$row['akibatInsiden'],$row['kerugianWaktu'],$row['kerugianMaterial'],$row['dokumentasi']));

        }

        if(fclose($handle)) $data = '{"status":"success"}';
        else $data = '{"status":"failed"}';

        echo $data;

        break;
    
    default:
        echo '{"status":"failed"}';
        break;

}

Database::disconnect();
