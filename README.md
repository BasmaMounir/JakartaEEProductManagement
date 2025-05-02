# 🛍️ Product Manager API

This is a simple Java web project that allows you to manage products using Servlets and HTTP requests.

## 📦 Features

- Add Product
- View All Products
- Delete Product
- Update Product

## 🚀 How to Run

1. Import the project into IntelliJ.
2. Make sure Tomcat is configured and running.
3. Run the application.
4. Use Postman to test the endpoints.

## 📄 GET All Products
**Endpoint:**  
`GET http:http://localhost:8080/product-manager/product

## ➕ Add Product
**Endpoint:**  
`POST http://localhost:8080/product?name={productName},price={productPrice}`

## 🗑️ Delete Product
**Endpoint:**  
`DELETE http://localhost:8080/product?id={productId}`
**Query Parameter:**
- `id` (int): ID of the product to delete

