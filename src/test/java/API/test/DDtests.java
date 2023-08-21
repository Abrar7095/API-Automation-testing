package API.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import API.endpoints.UserEndpoints;
import API.payload.User;
import API.utilities.DataProviders;
import io.restassured.response.Response;

public class DDtests {

	@Test(priority=1,dataProvider="Data", dataProviderClass=DataProviders.class )
	public void testPostuser(String userID,String username ,String fname,String lname,String userEmail,String pwd,String ph) {
		
		User userPayload= new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
	
		Response response = UserEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200,404);
		
	}
	
	@Test(priority=1,dataProvider="UserNames", dataProviderClass=DataProviders.class )
	public void testDeleteuserByName(String userName) {
		
		Response response= UserEndpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200,404);
	}
	
	
}
