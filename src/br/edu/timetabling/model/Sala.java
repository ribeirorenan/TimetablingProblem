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
public class Sala {
    String nome;
    Integer capacidade;

    public Sala() {
    }

    @Override
    public String toString() {
        return "Sala{" + "nome=" + nome + ", capacidade=" + capacidade + '}';
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
    
}
