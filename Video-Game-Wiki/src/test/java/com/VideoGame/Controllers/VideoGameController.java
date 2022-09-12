package com.VideoGame.Controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.VideoGame.springboot.VideoGameWikiApplication;


/*
 *  SpringRunner is an alias for the SpringJUnit4ClassRunner.
 *  To use this class, simply annotate a JUnit 4 based test class with 
 *  @RunWith(SpringRunner.class).
 */
/*
 *  primary annotation to create unit and integration tests in 
 *  Spring Boot applications
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VideoGameWikiApplication.class, 
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
class VideoGameController {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private GameController GC;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
//	@Test
//	public void TestGetAllGAMES() {
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		
//		ResponseEntity<String> response = restTemplate
//				.exchange(getRootUrl(), HttpMethod.GET, entity, String.class);
//		
//		assertNotNull(response.getBody());
//	}
//	^^^ doesnt work

	@Test
	void test() throws Exception{
//		fail("Not yet implemented");
		assertThat(GC).isNotNull();
	}

}
