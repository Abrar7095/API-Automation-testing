package API.endpoints;
import static io.restassured.RestAssured.given;

import API.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndpoints {

     public static Response createUser(User payload){
        	
        Response response=given()
        		
        		.contentType(ContentType.JSON)
        		.accept(ContentType.JSON)
        		.body( payload)
        	
        	.when()
        	.post(Routes.base_Url);
        
        return  response;
        	
        }

     public static Response readuser(String userName){
     	
         Response response=given()
        		.pathParam("username", userName)
         		
         	
         	.when()
         	.get(Routes.get_Url);
         
         return  response;
         	
         }

     public static Response Updateuser(String UserName , User payload){
     	
         Response response=given()
         		
         		.contentType(ContentType.JSON)
         		.accept(ContentType.JSON)
         		.pathParam("username",UserName)
         		.body( payload)
         	
         	.when()
         	.put(Routes.Update_Url);
         
         return  response;
         	
         }
     
     public static Response deleteUser(String UserName){
      	
         Response response=given()
        		.pathParam("username", UserName)
         		
         	
         	.when()
         	.delete(Routes.delete_Url);
         
         return  response;
         	
         }
     
}
