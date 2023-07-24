package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ForGettingID extends baseclass {
	@Test
	public static void getBookingID() {

		Response res = httprequest.given().when().get();
		Assert.assertEquals(200, res.statusCode());
		res.prettyPeek();

	}
	
	

}