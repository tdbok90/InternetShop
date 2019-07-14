package com.isa.eshop.phones;

import com.isa.eshop.config.TemplateProvider;
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
import java.util.UUID;

@WebServlet("/findPhoneByUUIDServlet")
public class FindPhoneByUUIDServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "findByUUID";

    @EJB
    ProductServices productServices;
    @Inject
    TemplateProvider templateProvider;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UUID id = UUID.fromString(req.getParameter("id"));

        Phone phone = productServices.getPhoneByUUID(id);

        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Map<String, Object> model = new HashMap<>();
        model.put("mobile", phone);

        Template template = templateProvider.getTemplate(
                getServletContext(), TEMPLATE_NAME
        );

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            System.err.println("Error while processing template: " + e);
        }

        resp.setStatus(HttpServletResponse.SC_FOUND);


    }
}
