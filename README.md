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
`GET http://localhost:8080/product-manager/product

<img src="https://github.com/BasmaMounir/JakartaEEProductManagement/blob/development/images/get.png?raw=true" alt="Get" width="400"/>


## ➕ Add Product
**Endpoint:**  
`POST http://localhost:8080/product?name={productName},price={productPrice}`

<img src="https://github.com/BasmaMounir/JakartaEEProductManagement/blob/development/images/post.png?raw=true" alt="Add" width="400"/>

## 🗑️ Delete Product
**Endpoint:**  
`DELETE http://localhost:8080/product?id={productId}`
**Query Parameter:**
- `id` (int): ID of the product to delete
  
<img src="https://github.com/BasmaMounir/JakartaEEProductManagement/blob/development/images/delete.png?raw=true" alt="Delete" width="400"/>

## ✏️ Update Product
**Endpoint:**  
`PUT http://localhost:8080/product?id={id}&name={newName}&price={newPrice}`
**Query Parameters:**
- `id` (int): ID of the product to update
- `name` (String): New name
- `price` (int): New price
  
<img src="https://github.com/BasmaMounir/JakartaEEProductManagement/blob/development/images/update.png?raw=true" alt="Update" width="400"/>

