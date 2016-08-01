/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.timetabling.Util;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.edu.timetabling.model.*;

public class HorarioEscolar {

    String nome;
    static Integer quantidadeMaterias;
    static Integer qntSalas;
    static Integer diasLetivos;
    static Integer periodosPorDia;
    static Integer qntTurma;
    static Integer qntRestricoes;

    private List<Curricula> curriculas;
    private List<Course> courses;
    private List<Room> rooms;
    private TimeTable timeTable;

    public static int[][] aulasConflitantes;
    public static int[][] horariosDisponiveis;

    public HorarioEscolar() {
        curriculas = new ArrayList<Curricula>();
        courses = new ArrayList<Course>();
        rooms = new ArrayList<Room>();
    }

    public void constroiHorarioPorArquivo(String nomeArquivo) {

        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {

                String primeiraPalavra = Util.buscaPalavra(linha);

                switch (primeiraPalavra) {

                    case "Name":
                        this.setNome(Util.restante);
                        break;
                    case "Courses":
                        this.setQntMaterias(Integer.valueOf(Util.restante));
                        break;
                    case "Rooms":
                        this.setQntSalas(Integer.valueOf(Util.restante));
                        break;
                    case "Days":
                        this.setDiasLetivos(Integer.valueOf(Util.restante));
                        break;
                    case "Periods_per_day":
                        this.setPeriodosPorDia(Integer.valueOf(Util.restante));
                        break;
                    case "Curricula":
                        this.setQntTurma(Integer.valueOf(Util.restante));
                        break;
                    case "Constraints":
                        this.setQntRestricoes(Integer.valueOf(Util.restante));
                        break;

                    case "COURSES": {

                        for (int i = 1; i <= this.getQntMaterias(); i++) {

                            linha = lerArq.readLine();
                            Course newCourse = new Course();
                            newCourse.setName(Util.buscaPalavra(linha));
                            newCourse.setTeacher(new Teacher(Util.buscaPalavra(Util.restante)));
                            newCourse.setNumberOfLectures(Integer.valueOf(Util.buscaPalavra(Util.restante)));
                            newCourse.setMinWorkingDays(Integer.valueOf(Util.buscaPalavra(Util.restante)));
                            newCourse.setNumberOfStudents(Integer.valueOf(Util.restante));
                            this.courses.add(newCourse);
                        }
                        break;
                    }

                    case "ROOMS": {

                        for (int i = 1; i <= this.getQntSalas(); i++) {

                            linha = lerArq.readLine();
                            Room newRoom = new Room();
                            newRoom.setId(Util.buscaPalavra(linha));
                            newRoom.setCapacity(Integer.valueOf(Util.restante));
                            this.rooms.add(newRoom);

                        }
                        break;
                    }

                    case "CURRICULA": {
                        for (int i = 1; i <= this.getQntTurma(); i++) {
                            linha = lerArq.readLine();
                            Curricula newCurricula = new Curricula();
                            newCurricula.setCurriculumId(Util.buscaPalavra(linha));
                            int qntMaterias = (Integer.valueOf(Util.buscaPalavra(Util.restante)));
                            newCurricula.setNumberOfCourses(qntMaterias);
                            for (int j = 1; j < qntMaterias; j++) {
                                newCurricula.getCourses().add(this.buscaMateriaPorNome(Util.buscaPalavra(Util.restante)));

                            }
                            newCurricula.addCourse(this.buscaMateriaPorNome(Util.restante));
                            this.curriculas.add(newCurricula);

                        }
                        break;
                    }

                    case "UNAVAILABILITY_CONSTRAINTS": {
                        linha = lerArq.readLine();
                        while (!Util.buscaPalavra(linha).equals("")) {

                            Course course = this.buscaMateriaPorNome(Util.buscaPalavra(linha));
                            UnavailabiltyConstraint unavailabiltyConstraint = new UnavailabiltyConstraint();
                            unavailabiltyConstraint.setDay(Integer.valueOf(Util.buscaPalavra(Util.restante)));
                            unavailabiltyConstraint.setPeriodOfDay(Integer.valueOf(Util.restante));
                            course.addUnavailabilityConstraints(unavailabiltyConstraint);
                            linha = lerArq.readLine();
                        }

                        break;
                    }

                }

                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        /*
         * seta a instância da timeTable com os dados obtidos
         */
        timeTable = new TimeTable(diasLetivos, periodosPorDia, qntSalas);
    }

    /*
     * Função que cria uma instância da busca tabu com todos os dados necessários
     */

    public TabuSearch getTabuSearch(){
        return new TabuSearch(curriculas, courses, rooms, timeTable);
    }

    public String toString(){

        System.out.println("Cursos: ");
        for (Course course : courses) {
            System.out.print(course.toString());
            System.out.println();
        }
        System.out.println();


        System.out.println("Salas: ");
        for (Room room: rooms) {
            System.out.println(room.toString());
        }

        System.out.println("Turmas: ");
        for (Curricula curricula : curriculas) {
            System.out.println(curricula.toString());
        }

        return "";
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;

    }

    public Integer getQntMaterias() {
        return quantidadeMaterias;
    }

    public void setQntMaterias(Integer qntMaterias) {
        this.quantidadeMaterias = qntMaterias;
    }

    public Integer getQntSalas() {
        return qntSalas;
    }

    public void setQntSalas(Integer qntSalas) {
        this.qntSalas = qntSalas;

    }

    public Integer getDiasLetivos() {
        return diasLetivos;
    }

    public void setDiasLetivos(Integer diasLetivos) {
        this.diasLetivos = diasLetivos;
    }

    public Integer getPeriodosPorDia() {
        return periodosPorDia;
    }

    public void setPeriodosPorDia(Integer periodosPorDia) {
        this.periodosPorDia = periodosPorDia;
    }

    public Integer getQntTurma() {
        return qntTurma;
    }

    public void setQntTurma(Integer qntTurma) {
        this.qntTurma = qntTurma;
    }

    public Integer getQntRestricoes() {
        return qntRestricoes;
    }

    public void setQntRestricoes(Integer qntRestricoes) {
        this.qntRestricoes = qntRestricoes;
    }

    public Course buscaMateriaPorNome(String nome) {

        for (Course course : courses) {
            if (course.getName().equals(nome)) {
                return course;
            }

        }
        return null;

    }


    public String tabelaToString() {

        return "";
    }

    public void constroiTabela() {

    }

    /*
        Inicialização de Objetos Finais
     */
    public void constroiTabelaAulasConflitantes() {

    }

    public void constroiTabelaHorariosDisponiveis() {


    }

}
