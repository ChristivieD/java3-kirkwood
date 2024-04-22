package edu.christivie.java3kirkwood.anime.data;

import edu.christivie.java3kirkwood.anime.models.Anime;
import edu.christivie.java3kirkwood.anime.models.AnimeGenre;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AnimeDAO extends Database1 {
    public static void main(String[] args) {
        List<Anime> courses = get(10, 0, "", "");
        courses.forEach(System.out::println);
    }
    public static List<Anime> get(int limit, int offset, String genre, String status_type){
        List<Anime> animeList = new ArrayList<>();
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_get_animes(?,?,?,?)}"))
        {
            statement.setInt(1,limit);
            statement.setInt(2,offset);
            statement.setString(3,genre);
            statement.setString(4,status_type);

            try(ResultSet resultSet = statement.executeQuery()){
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
                    String username = resultSet.getString("username");
                    String genre_name = resultSet.getString("genre_name");
                    Anime anime = new Anime(anime_id,release_date,genre_id,description,rating,image,status,language,title,username,genre_name);
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
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int numCourses = resultSet.getInt("num_courses");
                genres.add(new AnimeGenre(id,name,numCourses));
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
    public static TreeMap<Anime, Instant> getAnimeGenre(int limit, int offset, int userId){
        TreeMap<Anime, Instant> genres = new TreeMap<>();
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{ CALL sp_get_anime_by_genre(?,?,?)}") ){
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            statement.setInt(3, userId);
            try(ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    int anime_id = resultSet.getInt("anime_id");
                    String release_date = resultSet.getString("release_date");
                    int genre_id = resultSet.getInt("genre_id");
                    String description = resultSet.getString("description");
                    String rating = resultSet.getString("rating");
                    String image = resultSet.getString("image");
                    String status = resultSet.getString("status");
                    String language = resultSet.getString("language");
                    String title = resultSet.getString("title");
                    String username = resultSet.getString("username");
                    String genre_name = resultSet.getString("genre_name");
                    Anime anime = new Anime(anime_id, release_date, genre_id, description, rating, image, status, language,title, username, genre_name);
                    Instant reviewDate = resultSet.getTimestamp("posted_at").toInstant();
                    genres.put(anime, reviewDate);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return genres;
    }
}
