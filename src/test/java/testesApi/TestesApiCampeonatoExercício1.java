package testesApi;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import org.junit.Test;

import io.restassured.RestAssured;

public class TestesApiCampeonatoExercício1 {

	@Test
	public void testePortalDoCampeonato1() {

		RestAssured.useRelaxedHTTPSValidation();
		String token = "Bearer test_eade22cb669bacd6633dd23635cf65";

		Map<String, String> headerMap = new HashMap<>();
		String url = "https://api.api-futebol.com.br/v1/campeonatos";
		headerMap.put("Authorization", token);

		given()
				.headers(headerMap)
				.log().all()
				.when()
				.get(url)
				.then().assertThat()
				.log().all()
				.statusCode(200)
				.body(containsString("Campeonato Brasileiro"));

	}

}
