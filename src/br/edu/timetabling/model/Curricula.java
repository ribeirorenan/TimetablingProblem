package br.edu.timetabling.model;

import java.util.List;

/**
 * Created by renan on 7/31/16.
 */
public class Curricula {
    private String curriculumId;
    private int numberOfCourses;
    private List<Course> courses;

    public Curricula() {
    }


    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
