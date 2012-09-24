/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.larsdan.sshop;

import edu.chl.hajo.shop.core.Product;
import edu.chl.hajo.shop.core.Shop;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xclose
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionParam = request.getParameter("action");
        if (actionParam.equals("add")) {
            Shop.INSTANCE.getProductCatalogue().add(new Product(request.getParameter("name"),
                    Double.parseDouble(request.getParameter("price"))));
            response.sendRedirect("products.jspx");
            
        } else if (actionParam.equals("edit")) {
            
            if (request.getParameter("name") == null) {
                Product prod = Shop.INSTANCE.getProductCatalogue().find(
                        Long.parseLong(request.getParameter("id")));
                request.setAttribute("prod", prod);
                request.getRequestDispatcher("editProduct.jspx").forward(request, response);
            } else {
                Shop.INSTANCE.getProductCatalogue().update(new Product(
                        Long.parseLong(request.getParameter("id")),
                        request.getParameter("name"),
                        Double.parseDouble(request.getParameter("price"))));
                response.sendRedirect("products.jspx");
            }
        } else if (actionParam.equals("delete")) {
            if (request.getParameter("name") == null) {
                Product prod = Shop.INSTANCE.getProductCatalogue().find(
                        Long.parseLong(request.getParameter("id")));
                request.setAttribute("prod", prod);
                request.getRequestDispatcher("deleteProduct.jspx").forward(request, response);
            } else {
                Shop.INSTANCE.getProductCatalogue().remove(
                        Long.parseLong(request.getParameter("id")));
                response.sendRedirect("products.jspx");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
