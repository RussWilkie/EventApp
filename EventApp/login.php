<?PHP 
    require_once("connection.php");
    if( isset($_POST['txtUsername']) && isset($_POST['txtPassword']) ) { 
        $username = $_POST['txtUsername'];
        $password = $_POST['txtPassword'];
        
        $query = "SELECT username, password FROM Users ". 
        " WHERE username = '$username' AND password = '$password';";
        
        $result = mysqli_query($conn, $query);

        if(($result -> num_rows) > 0){
            if(isset($_POST['mobile']) && $_POST['mobile'] == "android"){ 
                echo "success"; 
                exit; 
            }
            echo "success";
           // header("location: login.php"); //replace index.php with your url
        } else{ 
            echo "Login Failed <br/>";
        } 
    } 
?>
<html>
<head><title>EventApp Login</title></head>
    <body>
        <h1>Login|</h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
            Username <input type="text" name="txtUsername" value="" /><br/>
            Password <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" name="btnSubmit" value="Login"/>
        </form>
    </body>
</html>