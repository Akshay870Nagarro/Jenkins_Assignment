package testCases;

import org.testng.annotations.Test;

import data.Body;
import io.restassured.response.Response;

public class UpdateBooking extends baseclass {
	@Test
	public static void updateBooking() {
		Response res = httprequest.given().header("Accept", "application/json")
				.header("Content-Type", "application/json").body(Body.bodyUpdate()).when().put();
		res.prettyPeek();
	}
}
