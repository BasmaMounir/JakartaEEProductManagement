package org.example.jakartaeeproductmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "productServlet", value = "/product")
public class ProductServlet extends HttpServlet {

    private static final Map<Integer, Product> products = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        Product product1 = new Product("Gaming Laptop", 1499);
        Product product2 = new Product("Wireless Bluetooth Headphones", 199);
        Product product3 = new Product("Smartphone - 128GB", 899);
        Product product4 = new Product("Smartwatch", 199);

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
        products.put(product4.getId(), product4);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (products.isEmpty()) {
            out.println("{\"message\": \"No products found.\"}");
            return;
        }

        out.println("[");
        AtomicInteger count = new AtomicInteger();
        products.forEach((id, product) -> {
            out.print("  {");
            out.print("\"id\": " + product.getId() + ", ");
            out.print("\"name\": \"" + product.getName() + "\", ");
            out.print("\"price\": " + product.getPrice());
            out.print("}");
            if (count.incrementAndGet() < products.size()) {
                out.println(",");
            } else {
                out.println();
            }
        });
        out.println("]");
    }
}