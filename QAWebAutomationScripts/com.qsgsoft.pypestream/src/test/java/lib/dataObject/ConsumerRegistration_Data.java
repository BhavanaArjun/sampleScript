package lib.dataObject;

import java.util.Random;

public class ConsumerRegistration_Data {

	public String randomString() {
		char[] chars = "123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	long ph = System.currentTimeMillis();

	// int intPh = (int) ph;
	String strPh = Long.toString(ph);
	String phoneNumber = strPh.substring(10);

	public final String phoneNumberData = randomString(),
			// countryCodeData = "+91",
			code = "990000", 
			firstname = "FN" + System.currentTimeMillis(),
			lastname = "LN" + System.currentTimeMillis(), 
			etemp = strPh.substring(3), 
			emailId = "ab" + etemp + "@yopmail.com",
			password = "pass@123",			
			confirmPassword = "pass@123";
}
