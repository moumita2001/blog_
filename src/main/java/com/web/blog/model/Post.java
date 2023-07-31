package com.web.blog.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
@Entity
@Table(name="Post")
public class Post {
    @Id
    @Column(name="post_id",length=50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;
    @Column(name="post_title",length=200)
    private String title;

    @Lob
    @Column(name="content",length=Integer.MAX_VALUE-1)
    private String content;



//    @Column(name = "user_id")
//    private String username;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;



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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post() {
    }

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Post(long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }
    //    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

//    public Post() {
//    }
//
//    public Post(long id, String title, String content, String username) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//        this.username = username;
//    }
//
//    public Post(String title, String content, String username) {
//        this.title = title;
//        this.content = content;
//        this.username = username;
//    }
//
//    @Override
//    public String toString() {
//        return "Post{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                ", username='" + username + '\'' +
//                '}';
//    }
}
