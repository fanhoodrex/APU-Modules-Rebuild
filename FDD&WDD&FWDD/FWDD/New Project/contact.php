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
    .contact-form-widget {
        min-height:204px;
    }
    </style>';
    renderHeader([
        'description' => 'Contact Us',
        'author' => 'Fang',
        'dependencies' => [$inlineStyle]
    ]);
    ?>
</head>

<body>
    <?php include_once 'common/navbar.php'; ?>
    <div class="container-fluid py-5" id="main-content">
        <div class="row justify-content-center align-self-center">
            <form class="form-signin col-lg-4 col-sm-12 col-xs-12">
                <div class="row justify-content-md-center mb-2">
                    <h2>Contact Us</h2>

                </div>
                <div class="row justify-content-md-center mb-2">
                    <p>Drop us your enquires here!</p>
                </div>
                <div class="form-group">
                    <label for="txtName">Fullname</label>
                    <input type="text" class="form-control" id="txtName">
                </div>
                <div class="form-group">
                    <label for="txtEmail">Email address</label>
                    <input type="email" class="form-control" id="txtEmail" aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="txtPassword">Your question</label>
                    <textarea class="form-control" rows="3"></textarea>
                </div>
                <button class="btn btn btn-primary" type="submit">Submit</button>
            </form>
        </div>
        <div class="row my-5 justify-content-center align-self-center">
            <div class="col-lg-8">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="card contact-form-widget text-center">
                            <div class="card-body">
                                <h1 class="card-title"><i class="fas fa-phone"></i></h1>
                                <h5>Contact Us</h5>
                                <p class="card-text">+603 8023 8315</p>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="card contact-form-widget text-center">
                            <div class="card-body">
                                <h1 class="card-title"><i class="fas fa-envelope-open"></i></h1>
                                <h5>Send us an email</h5>
                                <p class="card-text">enquiry@fang.com</p>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="card contact-form-widget text-center">
                            <div class="card-body">
                                <h1 class="card-title"><i class="fas fa-map-marker-alt"></i></h1>
                                <h5>Visit us</h5>
                                <p class="card-text">
                                    44, Technology Park Malaysia,<br>
                                    Bukit Jalil,<br>
                                    58700 Kuala Lumpur
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="card contact-form-widget text-center">
                            <div class="card-body">
                                <h1 class="card-title"><i class="fab fa-whatsapp"></i></h1>
                                <h5>WhatsApp Us</h5>
                                <p class="card-text">+603 8023 8315</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <?php include_once 'common/components.php'; ?>
    <?php renderCopyright(); ?>
    <?php renderFooter(); ?>
</body>

</html>