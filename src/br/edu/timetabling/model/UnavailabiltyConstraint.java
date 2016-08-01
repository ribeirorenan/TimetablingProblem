package br.edu.timetabling.model;

/**
 * Created by renan on 7/31/16.
 */
public class UnavailabiltyConstraint {
    int day;
    int periodOfDay;


    public UnavailabiltyConstraint() {
    }

    public UnavailabiltyConstraint(int day, int periodOfDay) {
        this.day = day;
        this.periodOfDay = periodOfDay;
    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPeriodOfDay() {
        return periodOfDay;
    }

    public void setPeriodOfDay(int periodOfDay) {
        this.periodOfDay = periodOfDay;
    }

    @Override
    public String toString() {
        return "UnavailabiltyConstraint{" +
                "day=" + day +
                ", periodOfDay=" + periodOfDay +
                '}';
    }
}
