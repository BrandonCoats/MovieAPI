package Tests;

import org.junit.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;


import static io.restassured.RestAssured.given;
public class RegistrationTests extends FunctionalTest{

	@Test
	public void TestCreateUser() {
		JsonObject obj = new JsonObject();
		obj.addProperty("id", 1);
		obj.addProperty("email", "tog@gmail.com");
		obj.addProperty("username", "TheCaveMan");
		obj.addProperty("password", "TheFunkyChicken");
		obj.addProperty("isAdmin", false);
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "registration";
		
		String request = obj.toString();
		given()
		.contentType("application/json\r\n")
		.body(request)
		.when()
		.post(locationToHit)
		.then().statusCode(200);
	}
	
}
