package com.insper.user.common;

import com.insper.user.user.LoginService;
import com.insper.user.user.UserService;
import com.insper.user.user.dto.ReturnUserDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
public class LoginFilter implements Filter {

    @Autowired
    private LoginService loginService;

    List<String> openPostRoutes = Arrays.asList("/login");

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String token = req.getHeader("token");

        String uri = req.getRequestURI();
        String method = req.getMethod();

        if (method.equals("OPTIONS")) {
            chain.doFilter(request, response);
        } else if (method.equals("POST") && openPostRoutes.contains(uri)) {
            chain.doFilter(request, response);
        } else  if (method.equals("GET") && uri.contains("/token")) {
            chain.doFilter(request, response);
        } else {
            ReturnUserDTO user = loginService.get(token);
            if (user != null) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "O token informado é inválido");
            }
        }

    }

}