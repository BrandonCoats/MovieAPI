package Tests;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import Models.Actor;
import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;

import static io.restassured.RestAssured.given;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
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
		try 
		{
			String workDir =  System.getProperty("user.dir");
			workDir = workDir + "src\\main\\resources\\Images\\alienTest.jpg";
			BufferedImage imageToInput = ImageIO.read(new File(workDir));
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			ImageIO.write(imageToInput, "jpg", byteStream);
			byte[] imageBytes = byteStream.toByteArray();
			String encoded = Base64.getEncoder().encodeToString(imageBytes);
			obj.addProperty("image", encoded);
		} catch (IOException e) 
		{
			System.out.println("Failed to read bytes from image/file");
		}
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
		String locationToHit =  RestAssured.baseURI + RestAssured.basePath + "movies/poster/21";
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