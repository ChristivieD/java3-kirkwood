package edu.christivie.java3kirkwood.anime.data;

import edu.christivie.java3kirkwood.anime.models.User;
import edu.christivie.java3kirkwood.shared.ComServices;
import jakarta.servlet.http.HttpServletRequest;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersDAO extends Database1 {
    public static void main(String[] args) throws SQLException {
//        getAll().forEach(System.out::println);
        User user = getUserById(1);
        System.out.println(user);
        User user1 = new User();
        user1.setUser_id(10);
        UsersDAO.delete(user1);
        System.out.println("User has been deleted");
    }

    public static List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            if (connection != null) {
                try (CallableStatement statement = connection.prepareCall("{CALL sp_get_all_users()}")) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("user_id");
                            String username = resultSet.getString("username");
                            String email = resultSet.getString("email");
                            char[] password = resultSet.getString("password").toCharArray();
                            String birthday = resultSet.getString("birthday");
                            String picture = resultSet.getString("picture");
                            String privileges = resultSet.getString("privileges");
                            String status = resultSet.getString("status");
                            String language = resultSet.getString("language");

                            User user = new User(id,username,email,password,birthday,picture,privileges,status,language);
                            users.add(user);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static User get(String email) {
        try (Connection connection = getConnection();
        CallableStatement statement = connection.prepareCall("{CALL sp_get_user(?)}")
        ) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                char[] password = resultSet.getString("password").toCharArray();
                String birthday = resultSet.getString("birthday");
                String picture = resultSet.getString("picture");
                String privileges = resultSet.getString("privileges");
                String status = resultSet.getString("status");
                String language = resultSet.getString("language");
                return new User(id, username, email, password, birthday, picture, privileges, status,language);
            }
        } catch (SQLException e) {
            System.out.println("Check your stored procedures");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static User getUserById(int id){
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_get_user_by_id(?)}");
        ){
            System.out.println("Executing getUserId with ID: " + id);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                char[] password = resultSet.getString("password").toCharArray();
                String birthday = resultSet.getString("birthday");
                String picture = resultSet.getString("picture");
                String privileges = resultSet.getString("privileges");
                String status = resultSet.getString("status");
                String language = resultSet.getString("language");
                return new User(id, username, email, password, birthday, picture, privileges, status,language);

            }

        }catch (SQLException e){
            System.out.println("Check your stored procedures");
            System.out.println(e.getMessage());
        }
        System.out.println("User with ID " + id + " not found"); // Log statement
        return null;
    }

    public static String add(User user){
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_add_user(?, ?)}")
        ){
            statement.setString(1,user.getEmail());
            String hashedPassword = BCrypt.hashpw(String.valueOf(user.getPassword()), BCrypt.gensalt(12));
            statement.setString(2,hashedPassword);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected == 1){
                try(CallableStatement statement2 = connection.prepareCall("{CALL sp_get_2fa_code(?)}")) {
                    statement2.setString(1, user.getEmail());
                    ResultSet resultSet= statement2.executeQuery();
                    if(resultSet.next()){
                        String code = resultSet.getString("code");
                        String method = resultSet.getString("method");
                        if(method.equals("email")){
                            String subject = "View Anime New User";
                            String message = "<h2>Welcome to View Anime</h2>";
                            message += "<p> Please enter the code <b>" + code+ "</b> on the website to activate your account</p>";
                            boolean sent = ComServices.sendEmail(user.getEmail(),subject, message);
                            return sent ? code : "";
                        }
                    }
                }
            }
        } catch (SQLException e){
            System.out.println("Likely error with stored procedure");
            System.out.println(e.getMessage());
        }
        return "";
    }
    public  static void  update(User user){
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("CALL sp_update_user(?,?,?,?,?,?,?,?)")
        ){
            statement.setInt(1,user.getUser_id());
            statement.setString(2,user.getUsername());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getBirthday());
            statement.setString(5,user.getPicture());
            statement.setString(6, user.getPrivileges());
            statement.setString(7, user.getStatus());
            statement.setString(8,user.getLanguage());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Likely error with stored procedure");
            System.out.println(e.getMessage());
        }
    }

    public static  void passwordReset(String email, HttpServletRequest req){
        User userFromDatabase = UsersDAO.get(email);
        if(userFromDatabase != null){
            try(Connection connection = getConnection()){
                String uuid = String.valueOf(UUID.randomUUID());
                try(CallableStatement statement = connection.prepareCall("{CALL sp_add_password_reset(?,?)}")){
                    statement.setString(1,email);
                    statement.setString(2,uuid);
                    statement.executeUpdate();
                }
                ComServices.sendPasswordResetEmail(email,uuid,req);
            }catch (SQLException e){
                System.out.println("Likely error with stored procedure");
                System.out.println(e.getMessage());
            }
        }
    }
    public static String getPasswordReset(String token){
        String email = "";
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_get_password_reset(?)}")
        ){
            statement.setString(1,token);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    Instant now = Instant.now();
                    Instant created_at = resultSet.getTimestamp("created_at").toInstant();
                    Duration timeBetween= Duration.between(now, created_at);
                    long minutesBetween = timeBetween.toMinutes();
                    email = resultSet.getString("email");
                }
            }
        } catch(SQLException e){
            System.out.println("Likely error with stored procedure");
            System.out.println(e.getMessage());
        }

        return email;
    }
    public static  void updatePassword(User user){
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("CALL sp_update_user_password(?,?)")
        ){
            statement.setString(1,user.getEmail());
            String hashedPassword = BCrypt.hashpw(String.valueOf(user.getPassword()),BCrypt.gensalt(12));
            statement.setString(2,hashedPassword);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Likely error with stored procedure");
            System.out.println(e.getMessage());
        }
    }
    public static void delete(User user) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                try (CallableStatement statement = connection.prepareCall("{CALL sp_delete_user(?)}")) {
                    statement.setInt(1, user.getUser_id());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
