package com.isa.eshop.phones;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@WebServlet("/addPhoneServlet")
public class addPhoneServlet extends HttpServlet {
    @Inject
    ProductServices productServices;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        UUID id = UUID.randomUUID();

        final String producer = req.getParameter("producer");
        final String model = req.getParameter("model");
        final BigDecimal price = new BigDecimal(req.getParameter("price"));
        final BigDecimal screen = new BigDecimal(req.getParameter("scrren"));
        final ProductStatus status = ProductStatus.valueOf(req.getParameter("status"));
        final Boolean promoted = Boolean.valueOf(req.getParameter("promoted"));
        LocalDateTime dateTime = LocalDateTime.now();

        Phone phone = Phone.builder()
                .producer(producer)
                .model(model)
                .price(price)
                .scrren(screen)
                .status(status)
                .isPromoted(promoted)
                .createData(dateTime)
                .id(id).build();


        productServices.addPhone(phone);

        resp.sendRedirect("/showAllPhonsServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
