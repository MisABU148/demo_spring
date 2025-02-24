<!DOCTYPE html>
<html lang="ru">
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Товары со всего мира</h4>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} rub. | <a href="/product/${product.id}">Подробнее...</a> </p>
    </div>
</#list>
<hr>
<h3> Create new </h3>
<form action="/product/create" method = "post">
    Name: <input type="text" name="title"/><br><br>
    Description: <input type="text" name="description"/><br><br>
    Price: <input type="number" name="price"/><br><br>
    City: <input type="text" name="city"/><br><br>
    Author: <input type="text" name="author"/><br><br>
    <input type="submit" value="Add new"/>
</form>
</body>
</html>