<?php
$dsn = 'mysql:dbname=news_management_sys;host=localhost:3306';
$user = 'root';
$password = '';
global $db;
try {
    $db = new PDO($dsn, $user, $password,[
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES => false,
    ]);
} catch (PDOException $e) {
    echo 'Connection failed: ' . $e->getMessage();
    exit();
}
?>