package com.akanksha.mediaplayer;

public class Music  {
    private String song_name;
    private String artist;
    private int songs;

    public Music(String song_name, String artist, int songs) {
        this.song_name = song_name;
        this.artist = artist;
        this.songs = songs;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongs() {
        return songs;
    }

    public void setSongs(int songs) {
        this.songs = songs;
    }
}
