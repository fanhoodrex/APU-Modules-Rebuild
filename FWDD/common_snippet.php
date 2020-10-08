<?php
$db = mysqli_connect('localhost', 'root', '', 'testajax'); #sql database connection

if (isset($_POST[''])){ #if condition based on post method
    $username = $_POST['username'];# declare variables
    $password = $_POST['password'];
    $email = $_POST['email'];
	$query = "SQL Statement"; # declare variable for SQL query
    $results = mysqli_query($db, $sql); #execute the sql statement
    
    if(mysqli_num_rows($results)>0){
        echo "";
    }
    else{
        echo "";
    }
}

while ($result = mysqli_fetch_array($execQuery)){ #call mysqli_fetch_array fucntion
}
?>