package com.mk.mnx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mk.mnx.infr.constants.CommonConstants;

import io.jsonwebtoken.Jwts;

@Component
@Order(9)
public class SecurityFilter implements Filter {
	
	protected final Logger logger = LoggerFactory.getLogger(CommonConstants.LOGGER_INFRA);

	
	@Value("${requiere.session:false}")
	private Boolean REQUIRED_SESSION;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("En el filtro de seguridad , [{}]",REQUIRED_SESSION);
		if(REQUIRED_SESSION) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String tokem = httpRequest.getHeader(CommonConstants.SESSION_HTTP_HEADER);
			if (tokem == null) {
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN,"Autentication is necesary");
				return;
			}
			else {
				try {
					String user = Jwts.parser()
					.setSigningKey(CommonConstants.TOKEN_PASS)
					.parseClaimsJws(tokem).getBody().getSubject();
					logger.debug("User [{}]",user);
					HttpSession session = httpRequest.getSession(true);
					session.setAttribute(CommonConstants.SESSION_USER, user);
				}
				catch(Exception e) {
					logger.error("Error añ validar el token ",e);
					((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN,"Autentication is not  valid");
					return;
				}
			}
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException { }
	
	public void destroy() { }

}
