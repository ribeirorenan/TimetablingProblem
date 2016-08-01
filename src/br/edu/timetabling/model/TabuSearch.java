package br.edu.timetabling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 8/1/16.
 */
public class TabuSearch {
    /*
     * Estruturas primárias
     */
    private List<Curricula> curriculas;
    private List<Course> courses;
    private List<Room> rooms;
    TimeTable timeTable;


    /*
     * Estruturas auxiliares
     */
    private ArrayList<Room> virtualRoom;

    public TabuSearch(List<Curricula> curriculas, List<Course> courses, List<Room> rooms, TimeTable timeTable) {
        this.curriculas = curriculas;
        this.courses = courses;
        this.rooms = rooms;
        this.timeTable = timeTable;
    }


    public void start(){

    }

    /*
     * Cria solução inicial da tabela de horário
     */
    private TabuSearch initialSolution() {



        return null;
    }





    /*
     * Funções auxiliares
     */

    private List<Course> getTopDownCourseList(){


        for (Course course : courses) {

        }

        return null;
    }

    private List<Room> getAvaibleRooms(Course course){
        List<Room> roomsAvaible = new ArrayList<Room>();

        for (Room room : rooms){
            if (room.getCapacity() >= course.getNumberOfStudents()) {
                roomsAvaible.add(room);
            }
        }

        return roomsAvaible;
    }

    /*
     * Getters and Setters
     */

    public List<Curricula> getCurriculas() {
        return curriculas;
    }

    public void setCurriculas(List<Curricula> curriculas) {
        this.curriculas = curriculas;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    public ArrayList<Room> getVirtualRoom() {
        return virtualRoom;
    }

    public void setVirtualRoom(ArrayList<Room> virtualRoom) {
        this.virtualRoom = virtualRoom;
    }
}
