package com.VideoGame.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*		NOTES
 * @EnableJpaAuditing - Annotation to enable auditing in JPA via annotation configuration.
 */

@SpringBootApplication
@EnableJpaAuditing
public class VideoGameWikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoGameWikiApplication.class, args);
	}

}
