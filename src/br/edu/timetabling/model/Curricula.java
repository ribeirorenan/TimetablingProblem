package br.edu.timetabling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan
 */
public class Curricula {
    private String curriculumId;
    private int numberOfCourses;
    private List<Course> courses;
    private int curriculaID;

    public Curricula() {
        courses = new ArrayList<>();
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

    public int getCurriculaID() {
        return curriculaID;
    }

    public void setCurriculaID(int curriculaID) {
        this.curriculaID = curriculaID;
    }

    public boolean addCourse(Course course){
        //course.setCourseCurriculaID(aux);
        this.courses.add(course);
        return true;
    }

    @Override
    public String toString() {

        String cursos = "";

//        for (Course course :
//                courses) {
//            cursos += course.toStringName() + " ";
//        }

        return "Curricula{" +
                "curriculumId='" + curriculumId + '\'' +
                ", numberOfCourses=" + numberOfCourses +
                ", courses: " + cursos +
                '}';
    }
}