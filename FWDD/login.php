<?php
session_start();
include_once 'common/master.php';
if (isset($_SESSION['usrid'])){
    session_destroy();
    header("Refresh:0");
    exit();
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
  <?php 
  $inlineStyle = '
    <style>
    .a:hover {
        cursor:pointer;
    }
    </style>';
  renderHeader([
    'description' => 'Login',
    'author' => 'Fang',
    'dependencies' => [$inlineStyle]
  ]); 
  ?>
</head>
<body>
    <?php include_once 'common/navbar.php'; ?>
    <div class="container-fluid py-5" id="main-content">
        <div class="row justify-content-center align-self-center">
            <form class="form-login col-lg-4 col-sm-12 col-xs-12">
                <input type="hidden" name="a" value="login">
                <div class="row justify-content-md-center mb-2">
                    <h2>Login</h2>
                </div>
                <div class="form-group">
                    <label for="txtUsername">Username</label>
                    <input type="text" class="form-control" name="username" id="txtUsername">
                </div>
                <div class="form-group">
                    <label for="txtPassword">Password</label>
                    <input type="password" class="form-control" name="password" id="txtPassword">
                </div>
                <div class="form-group"  style="padding-bottom:15px;">
                    <div class="row">
                        <div class="form-check col-12">
                            <input type="checkbox" class="form-check-input ml-0" id="chkRmb">
                            <label class="form-check-label" style="margin-left:20px;" for="chkRmb">Remember me</label>
                        </div>
                    </div>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="button" onclick="login(this);">Sign in</button>
            </form>
        </div>
    </div>
    <?php include_once 'common/components.php'; ?>
  <?php renderCopyright(); ?>
  <?php renderFooter(); ?>
    <script>
        function login(){
            $.ajax({
                url: window.location.origin + "/handler.php",
                dataType: "JSON",
                method: "POST",
                data: $(".form-login").serialize(),
                success: function(data) {
                    if (data.code == 200){
                        window.location.href = '/';
                    }
                    else{
                        Swal.fire('Authenticate account', 'Invalid credentials!', 'error');
                    }
                },error:function(data){
                    Swal.fire('Authenticate account', 'We encountered some unexpected error!', 'error');
                }
            });
        }
</script>
</body>
</html>