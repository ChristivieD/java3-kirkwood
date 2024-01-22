package edu.christivie.java3kirkwood.demos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Artist {
    @JsonProperty("name")
    private String name;

    @JsonProperty("picture_big")
    private String picture_big;

    public Artist() {
    }

    public String getName() {
        return name;
    }

    public String getPicture_big() {
        return picture_big;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", picture_big='" + picture_big + '\'' +
                '}';
    }
}
