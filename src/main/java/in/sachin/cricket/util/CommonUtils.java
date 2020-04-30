package in.sachin.cricket.util;

import java.util.Date;

import in.sachin.cricket.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class CommonUtils {

	public static boolean isTokenExpired(String token) {
		Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECURITY_KEY).parseClaimsJws(token).getBody();
		Date expDate = claims.getExpiration();
		return expDate.before(new Date());
	}

	public static String generateToken(String id) {
		return Jwts.builder().setSubject(id)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECURITY_KEY).compact();
	}

	public static boolean isValidToken(String token, String dbToken) {
		boolean isValidToken = false;
		if (token != null && token.equals(dbToken) && !isTokenExpired(token)) {
			isValidToken = true;
		}

		return isValidToken;

	}

}