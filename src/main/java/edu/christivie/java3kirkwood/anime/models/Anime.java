package edu.christivie.java3kirkwood.anime.models;

public class Anime {
    private int anime_id;
    private String release_date;
    private int genre_id;
    private String description;
    private String rating;
    private String image;
    private String status;
    private String language;
    private String title;
    public Anime(){}
    public Anime(int anime_id, String release_date, int genre_id, String description, String rating, String image, String status, String language, String title, String username, String genre_name){}

    public Anime(int anime_id, String release_date, int genre_id, String description, String rating, String image, String status, String language, String title) {
        this.anime_id = anime_id;
        this.release_date = release_date;
        this.genre_id = genre_id;
        this.description = description;
        this.rating = rating;
        this.image = image;
        this.status = status;
        this.language = language;
        this.title = title;
    }

    public int getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(int anime_id) {
        this.anime_id = anime_id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "anime_id=" + anime_id +
                ", release_date='" + release_date + '\'' +
                ", genre_id=" + genre_id +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
