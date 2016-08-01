package br.edu.timetabling.main;

import br.edu.timetabling.Util.HorarioEscolar;
import br.edu.timetabling.model.TabuSearch;
import br.edu.timetabling.model.TimeTable;

/**
 * Created by renan on 7/31/16.
 */

public class Main {
    public static void main(String[] args) {
        HorarioEscolar horarioEscolar = new HorarioEscolar();
        horarioEscolar.constroiHorarioPorArquivo("entrada.txt");
        //horarioEscolar.toString();
        TimeTable table = new TimeTable(horarioEscolar.getQntSalas(), horarioEscolar.getPeriodosPorDia(), horarioEscolar.getDiasLetivos());
        table.setFreeTime(horarioEscolar.getQntSalas(), horarioEscolar.getPeriodosPorDia(), horarioEscolar.getDiasLetivos());
        table.toString(horarioEscolar.getQntSalas(), horarioEscolar.getPeriodosPorDia(), horarioEscolar.getDiasLetivos());


        /*
         * A classe HorarioEscolar lê o arquivo de entrada, e proporciona para a classe TabuSearch os dados necessários
         * para a execução do algoritmo da Busca Tabu
         */
        TabuSearch tabuSearch = horarioEscolar.getTabuSearch();

    }
}
