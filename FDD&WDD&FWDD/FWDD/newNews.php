<?php
session_start();
include_once 'common/master.php';
include_once 'inc/util.php';
?>
<!DOCTYPE html>
<html lang="en">

<head>
  <?php
  $inlineStyle = '
    <style>
    .global-img{
      max-height: 300px;
      min-height: 300px;
      height:300px;
      width:100%;
      min-width:100%;
    }
    .card img{
      max-height: 400px;
      min-height: 400px;
      height:400px;
    }
    .edit-mode {
        border: 2px solid red;
    }
    </style>
  ';
  renderHeader([
    'description' => 'New News',
    'author' => 'Fang',
    'dependencies' => [$inlineStyle]
  ]);
  ?>
</head>

<body>
  <?php include_once 'common/navbar.php'; ?>
  <!-- Page Content -->
  <div class="container-fluid" id="main-content">
    <div class="row pt-3">
      <!-- Blog Entries Column -->
      <div class="col-lg-9">
        <form method="POST" id="form-news" enctype="multipart/form-data">
          <input type="hidden" name="a" value="createNews">
          <div class="row">
                        <span class="col-md-5"><h3>Create New News</h3></span>
                        <div class="col-md-3 offset-md-4">
                        <div class="form-group row">
                    <label id="col-sm-2" style="line-height: 2.5;" for="exampleFormControlSelect1">Category</label>
                    <select class="form-control col-sm-8" name="category" id="exampleFormControlSelect1">
                    <?php 
                $categories = getAllCategory();
                foreach ($categories as $category){
                  echo "<option value=\"".$category['id']."\">".$category['category']."</option>\\";
                }
                ?>
                    </select>
                </div>
                        </div>
                    </div>
          
          <div class="col-12 px-0">
            <div class="card mb-4">
              <input type="file" id="img-input" name="img-input" style="display:none;">
              <div style="z-index:500;right:0;position:absolute;" class="float-right">
                <span class="badge badge-xl badge-dark modify-img" onclick="modifyImage();" style="cursor:pointer;margin-right:0px;font-size:1em;">
                  <i class="fa fa-edit" aria-hidden="true"></i>
                </span>
              </div>
              <img class="card-img-top" src="img/blank.jpg" style="border: 2px solid #dee2e6;border-radius: 25px;" alt="Card image cap">
              <div class="card-body">
                <div class="card-title editable">
                    <input type="text" id="news-title" class="form-control" placeholder="News title.." name="news-title">
                </div>
                <div class="card-text">
                    <textarea name="news-text" id="news-text" class="form-control" placeholder="News text" rows="10"></textarea>
                </div>
                &nbsp;
              </div>
              <div class="card-footer">
                <button type="button" class="btn btn-primary float-right mr-2" onclick="saveCard(this);" style="position: relative;">Publish</button>
              </div>
            </div>
          </div>
        </form>
      </div>
      <div class="col-lg-3">
        <ul class="list-group">
          <li class="list-group-item bg-light">
            <h4><b>Newsfeed</b></h4>
          </li>
          <?php include_once 'common/newsfeed.php'; ?>
        </ul>
      </div>
    </div>
  </div>
  <?php include_once 'common/components.php'; ?>
  <?php renderCopyright(); ?>
  <?php renderFooter(); ?>
  <script>
    function saveCard(ths) {
          $.ajax({
            url: window.location.origin + "/handler.php",
            dataType: "JSON",
            method: "POST",
            data: new FormData($('#form-news')[0]),
            processData: false,
            contentType: false,
            success: function(data) {
                if (data.code == 200){
                    window.location.href = "manageNews.php?id=" + data.id;
                }
                else{
                    Swal.fire('Publish New',data.error,'error');
                }
            },
            error: function(data) {
                Swal.fire('Publish New','We encountered some unexpected error while processing your requrest!','error');
            }
          });
    }

    function modifyImage() {
      $("#img-input").unbind("click").click();
    }

    function readURL(input, targetImg) {
      if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
          targetImg.attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]); // convert to base64 string
      }
    }

    $("#img-input").change(function() {
      file = $(this)[0].files[0].name;
      readURL(this, $(".card-img-top"));
    });


  </script>
</body>

</html>