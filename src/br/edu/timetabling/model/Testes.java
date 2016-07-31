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
public class Testes {

    public static Boolean testaHorario(Aula aula, Integer horario) {

        for (Periodo periodo : aula.materia.restricoes) {

            if (HorarioEscolar.converteHorarioIndice(periodo.dia, periodo.hora) == horario) {
                return false;
            }
        }
        return true;
    }

    public static Boolean testaDisponibilidadeSala(Integer sala, Integer horario) {

        return (HorarioEscolar.tabelaHorario[sala][horario] == Aula.LIVRE);
    }

    public static Boolean testaTurma(Aula aula, Integer horario) {

        for (Turma t : HorarioEscolar.turmas) {
            if (t.getMaterias().contains(aula)) {
                for (Materia m : t.getMaterias()) {
                    for (int i = 0; i < HorarioEscolar.salas.size(); i++) {
                        if (HorarioEscolar.tabelaHorario[i][horario] == aula) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static Boolean testaProfessor(Aula aula, Integer horario) {

        for (Aula a : HorarioEscolar.aulas) {
            if (aula.materia.professor.equals(a.materia.professor) && (!aula.equals(a))) {
                //System.out.println(aula.professor + " ====== " + m.professor + "    " + m.nome + "  e  " + aula.nome);

                for (int i = 0; i < HorarioEscolar.salas.size(); i++) {
                    if (HorarioEscolar.tabelaHorario[i][horario] == a) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static Boolean testaRestricoesFortes(Aula aula, Integer sala, Integer horario) {

        return (testaProfessor(aula, horario))
                && (testaDisponibilidadeSala(sala, horario))
                && (testaTurma(aula, horario))
                && (testaHorario(aula, horario));

    }

    public static Boolean testaRestricoesFortesDeTroca(Aula aula, Integer sala, Integer horario) {

        return (testaTurma(aula, horario))
                && (testaHorario(aula, horario));

    }
    
    public Integer funcaoAvaliacao(){
        return ((testaDiasMinimos())
                + (testaAulaIsoladas())
                + (testaEstabilidadeSala())
                + (testaSala()));
    }
    
    public static Integer testaDiasMinimos() {
        Integer nota = 0;
        int dias = 0;

        //Nota X Peso
        return nota * 5;

    }

    public static int testaSala() {
        Integer nota = 0;
        Integer notaParcial = 0;

        for (Materia materia : HorarioEscolar.materias) {
            for (int i = 0; i < HorarioEscolar.salas.size(); i++) {
                for (int j = 0; j < HorarioEscolar.periodosPorDia * HorarioEscolar.diasLetivos; j++) {
                    if(HorarioEscolar.tabelaHorario[i][j].materia == materia ){
                        notaParcial = HorarioEscolar.salas.get(i).capacidade - materia.qntAlunos;
                        if(notaParcial < 0){
                            nota += notaParcial * -1;
                        }    
                    }
                    notaParcial = 0;
                }
            }
        }
        return nota;
    }

    public static Integer testaAulaIsoladas() {
        Integer nota = 0;

//        Integer horarioInicio = horario - aula.materia.minDiasTrabalhados;
//
//        if (horario - aula.materia.minDiasTrabalhados <= 0) {
//            horarioInicio = 0;
//        }
//
//        for (int i = 0; i < HorarioEscolar.salas.size(); i++) {
//            for (int j = horarioInicio; j < horario + aula.materia.minDiasTrabalhados; j++) {
//                //System.out.println("["+i+"]"+"["+j+"]"+HorarioEscolar.tabela[i][j] + "    "+ aula.nome);
//                if (HorarioEscolar.tabelaHorario[i][j] == aula) {
//                    nota++;
//                }
//            }
//        }

        //Nota X Peso
        return nota * 2;
    }

    public static Integer testaEstabilidadeSala() {
        Integer nota = 0;

//        for (int i = 0; i < HorarioEscolar.salas.size(); i++) {
//            if (i != sala) {
//                for (int j = 0; j < HorarioEscolar.getTotalAulas(); j++) {
//                    if (HorarioEscolar.tabelaHorario[i][j] == aula) {
//                        nota++;
//                    }
//                }
//            }
//        }

        //Nota X Peso
        return nota * 1;
    }
}
