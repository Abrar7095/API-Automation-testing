package API.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import API.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndpoints2 {
   // Method created for getting URL'sFrom properties file
   static ResourceBundle getURL(){
		
	ResourceBundle	routes=ResourceBundle.getBundle("routes"); // load properties file
     return routes;		
		
	}
	
	
	
	
	
	
	
     public static Response createUser(User payload){
       
    	String  post_Url= getURL().getString("post_Url");
    	 
    	 
        Response response=given()
        		
        		.contentType(ContentType.JSON)
        		.accept(ContentType.JSON)
        		.body( payload)
        	
        	.when()
        	.post( post_Url);
        
        return  response;
        	
        }

     public static Response readuser(String userName){
     	
    	 String get_Url = getURL().getString("get_Url");
    	 
         Response response=given()
        		.pathParam("username", userName)
         		
         	
         	.when()
         	.get(get_Url );
         
         return  response;
         	
         }

     public static Response Updateuser(String UserName , User payload){
     	
    	 String Update_Url = getURL().getString("Update_Url");
    	 
         Response response=given()
         		
         		.contentType(ContentType.JSON)
         		.accept(ContentType.JSON)
         		.pathParam("username",UserName)
         		.body( payload)
         	
         	.when()
         	.put( Update_Url);
         
         return  response;
         	
         }
     
     public static Response deleteUser(String UserName){
      	
    	 
    	 String delete_Url = getURL().getString("delete_Url");
    	 
         Response response=given()
        		.pathParam("username", UserName)
         		
         	
         	.when()
         	.delete( delete_Url);
         
         return  response;
         	
         }
     
}
