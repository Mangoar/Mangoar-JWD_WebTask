package com.example.WebAppPayments.filter;

import com.example.WebAppPayments.controller.command.Attribute;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName ="LanguageFilter", urlPatterns = {("/*")})
public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String language = (String) session.getAttribute(Attribute.LANGUAGE);
        if (language == null) {
            language = Attribute.LANGUAGE_US;
            session.setAttribute(Attribute.LANGUAGE, language);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void destroy() {

    }
}
