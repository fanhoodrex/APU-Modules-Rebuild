<?php
function generate_string($strength = 16) {
    $rules = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    $input_length = strlen($rules);
    $random_string = '';
    for($i = 0; $i < $strength; $i++) {
        $random_character = $rules[mt_rand(0, $input_length - 1)];
        $random_string .= $random_character;
    }
    return $random_string;
}
function getCategoryName($catID){
    global $db;
    $sGet = $db->prepare("SELECT category FROM news_category WHERE id = ?;");
    $sGet->execute(array($catID));
    if ($sGet->rowCount() > 0){
        $rGet = $sGet->fetch();
        return $rGet['category'];
    }
    else{
        return "";
    }
}
function getAuthorName($usrID){
    global $db;
    $sGet = $db->prepare("SELECT name FROM users WHERE id = ?;");
    $sGet->execute(array($usrID));
    if ($sGet->rowCount() > 0){
        $rGet = $sGet->fetch();
        return $rGet['name'];
    }
    else{
        return "";
    }
}

function getAllCategory(){
    global $db;
    $sGet = $db->query("SELECT * FROM news_category;");
    $rGet = $sGet->fetchAll(PDO::FETCH_ASSOC);
    return $rGet;
}
?>