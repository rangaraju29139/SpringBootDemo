<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

    <form:form action="" method="post" class="" modelAttribute="todo">

        <div class="form-group">
            <label for="description" >Description </label>
            <form:input class="form-control " id="description" type="text" name="description"  path="description"/>
        </div>
        <form:input class="form-control " path="id" type="hidden" />
        <form:input class="form-control " path="done" type="hidden"/>


        <input class="btn btn-success" type="submit" />
    </form:form>


</div>
<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>