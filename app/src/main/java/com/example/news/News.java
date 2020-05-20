package com.example.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("news")
    @Expose
    private List<News_> news = null;
    @SerializedName("page")
    @Expose
    private Integer page;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<News_> getNews() {
        return news;
    }

    public void setNews(List<News_> news) {
        this.news = news;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}
