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
		obj.addProperty("title", "Alien");
		obj.addProperty("posterId", 9);
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
	public void TestAddPosterToMovie() {

		JsonObject obj = new JsonObject();
		obj.addProperty("id", 1);
		obj.addProperty("title", "Alien");
		obj.addProperty("image", "http://www.nounsite.com/wp-content/uploads/2017/05/A-on-a-test-1.jpg");
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies/poster/21";

		String request = obj.toString();
		given()
		.contentType("application/json\r\n")
		.body(request)
		.when()
		.post(locationToHit)
		.then().statusCode(200);
	}
	@Test
	public void TestGetPosterById() {
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies/poster/9";
		given()
		.when()
		.get(locationToHit)
		.then()
		.statusCode(200);
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
		obj.addProperty("id", 9);
		obj.addProperty("genre", "Horror");
		obj.addProperty("title", "Alien");
		obj.addProperty("posterId", 1);
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
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies/8";
		given()
		.when()
		.delete(locationToHit)
		.then()
		.statusCode(200);
	}
}