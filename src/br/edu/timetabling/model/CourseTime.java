package br.edu.timetabling.model;

/**
 * Created by renan
 */
public class CourseTime {
    private int day;
    private int periodOfday;
    private int room;

    public CourseTime(int day, int periodOfday, int room) {
        this.day = day;
        this.periodOfday = periodOfday;
        this.room = room;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPeriodOfday() {
        return periodOfday;
    }

    public void setPeriodOfday(int periodOfday) {
        this.periodOfday = periodOfday;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
