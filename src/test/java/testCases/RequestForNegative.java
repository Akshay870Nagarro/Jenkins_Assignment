package testCases;

import org.testng.annotations.Test;

import data.Body;
import io.restassured.response.Response;

public class RequestForNegative extends baseclass {
	@Test
	public static void createBooking() {

		Response res = httprequest.given().header("Accept", "application/json")
				.header("Content-Type", "application/json").body(Body.bodyNegativePost()).when().post();
		res.prettyPeek();
	}
}
