<?php
$db = mysqli_connect('localhost','root','','testajax');

if (isset($_POST['proceed'])) {
    $name = $_POST['search'];
    $query = "select username from users where username like '%$name%'";
    $execQuery = mysqli_query($db, $query);
    while ($result = mysqli_fetch_array($execQuery))
    {
        ?>
        <a onclick='insert("<?php echo $result['username']; ?>")'>
        <?php echo $result['username']; ?><br/>
        </a>
        <?php
        
    }
}
    
if (isset($_POST['ok'])) {
    $name = $_POST['search'];
    $query = "select * from users where username = '$name'";
    $execQuery = mysqli_query($db, $query);
    while ($result = mysqli_fetch_array($execQuery))
    {
        ?>
		<table bgcolor="#99ff66">
        <tr>
        <td>Name</td>
        <td>:</td>
        <td><?php echo $result['username'] ?></td>
        </tr>
        <td>Password</td>
        <td>:</td>
        <td><input type="text" id="txtPassword" value ="<?php echo $result['password'] ?>"></input></td>
        </tr>
        <td>Email</td>
        <td>:</td>
        <td><?php echo $result['email'] ?></td>
        </tr>
        </table>
        <?php
            
    }
    exit();
 }
 
 if (isset($_POST['edit'])) {
    $name = $_POST['nm'];
	$Password = $_POST['pa'];
    $query = "update users set passaord ='$password' where username ='$name'";
    $execQuery = mysqli_query($db, $query);
    echo "Updated successfully!";
	exit();
}

 
 if (isset($_POST['del'])) {
    $name = $_POST['nm'];
    $query = "delete from users where username ='$name'";
    $execQuery = mysqli_query($db, $query);
    echo "Deleted successfully!";
	exit();
}
 
 ?>