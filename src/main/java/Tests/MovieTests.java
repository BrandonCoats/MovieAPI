package Tests;

import org.junit.Test;

import com.google.gson.JsonObject;

import Models.Actor;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.List;
public class MovieTests extends FunctionalTest{

	@Test
	public void TestAddMovie() {

		JsonObject obj = new JsonObject();
		obj.addProperty("id", 1);
		obj.addProperty("genre", "Horror");
		obj.addProperty("description", "Alien");
		obj.addProperty("poster", "SomeURL");
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies";

		String request = obj.toString();
		given()
		.contentType("application/json\r\n")
		.body(request)
		.when()
		.post(locationToHit)
		.then().statusCode(200);
	}
	
	@Test
	public void TestGetAllMovies() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies";
		given()
		.when()
		.get(locationToHit)
		.then()
		.statusCode(200);
	}
	@Test
	public void TestGetMovieById() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies/1";
		given()
		.when()
		.get(locationToHit)
		.then()
		.statusCode(200);
	}
	@Test
	public void TestUpdateMovieById() {
		JsonObject obj = new JsonObject();
		obj.addProperty("id", 1);
		obj.addProperty("genre", "Horror");
		obj.addProperty("description", "Alien");
		obj.addProperty("poster", "SomeNewURL");
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies";
		String request = obj.toString();
		given()
		.contentType("application/json\r\n")
		.body(request)
		.when()
		.put(locationToHit)
		.then()
		.statusCode(200);
	}
	@Test
	public void DeleteMovieById() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies/1";
		given()
		.when()
		.delete(locationToHit)
		.then()
		.statusCode(200);
	}
}