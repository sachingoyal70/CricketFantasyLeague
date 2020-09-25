package in.sachin.cricket.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
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

	public static List<String> convertArrayToList(String[] array) {
		List<String> intList = new ArrayList<String>(array.length);
		for (String i : array) {
			intList.add(i);
		}
		return intList;

	}

	public static String getUniquekey() {
		return UUID.randomUUID().toString();
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

	public static boolean validateDate() {
		boolean isValid = false;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date cflStartDate = sdf.parse(CommonConstants.TEAM_REGISTRATION_CLOSE_DATE);

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			sd.setTimeZone(TimeZone.getTimeZone("IST"));

			Date currentDate = sdf.parse(sd.format(new Date()));

			if (currentDate.before(cflStartDate)) {
				isValid = true;
			} else if (currentDate.equals(cflStartDate) && isModificationAllowed()) {
				isValid = true;
			} else {
				isValid = false;
			}
		} catch (Exception e) {

		}

		return isValid;
	}

	public static boolean isModificationAllowed() throws ParseException {

		boolean valid = false;

		SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
		sd.setTimeZone(TimeZone.getTimeZone("IST"));

		Date date = new Date();

		// Start Time
		Date inTime = new SimpleDateFormat("HH:mm:ss").parse(CommonConstants.TEAM_REGISTRATION_CLOSE_TIME);

		// Current Time
		Date checkTime = new SimpleDateFormat("HH:mm:ss").parse(sd.format(date));

		if (checkTime.before(inTime)) {
			valid = true;
		}

		return valid;
	}

	public static boolean isValidateModificationDate() {
		boolean isValid = false;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date cflStartDate = sdf.parse(CommonConstants.TEAM_MODIFICATION_START_DATE);

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			sd.setTimeZone(TimeZone.getTimeZone("IST"));

			Date currentDate = sdf.parse(sd.format(new Date()));

			if (currentDate.after(cflStartDate) && isValidateModificationTime()) {
				isValid = true;
			} else {
				isValid = false;
			}
		} catch (Exception e) {

		}

		return isValid;
	}

	public static boolean isValidateModificationTime() throws ParseException {

		boolean valid = false;

		SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
		sd.setTimeZone(TimeZone.getTimeZone("IST"));

		Date date = new Date();

		// Start Time
		Date inTime = new SimpleDateFormat("HH:mm:ss").parse(CommonConstants.TEAM_MODIFICATION_START_TIME);

		// End Time
		Date outTime = new SimpleDateFormat("HH:mm:ss").parse(CommonConstants.TEAM_MODIFICATION_END_TIME);

		// Current Time
		Date checkTime = new SimpleDateFormat("HH:mm:ss").parse(sd.format(date));

		if (checkTime.after(inTime) && checkTime.before(outTime)) {
			valid = true;
		}

		return valid;
	}

	public static String getDate() throws ParseException {
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("IST"));
		return format.format(new Date());
	}

}