package edu.christivie.java3kirkwood.learnx.models;

public class Course {
    private int id;
    private String name;
    private String description;
    private String level;
    private String picture;
    private String teacherFirstName;
    private String teacherLastName;
    private int category_id;
    private String categoryName;

    public Course() {
    }

    public Course(int id, String name, String description, String level, String picture, String teacherFirstName, String teacherLastName, int category_id, String categoryName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.level = level;
        this.picture = picture;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.category_id = category_id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                ", picture='" + picture + '\'' +
                ", teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherLastName='" + teacherLastName + '\'' +
                ", category_id=" + category_id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
