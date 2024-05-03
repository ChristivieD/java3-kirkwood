package edu.christivie.java3kirkwood.learnx.data;

import edu.christivie.java3kirkwood.learnx.models.JobListing;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class JobListiningDAO extends Database{
    public static void main(String[] args) {
        List<JobListing> jobListings = getAll(10, 0, "");
        jobListings.forEach(System.out::println);
    }
    public static List<JobListing> getAll(int limit, int offset, String location) {
        List<JobListing> jobListings = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall("{CALL sp_get_job_listings(?,?,?)}")) {
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            statement.setString(3, location);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int job_id = resultSet.getInt("job_id");
                    int department_id = resultSet.getInt("department_id");
                    String department_name = resultSet.getString("department_name");
                    boolean feature = resultSet.getBoolean("feature");
                    String position = resultSet.getString("position");
                    Instant posted_at = resultSet.getTimestamp("posted_at").toInstant();
                    String contract = resultSet.getString("contract");
                    String description = resultSet.getString("description");

                    JobListing jobListing = new JobListing(job_id, department_id, department_name,feature, position, posted_at, contract, location, description);
                    jobListings.add(jobListing);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return jobListings;
    }

}
