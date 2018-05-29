package Tests;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
public class UserTests extends FunctionalTest{

	@Test
	public void TestAddUser() {
		JsonObject obj = new JsonObject();
		obj.addProperty("id", 1);
		obj.addProperty("email", "tog@gmail.com");
		obj.addProperty("username", "TheCaveMan");
		obj.addProperty("password", "TheFunkyChicken");
		obj.addProperty("isAdmin", false);
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "users";
		
		String request = obj.toString();
		given()
		.contentType("application/json\r\n")
		.body(request)
		.when()
		.post(locationToHit)
		.then().statusCode(200);
	}
	@Test
	public void TestUpdateUserById() {
		JsonObject obj = new JsonObject();
		obj.addProperty("id", 2);
		obj.addProperty("email", "tog@gmail.com");
		obj.addProperty("username", "TheCaveMan");
		obj.addProperty("password", "TheFunkyChicken");
		obj.addProperty("isAdmin", false);
		String request = obj.toString();
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "users";
		given()
		.contentType("application/json\r\n")
		.body(request)
		.when()
		.put(locationToHit)
		.then()
		.statusCode(200);
	}
	@Test
	public void TestGetAllUsers() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "users";
		given()
		.when()
		.get(locationToHit)
		.then()
		.statusCode(200);
	}
	@Test
	public void TestGetUserById() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "users/2";
		given()
		.when()
		.get(locationToHit)
		.then()
		.statusCode(200);
	}
	@Test
	public void DeleteUserById() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "users/1";
		given()
		.when()
		.delete(locationToHit)
		.then()
		.statusCode(200);
	}
}