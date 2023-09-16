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
<h1>Todo Page
</h1>


<div class="container">
    <div>Your todos are  </div>
    <table class="table table-responsive table-striped">
        <thead class="thead-dark">
        <th>id</th>
        <th>Description</th>
        <th>Target Date</th>
        <th>Is Done?</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning" >Delete ${todo.id}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>


</div>





<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>