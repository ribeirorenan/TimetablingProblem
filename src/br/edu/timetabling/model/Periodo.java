/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.timetabling.model;

/**
 *
 * @author Rodrigo
 */
public class Periodo {
    
    Integer dia;
    Integer hora;

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Periodo() {
    }

    @Override
    public String toString() {
        return "Horario{" + "dia=" + dia + ", hora=" + hora + '}';
    }

    public Periodo(Integer dia, Integer hora) {
        this.dia = dia;
        this.hora = hora;
    }
    
    
    
}
