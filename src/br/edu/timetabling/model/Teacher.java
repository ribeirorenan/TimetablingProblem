package br.edu.timetabling.model;

/**
 * Created by renan
 */
public class Teacher {

    private String nome;

    static final Teacher TEACHER = new Teacher("teacher");

    public Teacher(String nome) {
        this.nome = nome;
    }


    public String getName() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
