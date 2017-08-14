package com.msk.sso.client.servlet;

import com.msk.sso.client.constant.SSORelevanceDefine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        int end = request.getRequestURL().lastIndexOf(request.getRequestURI());
        String url = request.getRequestURL().substring(0, end) + request.getContextPath();
        response.sendRedirect(SSORelevanceDefine.getCasServerLogoutUrl()+"?service="+ url +"/switch/system");
    }
}
