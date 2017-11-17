package ru.intodayer.servlets.servlets;

import ru.intodayer.servlets.entities.User;
import ru.intodayer.servlets.services.UserService;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            chain.doFilter(req, resp);
            return;
        }

        resp.setStatus(401);
        resp.sendRedirect("/login");
    }

    @Override
    public void destroy() {}
}
