<?php
session_start();
include_once 'common/master.php';
include_once 'inc/util.php';
if (!isset($_GET['id'])) {
    header("Location: /");
    exit();
}
$sGet = $db->prepare("SELECT * FROM news WHERE id = ?;");
$sGet->execute(array($_GET['id']));
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
        'description' => 'View News',
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
                    <div class="row mb-2">
                        <span class="col-md-5">Author: <?php echo getAuthorName($rGet['author']); ?> | Published on <?php echo $rGet['dtcreated']; ?></span>
                        <div class="col-md-3 offset-md-4">
                            <span class="float-right">Category: <?php echo getCategoryName($rGet['catid']); ?></span>
                        </div>
                    </div>
                    <div class="col-12 px-0">
                        <div class="card mb-4">
                            <img class="card-img-top" src="<?php echo $rGet['img']; ?>" alt="Card image cap">
                            <div class="card-body">
                                <div class="card-title editable">
                                    <h2><?php echo $rGet['heading']; ?></h2>
                                </div>
                                <div class="card-text">
                                    <p>
                                        <?php echo $rGet['description']; ?>
                                    </p>
                                </div>
                                &nbsp;
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
</body>

</html>