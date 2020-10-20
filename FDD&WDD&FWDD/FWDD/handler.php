<?php
session_start();
include_once 'inc/dbconn.php';
include_once 'inc/util.php';
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);
function renderJSON($code,$jsonKey = null,$jsonVal = null){
    $json['code'] = (int)$code;
    if ($jsonKey != null){
        $json[$jsonKey] = $jsonVal;
    }    
    echo json_encode($json);
    exit();
}
function checkLogged(){
    if (!isset($_SESSION['usrid']))
        renderJSON(403,'error','Please login your account first!');
}
$allowImageFormat = array("png", "jpg", "jpeg","bmp");
if (isset($_POST['a'])){
    switch($_POST['a']){
        case "login":
            $sLogin = $db->prepare("SELECT id FROM users WHERE username = ? AND password = SHA2(?,256);");
            $sLogin->execute(array($_POST['username'],$_POST['password']));
            $resLogin = $sLogin->rowCount();
            if ($resLogin == 1){
                $rLogin = $sLogin->fetch();
                $_SESSION['usrid'] = $rLogin['id'];
            }
            renderJSON($resLogin == 1 ? 200 : 404);
        break;
        case "register":
            $errorArr = array();
            if (empty($_POST['password']) || !isset($_POST['password'])){
                $errorArr[] = "Empty entry for password is not allowed!";
            }
            if (empty($_POST['confirmpassword']) || !isset($_POST['confirmpassword'])){
                $errorArr[] = "Empty entry for confirm password is not allowed!";
            }
            if (count($errorArr) > 0){
                renderJSON(500,'error',join("<br>",$errorArr));
            }
            if ($_POST['password'] != $_POST['confirmPassword']){
                renderJSON(500,'error','Both password are not matched!');
            }
            $sCheckUnique = $db->prepare("SELECT id FROM users WHERE username = ?;");
            $sCheckUnique->execute(array($_POST['username']));
            if ($sCheckUnique->rowCount() > 0)
                renderJSON(500,'error','This username has been used by others!');
            $sRegister = $db->prepare("INSERT INTO users (username,password,name) VALUES (?,SHA2(?,256),?);");
            $sRegister->execute(array($_POST['username'],$_POST['password'],$_POST['name']));
            if ($sRegister->rowCount() == 1){
                renderJSON(200);
            }
            else{
                renderJSON(500,'error','Please try again later!');
            }
        break;
        case "deleteNews":
            checkLogged();
            $sDelete = $db->prepare("DELETE FROM news WHERE id = ? AND author = ?;");
            $sDelete->execute(array($_POST['id'],$_SESSION['usrid']));
            if ($sDelete->rowCount() == 0){
                renderJSON(500,'error','Unable to delete the news!');
            }
            else{
                renderJSON(200);
            }
        break;
        case "modifyNews":
            checkLogged();
            $errorArr = array();
            if (empty($_POST['news-title']) || !isset($_POST['news-title'])){
                $errorArr[] = "News title is required!";
            }
            if (empty($_POST['news-text']) || !isset($_POST['news-text'])){
                $errorArr[] = "News text is required!";
            }
            if (empty($_POST['category']) || !isset($_POST['category'])){
                $errorArr[] = "Category is requierd!";
            }
            if (empty($_POST['newsID']) || !isset($_POST['newsID'])){
                $errorArr[] = "News ID is required!";
            }
            if (count($errorArr) > 0){
                renderJSON(500,'error',join("<br>",$errorArr));
            }
            if (isset($_FILES['img-input']) && !empty($_FILES['img-input']['name'])){
                $fileName = $_FILES['img-input']['name'];
                $fileSize = $_FILES['img-input']['size'];
                $fileTempName = $_FILES['img-input']['tmp_name'];
                $ext = strtolower(pathinfo($fileName,PATHINFO_EXTENSION));
                if(!in_array($ext, $allowImageFormat)) {
                    renderJSON(500,'error','The image only accept extension with .png, .jpg, .jpeg and .png');
                }
                $dest_directoy = $_SERVER['DOCUMENT_ROOT'];
                $fullPath = "/img/".generate_string(8).".".$ext;
                if ($fileSize < 15 * 1024 * 1024){ //allow 15mb max
                    if (move_uploaded_file($fileTempName,$dest_directoy.$fullPath)){
                        $sSave = $db->prepare("UPDATE news SET img = ? WHERE id= ?;");
                        $sSave->execute(array($fullPath,$_POST['newsID']));
                        if ($sSave->rowCount() == 0){
                            renderJSON(500,'error','Image cannot be uploaded!');
                        }
                    }
                    else{
                        renderJSON(500,'error','We are having issue processing your image!<br>Please try again later!');
                    }
                }
                else{
                    renderJSON(500,'error','The image size should not more than 15 MB!');
                }
            }
            $sSave = $db->prepare("UPDATE news SET author = ?,heading = ?, description = ?, catid = ?, dtupdated = NOW() WHERE id= ?;");
            $sSave->execute(array(1,$_POST['news-title'],preg_replace("/\r\n|\r/", "<br>",$_POST['news-text']),$_POST['category'],$_POST['newsID']));
            if ($sSave->rowCount() == 1){
                renderJSON(200);
            }
            renderJSON(500,'error','No changes is detected!');
        break;
        case "createNews":
            checkLogged();
            $errorArr = array();
            if (empty($_POST['news-title']) || !isset($_POST['news-title'])){
                $errorArr[] = "News title is required!";
            }
            if (empty($_POST['news-text']) || !isset($_POST['news-text'])){
                $errorArr[] = "News text is required!";
            }
            if (empty($_POST['category']) || !isset($_POST['category'])){
                $errorArr[] = "Category is requierd!";
            }
            if (empty($_FILES['img-input']) || !isset($_FILES['img-input'])){
                $errorArr[] = "Image is required!";
            }
            if (count($errorArr) > 0){
                renderJSON(500,'error',join("<br>",$errorArr));
            }
            $fileName = $_FILES['img-input']['name'];
            $fileSize = $_FILES['img-input']['size'];
            $fileTempName = $_FILES['img-input']['tmp_name'];
            $ext = strtolower(pathinfo($fileName,PATHINFO_EXTENSION));
            if(!in_array($ext, $allowImageFormat)) {
                renderJSON(500,'error','The image only accept extension with .png, .jpg, .jpeg and .png');
            }
            $dest_directoy = $_SERVER['DOCUMENT_ROOT'];
            $fullPath = "/img/".generate_string(8).".".$ext;
            if ($fileSize < 15 * 1024 * 1024){ //allow 15mb max
                if (move_uploaded_file($fileTempName,$dest_directoy.$fullPath)){
                    $sSave = $db->prepare("INSERT INTO news (author,heading,img,description,catid,dtcreated) VALUES (?,?,?,?,?,NOW());");
                    $sSave->execute(array(1,$_POST['news-title'],$fullPath,preg_replace("/\r\n|\r/", "<br>",$_POST['news-text']),$_POST['category']));
                    if ($sSave->rowCount() == 1){
                        renderJSON(200,"id",$db->lastInsertId());
                    }
                    renderJSON(500,'error','Please check your form input again!');
                }
                else{
                    renderJSON(500,'error','We are having issue processing your image!<br>Please try again later!');
                }
            }
            else{
                renderJSON(500,'error','The image size should not more than 15 MB!');
            }
        break;
        case "changePassword":
            checkLogged();
            $errorArr = array();
            if (empty($_POST['password']) || !isset($_POST['password'])){
                $errorArr[] = "Empty entry for password is not allowed!";
            }
            if (empty($_POST['newPassword']) || !isset($_POST['newPassword'])){
                $errorArr[] = "Empty entry for new password is not allowed!";
            }
            if (empty($_POST['confirmNewPassword']) || !isset($_POST['confirmNewPassword'])){
                $errorArr[] = "Empty entry for confirm new password is not allowed!";
            }
            if (count($errorArr) > 0){
                renderJSON(500,'error',join("<br>",$errorArr));
            }
            if ($_POST['newPassword'] != $_POST['confirmNewPassword']){
                renderJSON(500,'error','Both password are not matched!');
            }
            $sChange = $db->prepare("UPDATE users SET password = SHA2(?,256) WHERE password = SHA2(?,256) AND id = ?;");
            $sChange->execute(array($_POST['confirmNewPassword'],$_POST['password'],$_SESSION['usrid']));
            if ($sChange->rowCount() == 1){
                renderJSON(200);
            }
            else{
                renderJSON(500,'error','You have entered incorrect old password!');
            }
        break;
    }
}
else{
    switch($_GET['a']){
        case "viewNews":
            $sGetNews = $db->prepare("SELECT * FROM news WHERE catid = ?;");
            $sGetNews->execute(array($_GET['catID']));
            if ($sGetNews->rowCount() > 0){
                $rGetNews = $sGetNews->fetchAll();
                foreach($rGetNews as $k=>$v){
                    if (isset($_SESSION['usrid'])){
                        $rGetNews[$k]['allowDelete'] =  ($v['author'] == $_SESSION['usrid']  ? true : false);
                    }
                    else{
                        $rGetNews[$k]['allowDelete'] = false;
                    }
                }
                renderJSON(200,"news",$rGetNews);
            }
            else{
                renderJSON(404,"error","No news published in this category yet!");
            }
        break;
        case "logout":
            session_destroy();
            header("Location: /");
            exit();
        break;
    }
}
?>