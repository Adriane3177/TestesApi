package testesApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestesApiCampeonatoExercício1 {

	@Test
	public void testePortalDoCampeonato1() {

		RestAssured.useRelaxedHTTPSValidation();
		String token = "Bearer test_eade22cb669bacd6633dd23635cf65";

		Map<String, String> headerMap = new HashMap<>();
		String url = "https://api.api-futebol.com.br/v1/campeonatos";

		headerMap.put("Authorization", token);
		headerMap.put("charset", "UTF-8");

		Response response = given()
				.headers(headerMap)
				.log().all()
				.when()
				.get(url);

		List<String> nomePopularList = response.jsonPath().getList("edicao_atual.nome_popular");
		String valorEsperado = "Brasileirão Série B 2023";
		Assert.assertTrue(nomePopularList.contains(valorEsperado));

	}

}
