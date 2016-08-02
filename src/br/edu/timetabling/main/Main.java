package br.edu.timetabling.main;

import br.edu.timetabling.Util.HorarioEscolar;
import br.edu.timetabling.model.TabuSearch;
import br.edu.timetabling.model.TimeTable;

/**
 * Created by renan
 */

public class Main {
    public static void main(String[] args) {
        HorarioEscolar horarioEscolar = new HorarioEscolar();
        horarioEscolar.constroiHorarioPorArquivo("/Users/pcmonceff/GitHub/TimetablingProblem/instancias/comp01.ctt");
        //horarioEscolar.toString();

        int days = horarioEscolar.getDiasLetivos();
        int periods = horarioEscolar.getPeriodosPorDia();
        int rooms = horarioEscolar.getQntSalas();

        TimeTable table = new TimeTable(days, periods, rooms);
//        table.toString(days, periods, rooms);

        /*
         * A classe HorarioEscolar lê o arquivo de entrada, e proporciona para a classe TabuSearch os dados necessários
         * para a execução do algoritmo da Busca Tabu
         */

        TabuSearch tabuSearch = horarioEscolar.getTabuSearch();

        tabuSearch.start();

        tabuSearch.getTimeTable().toString(days, periods, rooms);

    }
}
