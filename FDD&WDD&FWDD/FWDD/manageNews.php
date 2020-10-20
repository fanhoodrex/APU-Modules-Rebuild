<?php
session_start();
include_once 'common/master.php';
include_once 'inc/util.php';
if (!isset($_GET['id'])) {
  header("Location: /");
  exit();
}
$sGet = $db->prepare("SELECT * FROM news WHERE id = ? AND author = ?;");
$sGet->execute(array($_GET['id'],isset($_SESSION['usrid']) ? $_SESSION['usrid'] : null));
if ($sGet->rowCount() == 0) {
  header("Location: /");
  exit();
}
$rGet = $sGet->fetch();
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
    'description' => 'News Management',
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
          <input type="hidden" name="a" value="modifyNews">
          <input type="hidden" name="newsID" value="<?php echo $_GET['id']; ?>">
          <div class="row news-category justify-content-end">
            <span class="col-auto">Category: <?php echo getCategoryName($rGet['catid']); ?></span>
          </div>
          <div class="col-12 px-0">
            <div class="card mb-4">
              <input type="file" id="img-input" name="img-input" style="display:none;">
              <div style="z-index:500;right:0;position:absolute;" class="float-right">
                <span class="badge badge-xl badge-dark modify-img" onclick="modifyImage(this);" style="display:none;cursor:pointer;margin-right:0px;font-size:1em;">
                  <i class="fa fa-edit" aria-hidden="true"></i>
                </span>
              </div>
              <img class="card-img-top" src="<?php echo $rGet['img']; ?>" alt="Card image cap">
              <div class="card-body">
                <div class="card-title editable">
                  <h2><?php echo $rGet['heading']; ?></h2>
                </div>
                <div class="card-text">
                  <p><?php echo $rGet['description']; ?></p>
                </div>
                &nbsp;
              </div>
              <div class="card-footer">
                <button type="button" class="btn btn-danger float-right" onclick="deleteCard('<?php echo $_GET['id']; ?>');" style="position: relative;">Delete</button>
                <button type="button" class="btn btn-primary float-right mr-2" onclick="modifyCard(this);" style="position: relative;">Edit</button>
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
    function modifyCard(ths) {
      switch ($(ths).text()) {
        case "Edit":
          loadCategory();
          $(".editable").attr("contenteditable", true);
          cardText = $(".card-text").children("p").text();
          cardTitle = $(".card-title").children("h2").text();
          $(".card-text").html("<textarea name=\"news-text\" id=\"news-text\" class=\"form-control\" rows=\"10\">" + cardText + "</textarea>");
          $(".card-title").html("<input type=\"text\" id=\"news-title\" class=\"form-control\" name=\"news-title\" value=\"" + cardTitle + "\">");
          $(ths).text("Save");
          $(".modify-img").css("display", "block");
          break;
        case "Save":
          console.log($("#form-news").serialize());
          $(".editable").removeAttr("contenteditable");
          cardText = $("#news-text").val().replace(/\r\n|\r|\n/g, "<br />");
          cardTitle = $("#news-title").val();
          $.ajax({
            url: window.location.origin + "/handler.php",
            dataType: "JSON",
            method: "POST",
            data: new FormData($('#form-news')[0]),
            processData: false,
            contentType: false,
            success: function(data) {
              if (data.code == 200){
                location.reload();
              }
              else{
                Swal.fire('News modification',data.error,'error');
              }
            },
            error: function(data) {
              Swal.fire('News modification','We encountered unexpected error!','error');
            }
          });

          break;
      }
    }

    function loadCategory() {
      $(".news-category").html('<div class="col-3">\
              <div class="form-group row">\
                <label id="col-sm-2" style="line-height: 2.5;" for="exampleFormControlSelect1">Category</label>\
                <select class="form-control col-sm-8" name="category" id="exampleFormControlSelect1">\
                <?php 
                $categories = getAllCategory();
                foreach ($categories as $category){
                  echo "<option value=\"".$category['id']."\"".(($category['id'] == $rGet['catid']) ? " selected" : "").">".$category['category']."</option>\\";
                }
                ?>
                </select>\
              </div>\
            </div>');
            
    }

    function duplicateImage() {
      return '<div class="img-box">\
      <div class="form-group mt-5">\
      <div style="z-index:502;top: 5px;right: 10px;position:absolute;" class="float-right">\
                      <span class="badge badge-xl badge-dark" onclick="removeImage(this);" style="cursor:pointer;margin-right:0px;font-size:1em;"><i class="fa fa-times" aria-hidden="true"></i></span>\
                    </div>\
      <img src="img/4.jpg" class="img-fluid global-img" alt="Responsive image">\
      </div>\
  <div class="form-group">\
    <label for="exampleFormControlFile1">Example file input</label>\
    <div class="row" id="exampleFormControlFile1">\
    <div class="col-9">\
    <input type="file" class="form-control-file">\
    </div>\
    <div class="col-3">\
    <button type="button" onClick="actDuplicateImage(this);" class="btn btn-success float-right">Add</button>\
    </div>\
    </div>\
    </div>\
  </div>';
    }

    function modifyImage(ths) {
      $("#img-input").unbind("click").click();
    }

    function deleteCard(id) {
      Swal.fire({
        title: 'Do you want to delete news?',
        icon: 'info',
        showCancelButton: true,
        confirmButtonText: 'Yes',
      }).then((result) => {
        $.ajax({
          url: window.location.origin + "/handler.php",
          dataType: "JSON",
          method: "POST",
          data: {
            "a": "deleteNews",
            "id": id
          },
          success: function(data) {
            if (data.code == 200) {
              Swal.fire('Delete News', 'You have successfully deleted this news!', 'success').then(() => {
                window.location.href = '/';
              });
            } else {
              Swal.fire('Delete News', data.error, 'error');
            }
          },
          error: function(data) {
            Swal.fire('Delete News', 'We encountered unexpection error!', 'error');
          }
        });
      });
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

    function actDuplicateImage(ths) {
      $(duplicateImage()).insertAfter($(ths).closest(".img-box"));
    }

    function removeImage(ths) {
      if ($(".img-box").length > 2) {
        $(ths).closest(".img-box").remove();
      }
    }
  </script>
</body>

</html>