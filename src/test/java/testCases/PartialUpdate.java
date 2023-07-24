package testCases;

import org.testng.annotations.Test;

import data.Body;
import io.restassured.response.Response;

public class PartialUpdate extends baseclass {
	
	@Test
	public static void partialUpdate() {
		Response res = httprequest.given().header("Accept", "application/json")
				.header("Content-Type", "application/json").body(Body.bodyPartialUpdate()).when().patch();
		res.prettyPeek();

	}
}
