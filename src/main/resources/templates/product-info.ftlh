<!DOCTYPE html>
<html lang="ru">
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Information about products</h4>
<b>Name of product: </b>${product.title}<br>
<b>Description of product: </b>${product.description}<br>
<b>Price of product: </b>${product.price}<br>
<b>City development: </b>${product.city}<br>
<b>Author of product: </b>${product.author}<br>
<hr>
<h3> Create new </h3>
<form action="/product/delete/${product.id}" method = "post">
    <input type="submit" value="Delete product"/>
</form>
</body>
</html>