package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import io.restassured.response.Response;
import utilities.ReusableUtils;

public class UserTest2 extends ReusableUtils{

	//Faker faker = new Faker();
	//User userPayload;
	
	@Test(priority = 1)
	public void testPostUser() throws InterruptedException {

//		userPayload = new User();
//		
//		userPayload.setId(faker.idNumber().hashCode());
//		userPayload.setUsername(faker.name().username());
//		userPayload.setFirstname(faker.name().firstName());
//		userPayload.setLastname(faker.name().lastName());
//		userPayload.setEmail(faker.internet().emailAddress());
//		userPayload.setPassword(faker.internet().password());
//		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		postData(
				faker.idNumber().hashCode(),
				faker.name().username(),
				faker.name().firstName(),
				faker.name().lastName(),
				faker.internet().emailAddress(),
				faker.internet().password(),
				faker.phoneNumber().cellPhone()
		);
		
		logs.info("************** Creating User Info ********************");
		Response response = UserEndPoints2.createUser(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Thread.sleep(2000);
		logs.info("************** User Created ********************");
	}
	
	@Test(priority = 2)
	public void testReadUser() {
		logs.info("************** Reading User Info ********************");
		Response response = UserEndPoints2.readUser(this.payload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		logs.info("************** Updating User Info ********************");
		
		//update data using payload
		payload.setFirstname(faker.name().firstName());
		payload.setLastname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints2.updateUser(this.payload.getUsername(), payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logs.info("************** Updated User Info ********************");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		logs.info("************** Deleting User Info ********************");
		
		Response response = UserEndPoints2.deleteUser(this.payload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logs.info("************** Deleted User Info ********************");
	}
}
