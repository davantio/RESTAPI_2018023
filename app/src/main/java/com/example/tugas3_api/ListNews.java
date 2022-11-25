package com.example.tugas3_api;

public class ListNews {
    private String author;
    private String title;
    private String description;
    private String url;

    public ListNews(String author,
                    String title,
                    String description,
                    String url) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
