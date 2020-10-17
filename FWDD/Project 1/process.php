<?php 
  $db = mysqli_connect('localhost', 'root', '', 'testajax');
  
  if (isset($_POST['email_check'])) {
  	$email = $_POST['email'];
  	$sql = "SELECT * FROM users WHERE email='$email'";
  	$results = mysqli_query($db, $sql); # call for mysqli_qquery function
  	if (mysqli_num_rows($results) > 0) { # if the row returned is not zero
  	  echo "not_available";	
  	}else{
  	  echo 'available';
  	}
  	exit();
  }
  
  if (isset($_POST['save'])) {
  	$username = $_POST['username'];
  	$email = $_POST['email'];
  	$password = $_POST['password'];
	$query = "INSERT INTO users (username, email, password) VALUES ('$username', '$email', '".md5($password)."')";
	$results = mysqli_query($db, $query); #call for mysqli_qquery function
	echo 'Registered Successfully!';
	exit();
  }
?>