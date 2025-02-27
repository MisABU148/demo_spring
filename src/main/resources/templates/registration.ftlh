<!DOCTYPE html>
<html lang="ru">
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Registration</h4>
<form action="/registration" method = "post">
    User name: <input type="text" name="name"/><br><br>
    Email: <input type="email" name="email"/><br><br>
    Phone no.: <input type="text" name="numberPhone"/><br><br>
    Password: <input type="password" name="password"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/><br><br>
    <input type="submit" value="Sign up"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>
