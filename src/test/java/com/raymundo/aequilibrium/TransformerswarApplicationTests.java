package com.raymundo.aequilibrium;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.raymundo.aequilibrium.utilities.Utilities;

@SpringBootTest
class TransformerswarApplicationTests {
	
	@Autowired
	private RestTemplate restTemplate;
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Test
	public void testListTransformers() {
		
		String json = null;
		String url = "http://localhost:8080/transformer/list";
		Object data = restTemplate.getForObject(url , Object.class);
		if (data != null) {
			json = Utilities.objectToJson(data);
		} 

		logger.info("testListTransformers : "+json);

	}
	
	
	@Test
	public void testCreateTransformer() {
		
		String url = "http://localhost:8080/transformer/create";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String requestJson = "{" + 
				"    \"name\":         \"Optimus Prime\"," + 
				"    \"type\":         \"A\"," + 
				"    \"strength\":     1," + 
				"    \"intelligence\": 1," + 
				"    \"speed\":        1," + 
				"    \"endurance\":    1," + 
				"    \"rank\":         8," + 
				"    \"courage\":      1," + 
				"    \"firepower\":    1," + 
				"    \"skill\":        2" + 
				" }";

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		String answer = restTemplate.postForObject(url, entity, String.class);

		logger.info("testCreateTransformer : "+answer);

	}
	
	
	@Test
	public void testUpdateTransformer() {
		
		String url = "http://localhost:8080/transformer/update";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String requestJson = "{" + 
				"    \"name\":         \"Optimus Prime\"," + 
				"    \"type\":         \"A\"," + 
				"    \"strength\":     10," + 
				"    \"intelligence\": 10," + 
				"    \"speed\":        10," + 
				"    \"endurance\":    10," + 
				"    \"rank\":         8," + 
				"    \"courage\":      10," + 
				"    \"firepower\":    10," + 
				"    \"skill\":        2" + 
				" }";

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		String answer = restTemplate.postForObject(url, entity, String.class);

		logger.info("testUpdateTransformer : "+answer);

	}
	
	@Test
	public void testDeleteTransformer() {
		
		Integer idTransformer = 6;
		String json = null;
		String url = "http://localhost:8080/transformer/delete/"+idTransformer;
		Object data = restTemplate.getForObject(url , Object.class);
		if (data != null) {
			json = Utilities.objectToJson(data);
		} 

		logger.info("testDeleteTransformer : "+json);

	}
	
	
	@Test
	public void testWarTransformers() {
		
		String url = "http://localhost:8080/war";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String requestJson = "{"+
				             "\"transformersForWar\": [1,2,3,4,5,6,7,8,9,10,11]"+
		                     "}";

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		String answer = restTemplate.postForObject(url, entity, String.class);

		logger.info("testWarTransformers : "+answer);

	}

}
