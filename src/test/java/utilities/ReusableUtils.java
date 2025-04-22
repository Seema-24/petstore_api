package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import api.payload.User;

public class ReusableUtils {
	
	protected User payload;
	protected Logger logs;
	public Faker faker;
	
	@BeforeClass
	public void setup() {
		
		logs = LogManager.getLogger(this.getClass());
		payload = new User();
		faker = new Faker();
	}
	
	
	public void postData(int userID, String username, String fName, String lName, String email, String pwd, String phone) {
		
		payload.setId(userID);
		payload.setUsername(username);
		payload.setFirstname(fName);
		payload.setLastname(lName);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(phone);
	}
}
