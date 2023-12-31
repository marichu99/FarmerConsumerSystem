package com.servlet.filter;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpRequest.getSession();

        String servletPath = httpRequest.getServletPath();

        if (httpSession.isNew()) {
            httpSession.invalidate();

            if (servletPath.equals("/login") || servletPath.equals("/index.jsp") || servletPath.equals("/sign") || servletPath.equals("/rest")
                    || servletPath.contains("/css/") || servletPath.contains("/js/") || servletPath.contains("/forgot")) {
                filterChain.doFilter(servletRequest, servletResponse);

            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                servletResponse.getWriter().flush();

            }

        } else {
            if (StringUtils.isNotBlank((String) httpSession.getAttribute("loggedInId"))) {
                httpResponse.addHeader("AuthTime", DateFormat.getDateTimeInstance().format(new Date()));
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                if (servletPath.equals("/index.jsp") || servletPath.equals("/login") || servletPath.equals("/sign")
                        || servletPath.equals("/") || servletPath.contains("/css/") || servletPath.contains("/images/") || servletPath.equals("/rest")
                        || servletPath.contains("/js/") || servletPath.contains("/forgot")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                    servletResponse.getWriter().flush();
                }
            }
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}