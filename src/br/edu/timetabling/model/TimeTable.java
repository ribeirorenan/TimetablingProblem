package br.edu.timetabling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan
 */

public class TimeTable {

    private Course [][][] horario;

    private int days;
    private int periodsOfDay;
    private int rooms;
    private List<SwitchCourseTime> tabuList;

    public TimeTable() {

    }

    public TimeTable(Course[][][] horario) {
        this.horario = horario;
    }

    public TimeTable(int days, int periods, int rooms) {
        this.days = days;
        this.periodsOfDay = periods;
        this.rooms = rooms;
        this.horario = new Course[days][periods][rooms];
        this.tabuList = new ArrayList<>();
        setFreeTime(days, periods, rooms);
    }


    /*
     * Funções auxiliares
     */

    public boolean addCourse(Course course, CourseTime courseTime){
        if(horario[courseTime.getDay()][courseTime.getPeriodOfday()][courseTime.getRoom()] == Course.FREE){
            horario[courseTime.getDay()][courseTime.getPeriodOfday()][courseTime.getRoom()] = course;
            horario[courseTime.getDay()][courseTime.getPeriodOfday()][courseTime.getRoom()].setCourseTime(courseTime);
            return true;
        }
        return false;
    }

    /**
     * Troca os cursos de horário dentro da tabela de cursos
     * @param courseTime1
     * @param courseTime2
     * @return
     */
    public boolean switchCourses(CourseTime courseTime1, CourseTime courseTime2){
        Course courseAux = getCourseByCourseTime(courseTime1);

        this.horario[courseTime1.getDay()][courseTime1.getPeriodOfday()][courseTime1.getRoom()] = this.horario[courseTime1.getDay()][courseTime2.getPeriodOfday()][courseTime2.getRoom()];
        this.horario[courseTime1.getDay()][courseTime2.getPeriodOfday()][courseTime2.getRoom()] = courseAux;
        return true;
    }

    /*
     * Se já tiver na lista tabu não realiza o movimento
     */
    public boolean switchCourses(CourseTime courseTime1, CourseTime courseTime2, List<SwitchCourseTime> switchCourseTimes){
        Course courseAux = getCourseByCourseTime(courseTime1);

        for (SwitchCourseTime switchCourseTime : switchCourseTimes) {
            if (switchCourseTime.verifyCourseTimeSwitch(courseTime1, courseTime2)) {
                return false;
            }
        }
        this.horario[courseTime1.getDay()][courseTime1.getPeriodOfday()][courseTime1.getRoom()] = this.horario[courseTime1.getDay()][courseTime2.getPeriodOfday()][courseTime2.getRoom()];
        this.horario[courseTime1.getDay()][courseTime2.getPeriodOfday()][courseTime2.getRoom()] = courseAux;
        return true;
    }


    public void addTabu(CourseTime courseTime1, CourseTime courseTime2){
        tabuList.add(new SwitchCourseTime(courseTime1, courseTime2));
    }

    private void setFreeTime(int days, int periods, int rooms){
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < periods; j++) {
                for (int k = 0; k < rooms; k++) {
                    this.horario[i][j][k] = Course.FREE;
                }
            }
        }
    }


    /*
     * Getters and Setters
     */

    public Course[][][] getHorario() {
        return horario;
    }

    public void setHorario(Course[][][] horario) {
        this.horario = horario;
    }

    public List<SwitchCourseTime> getTabuList() {
        return tabuList;
    }

    public void setTabuList(List<SwitchCourseTime> tabuList) {
        this.tabuList = tabuList;
    }

    public Course getCourseByCourseTime(CourseTime courseTime){
        return this.horario[courseTime.getDay()][courseTime.getPeriodOfday()][courseTime.getRoom()];
    }

    public Course[][][] getTimeTable() {
        return horario;
    }

    public void setTimeTable(Course[][][] horario) {
        this.horario = horario;
    }

    public String toString(int days, int periods, int rooms) {
        System.out.println("Horário: ");
        System.out.println();

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < periods; j++) {
                for (int k = 0; k < rooms; k++) {
                    System.out.print(this.horario[i][j][k].getName() + "  ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return " ";
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPeriodsOfDay() {
        return periodsOfDay;
    }

    public void setPeriodsOfDay(int periodsOfDay) {
        this.periodsOfDay = periodsOfDay;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
