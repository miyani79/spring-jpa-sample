package com.miyani.sample.spring.boot.jpa;

import com.miyani.sample.spring.boot.jpa.service.ArticleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaSampleApplication {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run(JpaSampleApplication.class, args);

		ArticleService service = context.getBean(ArticleService.class);
		service.saveArticle();
	}

}
