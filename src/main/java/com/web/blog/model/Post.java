package com.web.blog.model;
import jakarta.persistence.*;

import java.time.Instant;
@Entity
@Table(name="Post")
public class Post {
    @Id
    @Column(name="post_id",length=50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="post_title",length=50)
    private String title;
    @Lob
    @Column(name="content")
    private String content;

    @Column(name = "user_id")
    private String username;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Post() {
    }

    public Post(long id, String title, String content, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public Post(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
