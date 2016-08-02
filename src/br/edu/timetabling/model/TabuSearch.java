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

        for (Curricula curricula: curriculas) {
            for (Course course: curricula.getCourses()) {
                if (course != null){
                    course.setCourseCurriculaID(curricula.getCurriculaID());
                }
            }
        }

        for (Course course : courses) {
            //Lista com os CourseTimes disponíveis para cada curso
            List<CourseTime> listOfCourseTimes = new ArrayList<CourseTime>();

            for (int i = 0; i < timeTable.getDays(); i++) {
                for (int j = 0; j < timeTable.getPeriodsOfDay(); j++) {
                    for (int k = 0; k < timeTable.getRooms(); k++) {

                        //obtem lista de courseTimes disponíveis
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
                        if (checkScheduleConflict(course, listOfCourseTimes.get(courseTimePosition))) { //checa se não há aula no mesmo horário

                            if (timeTable.addCourse(course, listOfCourseTimes.get(courseTimePosition))) { //checa se foi possível adicionar na timetable
                                course.incrementCountOfInsertedLectures();
                                listOfCourseTimes.remove(courseTimePosition);
                                break;
                            }

                        }
                        listOfCourseTimes.remove(courseTimePosition);
                    }
                }
            }

        }
        timeTable.toString(1, timeTable.getPeriodsOfDay(), timeTable.getRooms());
        timeTable.switchCourses(new CourseTime(0,0,0), new CourseTime(0,0,1));
        System.out.println("\n\n\n");

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
        if(course.getNumberOfStudents() <= rooms.get(courseTime.getRoom()).getCapacity()){
            return true;
        }

        return false;
    }

    /*
     * Verifica se está inserindo na restrição do curso
     */
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
     * Verifica se há conflito de Courses no mesmo horário em salas diferentes
     */
    private boolean checkScheduleConflict(Course course, CourseTime courseTime){
        for (int i = 0; i < timeTable.getRooms(); i++) {
            if (timeTable.getTimeTable()[courseTime.getDay()][courseTime.getPeriodOfday()][i].getCourseCurriculaID() == course.getCourseCurriculaID()){
                //System.out.println(course.getName() + " " + course.getCourseCurriculaID());
                return false;
            }
        }

        return true;
    }

    /*
     * Obtém o indice de uma currícula de um determinado curso passado por parâmetro
     */
    private int getResumeFromCourse (Course course){

        int i = 0;


        for (Curricula curricula: curriculas) {
            if (curricula.getCourses().contains(course)){

            }
        }

        return 0;
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