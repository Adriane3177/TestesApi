package testesApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestesApiCampeonatoExercício3 {

	@Test
	public void testePortalDoCampeonato3() {

		RestAssured.useRelaxedHTTPSValidation();
		String token = "Bearer test_eade22cb669bacd6633dd23635cf65";

		Map<String, String> headerMap = new HashMap<>();
		String url = "https://api.api-futebol.com.br/v1/campeonatos/14/artilharia";
		headerMap.put("Authorization", token);
		headerMap.put("charset", "UTF-8");

		Response response = given()
				.headers(headerMap)
				.log().all()
				.when()
				.get(url);

		List<String> nomePopularList = response.jsonPath().getList("atleta.nome_popular");
		String valorEsperado = "Caio Dantas";
		Assert.assertTrue(nomePopularList.contains(valorEsperado));
		System.out.println(valorEsperado);
		System.out.println(nomePopularList);

	}

}
