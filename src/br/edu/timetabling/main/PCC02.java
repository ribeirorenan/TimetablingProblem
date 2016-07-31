/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.timetabling.main;

import br.edu.timetabling.model.HorarioEscolar;
import java.util.Scanner;

public class PCC02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        HorarioEscolar horario = new HorarioEscolar();
        horario.constroiHorarioPorArquivo("dataset01.txt");
        //System.out.println(horario);
        horario.constroiTabela();
        System.out.println(horario.tabelaToString());
    }

}