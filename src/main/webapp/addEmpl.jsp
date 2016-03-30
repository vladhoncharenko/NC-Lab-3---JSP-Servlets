<%--
 View of add Employee Servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<form method="post" action="/lab3/employeeadd">
    <h2>To add new department: Enter data in fields and press "Add"</h2>

    <label for="enameId">Name:</label>
    <div><input type="text" name="ename" value="" size="20" id="enameId" data-validation="length"
                data-validation-length="1-10"
                data-validation-error-msg="Data is not valid. Please, enter 1-10 symbols."/></div>

    <label for="jobId">Job:</label>
    <div><input type="text" name="job" value="" size="20" id="jobId" data-validation="length"
                data-validation-length="1-9" data-validation-error-msg="Data is not valid. Please, enter 1-9 symbols."/>
    </div>

    <label for="hiredateId">Hire Date:</label>
    <div><input type="text" name="hiredate" value="" size="20" id="hiredateId" data-validation="date"
                data-validation-help="In Format: YYYY-MM-DD "/></div>

    <label for="mgrId">Manager's Id:</label>
    <div><input type="text" name="mgr" value="" size="20" id="mgrId" data-validation="canBeNull"
                data-validation-length="1-10"
                data-validation-error-msg="Data is not valid. Please, enter valid numeric Manager's Id or or enter NULL"
                data-validation-help="Enter number or NULL"/></div>

    <label for="salId">Salary:</label>
    <div><input type="text" name="sal" value="" size="20" id="salId" data-validation="number"
                data-validation-error-msg="Data is not valid. Please, enter only numbers."/></div>

    <label for="commId">Commissions:</label>
    <div><input type="text" name="comm" value="" size="20" id="commId" data-validation="canBeNull"
                data-validation-length="1-10"
                data-validation-error-msg="Data is not valid. Please, enter valid numeric department number or enter NULL"
                data-validation-help="Enter number or NULL"/></div>

    <label for="deptnoId">Department Number:</label>
    <div><input type="text" name="deptno" value="" size="20" id="deptnoId" data-validation="number"
                data-validation-error-msg="Data is not valid. Please, enter valid numeric department number."/></div>

    <input type="submit" name="RUNb" value="Add"/>
</form>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
        src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js"></script>
<script type="text/javascript" src="resources/dataValidationConfig.js"></script>
<link href="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/theme-default.min.css" rel="stylesheet"
      type="text/css"/>
</body>
</html>
