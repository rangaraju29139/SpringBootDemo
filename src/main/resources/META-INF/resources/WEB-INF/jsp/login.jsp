<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">

    <title>Document</title>
</head>
<body>
<div class="container">
    <h1>Hey this is the login page - JSP</h1>
    <pre>${errorMessage}</pre>
    <form action="" method="post" class="">
        <div class="form-group">
            <label for="username" >Name </label>
            <input class="form-control " id="username" type="text" name="username" />
        </div>
        <div class="form-group">
            <label for="password"> Password </label>
           <input class="form-control" id="password" type="password" name="password" />
       </div>
        <input class="btn btn-success" type="submit" />
    </form>


</div>
<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>