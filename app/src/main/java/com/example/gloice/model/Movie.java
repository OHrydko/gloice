package com.example.gloice.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.gloice.db.IntegerConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "movie")
public class Movie {
    @PrimaryKey
    private Integer id;

    private Double popularity;

    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    private Boolean video;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    private Boolean adult;

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;

    @SerializedName("original_language")
    @Expose
    private String originalLanguage;

    @SerializedName("original_title")
    @Expose
    private String originalTitle;

    @SerializedName("genre_ids")
    @Expose
    @TypeConverters({IntegerConverter.class})
    private List<Integer> genreIds;

    private String title;

    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;

    private String overview;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    public Movie(Integer id, Double popularity, Integer voteCount, Boolean video, String posterPath,
                 Boolean adult, String backdropPath, String originalLanguage, String originalTitle,
                 List<Integer> genreIds, String title, Double voteAverage, String overview,
                 String releaseDate) {
        this.id = id;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.posterPath = posterPath;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getTitle() {
        return title;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
