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



    public boolean verifyCourseTimeSwitch(CourseTime courseTime1, CourseTime courseTime2){
        if((courseTime1 == this.courseTime1) && (courseTime2 == this.courseTime2)){
            return false;
        }

        return true;
    }

    /*
     * Getters and Setters
     */

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
