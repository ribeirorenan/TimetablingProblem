package br.edu.timetabling.model;

import java.util.List;

/**
 * Created by renan on 8/1/16.
 */
public class TabuSearch {
    private List<Curricula> curriculas;
    private List<Course> courses;
    private List<Room> rooms;
    TimeTable timeTable;

    public TabuSearch(List<Curricula> curriculas, List<Course> courses, List<Room> rooms, TimeTable timeTable) {
        this.curriculas = curriculas;
        this.courses = courses;
        this.rooms = rooms;
        this.timeTable = timeTable;
    }
}
