<%@ page import="utils.ExecutePLSQL" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteDepartment</title>
</head>
<body>
<%--TODO Yes/No confirm--%>
<% String name = request.getParameter("deptntNoField");
    int i = ExecutePLSQL.executeUpdate("DELETE FROM DEPTNT WHERE DEPTNO=" + name);%>

<h1 align="center">Department with DEPTNO = <%= name %> deleted. </h1>
<form action="/lab3/departments">
    <p align="center"><input type="submit" value="Go Back"></p>

</form>
</body>
</html>
