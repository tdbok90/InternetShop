<h1>Moje produkty:</h1>
<h2>${productService.getIdentifier()}</h2>
<#list products as product>
    <h2>Product name: ${product.name}</h2>
    <p>Product price: ${product.price}</p>
    <a href="/products-management/${product.id}">Edit product</a>
</#list>