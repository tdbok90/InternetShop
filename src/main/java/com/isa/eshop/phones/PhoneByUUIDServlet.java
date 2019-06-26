package com.isa.eshop.phones;

import com.isa.eshop.config.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.logging.Logger;

@WebServlet("/PhoneByUUIDServlet")
public class PhoneByUUIDServlet extends HttpServlet {

    @EJB
    ProductServices productServices;

    Logger logger = Logger.getLogger(getClass().getName());

    private static final String TEMPLATE_NAME = "products-management";



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("Content-Type", "text/html; charset=utf-8");
        Phone phone = productServices.getPhoneByUUID(productServices.getPhoneList().get(1).getId());

        Map<String, Object> model = new HashMap<>();
        model.put("mobile",phone);

        Template template = TemplateProvider.createTemplate(
                getServletContext(), TEMPLATE_NAME
        );

        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            System.err.println("Error while processing template: " + e);
        }


    }
}
