/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.timetabling.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Materia {
    
    String nome;
    String professor;
    Integer qntAulasSemanais;
    Integer qntAlunos;
    Integer minDiasTrabalhados;
    
    public List<Periodo> restricoes = new ArrayList<>();
    
    public Materia() {
    }

    public Materia(String nome, String professor, Integer qntAulasSemanais, Integer qntAlunos, Integer minDiasFolga) {
        this.nome = nome;
        this.professor = professor;
        this.qntAulasSemanais = qntAulasSemanais;
        this.qntAlunos = qntAlunos;
        this.minDiasTrabalhados = minDiasFolga;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Integer getQntAulasSemanais() {
        return qntAulasSemanais;
    }

    public void setQntAulasSemanais(Integer qntAulasSemanais) {
        this.qntAulasSemanais = qntAulasSemanais;
    }

    public Integer getQntAlunos() {
        return qntAlunos;
    }

    public void setQntAlunos(Integer qntAlunos) {
        this.qntAlunos = qntAlunos;
    }

    public Integer getMinDiasFolga() {
        return minDiasTrabalhados;
    }

    public void setMinDiasFolga(Integer minDiasFolga) {
        this.minDiasTrabalhados = minDiasFolga;
    }

    @Override
    public String toString() {
        return "Materia{" + "nome=" + nome + ", professor=" + professor + ", qntAulasSemanais=" + qntAulasSemanais + ", qntAlunos=" + qntAlunos + ", minDiasFolga=" + minDiasTrabalhados + ", restricoes=" + restricoes + '}';
    }

 
    
    
    
    
}
