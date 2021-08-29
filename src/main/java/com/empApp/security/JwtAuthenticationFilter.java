package com.empApp.security;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.empApp.security.helper.JwtUtil;
import com.empApp.services.CustomUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//get JWT header
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		
		//bearer
		UserDetails details = null;
		//null and format
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			String msg = "";
			try {
				
				try {
					username = this.jwtUtil.getUsernameFromToken(jwtToken);
					details = this.customUserDetailsService.loadUserByUsername(username);
				}catch(ExpiredJwtException  e) {
					msg ="expired";
					
				}catch(MalformedJwtException e) {
					msg ="token is invalid";
				}catch(AccessDeniedException e) {
					msg="access denied";
				}
				
				
			} catch (Exception e) {
				System.out.println(msg);
				
				e.printStackTrace();
				
			}
			
			
			
			//System.out.println("Authority :: "+details.getAuthorities());
			//validate
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.out.println("Token is not validated");
				System.out.println(msg);
				if(msg.equals("expired")) {
					response.setContentType("application/json;charset=UTF-8");
			        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			        response.getWriter().write(new JSONObject() 
			                .put("timestamp", LocalDateTime.now())
			                .put("message", "Token is Expired please login again to generate new token")
			                .put("success", false)
			                .toString());
				}else if(msg.equals("token is invalid")) {
					response.setContentType("application/json;charset=UTF-8");
			        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			        response.getWriter().write(new JSONObject() 
			                .put("timestamp", LocalDateTime.now())
			                .put("message", "Token is invalid")
			                .put("success", false)
			                .toString());
				} 
				

			}
			
		}
		
		
		try {
			filterChain.doFilter(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
}
