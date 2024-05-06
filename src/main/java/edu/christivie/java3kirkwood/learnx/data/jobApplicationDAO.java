package edu.christivie.java3kirkwood.learnx.data;

import edu.christivie.java3kirkwood.learnx.models.JobApplication;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class jobApplicationDAO extends Database{
    public static JobApplication addJobApplication(int applicationId, int jobId, String firstName, String lastName, String email, double desiredSalary, Instant dateSubmitted,String status){
        try (Connection connection = getConnection();
             CallableStatement statement = connection.prepareCall("{CALL sp_add_job_application(?,?,?,?,?,?,?,?)}")
        ) {
            statement.setInt(1, applicationId);
            statement.setInt(2, jobId);
            statement.setString(3, firstName);
            statement.setString(4, email);
            statement.setDouble(5, desiredSalary);
            statement.setString(6, lastName);
            statement.setTimestamp(7, Timestamp.from(dateSubmitted));
            statement.setString(8, status);
            int rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
}
