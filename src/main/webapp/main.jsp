
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Hello <%=session.getAttribute("uname")%>!</p>
<p>Your id is <%=session.getAttribute("empno")%></p>
<a href="./employees">Click here</a>
</body>
</html>
