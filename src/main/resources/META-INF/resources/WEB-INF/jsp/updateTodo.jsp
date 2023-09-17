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
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >

    <title>Document</title>
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Enter Todo Details</h1>

    <form:form action="" method="post" class="" modelAttribute="todo">

        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>
        <form:input class="form-control " path="id" type="hidden" />
        <form:input class="form-control " path="done" type="hidden"/>


        <input class="btn btn-success" type="submit" />
    </form:form>


</div>
<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
    </script>
</body>
</html>