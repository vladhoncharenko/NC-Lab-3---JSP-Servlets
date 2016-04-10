
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login/Register</title>
    <link rel="stylesheet" href="resources/login.css" type="text/css">
</head>
<body>
<div class="bodycontent">
<div class="wrap" align="center">
<form method="post" action="login">
<br>
    <br>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="uname" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="pass" value="" /></td>
            </tr>
            <tr>
                <td align="center"><input type="reset" value="Reset" /></td>
                <td align="center"><input type="submit" name="login" value="Login" /></td>
            </tr>
            </tbody>
        </table>
</form>
    <form method="post" action="login">

            <table border="1" width="30%" cellpadding="5">
                <thead>
                <tr>
                    <th colspan="2">Register</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Your Employee ID</td>
                    <td><input type="text" name="regid" value="" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="regemail" value="" /></td>
                </tr>
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="reguname" value="" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="regpass" value="" /></td>
                </tr>
                <tr>
                    <td align="center"><input type="reset" value="Reset" /></td>
                    <td align="center"><input type="submit" name="register" value="Submit" /></td>
                </tr>
                </tbody>
            </table>

    </form>
</div>
</div>
</body>
</html>
