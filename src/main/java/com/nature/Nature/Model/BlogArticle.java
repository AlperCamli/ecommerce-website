package com.nature.Nature.Model;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class BlogArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String content;
    private String title;
    private Date publishDate;
    private int readingTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
}
