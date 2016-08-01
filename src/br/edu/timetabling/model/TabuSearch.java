package br.edu.timetabling.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by renan
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


    /**
     * Inicia o algoritmo Tabu Search
     */
    public void start(){
        /* Gera a solução incial */
        TimeTable timeTableInicial = initialSolution();
    }

    /*
     * Cria solução inicial da tabela de horário
     */
    private TimeTable initialSolution() {

        for (Course course : courses) {
            //Lista com os CourseTimes disponíveis para cada curso
            List<CourseTime> listOfCourseTimes = new ArrayList<CourseTime>();

            for (int i = 0; i < timeTable.getDays(); i++) {
                for (int j = 0; j < timeTable.getPeriodsOfDay(); j++) {
                    for (int k = 0; k < timeTable.getRooms(); k++) {


                        if(courseTimeAvailable(course, new CourseTime(i, j, k))){
                            listOfCourseTimes.add(new CourseTime(i, j, k));
                        }

                    }
                }
            }

            /*
             * Verifica se a quantidade de aulas é menor que a quantidade de salas disponíveis para alocar as aulas.
             * Após essa verificação, adiciona aulas em salas aleatórias a partir da lista de salas disponíveis
             */
            if(course.getNumberOfLectures() < listOfCourseTimes.size()){
                for (int i = 0; i < course.getNumberOfLectures(); i++) {
                    while(!listOfCourseTimes.isEmpty()){
                        Random random = new Random();
                        int courseTimePosition = random.nextInt(listOfCourseTimes.size());
                        if(timeTable.addCourse(course, listOfCourseTimes.get(courseTimePosition))){
                            listOfCourseTimes.remove(courseTimePosition);
                            break;
                        }
                        listOfCourseTimes.remove(courseTimePosition);
                    }

                }
            }
        }

        return null;
    }

    private boolean courseTimeAvailable(Course course, CourseTime courseTime){
        if(getAvailableRoomsCapacity(course, courseTime) && getAvailableTimes(course, courseTime)){
            return true;
        }

        return false;
    }



    /*
     * Funções auxiliares
     */

    private List<Course> getTopDownCourseList(){


        for (Course course : courses) {

        }

        return null;
    }

    private List<Room> getAvailableRoomsCapacity(Course course){
        List<Room> roomsAvailableCapacity = new ArrayList<Room>();

        for (Room room : rooms){
            if (room.getCapacity() >= course.getNumberOfStudents()) {
                roomsAvailableCapacity.add(room);
            }
        }

        return roomsAvailableCapacity;
    }
    private boolean getAvailableRoomsCapacity(Course course, CourseTime courseTime){
        if(course.getNumberOfLectures() <= rooms.get(courseTime.getRoom()).getCapacity()){
            return true;
        }
        return false;
    }

    private boolean getAvailableTimes(Course course, CourseTime courseTime){

        List<UnavailabiltyConstraint> constraintList = course.getUnavailabiltyConstraints();
        for (UnavailabiltyConstraint constraint: constraintList) {
            if (constraint.getDay() == courseTime.getDay() && constraint.getPeriodOfDay() == courseTime.getPeriodOfday()) {
                return false;
            }
        }

        return true;
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
