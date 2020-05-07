package com.example.gloice.model;

import java.util.List;

public class Data {

    private Integer page;
    private Integer total_results;
    private Integer total_pages;
    private List<Movie> results;

    public Data(Integer page, Integer total_results, Integer total_pages, List<Movie> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }
}
