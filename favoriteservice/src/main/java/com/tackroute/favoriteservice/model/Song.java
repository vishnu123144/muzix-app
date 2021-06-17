package com.tackroute.favoriteservice.model;

//@Document(collection = "music")
public class Song {

    private String favoriteId;
    private String songTitle;
    private String artistName;
    private String songUrl;
    private String listeners;

    public Song() {

    }

    public Song(String favoriteId, String songTitle, String artistName, String songUrl, String listeners) {
        this.favoriteId = favoriteId;
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.songUrl = songUrl;
        this.listeners = listeners;
    }

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
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

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

}
