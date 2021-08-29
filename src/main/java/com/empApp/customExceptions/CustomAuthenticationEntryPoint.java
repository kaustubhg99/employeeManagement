package com.empApp.customExceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException authException) throws IOException, ServletException {
		/*
		 * JSONObject jo = new JSONObject(); jo .put("timestamp", new Date())
		 * .put("status", 403) .put("message", "Access denied");
		 * 
		 * res.setContentType("application/json;charset=UTF-8"); res.setStatus(403);
		 * res.getWriter().write(jo.toString()); System.out.println(jo);
		 */
		/*
		 * res.setContentType("application/json;charset=UTF-8"); res.setStatus(403);
		 * PrintWriter writer = res.getWriter(); writer.println("HTTP Status 401 - " +
		 * authException.getMessage());
		 */
		
		throw new UserNotExistException("You dont have access", false);
	}

}
