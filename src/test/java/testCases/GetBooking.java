package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetBooking extends baseclass {
	@Test
	public static void getBooking() {

		Response res = httprequest.given().when().get();
		Assert.assertEquals(200, res.statusCode());
		res.prettyPeek();
	}
}
