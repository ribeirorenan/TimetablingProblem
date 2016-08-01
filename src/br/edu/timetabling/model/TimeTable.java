package br.edu.timetabling.model;

import java.util.Arrays;

/**
 * Created by renan on 7/31/16.
 */

public class TimeTable {

    private Course [][][] horario;

    public TimeTable() {
    }

    public TimeTable(Course[][][] horario) {
        this.horario = horario;
    }

    public TimeTable(int days, int periods, int rooms) {
        this.horario = new Course[days][periods][rooms];
    }

    public Course[][][] getHorario() {
        return horario;
    }

    public void setHorario(Course[][][] horario) {
        this.horario = horario;
    }
    
    public void setFreeTime(int days, int periods, int rooms){
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < periods; j++) {
                for (int k = 0; k < rooms; k++) {
                    this.horario[i][j][k] = Course.FREE;
                }
            }
        }
    }

    public String toString(int days, int rooms, int periods) {
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

        return "TimeTable{" +
                "horario=" + Arrays.toString(horario) +
                '}';
    }
}
