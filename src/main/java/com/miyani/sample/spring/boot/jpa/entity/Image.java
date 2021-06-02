package com.miyani.sample.spring.boot.jpa.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Image
{
    public Image() {}

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;
    public void setArticle(Article article) {
        this.article = article;
    }

    public Image(String url)
    {
        this.url = url;
    }
}