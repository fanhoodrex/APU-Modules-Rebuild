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
        'description' => 'Register',
        'author' => 'Fang',
        'dependencies' => [$inlineStyle]
    ]);
    ?>
</head>

<body>
    <?php include_once 'common/navbar.php'; ?>
    <div class="container-fluid py-5" id="main-content">
        <div class="row justify-content-center align-self-center">
            <form method="POST" class="form-register col-lg-4 col-sm-12 col-xs-12">
                <input type="hidden" name="a" value="register">
                <div class="row justify-content-md-center mb-2">
                    <h2>Register</h2>
                </div>
                <div class="form-group">
                    <label for="txtUsername">Username</label>
                    <input type="text" class="form-control" name="username" id="txtUsername">
                </div>
                <div class="form-group">
                    <label for="txtName">Fullname</label>
                    <input type="text" class="form-control" id="txtName" name="name">
                </div>
                <div class="form-group">
                    <label for="txtPassword">Password</label>
                    <input type="password" class="form-control" name="password" id="txtPassword">
                </div>
                <div class="form-group">
                    <label for="txtConfirmPassword">Confirm Password</label>
                    <input type="password" class="form-control" name="confirmPassword" id="txtConfirmPassword">
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="button" onclick="register(this);">Register account</button>
            </form>
        </div>
    </div>
    <?php include_once 'common/components.php'; ?>
    <?php renderCopyright(); ?>
    <?php renderFooter(); ?>
    <script>
        function register(ths) {
            $.ajax({
                url: window.location.origin + "/handler.php",
                dataType: "JSON",
                method: "POST",
                data: $(".form-register").serialize(),
                success: function(data) {
                    if (data.code == 200) {
                        Swal.fire('Create account', 'You have successfully created your account!', 'success').then(function() {
                            window.location.href = '/login.php';
                        });
                    }
                    else{
                        Swal.fire('Create account', data.error, 'error');
                    }
                },
                error: function(data) {
                    Swal.fire('Create account', 'We encountered some unexpected error!', 'error');
                }
            });
        }
    </script>
</body>

</html>