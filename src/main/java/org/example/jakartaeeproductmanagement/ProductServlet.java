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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        Product product = new Product(name, price);
        products.put(product.getId(), product);
        if (name == null || name.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("{\"error\": \"Name cannot be empty\"}");
            return;
        }
        if (price < 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("{\"error\": \"Price cannot be negative\"}");
            return;
        }else
        {response.setContentType("application/json");
            response.getWriter().println("{\"message\": \"✅ Product Added!, ID: " + product.getId()+"\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product removed = products.remove(id);

        response.setContentType("application/json");
        if (removed != null) {
            response.getWriter().println("{\"message\": \"✅ Product with ID " + id + " deleted.\"}");
        } else {
            response.getWriter().println("{\"message\": \"❌ Product not found.\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        Product product = products.get(id);

        response.setContentType("application/json");

        if (product == null) {
            response.getWriter().println("{\"message\": \"❌ Product not found.\"}");
            return;
        }

        product.setName(name);
        product.setPrice(price);
        response.getWriter().println("{\"message\": \"✅ Product updated,ID: " + id+"\"}");
    }
}