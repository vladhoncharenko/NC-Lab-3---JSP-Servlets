<%@ page import="utils.ExecutePLSQL" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteEmployee</title>
</head>
<body>
<%--TODO Yes/No confirm--%>
<% String name = request.getParameter("emplNoField");
    int i = ExecutePLSQL.executeUpdate("DELETE FROM EMPL WHERE EMPNO=" + name);%>

<h1 align="center">Employee with EMPNO = <%= name %> deleted. </h1>
<form action="/lab3/employees">
    <p align="center"><input type="submit" value="Go Back"></p>

</form>
</body>
</html>
