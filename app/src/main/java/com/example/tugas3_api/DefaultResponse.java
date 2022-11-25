package com.example.tugas3_api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DefaultResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
    private List<ListNews> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ListNews> getArticles() {
        return articles;
    }

    public void setArticles(List<ListNews> articles) {
        this.articles = articles;
    }
}
