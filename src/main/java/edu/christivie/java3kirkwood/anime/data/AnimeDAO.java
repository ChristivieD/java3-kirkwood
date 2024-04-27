package edu.christivie.java3kirkwood.anime.data;

import edu.christivie.java3kirkwood.anime.models.Anime;
import edu.christivie.java3kirkwood.anime.models.AnimeGenre;
import edu.christivie.java3kirkwood.anime.models.Review;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AnimeDAO extends Database1 {
    public static void main(String[] args) {
        List<Anime> animeList = getAnimes(10, 0, "", "");
        animeList.forEach(System.out::println);

        List<AnimeGenre> allGenres = getAllGenres();
        allGenres.forEach(System.out::println);
        List<Review> reviews = getReviewsByAnimeId(4);
        reviews.forEach(System.out::println);

        Anime anime = getAnimeById(4);
        System.out.println(anime);
    }
    public static List<Anime> getAnimes(int limit, int offset, String genre, String status_type) {
        List<Anime> animeList = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall("{CALL sp_get_animes(?,?,?,?)}")) {
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            statement.setString(3, genre);
            statement.setString(4, status_type);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int anime_id = resultSet.getInt("anime_id");
                    String release_date = resultSet.getString("release_date");
                    int genre_id = resultSet.getInt("genre_id");
                    String description = resultSet.getString("description");
                    String rating = resultSet.getString("rating");
                    String image = resultSet.getString("image");
                    String status = resultSet.getString("status");
                    String language = resultSet.getString("language");
                    String title = resultSet.getString("title");
                    String genre_name = resultSet.getString("genre_name");

                    Anime anime = new Anime(anime_id, release_date, genre_id, description, rating, image, status, language, title, genre_name);
                    animeList.add(anime);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return animeList;
    }
    public static List<AnimeGenre> getAllGenres(){
        List<AnimeGenre> genres = new ArrayList<>();
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("CALL sp_get_all_anime_genre");
            ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                int id = resultSet.getInt("genre_id");
                String name = resultSet.getString("genre_name");
                int numAnimes = resultSet.getInt("num_anime");
                genres.add(new AnimeGenre(id,name,numAnimes));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return genres;
    }
    // get single course
    // add new courses
    // update a course
    public static boolean review(int user_id, int anime_id){
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_add_review(?,?,?,?,?)} ");
        ) { statement.setInt(1,user_id);
            statement.setInt(2,anime_id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static TreeMap<Anime, Instant> getAnimeGenre(int limit, int offset, String genre_id, String status){
        TreeMap<Anime, Instant> genres = new TreeMap<>();
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{ CALL sp_get_anime_by_genre(?,?,?,?)}") ){
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            statement.setString(3, genre_id);
            statement.setString(2, status);
            try(ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    int anime_id = resultSet.getInt("anime_id");
                    String release_date = resultSet.getString("release_date");
                    int genreId = resultSet.getInt("genre_id");
                    String description = resultSet.getString("description");
                    String rating = resultSet.getString("rating");
                    String image = resultSet.getString("image");
                    String animeStatus = resultSet.getString("status");
                    String language = resultSet.getString("language");
                    String title = resultSet.getString("title");
                    int reviewId = resultSet.getInt("review_id");
                    int reviewUserId = resultSet.getInt("user_id");
                    String reviewRating = resultSet.getString("rating");
                    String reviewText = resultSet.getString("text");
                    Instant reviewPostedAt = resultSet.getTimestamp("posted_at").toInstant();
                    String genreName = resultSet.getString("genre_name");
                    Anime anime = new Anime(anime_id, release_date, genreId, description, rating, image, animeStatus,
                            language,title, reviewId,reviewUserId,reviewRating,reviewText,reviewPostedAt,genreName);
                    Review review = new Review(reviewId, reviewUserId, reviewRating,reviewText,reviewPostedAt);
                    anime.add(review);
                    genres.put(anime, reviewPostedAt);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return genres;
    }
    public static List<Review> getReviewsByAnimeId(int anime_id) {
        List<Review> reviews = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall("{CALL sp_get_review(?)}")
        ) {
            statement.setInt(1, anime_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int reviewId = resultSet.getInt("review_id");
                int userId = resultSet.getInt("user_id");
                String rating = resultSet.getString("rating");
                String text = resultSet.getString("text");
                Instant reviewPostedAt = resultSet.getTimestamp("posted_at").toInstant();
                Review review = new Review(reviewId,userId,rating,text,reviewPostedAt);
                reviews.add(review);
            }
        } catch (SQLException e) {
            System.out.println("Check your stored procedures");
            System.out.println(e.getMessage());
        }
        return reviews;
    }
    public static Anime getAnimeById(int animeId) {
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall("{CALL sp_get_anime_by_id(?)}")
        ) {
            statement.setInt(1, animeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int anime_id = resultSet.getInt("anime_id");
                String release_date = resultSet.getString("release_date");
                int genre_id = resultSet.getInt("genre_id");
                String description = resultSet.getString("description");
                String rating = resultSet.getString("rating");
                String image = resultSet.getString("image");
                String status = resultSet.getString("status");
                String language = resultSet.getString("language");
                String title = resultSet.getString("title");
                return new Anime(anime_id, release_date, genre_id, description, rating, image, status, language, title);
            }
        } catch (SQLException e) {
            System.out.println("Check your stored procedures");
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Anime addAnime(String date, int genreId, String description, String rating, String image, String status,String language, String title) {
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall("{CALL sp_add_anime(?,?,?,?,?,?,?,?)}")
        ) {
            statement.setString(1, date);
            statement.setInt(2, genreId);
            statement.setString(3, description);
            statement.setString(4, rating);
            statement.setString(5, image);
            statement.setString(6, status);
            statement.setString(7, language);
            statement.setString(8, title);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected == 1){
                int animeId = statement.getInt(8);
                return getAnimeById(animeId);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
    public static void delete(Anime anime) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                try (CallableStatement statement = connection.prepareCall("{CALL sp_delete_anime(?)}")) {
                    statement.setInt(1, anime.getAnime_id());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
