package br.edu.timetabling.model;

/**
 * Created by renan on 8/2/16.
 */
public class SwitchCourseTime {
    CourseTime courseTime1;
    CourseTime courseTime2;


    public SwitchCourseTime(CourseTime courseTime1, CourseTime courseTime2) {
        this.courseTime1 = courseTime1;
        this.courseTime2 = courseTime2;
    }

    public SwitchCourseTime() {

    }


    public CourseTime getCourseTime1() {
        return courseTime1;
    }

    public void setCourseTime1(CourseTime courseTime1) {
        this.courseTime1 = courseTime1;
    }

    public CourseTime getCourseTime2() {
        return courseTime2;
    }

    public void setCourseTime2(CourseTime courseTime2) {
        this.courseTime2 = courseTime2;
    }
}
