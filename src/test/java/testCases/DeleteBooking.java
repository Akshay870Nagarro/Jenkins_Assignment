package testCases;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteBooking extends baseclass {
	@Test
	public static void deleteBooking() {

		Response res = httprequest.given().header("Accept", "application/json")
				.header("Content-Type", "application/json").when().delete();
		res.prettyPeek();
	}
}
