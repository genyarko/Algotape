package com.example.algotapez.Model;

import java.io.Serializable;
import java.util.List;

public class Song implements Serializable {
    private String songTitle;
    private String artistName;
    private String features;
    private String albumTitle;
    private int duration;
    private String genre;
    private String key;
    private String releaseDate;
    private String imageUrl;
    private String audioUrl;
    private String albumType;
    private String producer;
    private String instrumentalist;
    private String label;
    private String composer;
    private String lyrics;
    private int year;
    private List<String> imageUrls;

    public Song() {
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getInstrumentalist() {
        return instrumentalist;
    }

    public void setInstrumentalist(String instrumentalist) {
        this.instrumentalist = instrumentalist;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songTitle='" + songTitle + '\'' +
                ", artistName='" + artistName + '\'' +
                ", features='" + features + '\'' +
                ", albumTitle='" + albumTitle + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                ", key='" + key + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", audioUrl='" + audioUrl + '\'' +
                ", albumType='" + albumType + '\'' +
                ", producer='" + producer + '\'' +
                ", instrumentalist='" + instrumentalist + '\'' +
                ", label='" + label + '\'' +
                ", composer='" + composer + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", year=" + year +
                ", imageUrls=" + imageUrls +
                '}';
    }
}

