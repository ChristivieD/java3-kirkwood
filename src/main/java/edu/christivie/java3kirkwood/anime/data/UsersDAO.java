package edu.christivie.java3kirkwood.anime.data;

import edu.christivie.java3kirkwood.anime.models.Users;
import edu.christivie.java3kirkwood.shared.CommunicationService;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends Database1 {
    public static void main(String[] args) throws SQLException {
        getAll().forEach(System.out::println);
    }

    public static List<Users> getAll() {
        List<Users> users = new ArrayList<>();
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

                            Users user = new Users(id,username,email,password,birthday,picture,privileges,status);
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

    public static Users get(String email) {
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
                return new Users(id, username, email, password, birthday, picture, privileges, status);
            }
        } catch (SQLException e) {
            System.out.println("Check your stored procedures");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String add(Users user){
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
                            boolean sent = CommunicationService.sendEmail(user.getEmail(),subject, message);
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
    public  static void  update(Users user){
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("CALL sp_update_user(?,?,?,?,?,?,?)")
        ){
            statement.setInt(1,user.getUser_id());
            statement.setString(2,user.getUsername());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getBirthday());
            statement.setString(5,user.getPicture());
            statement.setString(6, user.getPrivileges());
            statement.setString(7, user.getStatus());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Likely error with stored procedure");
            System.out.println(e.getMessage());
        }
    }

}
