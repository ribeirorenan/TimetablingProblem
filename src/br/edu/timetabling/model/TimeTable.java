package br.edu.timetabling.model;

import java.util.Arrays;

/**
 * Created by renan
 */

public class TimeTable {

    private Course [][][] horario;

    private int days;
    private int periodsOfDay;
    private int rooms;

    public TimeTable() {

    }


    /*
     * Funções auxiliares
     */

    public boolean addCourse(Course course, CourseTime courseTime){
        days = courseTime.getDay();
        periodsOfDay = courseTime.getPeriodOfday();
        rooms = courseTime.getRoom();
        if(horario[days][periodsOfDay][rooms] == Course.FREE){
            horario[days][periodsOfDay][rooms] = course;
            return true;
        }
        return false;
    }

    public boolean switchCourses(){
        return false;
    }

    /*
     * Getters and Setters
     */


    public TimeTable(Course[][][] horario) {
        this.horario = horario;
    }

    public TimeTable(int days, int periods, int rooms) {
        this.horario = new Course[days][periods][rooms];
        setFreeTime(days, periods, rooms);
    }

    public Course[][][] getHorario() {
        return horario;
    }

    public void setHorario(Course[][][] horario) {
        this.horario = horario;
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
