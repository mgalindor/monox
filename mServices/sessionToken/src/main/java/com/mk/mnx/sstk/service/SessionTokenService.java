package com.mk.mnx.sstk.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.mk.mnx.infr.constants.CommonConstants;
import com.mk.mnx.infr.service.BaseService;
import com.mk.mnx.model.domain.User;
import com.mk.mnx.sstk.repository.UserRepository;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SessionTokenService extends BaseService {

	@Autowired
	private UserRepository userRepository;

	public String creaSessionToken(String userName, String password) {
		logger.debug("USer [{}] passs [{}]",userName,password);
		User u = userRepository.findUserByUserName(userName);
		String token="";
		if (u != null) {
			String pasSalt = password+u.getSalt();
			String pass= DigestUtils.md5DigestAsHex(pasSalt.getBytes());
			
			logger.debug("md5 {}",pass);
			
			if (u.getPassword().equals(pass)) {
				if(u.getToken() == null) {
					String t = generateToken(u);
					token = t;
				}
				
				else if(u.getToken() != null) {
					try {
						Jwts.parser()
						  .setSigningKey(CommonConstants.TOKEN_PASS)
						  .parseClaimsJws(u.getToken()).getBody().getSubject();
						token = u.getToken();
					}
					catch (ExpiredJwtException e) {
						String t = generateToken(u);
						token = t;
					}catch(Exception e) {
						logger.error("Error al validar token",e);
					}
				}
			}
		}
		return token;
	}
	
	private Date generateExpiration() {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, CommonConstants.NUMBER_OF_DAYS_TOKEN_LIVE);
		return cal.getTime();
	}
	
	private String generateTokenJWT(String userName) {
		String JWT = Jwts.builder().setSubject(userName)
				.setExpiration(generateExpiration())
				.signWith(SignatureAlgorithm.HS512, CommonConstants.TOKEN_PASS).compact();
		return JWT;
	}
	
	private String generateToken(User u) {
		String t = generateTokenJWT(u.getUserName());
		u.setToken(t);
		userRepository.save(u);
		return t;
	}
	

}
