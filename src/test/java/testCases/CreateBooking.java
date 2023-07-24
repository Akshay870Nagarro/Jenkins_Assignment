
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.Body;
import io.restassured.response.Response;

public class CreateBooking extends baseclass {

	@Test
	public static void createBooking() {

		Response res = httprequest.given().header("Accept", "application/json")
				.header("Content-Type", "application/json").body(Body.bodyPost()).when().post();
		Assert.assertEquals(200, res.statusCode());
		res.prettyPeek();
		log.info(res);
	}
	
}
