<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Fang</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item<?php echo ($_SERVER['PHP_SELF'] == '/index.php' ? ' active' : ''); ?>">
            <a class="nav-link" href="index.php">Home</a>
        </li>
       
        <?php if (!isset($_SESSION['usrid'])) { ?>        
        <li class="nav-item<?php echo ($_SERVER['PHP_SELF'] == '/login.php' ? ' active' : ''); ?>">
          <a class="nav-link" href="login.php">Login</a>
        </li>
        <li class="nav-item<?php echo ($_SERVER['PHP_SELF'] == '/register.php' ? ' active' : ''); ?>">
            <a class="nav-link" href="register.php">Register</a>
        </li>
        <?php }else{ ?>
          <li class="nav-item<?php echo ($_SERVER['PHP_SELF'] == '/newNews.php' ? ' active' : ''); ?>">
              <a class="nav-link" href="newNews.php">Create New News</a>
          </li>
          <li class="nav-item<?php echo ($_SERVER['PHP_SELF'] == '/changepassword.php' ? ' active' : ''); ?>">
              <a class="nav-link" href="changepassword.php">Change Password</a>
          </li>
          <li class="nav-item<?php echo ($_SERVER['PHP_SELF'] == '/handler.php?a=logout' ? ' active' : ''); ?>">
              <a class="nav-link" href="/handler.php?a=logout">Logout</a>
          </li>          
        <?php } ?>
        <li class="nav-item<?php echo ($_SERVER['PHP_SELF'] == '/contact.php' ? ' active' : ''); ?>">
            <a class="nav-link" href="contact.php">Contact Us</a>
        </li>
        <li class="nav-item<?php echo ($_SERVER['PHP_SELF'] == '/about.php' ? ' active' : ''); ?>">
          <a class="nav-link" href="about.php">About</a>
        </li>
      </ul>
    </div>
  </nav>