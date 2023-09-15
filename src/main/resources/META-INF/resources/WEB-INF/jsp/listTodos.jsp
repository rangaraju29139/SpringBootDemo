<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Heyy!!! This is the list todos page
</h1>

<div>Your todos are  </div>

    <table>
        <thead>
        <th>id</th>
        <th>Description</th>
        <th>Target Date</th>
        <th>Is Done?</th>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                </tr>
        </c:forEach>
        </tbody>
    </table>



</body>
</html>