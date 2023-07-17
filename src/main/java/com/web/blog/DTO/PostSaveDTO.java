package com.web.blog.DTO;

import java.time.Instant;

public class PostSaveDTO {
    private long id;
    private String content;
    private String title;
    private String username;

    public long getId() {
        return id;
    }

    public PostSaveDTO( String title, String content,String username) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PostSaveDTO(long id, String title, String content, String username) {
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
