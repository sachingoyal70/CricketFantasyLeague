package in.sachin.cricket.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.text.RandomStringGenerator;

import in.sachin.cricket.entity.CFLTeam;
import in.sachin.cricket.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class CommonUtils {

	public static List<Integer> convertArrayToList(int[] array) {
		List<Integer> intList = new ArrayList<Integer>(array.length);
		for (int i : array) {
			intList.add(i);
		}
		return intList;

	}

	public static int getTeamStatus(CFLTeam team) {
		int teamStatus = CommonConstants.TEAM_NOT_SELECTED;
		if (team != null) {
			teamStatus = CommonConstants.TEAM_SELECTED;
			if (team.getTeamEnabled() == CommonConstants.TEAM_ENABLED) {
				teamStatus = CommonConstants.TEAM_APPROVED;
			}
		}
		return teamStatus;
	}

	public static boolean isTokenExpired(String token) {
		boolean isExpired = true;
		try {
			Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECURITY_KEY).parseClaimsJws(token).getBody();
			Date expDate = claims.getExpiration();
			isExpired = expDate.before(new Date());
		} catch (Exception e) {

		}
		return isExpired;
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

	public static String generateCommonTextPassword() {
		String pwString = generateRandomSpecialCharacters(2).concat(generateRandomNumbers(2))
				.concat(generateRandomAlphabet(2, true)).concat(generateRandomAlphabet(2, false))
				.concat(generateRandomCharacters(2));
		List<Character> pwChars = pwString.chars().mapToObj(data -> (char) data).collect(Collectors.toList());
		Collections.shuffle(pwChars);
		String password = pwChars.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
		return password;
	}

	public static String generateRandomNumbers(int length) {
		RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(48, 57).build();
		return pwdGenerator.generate(length);
	}

	public static String generateRandomSpecialCharacters(int length) {
		RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(33, 45).build();
		return pwdGenerator.generate(length);
	}

	public static String generateRandomCharacters(int length) {
		RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(48, 57).build();
		return pwdGenerator.generate(length);
	}

	public static String generateRandomAlphabet(int length, boolean lowerCase) {
		int low;
		int hi;
		if (lowerCase) {
			low = 97;
			hi = 122;
		} else {
			low = 65;
			hi = 90;
		}
		RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(low, hi).build();
		return pwdGenerator.generate(length);
	}

	public static String upperCaseFirst(String value) {

		// Convert String to char array.
		char[] array = value.toLowerCase().toCharArray();
		// Modify first element in array.
		array[0] = Character.toUpperCase(array[0]);
		// Return string.
		return new String(array);
	}

}