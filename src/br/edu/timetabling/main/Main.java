package br.edu.timetabling.main;

import br.edu.timetabling.Util.HorarioEscolar;

/**
 * Created by renan on 7/31/16.
 */
public class Main {
    public static void main(String[] args) {
        HorarioEscolar horarioEscolar = new HorarioEscolar();
        horarioEscolar.constroiHorarioPorArquivo("dataset01.txt");
        horarioEscolar.toString();
    }
}
