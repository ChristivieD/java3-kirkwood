package edu.christivie.java3kirkwood.learnx.data;

import edu.christivie.java3kirkwood.learnx.models.Course;
import edu.christivie.java3kirkwood.learnx.models.CourseCategory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO extends Database{
    // get all courses
    public static List<Course> get(int limit, int offset,String categories,String skillLevel){
        List<Course> courses = new ArrayList<>();
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_get_courses(?,?,?,?)}"))
        {
            statement.setInt(1,limit);
            statement.setInt(2,offset);
            statement.setString(3,categories);
            statement.setString(4,skillLevel);
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    String level = resultSet.getString("level");
                    String picture = resultSet.getString("picture");
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    int category_id = resultSet.getInt("category_id");
                    String category_name = resultSet.getString("category_name");
                    Course course = new Course(id,name,description,level,picture,first_name,last_name,category_id,category_name);
                    courses.add(course);

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return courses;
    }
    public static List<CourseCategory> getAllCategories(){
        List<CourseCategory> categories = new ArrayList<>();
        try(Connection connection = getConnection();
        CallableStatement statement = connection.prepareCall("CALL sp_get_all_course_categories");
        ResultSet resultSet = statement.executeQuery();
        ){
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int numCourses = resultSet.getInt("num_courses");
                categories.add(new CourseCategory(id,name,numCourses));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }
    // get single course
    // add new courses
    // update a course
    // delete a course
    public static boolean enroll(int studentId, int courseId){
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall("{CALL sp_add_enrollment(?,?)} ");
            ) { statement.setInt(1,studentId);
                statement.setInt(2,courseId);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected== 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
