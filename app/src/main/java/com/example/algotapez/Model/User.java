package com.example.algotapez.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private String email;
    private int age;
    private String gender;
    private String country;
    private List<String> preferences;
    private List<String> favoriteSongs;
    private double latitude;
    private double longitude;
    private List<String> preferredGenres;
    private List<String> playHistory;

    public User() {
        // Default constructor required for Firebase
    }

    public User(String userId, String username, String email, int age, String gender, String country,
                List<String> preferences, List<String> favoriteSongs, double latitude, double longitude,
                List<String> preferredGenres, List<String> playHistory) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.preferences = preferences;
        this.favoriteSongs = favoriteSongs;
        this.latitude = latitude;
        this.longitude = longitude;
        this.preferredGenres = preferredGenres;
        this.playHistory = playHistory;
    }

    public <E> User(String uid, String username, String email, int parseInt, String gender, String country, ArrayList<E> es, ArrayList<E> es1, double latitude, double longitude) {
    }

    // Getter and setter methods for all attributes...

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<String> getPreferredGenres() {
        return preferredGenres;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public List<String> getFavoriteSongs() {
        return favoriteSongs;
    }

    public void setFavoriteSongs(List<String> favoriteSongs) {
        this.favoriteSongs = favoriteSongs;
    }

    public void setPreferredGenres(List<String> preferredGenres) {
        this.preferredGenres = preferredGenres;
    }

    public List<String> getPlayHistory() {
        return playHistory;
    }

    public void setPlayHistory(List<String> playHistory) {
        this.playHistory = playHistory;
    }
}


