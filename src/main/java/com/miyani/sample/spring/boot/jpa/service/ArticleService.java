package com.miyani.sample.spring.boot.jpa.service;

import com.miyani.sample.spring.boot.jpa.entity.Article;
import com.miyani.sample.spring.boot.jpa.entity.Image;
import com.miyani.sample.spring.boot.jpa.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void saveArticle() {
        Article article = new Article("foo");

        article.addImage(new Image("foo 1"));
        article.addImage(new Image("foo 2"));
        article.addImage(new Image("foo 3"));
        article.addImage(new Image("foo 4"));

        articleRepository.saveAndFlush(article);
    }
}
