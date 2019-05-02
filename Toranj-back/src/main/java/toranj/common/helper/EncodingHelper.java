package toranj.common.helper;

import java.util.Base64;

import toranj.login.domain.User;

public class EncodingHelper {
	
	public User decodeValues(String token) {
		byte[] decodedBytes = Base64.getDecoder().decode(token);
		String decodedValues = new String(decodedBytes);
		String[] valuesSplit = decodedValues.split("\\|");
		User user = new User();
		user.setId(Integer.parseInt(valuesSplit[1]));
		user.setUserName(valuesSplit[2]);
		user.setPassword(valuesSplit[3]);
		user.setSession(token);
		return user;
	}
	
	public String encodeValues(User user) {
		String random1 = getRandomNum();
		String random2 = getRandomNum();
		return Base64.getEncoder().encodeToString((random1 + "|" +user.getId() + "|" + user.getUserName() + "|" + user.getPassword() + "|" + random2).getBytes());
	}
	
	private String getRandomNum() {
		String randomNum = "";
		for(int i=0; i<5; i++) {
			randomNum += String.valueOf((int)(Math.random() * 8 + 1));
		}
		return randomNum;
	}

}
