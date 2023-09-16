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
    <h1>Enter Todo Details</h1>

    <form action="" method="post" class="">
        <div class="form-group">
            <label for="description" >Description </label>
            <input class="form-control " id="description" type="text" name="description" />
        </div>

        <input class="btn btn-success" type="submit" />
    </form>


</div>
<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>