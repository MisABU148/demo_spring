<!DOCTYPE html>
<html lang="ru">
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL | <a href="/login">Log in</a></h1><hr>
<h4>Products from whole world!</h4>
<form action="/" method="get">
    Search by title: <input type="text" name="title"><br>
    <input type="submit" value="Search...">
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} rub. | <a href="/product/${product.id}">Details...</a> </p>
    </div>
    <#else>
    <h3>No products</h3>
</#list>
<hr>
<h3> Create new </h3>
<form action="/product/create" method = "post" enctype="multipart/form-data">
    Name: <input type="text" name="title"/><br><br>
    Description: <input type="text" name="description"/><br><br>
    Price: <input type="number" name="price"/><br><br>
    City: <input type="text" name="city"/><br><br>
    Author: <input type="text" name="author"/><br><br>

    First picture: <input type="file" name="file1"/><br><br>
    Second picture: <input type="file" name="file2"/><br><br>
    Third picture: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Add new"/>
</form>
</body>
</html>