<%@ page import="utils.ExecutePLSQL" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Department</title>
</head>
<body>

<% String name = request.getParameter("deptntNoField");
    ResultSet i = ExecutePLSQL.executeQuery("SELECT * FROM DEPTNT WHERE DEPTNO=" + name);
    String number = null;
    String nameD = null;
    String loc = null;
    if (i.next()) {
        number = i.getString(1);
        nameD = i.getString(2);
        loc = i.getString(3);
    }

%>

<div class="bodycontent">
    <form method="post" action="">
        <h2>To edit department <%= number %> : Enter data in fields and press "Save"</h2>
        <input type="hidden" name="DeptntNoF" value="<%= number %>">

        <label for="dnameId">Enter Name:</label>
        <div><input type="text" name="dname" value="<%=nameD%>" size="20" id="dnameId" data-validation="length"
                    data-validation-length="1-13"
                    data-validation-error-msg="Data is not valid. Please, enter 1-13 symbols."/></div>
        <label for="locId">Enter Location:</label>
        <div><input type="text" name="loc" value="<%=loc%>" size="20" id="locId" data-validation="length"
                    data-validation-length="1-13"
                    data-validation-error-msg="Data is not valid. Please, enter 1-13 symbols."/></div>

        <input type="submit" name="RUNb" value="Save"/>
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

