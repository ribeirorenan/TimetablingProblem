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
public class Tabu {

    List<Movimento> vizinhanca = new ArrayList<>();
    Aula target;
    int salaAtual;
    int horarioAtual;

    public void geraVizinhaca() {

        System.out.println("Buscando Vizinhaça");

        for (int i = 0; i < HorarioEscolar.salas.size(); i++) {
            for (int j = 0; j < HorarioEscolar.diasLetivos * HorarioEscolar.periodosPorDia; j++) {

                if (HorarioEscolar.tabelaHorario[i][j] == Aula.LIVRE) {
                    if (canMove(target, i, j)) {
                        vizinhanca.add(new Movimento(Aula.LIVRE, i, j));

                    }
                } else {
                   
                    if ((canSwap(HorarioEscolar.tabelaHorario[i][j], i, j)) && (!HorarioEscolar.tabelaHorario[i][j].equals(target))) {

                        vizinhanca.add(new Movimento(HorarioEscolar.tabelaHorario[i][j], i, j));
                    }
                }

            }
        }

    }

    public boolean canMove(Aula aula, int novaSala, int novoHorario) {
        if (HorarioEscolar.tabelaHorario[novaSala][novoHorario] == Aula.LIVRE) {
            if (Testes.testaRestricoesFortes(aula, novaSala, novoHorario)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean canSwap(Aula aula, int sala, int horario) {
        if (Testes.testaRestricoesFortesDeTroca(target, sala, horario)) {
            System.out.println("Entrou 1º Fase: "+target+" swap com "+aula);
            if (Testes.testaRestricoesFortesDeTroca(aula, salaAtual, horarioAtual)) {
 
                return true;
            }
            return false;
        }
        return false;
    }

    public void swap(Movimento mov) {

        HorarioEscolar.tabelaHorario[horarioAtual][salaAtual] = mov.aula;
        HorarioEscolar.tabelaHorario[mov.horario][mov.sala] = target;

    }

}
