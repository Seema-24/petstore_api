package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;
import utilities.DataProviders;
import utilities.ReusableUtils;

public class DataDrivenTests extends ReusableUtils {
	
	

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID, String username, String fName, String lName, String email, String pwd, String phone) {
		
		logs.info("************** Reading User : "+userID+" Info ********************");
		
//		User userPayload = new User();
//		
//		userPayload.setId(Integer.parseInt(userID));
//		userPayload.setUsername(username);
//		userPayload.setFirstname(fName);
//		userPayload.setLastname(lName);
//		userPayload.setEmail(email);
//		userPayload.setPassword(pwd);
//		userPayload.setPhone(phone);
		
		postData(Integer.parseInt(userID), username, fName, lName, email, pwd, phone);
			
		Response response = UserEndPoints.createUser(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2, dataProvider = "Usernames", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {
		
		logs.info("************************** Deleting User Info *******************");
		Response response = UserEndPoints.deleteUser(username);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
