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



    public boolean verifyTabu(CourseTime courseTime1, CourseTime courseTime2){
        if((testSwitchTimeCourse(courseTime1, this.courseTime1)) && (testSwitchTimeCourse(courseTime2, this.courseTime2))){
            return false;
        }

        return true;
    }

    public boolean verifyTabu(SwitchCourseTime switchCourseTime1, SwitchCourseTime switchCourseTime2){
        if((testSwitchTimeCourse(switchCourseTime1.getCourseTime1(), switchCourseTime2.getCourseTime1())) && (testSwitchTimeCourse(switchCourseTime2.getCourseTime2(), switchCourseTime1.getCourseTime2()))){
            return true;
        }

        return true;
    }

    private boolean testSwitchTimeCourse(CourseTime courseTime1, CourseTime courseTime2){
        if((courseTime1.getDay() == courseTime2.getDay()) && (courseTime1.getPeriodOfday() == courseTime2.getPeriodOfday()) && courseTime1.getRoom() == courseTime2.getRoom()){
            return true;
        }
        return false;
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

    @Override
    public String toString() {
        return "SwitchCourseTime{" +
                "courseTime1=" + courseTime1 +
                ", courseTime2=" + courseTime2 +
                '}';
    }
}
