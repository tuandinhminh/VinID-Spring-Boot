package com.example.demo.config;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    Calendar calendar = Calendar.getInstance();
    String jsonString = new JSONObject()
            .put("timestamp",calendar.getTime())
            .put("code", 1)
            .put("message", "that bai")
            .toString();

    public CustomAuthenticationEntryPoint() throws JSONException {
    }

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException)
            throws IOException, ServletException {
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.getWriter().write(jsonString);
//        res.getWriter().write(JsonBuilder //my util class for creating json strings
//                .put("timestamp", DateGenerator.getDate())
//                .put("status", 403)
//                .put("message", "Access denied")
//                .build());
//        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "XAC THUC KHONG THANH CONG");
    }
}