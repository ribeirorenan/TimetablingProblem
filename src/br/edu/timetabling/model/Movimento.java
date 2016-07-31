/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.timetabling.model;

/**
 *
 * @author Joao
 */
public class Movimento {

    Aula aula;
    int sala;
    int horario;

    public Movimento() {
    }

    public Movimento(Aula aula, int sala, int horario) {
        this.aula = aula;
        this.sala = sala;
        this.horario = horario;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getSala() {
        return sala;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Movimento{" + "aula=" + aula + ", sala=" + sala + ", horario=" + horario + '}';
    }

}
