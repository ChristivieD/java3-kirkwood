package edu.christivie.java3kirkwood.anime.models;


public class AnimeGenre  {
    private int genre_id;
    private String genre_name;
    private int num_anime;

    public AnimeGenre() {
    }

    public AnimeGenre(int genre_id, String genre_name, int num_anime) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
        this.num_anime = num_anime;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public int getNum_anime() {
        return num_anime;
    }

    public void setNum_anime(int num_anime) {
        this.num_anime = num_anime;
    }
}
