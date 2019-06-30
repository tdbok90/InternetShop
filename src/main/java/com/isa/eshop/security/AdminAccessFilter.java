package com.isa.eshop.security;

import com.isa.eshop.users.LoggedUserService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin","/admin/*"})
public class AdminAccessFilter implements Filter {

    private final LoggedUserService loggedUserService;

    @Inject
    public AdminAccessFilter(LoggedUserService loggedUserService) {
        this.loggedUserService = loggedUserService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!loggedUserService.getLoggedUser().isPresent()) {
            ((HttpServletResponse) response).sendRedirect("/login");
            return;
        }
        chain.doFilter(request, response);
    }
}
