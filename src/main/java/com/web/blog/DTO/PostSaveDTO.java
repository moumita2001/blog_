package com.web.blog.DTO;

import java.time.Instant;

public class PostSaveDTO {
    private long id;
    private String content;
    private String title;
    private long username;

    public long getId() {
        return id;
    }

    public PostSaveDTO(String content, String title, long username) {
        this.content = content;
        this.title = title;
        this.username = username;
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

    public PostSaveDTO() {
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

    public PostSaveDTO(long id, String title, String content, long username) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.username = username;
    }


    @Override
    public String toString() {
        return "PostSaveDTO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
