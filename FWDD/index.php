<?php
include_once 'common/master.php';
include_once 'inc/util.php';
session_start();
?>
<!DOCTYPE html>
<html lang="en">

<head>
  <?php 
  $inlineStyle = '
  <style>
  .card img{
    max-height: 250px;
    min-height: 250px;
    height:250px;
  }
  .card-title,.card-text{
    width: 100%;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis // This is where the magic happens
  }
  .nav-item{
    cursor:pointer;
  }
  </style>';
  renderHeader([
    'description' => 'Home page',
    'author' => 'Fang',
    'dependencies' => [$inlineStyle]
  ]); 
  ?>
</head>

<body>
  <?php include_once 'common/navbar.php'; ?>
  <div class="container-fluid" id="main-content">
    <div class="row">
        <div class="col-lg-12 mt-3 mx-10">
          <div class="row justify-content-md-center mb-2">
            <h2>News</h2>
          </div>
          <div class="row justify-content-md-center mb-2">
            <nav>
              <div class="nav nav-tabs" id="nav-tab" role="tablist" style="background-color:rgba(0,0,0,.03);">
                <?php 
                  $categories = getAllCategory();
                  $i = 1;
                  foreach ($categories as $category){
                    echo "<a class=\"nav-item nav-link".($i == 1 ? " init-nav active" : "")."\" data-id=\"".$category['id']."\" onclick=\"viewNews(this);\">".$category['category']."</a>";
                    $i++;
                  }
                ?>
              </div>
            </nav>
          </div>
          <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active">
              <div class="row">
              </div>
            </div>
          </div>
        </div>
    </div>
  </div>
  <?php include_once 'common/components.php'; ?>
  <?php renderCopyright(); ?>
  <?php renderFooter([
    'dependencies' => ['<script src="js/util.js"></script>']
  ]); ?>
  
	<script>
		$(document).ready(function() {
      $(".init-nav").unbind("click").click();
		});
    function cardTemplate(id,img,title,description,isDeletable){
      t = '<div class="col-lg-4">\
                  <div class="card" style="width: 100%;">\
                    <img class="card-img-top" src="' + img + '" alt="Card image cap">\
                    <div class="card-body" style="cursor:pointer;" onclick="window.location.href=\'viewNews.php?id=' + id + '\'">\
                      <h2 class="card-title" style="text-overflow: ellipsis;">' + title + '</h2>\
                      <p class="card-text">' + description + '</p>';
                      if (isDeletable == true){
                        t += '</div>';
                        t += '<div class="card-footer">';
                        t += '<button type="button" class="btn btn-danger float-right" onclick="deleteCard(' + id + ');" style="position: relative;">Delete</button>\
                        <button type="button" class="btn btn-primary float-right mr-2" onclick="window.location.href=\'manageNews.php?id=' + id + '\'" style="position: relative;">Edit</button>';
                        
                      }
                      

                    t += '</div>\
                  </div>\
                </div>';
                return t;
    }
    function viewNews(ths){
      $(".nav-item").removeClass("active");
      $(ths).addClass("active");
      $.ajax({
        url: window.location.origin + "/handler.php",
          dataType: "JSON",
          method: "GET",
          data: {
            "a": "viewNews",
            "catID": $(ths).data("id")
          },
          success:function(data){
            e = "";
            if (data.code == 200){
              $.each(data.news,function(k,v){
                console.log(v);
                e += cardTemplate(v.id,v.img,v.heading,v.description,v.allowDelete);
              });
              $(".tab-pane").children(".row").html(e);
            }
            else{
              e = "<div class=\"col-lg-12\"><p>" + data.error + "</p></div>";
            }
            $(".tab-pane").children(".row").html(e);
          },error:function(data){

          }
      })
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
                location.reload();
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
    
  </script>
  
</body>
</html>
