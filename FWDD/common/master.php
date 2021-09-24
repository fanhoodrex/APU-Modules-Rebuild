<?php
include_once 'inc/dbconn.php';
function validateUserID($usrID){
    global $db;
    $sCheck = $db->prepare("SELECT id FROM users WHERE id = ?;");
    $sCheck->execute($usrID);
    return $sCheck->rowCount() == 1 ? true : false;
}
function checkAuth(){
    if (!isset($_SESSION['usrid']) || empty($_SESSION['usrid']))
        header('Location: login');
        exit();
    if (!validateUserID($_SESSION['usrid']))
        header('Location: login');
        exit();
}
function renderHeader($arr = null){
    echo '<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="'.(($arr == null || !isset($arr['description']) || empty($arr['description'])) ? '' : $arr['description']).'">
    <meta name="author" content="'.(($arr == null || !isset($arr['author']) || empty($arr['author'])) ? '' : $arr['author']).'">
    <link rel="icon" href="'.(($arr == null || !isset($arr['favicon']) || empty($arr['favicon'])) ? '' : $arr['favicon']).'" type="image/jpg" sizes="16x16">
    <title>Home Page</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <!-- Style for tab UI -->
    <style>
      #main-content{
        background-color:#e9ecef;
        min-height: 100%;
        padding-bottom:15px;
      }
       .news-selection *{
           color: rgba(0,0,0,.9);
       }
       .news-selection *:hover{
           color: rgba(0,0,0,.9);
           text-decoration:none;
       }
       footer{
           bottom: 0;
       }
    </style>';
    if ($arr != null){
        if (isset($arr['dependencies']) || !empty($arr['dependencies'])){
            foreach($arr['dependencies'] as $des)
                echo $des;
        }
    }
}

function renderCopyright($specialConfigure = null){
    echo '<footer style="opacity:0.5" class="py-5 bg-light sticky-bottom">
    <div class="container">
      <p class="m-0 text-center">Copyright '.date('Y').'&copy;</p>
    </div>
  </footer>';
}

function renderFooter($arr = null){
    echo '<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>';
    if ($arr != null){
        if (isset($arr['dependencies']) || !empty($arr['dependencies'])){
            foreach($arr['dependencies'] as $des)
                echo $des;
        }
    }
}
?>