package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ProductServlet", urlPatterns = "/product")
public class ProductServlet extends javax.servlet.http.HttpServlet {

    ProductService productService = new ProductServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");

        if(action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                createProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:break;
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");

        if(action == null) {
            action = "";
        }

        switch (action) {
            case "add":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showProductDetail(request, response);
                break;
            case "search":
                showSearchForm(request,response);
                break;
            default:
                showProductList(request, response);
                break;
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("product/list.jsp");
        try {
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("product/create.jsp");
        try {
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        this.productService.add(new Product(name, price, description));

        request.setAttribute("message", "New product was created");

        RequestDispatcher rd = request.getRequestDispatcher("product/create.jsp");
        try {
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher rd;
        if(product==null){
            rd = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("product",product);
            rd = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request,HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        Product product = this.productService.findById(id);
        RequestDispatcher rd;
        if(product == null) {
            rd = request.getRequestDispatcher("error.jsp");
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            this.productService.edit(id, product);
            request.setAttribute("message","Product was updated");
            request.setAttribute("product", product);
            rd = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = this.productService.findById(id);
        RequestDispatcher rd;
        if(product == null) {
            rd = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("product", product);
            rd = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = this.productService.findById(id);
        RequestDispatcher rd;
        if(product == null) {
            rd = request.getRequestDispatcher("error.jsp");
        } else {
            this.productService.delete(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = this.productService.findById(id);

        if(product != null) {
            request.setAttribute("product", product);
            RequestDispatcher rd = request.getRequestDispatcher("product/view.jsp");
            try {
                rd.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("product/search.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

        Product product = this.productService.findByName(name);
        RequestDispatcher rd;
        if(product != null) {
            request.setAttribute("product", product);
            rd = request.getRequestDispatcher("product/view.jsp");
        } else {
            request.setAttribute("message", "Không tìm thấy sản phẩm");
            rd = request.getRequestDispatcher("product/search.jsp");
        }
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
