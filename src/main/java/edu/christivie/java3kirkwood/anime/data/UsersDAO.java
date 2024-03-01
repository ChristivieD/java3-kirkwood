package edu.christivie.java3kirkwood.anime.data;

import edu.christivie.java3kirkwood.anime.models.Users;
import edu.christivie.java3kirkwood.learnx.models.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
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
                            String firstName = resultSet.getString("username");
                            String email = resultSet.getString("email");
                            String birthday = resultSet.getString("birthday");
                            String picture = resultSet.getString("picture");
                            String privileges = resultSet.getString("privileges");
                            String status = resultSet.getString("status");

                            // Create a new Users object and add it to the list
                            Users user = new Users(id, firstName, email, birthday.toCharArray(), picture, privileges, status);
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
}
