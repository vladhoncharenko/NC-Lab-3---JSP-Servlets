<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login/Register</title>
    <link rel="stylesheet" href="resources/login.css" type="text/css">
</head>
<body>
<%if (session.getAttribute("fail")!=null){%>
    <script>
        alert('Username,id or email is already registered!')
    </script>
<%session.setAttribute("fail",null);
}%>
<%if (session.getAttribute("loginfail")!=null){%>
<script>
    alert('Wrong username or password')
</script>
<%session.setAttribute("loginfail",null);
}%>
<%if (session.getAttribute("reg")!=null){%>
<script>
    alert('Registration successful!')
</script>
<%session.setAttribute("reg",null);
}%>
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
                <td><input type="text" name="uname" value="" data-validation="length"
                           data-validation-length="4-15" data-validation-error-msg="Minimum username length is 4 symbols"
                /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="pass" value=""  data-validation="length"
                           data-validation-length="4-20" data-validation-error-msg="Minimum password length is 4 symbols"
                /></td>
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
                    <td><input type="text" name="regid" value="" data-validation="number"
                               data-validation-error-msg="Data is not valid. Please, enter only numbers."/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="regemail" value="" data-validation='email'/></td>
                </tr>
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="reguname" value=""
                               data-validation="length"
                               data-validation-length="4-15" data-validation-error-msg="Minimum username length is 4 symbols"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="regpass" value=""
                               data-validation="length"
                               data-validation-length="4-20" data-validation-error-msg="Minimum password length is 4 symbols"
                    /></td>
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
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
        src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js"></script>
<script type="text/javascript" src="resources/dataValidationConfig.js"></script>
<link href="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/theme-default.min.css" rel="stylesheet"
      type="text/css"/>
</body>
</html>
