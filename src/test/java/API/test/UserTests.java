package API.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import API.endpoints.UserEndpoints;
import API.payload.User;
import io.restassured.response.Response;

public class UserTests {
    Faker faker;
    User userpayload;
	
    public Logger logger;
    
	@BeforeClass
	public void setup() {
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		// logs
		logger= LogManager.getLogger(this.getClass());
		logger.debug("debugging....");
	}
	@Test(priority = 1)
	public void testPostUser() {

		logger.info("********** Creating User **********");
		
		Response response =	UserEndpoints.createUser( userpayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 404,200);
	
	logger.info("**********  User is created **********");
	}
	
	@Test(priority=2)
	public void testGetUserByNAme() {
		logger.info("********** reading User Info **********");
		
		Response response = UserEndpoints.readuser(this.userpayload.getUsername());
    response.then().log().all();
    Assert.assertEquals(response.getStatusCode(), 404,200);
	
    logger.info("********** User is displayed **********");
	}
	
	@Test(priority = 3)
	public void testUpdateUserByName() {
	
		  logger.info("********** Updating user **********");
		
		// update data using payload 
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response =	UserEndpoints.Updateuser(this.userpayload.getUsername(),userpayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200,404);
		
		// checking data after update
		Response responseAfterupdate = UserEndpoints.readuser(this.userpayload.getUsername());
	    Assert.assertEquals(responseAfterupdate.getStatusCode(), 200);
	    
	    logger.info("********** user is updated **********");
	}
	@Test(priority=4)
	public void testDeleteUserByName( ) {
		
		 logger.info("********** deleting user **********");
	Response response=	UserEndpoints.deleteUser(this.userpayload.getUsername()); 
		 Assert.assertEquals(response.getStatusCode(), 200,404);
		 logger.info("********** user is deleted **********");
	
	}
	
	
}
