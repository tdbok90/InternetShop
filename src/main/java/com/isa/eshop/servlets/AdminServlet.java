package com.isa.eshop.servlets;

import com.isa.eshop.config.TemplateProvider;
import com.isa.eshop.users.LoggedUserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    private static final String TEMPLATE_NAME = "index";

    @Inject
    private TemplateProvider templateProvider;

    private final LoggedUserService loggedUserService;

    @Inject
    public AdminServlet(LoggedUserService loggedUserService) {
        this.loggedUserService = loggedUserService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> model = new HashMap<>();
        model.put("content", "admin");

        Template template = templateProvider.getTemplate(
                getServletContext(), TEMPLATE_NAME
        );

        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            System.err.println("Error while processing template: " + e);
        }
    }
}