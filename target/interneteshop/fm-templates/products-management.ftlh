<html>
<head>
    <title>Test</title>
</head>
<body>
<p>
<h1>Moje produkty:</h1>
<#list products as product>
    <h2>Product name: ${product.model}</h2>
    <p>Product price: ${product.producer}</p>
    <p>Product UUID: ${product.id}</p>
    <a href="/products-management/${product.id}">Edit product</a>
</#list>
</p>

<p>
    <h1>Produkt wyszukany po id:</h1>
    <h2>Product name: ${mobile.model}</h2>
    <p>Product price: ${mobile.producer}</p>
    <p>Product UUID: ${mobile.id}</p>
</p>


</body>
</html>