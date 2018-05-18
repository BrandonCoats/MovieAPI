package Tests;

import org.junit.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
public class ActorTests extends FunctionalTest{

	@Test
	public void TestAddActor() {

		JsonObject obj = new JsonObject();
		obj.addProperty("id", 1);
		obj.addProperty("name", "Tom Hanks");
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "actors";

		String request = obj.toString();
		given()
		.contentType("application/json\r\n")
		.body(request)
		.when()
		.post(locationToHit)
		.then().statusCode(200);
	}
	
	@Test
	public void TestGetAllActors() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "actors";
		given()
		.when()
		.get(locationToHit)
		.then()
		.statusCode(200);
	}
	@Test
	public void TestGetActorById() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "actors/1";
		given()
		.when()
		.get(locationToHit)
		.then()
		.statusCode(200);
	}
	@Test
	public void DeleteActorById() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "actors/1";
		given()
		.when()
		.delete(locationToHit)
		.then()
		.statusCode(200);
	}
}