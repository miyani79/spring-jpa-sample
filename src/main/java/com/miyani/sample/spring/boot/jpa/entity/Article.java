package com.miyani.sample.spring.boot.jpa.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Article
{
    public Article() {}

    public Article(String content) {
        this.content = content;
    }

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    public void addImage(final Image image) {
        image.setArticle(this);
        images.add(image);
    }
}
