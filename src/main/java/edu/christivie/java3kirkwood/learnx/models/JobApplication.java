package edu.christivie.java3kirkwood.learnx.models;

import java.time.Instant;
import java.time.LocalDateTime;

public class JobApplication {
    private int applicationId;
    private int jobId;
    private String firstName;
    private String lastName;
    private double desiredSalary;
    private LocalDateTime earliestStartDate;
    private Instant dateSubmitted;
    private String status;

    public JobApplication(int applicationId, int jobId, String firstName, String lastName, double desiredSalary, LocalDateTime earliestStartDate, Instant dateSubmitted, String status) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.desiredSalary = desiredSalary;
        this.earliestStartDate = earliestStartDate;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(double desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public LocalDateTime getEarliestStartDate() {
        return earliestStartDate;
    }

    public void setEarliestStartDate(LocalDateTime earliestStartDate) {
        this.earliestStartDate = earliestStartDate;
    }

    public Instant getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Instant dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicationId=" + applicationId +
                ", jobId=" + jobId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", desiredSalary=" + desiredSalary +
                ", earliestStartDate=" + earliestStartDate +
                ", dateSubmitted=" + dateSubmitted +
                ", status='" + status + '\'' +
                '}';
    }
}
