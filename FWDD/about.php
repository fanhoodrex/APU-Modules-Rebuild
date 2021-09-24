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
    .carousel-inner > .carousel-item > img {height:570px; }
    </style>';
  renderHeader([
    'description' => 'About us',
    'author' => 'Fang',
    'dependencies' => [$inlineStyle]
  ]);
  ?>
</head>

<body>
  <?php include_once 'common/navbar.php'; ?>
  <div class="container-fluid py-5" id="main-content">
    <div class="row justify-content-center align-self-center">
      <div class="form-signin col-lg-12">
        <div class="row justify-content-md-center mb-2">
          <h2>About Us</h2>
        </div>
        <div class="row justify-content-md-center mb-2">
          <p class="lead">
            Fang is a incredible news sharing community which allows the public to exchange the newsfeed that happens daily around the world!
          </p>
            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img class="d-block w-100" src="img/1.jpg" alt="First slide">
                </div>
                <div class="carousel-item">
                  <img class="d-block w-100" src="img/2.jpg" alt="Second slide">
                </div>
                <div class="carousel-item">
                  <img class="d-block w-100" src="img/3.jpg" alt="Third slide">
                </div>
              </div>
              <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
          </div>
        </div>
        <div class="row my-5 justify-content-center align-self-center">
          <div class="col-lg-8">
            <div class="row">
              <div class="col-lg-3">
                <div class="card contact-form-widget text-center">
                  <div class="card-body">
                    <h1 class="card-title"><i class="far fa-check-circle"></i></h1>
                    <h5>Reliable Conetent</h5>
                  </div>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="card contact-form-widget text-center">
                  <div class="card-body">
                    <h1 class="card-title"><i class="fas fa-globe-americas"></i></h1>
                    <h5>Globalization</h5>
                  </div>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="card contact-form-widget text-center">
                  <div class="card-body">
                    <h1 class="card-title"><i class="fas fa-language"></i></h1>
                    <h5>Multilanguage</h5>
                  </div>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="card contact-form-widget text-center">
                  <div class="card-body">
                    <h1 class="card-title"><i class="fas fa-user-friends"></i></h1>
                    <h5>Multiple Users</h5>
                  </div>
                </div>
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