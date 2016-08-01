package br.edu.timetabling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 7/31/16.
 */
public class Course {
    private String name;
    private Teacher teacher;
    private int numberOfLectures;
    private int minWorkingDays;
    private int numberOfStudents;
    private List<UnavailabiltyConstraint> unavailabiltyConstraints;


    public Course() {
        this.unavailabiltyConstraints = new ArrayList<UnavailabiltyConstraint>();
    }

    public Course(String name, Teacher teacher, int numberOfLectures, int minWorkingDays, int numberOfStudents) {
        this.name = name;
        this.teacher = teacher;
        this.numberOfLectures = numberOfLectures;
        this.minWorkingDays = minWorkingDays;
        this.numberOfStudents = numberOfStudents;
        this.unavailabiltyConstraints = new ArrayList<UnavailabiltyConstraint>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getNumberOfLectures() {
        return numberOfLectures;
    }

    public void setNumberOfLectures(int numberOfLectures) {
        this.numberOfLectures = numberOfLectures;
    }

    public int getMinWorkingDays() {
        return minWorkingDays;
    }

    public void setMinWorkingDays(int minWorkingDays) {
        this.minWorkingDays = minWorkingDays;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }


    public boolean addUnavailabilityConstraints(UnavailabiltyConstraint unavailabiltyConstraint){
        this.unavailabiltyConstraints.add(unavailabiltyConstraint);
        return  true;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher.getName() +
                ", numberOfLectures=" + numberOfLectures +
                ", minWorkingDays=" + minWorkingDays +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }

    public String toStringName() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }


    public List<UnavailabiltyConstraint> getUnavailabiltyConstraints() {
        return unavailabiltyConstraints;
    }

    public void setUnavailabiltyConstraints(List<UnavailabiltyConstraint> unavailabiltyConstraints) {
        this.unavailabiltyConstraints = unavailabiltyConstraints;
    }
}