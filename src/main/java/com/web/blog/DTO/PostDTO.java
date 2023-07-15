package com.web.blog.DTO;

import java.time.Instant;

public class PostDTO {
    private long id;
    private String content;
    private String title;

    private long username;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUsername() {
        return username;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    public PostDTO(long id, String content, String title, long username) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.username = username;
    }

    public PostDTO(String content, String title, long username) {
        this.content = content;
        this.title = title;
        this.username = username;
    }

    public PostDTO() {
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
