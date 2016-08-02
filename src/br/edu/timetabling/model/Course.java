package br.edu.timetabling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan
 */
public class Course {
    private String name;
    private Teacher teacher;
    private int numberOfLectures;
    private int minWorkingDays;
    private int numberOfStudents;
    private List<UnavailabiltyConstraint> unavailabiltyConstraints;
    private CourseTime courseTime;
    private List<Integer> listOfCurriculaID;
    private List<Integer> listOfViolatedConstraints;

    /* Gambiarra - Contador para comparar o numero de leituras com as inseridas */
    private int countInsertedLectures;

    static final Course FREE = new Course("livre", Teacher.TEACHER, Integer.BYTES, Integer.MIN_VALUE, Integer.MIN_VALUE);

    public Course() {
        this.unavailabiltyConstraints = new ArrayList<UnavailabiltyConstraint>();
        this.listOfCurriculaID = new ArrayList<Integer>();
        listOfViolatedConstraints = new ArrayList<>();
    }

    public Course(String name, Teacher teacher, int numberOfLectures, int minWorkingDays, int numberOfStudents) {
        this.name = name;
        this.teacher = teacher;
        this.numberOfLectures = numberOfLectures;
        this.minWorkingDays = minWorkingDays;
        this.numberOfStudents = numberOfStudents;
        this.unavailabiltyConstraints = new ArrayList<UnavailabiltyConstraint>();
        this.courseTime = new CourseTime(0, 0, 0);
        this.countInsertedLectures = 0;
        this.listOfCurriculaID = new ArrayList<Integer>();
        listOfViolatedConstraints = new ArrayList<>();
    }


    public boolean isAllLecturesInserted(){
        if(countInsertedLectures == numberOfLectures){
            return true;
        }

        return false;
    }


    public int getNotInsertedLectures(){
        if(countInsertedLectures != numberOfLectures){
            return numberOfLectures - countInsertedLectures;
        }
        return 0;
    }

    public boolean remainingLecturesIsPair  (){
        if (((getNumberOfLectures() - getCountInsertedLectures()) % 2) == 0){
            return true;
        }

        return false;
    }

    public void incrementCountOfInsertedLectures(){
        countInsertedLectures += 1;
    }


    public void addViolatedConstraint(int constraint){
        this.listOfViolatedConstraints.add(constraint);
    }

    /*
     * Getters and Setters
     */

    public List<Integer> getListOfViolatedConstraints() {
        return listOfViolatedConstraints;
    }

    public void setListOfViolatedConstraints(List<Integer> listOfViolatedConstraints) {
        this.listOfViolatedConstraints = listOfViolatedConstraints;
    }

    public CourseTime getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(CourseTime courseTime) {
        this.courseTime = courseTime;
    }

    public int getCountInsertedLectures() {
        return countInsertedLectures;
    }

    public void setCountInsertedLectures(int countInsertedLectures) {
        this.countInsertedLectures = countInsertedLectures;
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

    public List<Integer> getListOfCurriculaID() {
        return listOfCurriculaID;
    }

    public void addCurrilaID(Integer id){
        listOfCurriculaID.add(id);
    }

    public void setListOfCurriculaID(List<Integer> listOfCurriculaID) {
        this.listOfCurriculaID = listOfCurriculaID;
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