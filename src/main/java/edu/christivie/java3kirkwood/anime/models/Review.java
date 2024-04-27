package edu.christivie.java3kirkwood.anime.models;

import edu.christivie.java3kirkwood.anime.data.UsersDAO;

import java.time.Instant;

public class Review {
    private  int review_id;
    private  int user_id;
    private  int anime_id;
    private String rating;
    private  String text;
    private  Instant posted_at;

    public Review(int reviewId, int reviewUserId, String reviewRating, String reviewText, Instant reviewPostedAt) {
        this.review_id = reviewId;
        this.user_id = reviewUserId;
        this.rating = (reviewRating);
        this.text = reviewText;
        this.posted_at = reviewPostedAt;
    }

    public Review() {
    }

    public Review(int review_id, int user_id, int anime_id, String rating, String text, Instant posted_at) {
        this.review_id = review_id;
        this.user_id = user_id;
        this.anime_id = anime_id;
        this.rating = rating;
        this.text = text;
        this.posted_at = posted_at;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(int anime_id) {
        this.anime_id = anime_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Instant posted_at) {
        this.posted_at = posted_at;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", user_id=" + user_id +
                ", anime_id=" + anime_id +
                ", rating=" + rating +
                ", text='" + text + '\'' +
                ", posted_at=" + posted_at +
                '}';
    }
    public String getUserName(){
        User user = UsersDAO.getUserById(this.user_id);
        if(user != null){
            return user.getUsername();
        }
        else {
            return "Unknown User";
        }
    }
}
