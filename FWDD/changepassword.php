<?php
session_start();
include_once 'common/master.php';
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
    'description' => 'Change Password',
    'author' => 'Fang',
    'dependencies' => [$inlineStyle]
  ]); 
  ?>
</head>
<body>
    <?php include_once 'common/navbar.php'; ?>
    <div class="container-fluid py-5" id="main-content">
        <div class="row justify-content-center align-self-center">
            <form class="form-change-password col-lg-4 col-sm-12 col-xs-12">
                <input type="hidden" name="a" value="changePassword">
                <div class="row justify-content-md-center mb-2">
                    <h2>Change Password</h2>
                </div>
                <div class="form-group">
                    <label for="txtOldPassword">Old Password</label>
                    <input type="password" class="form-control" name="password" id="txtOldPassword">
                </div>
                <div class="form-group">
                    <label for="txtNewPassword">New Password</label>
                    <input type="password" class="form-control" name="newPassword" id="txtNewPassword">
                </div>
                <div class="form-group">
                    <label for="txtConfirmNewPassword">Confirm New Password</label>
                    <input type="password" class="form-control" name="confirmNewPassword" id="txtConfirmNewPassword">
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="button" onclick="changePassword();">Change Password</button>
            </form>
        </div>
    </div>
    <?php include_once 'common/components.php'; ?>
  <?php renderCopyright(); ?>
  <?php renderFooter(); ?>
    <script>
        function changePassword(){
            $.ajax({
                url: window.location.origin + "/handler.php",
                dataType: "JSON",
                method: "POST",
                data: $(".form-change-password").serialize(),
                success: function(data) {
                    if (data.code == 200){
                        Swal.fire('Change Password', 'You have successfully changed your password!', 'success').then(()=>{
                            location.reload();
                        });
                    }
                    else{
                        Swal.fire('Change Password', data.error, 'error');
                    }
                },error:function(data){
                    Swal.fire('Change Password', 'We encountered some unexpected error!', 'error');
                }
            });
        }
    </script>
</body>
</html>