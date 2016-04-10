<%@ page import="utils.ExecutePLSQL" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>

<% String name = request.getParameter("emplNoField");
    ResultSet i = ExecutePLSQL.executeQuery("SELECT * FROM EMPL WHERE EMPNO=" + name);
    String number = null;
    String eName = null;
    String job = null;
    String hireDate = null;
    String mgr = null;
    String sal = null;
    String comm = null;
    String deptNo = null;

    if (i.next()) {
        number = i.getString(1);
        eName = i.getString(2);
        job = i.getString(3);
        hireDate = i.getString(4).replace(" 00:00:00.0", "");
        mgr = i.getString(5);
        sal = i.getString(6);
        comm = i.getString(7);
        deptNo = i.getString(8);
    }

%>

<div class="bodycontent">
    <form method="post" action="">
        <h2>To edit employee <%= number %> : Enter data in fields and press "Save"</h2>
        <input type="hidden" name="emplNoF" value="<%= number %>">


        <label for="enameId">Name:</label>
        <div><input type="text" name="ename" value="<%= eName %>" size="20" id="enameId" data-validation="length"
                    data-validation-length="1-10"
                    data-validation-error-msg="Data is not valid. Please, enter 1-10 symbols."/></div>

        <label for="jobId">Job:</label>
        <div><input type="text" name="job" value="<%= job %>" size="20" id="jobId" data-validation="length"
                    data-validation-length="1-9"
                    data-validation-error-msg="Data is not valid. Please, enter 1-9 symbols."/>
        </div>

        <label for="hiredateId">Hire Date:</label>
        <div><input type="text" name="hiredate" value="<%= hireDate %>" size="20" id="hiredateId" data-validation="date"
                    data-validation-help="In Format: YYYY-MM-DD "/></div>

        <%--TODO: data validation--%>
        <label for="mgrId">Manager's Id:</label>
        <div><input type="text" name="mgr" value="<%= mgr %>" size="20" id="mgrId" data-validation="canBeNull"
                    data-validation-length="1-10"
                    data-validation-error-msg="Data is not valid. Please, enter valid numeric Manager's Id or or enter NULL"
                    data-validation-help="Enter number or NULL"/></div>
        <label for="salId">Salary:</label>
        <div><input type="text" name="sal" value="<%= sal %>" size="20" id="salId" data-validation="number"
                    data-validation-error-msg="Data is not valid. Please, enter only numbers(1-7)."/></div>

        <label for="commId">Commissions:</label>
        <div><input type="text" name="comm" value="<%= comm %>" size="20" id="commId" data-validation="canBeNull"
                    data-validation-length="1-10"
                    data-validation-error-msg="Data is not valid. Please, enter valid numeric department number or enter NULL"
                    data-validation-help="Enter number or NULL"/></div>

        <label for="deptnoId">Department Number:</label>
        <div><input type="text" name="deptno" value="<%= deptNo %>" size="20" id="deptnoId" data-validation="number"
                    data-validation-error-msg="Data is not valid. Please, enter valid numeric department number."/>
        </div>

        <input type="submit" name="RUNb" value="Save"/>
    </form>
</div>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
        src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js"></script>
<script type="text/javascript" src="resources/dataValidationConfig.js"></script>
<link href="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/theme-default.min.css" rel="stylesheet"
      type="text/css"/>
</body>
</html>
