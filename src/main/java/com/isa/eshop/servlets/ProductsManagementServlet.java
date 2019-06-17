package com.isa.eshop.servlets;

import com.isa.eshop.config.TemplateProvider;
import com.isa.eshop.phones.ProductServices;
import com.isa.eshop.repository.PhonesRepository;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ProductsManagementServlet")
public class ProductsManagementServlet extends HttpServlet {


    private static final String TEMPLATE_NAME = "products-managment";

    @Inject
    TemplateProvider templateProvider;

    @EJB
    ProductServices productServices;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> model = new HashMap<>();
        model.put("product", PhonesRepository.getPhoneRepository());

        Template template = templateProvider.createTemplate(
                getServletContext(), TEMPLATE_NAME
        );

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            System.err.println("Error while processing template: " + e);
        }
    }
    }
