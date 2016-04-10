<%--
  View of add Department Servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Department</title>
</head>
<body>
<div class="bodycontent">
<form method="post" action="/lab3/departmentadd">
    <h2>To add new department: Enter data in fields and press "Add"</h2>

    <label for="dnameId">Enter Name:</label>
    <div><input type="text" name="dname" value="" size="20" id="dnameId" data-validation="length"
                data-validation-length="1-13"
                data-validation-error-msg="Data is not valid. Please, enter 1-13 symbols."/></div>
    <label for="locId">Enter Location:</label>
    <div><input type="text" name="loc" value="" size="20" id="locId" data-validation="length"
                data-validation-length="1-13"
                data-validation-error-msg="Data is not valid. Please, enter 1-13 symbols."/></div>

    <input wtype="submit" name="RUNb" value="Add"/>
</form>
</div>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
        src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js"></script>
<link href="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/theme-default.min.css" rel="stylesheet"
      type="text/css"/>
<script>$.validate();</script>
</body>
</html>
