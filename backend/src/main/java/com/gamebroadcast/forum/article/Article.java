package com.gamebroadcast.forum.article;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "article", uniqueConstraints = {
        @UniqueConstraint(name = "article_unique_title", columnNames = "title") })
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@Data
public class Article {

    @Id
    @SequenceGenerator(name = "article_sequence", sequenceName = "article_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 512)
    private String title;

    @Column(name = "introduction", nullable = false, length = 2048)
    private String introduction;

    @Column(name = "content_path", nullable = false, length = 1024)
    private String contentPath;

    @Column(name = "image_path", nullable = true, length = 1024)
    private String imagePath;

    public Article() {
    }

    public Article(String title, String introduction, String contentPath, String imagePath) {
        this.title = title;
        this.introduction = introduction;
        this.contentPath = contentPath;
        this.imagePath = imagePath;
    }

    public Article(Long id, String title, String introduction, String contentPath, String imagePath) {
        this.id = id;
        this.title = title;
        this.introduction = introduction;
        this.contentPath = contentPath;
        this.imagePath = imagePath;
    }
}
