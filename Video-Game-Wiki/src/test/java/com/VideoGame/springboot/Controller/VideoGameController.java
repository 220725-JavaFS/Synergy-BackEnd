package com.VideoGame.springboot.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.VideoGame.springboot.VideoGameWikiApplication;


@RunWith(SpringRunner.class)
/*
 *  SpringRunner is an alias for the SpringJUnit4ClassRunner.
 *  To use this class, simply annotate a JUnit 4 based test class with 
 *  @RunWith(SpringRunner.class).
 */
@SpringBootTest(classes = VideoGameWikiApplication.class, 
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/*
 *  primary annotation to create unit and integration tests in 
 *  Spring Boot applications
 */
class VideoGameController {
	
//	@Autowired

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
