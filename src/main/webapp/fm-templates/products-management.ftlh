<html>
<head>
    <title>Test</title>
</head>
<body>
<p>
<h1>Moje produkty:</h1>
<#list products as product>
    <h2>Product name: ${product.model}</h2>
    <p>Product price: ${product.price}</p>
    <p>Product UUID: ${product.id}</p>
    <a href="/products-management/${product.id}">Edit product</a>
</#list>
</p>

</body>
</html>