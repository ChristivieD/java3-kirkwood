package edu.christivie.java3kirkwood.learnx.data;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getConnection(){
        Dotenv dotenv = Dotenv.load();
        String db_full_driver=dotenv.get("DB_FULL_DRIVER");
        String connectionString =dotenv.get("LEARNX_DB_CONNECTION_STRING");
        String user=dotenv.get("DB_USERNAME");
        String password=dotenv.get("DB_PASSWORD");
        try{
            Class.forName(db_full_driver);
        } catch (ClassNotFoundException e){
            // what you want to happen if the driver is not found
        }
        try{
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            if(connection.isValid(2)){
                System.out.printf("Connection successful");
                return connection;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.printf("Unsuccessful Connection");
        return null;
    }
}
