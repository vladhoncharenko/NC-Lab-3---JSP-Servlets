<%--
  View of Executor Servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Database SQL Executor</title>
</head>
<body>
<form method="post" action="/lab3/execute">
    <h2>Enter query in input area and press button "Enter"</h2>
    <%
        if (request.getParameter("query") == null) {%>
    <%= "<input type=\"text\" name=\"query\" value=\"\" size=\"100\" />"%>
    <% } else {%>
    <%= "<input type=\"text\" name=\"query\" value=\" " + request.getParameter("query") + "\" size=\"100\" />" %>
    <% }
    %>

    <input type="submit" name="RUNb" value="RUN"/>
</form>
</body>
</html>
