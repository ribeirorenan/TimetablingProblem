/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.timetabling.model;

import br.edu.timetabling.Util.Util;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HorarioEscolar {

    String nome;
    static Integer quantidadeMaterias;
    static Integer quantidadeSalas;
    static Integer diasLetivos;
    static Integer periodosPorDia;
    static Integer quantidadeTurmas;
    static Integer quantidadeRestricoes;

    public static List<Materia> materias = new ArrayList<>();
    public static List<Sala> salas = new ArrayList<>();
    public static List<Turma> turmas = new ArrayList<>();
    public static List<Aula> aulas = new ArrayList<>();

    public static Aula[][] tabelaHorario;
    public static int[][] aulasConflitantes;
    public static int[][] horariosDisponiveis;

    public HorarioEscolar() {

    }
    /*
    Função para ler o arquivo e construir o horario saca?
     */

    public void constroiHorarioPorArquivo(String nomeArquivo) {
        //Teste de Push
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {

                String primeiraPalavra = Util.buscaPalavra(linha);

                switch (primeiraPalavra) {

                    case "Name":
                        this.setNome(Util.restante);
                        break;
                    case "Courses":
                        this.setQntMaterias(Integer.valueOf(Util.restante));
                        break;
                    case "Rooms":
                        this.setQntSalas(Integer.valueOf(Util.restante));
                        break;
                    case "Days":
                        this.setDiasLetivos(Integer.valueOf(Util.restante));
                        break;
                    case "Periods_per_day":
                        this.setPeriodosPorDia(Integer.valueOf(Util.restante));
                        break;
                    case "Curricula":
                        this.setQntTurma(Integer.valueOf(Util.restante));
                        break;
                    case "Constraints":
                        this.setQntRestricoes(Integer.valueOf(Util.restante));
                        break;

                    case "COURSES": {

                        for (int i = 1; i <= this.getQntMaterias(); i++) {

                            linha = lerArq.readLine();
                            Materia novaMateria = new Materia();
                            novaMateria.setNome(Util.buscaPalavra(linha));
                            novaMateria.setProfessor(Util.buscaPalavra(Util.restante));
                            novaMateria.setQntAulasSemanais(Integer.valueOf(Util.buscaPalavra(Util.restante)));
                            novaMateria.setMinDiasFolga(Integer.valueOf(Util.buscaPalavra(Util.restante)));
                            novaMateria.setQntAlunos(Integer.valueOf(Util.restante));
                            this.materias.add(novaMateria);

                        }
                        break;
                    }

                    case "ROOMS": {

                        for (int i = 1; i <= this.getQntSalas(); i++) {

                            linha = lerArq.readLine();
                            Sala novaSala = new Sala();
                            novaSala.setNome(Util.buscaPalavra(linha));
                            novaSala.setCapacidade(Integer.valueOf(Util.restante));
                            this.salas.add(novaSala);

                        }
                        break;
                    }

                    case "CURRICULA": {

                        for (int i = 1; i <= this.getQntTurma(); i++) {
                            linha = lerArq.readLine();
                            Turma novaTurma = new Turma();
                            novaTurma.setNome(Util.buscaPalavra(linha));
                            int qntMaterias = (Integer.valueOf(Util.buscaPalavra(Util.restante)));

                            for (int j = 1; j < qntMaterias; j++) {
                                novaTurma.materias.add(this.buscaMateriaPorNome(Util.buscaPalavra(Util.restante)));
                            }
                            novaTurma.materias.add(this.buscaMateriaPorNome(Util.restante));
                            this.turmas.add(novaTurma);

                        }
                        break;
                    }

                    case "UNAVAILABILITY_CONSTRAINTS": {
                        linha = lerArq.readLine();
                        while (!Util.buscaPalavra(linha).equals("")) {

                            Materia m = this.buscaMateriaPorNome(Util.buscaPalavra(linha));
                            Periodo h = new Periodo();
                            h.setDia(Integer.valueOf(Util.buscaPalavra(Util.restante)));
                            h.setHora(Integer.valueOf(Util.restante));
                            m.restricoes.add(h);
                            linha = lerArq.readLine();
                        }

                        break;
                    }

                }

                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }

    public String getNome() {
        return nome;
    }

    public static Integer getTotalAulas() {
        Integer soma = 0;
        for (Materia materia : materias) {
            soma += materia.qntAulasSemanais;
        }
        return soma;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public Integer getQntMaterias() {
        return quantidadeMaterias;
    }

    public void setQntMaterias(Integer qntMaterias) {
        this.quantidadeMaterias = qntMaterias;
    }

    public Integer getQntSalas() {
        return quantidadeSalas;
    }

    public void setQntSalas(Integer qntSalas) {
        this.quantidadeSalas = qntSalas;

    }

    public Integer getDiasLetivos() {
        return diasLetivos;
    }

    public void setDiasLetivos(Integer diasLetivos) {
        this.diasLetivos = diasLetivos;
    }

    public Integer getPeriodosPorDia() {
        return periodosPorDia;
    }

    public void setPeriodosPorDia(Integer periodosPorDia) {
        this.periodosPorDia = periodosPorDia;
    }

    public Integer getQntTurma() {
        return quantidadeTurmas;
    }

    public void setQntTurma(Integer qntTurma) {
        this.quantidadeTurmas = qntTurma;
    }

    public Integer getQntRestricoes() {
        return quantidadeRestricoes;
    }

    public void setQntRestricoes(Integer qntRestricoes) {
        this.quantidadeRestricoes = qntRestricoes;
    }

    @Override
    public String toString() {
        return "HorarioEscolar{" + "nome=" + nome + ", quantidadeMaterias=" + quantidadeMaterias + ", quantidadeSalas=" + quantidadeSalas + ", dias=" + diasLetivos + ", periodosPorDia=" + periodosPorDia + ", quantidadeTurmas=" + quantidadeTurmas + ", quantidadeRestricoes=" + quantidadeRestricoes + ", materias=" + materias + ", salas=" + salas + '}';
    }

    public static Materia buscaMateriaPorNome(String nome) {

        for (Materia materia : materias) {
            if (materia.nome.equals(nome)) {
                return materia;
            }

        }
        return null;

    }

    public int[] buscaLocalizacaoAula(Aula a) {

        for (int i = 0; i < diasLetivos * periodosPorDia; i++) {
            for (int j = 0; j < salas.size(); j++) {

                if (tabelaHorario[j][i].equals(a)) {
                    return (new int[]{j, i});
                }
            }
        }
        return null;
    }

    public String tabelaToString() {

        String saida = "\n           SALAS          \n    ";

        for (int i = 0; i < salas.size(); i++) {
            saida = saida + i + "       ";

        }

        for (int i = 0; i < diasLetivos * periodosPorDia; i++) {
            if (i % periodosPorDia == 0) {
                saida = saida + "\n";
            }
            saida = saida + "\n " + i % periodosPorDia + " ";

            for (int j = 0; j < salas.size(); j++) {
                int qntEspacos = 7;
                if (tabelaHorario[j][i] != null) {
                    saida = saida + tabelaHorario[j][i].materia.nome;
                    qntEspacos -= tabelaHorario[j][i].materia.nome.length();

                }

                for (int k = 0; k < qntEspacos; k++) {

                    saida = saida + " ";
                }
            }

        }
        return saida;

    }

    public void horariosDisponiveisToString() {

        System.out.print("\n           Horarios Disponiveis          \n   ");

        for (int i = 0; i < aulas.size(); i++) {
            System.out.print(aulas.get(i) + "  ");
        }

        System.out.println(aulas.size());

        for (int i = 0; i < aulas.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < diasLetivos * periodosPorDia; j++) {
                System.out.print(" " + horariosDisponiveis[i][j] + "  ");

            }
            System.out.println("\n");
        }
    }

    public void aulaConflitantesToString() {

        System.out.print("\n           Aulas Conflitantes          \n\t  ");

        for (int i = 0; i < aulas.size(); i++) {
            System.out.print(i + "  ");
        }

        for (int i = 0; i < aulas.size(); i++) {

            for (int j = 0; j < aulas.size(); j++) {
                System.out.print(aulasConflitantes[i][j] + "  ");

            }
            System.out.println("\n");
        }
    }

    /**
     *
     * @param aula
     * @return O valor da sala alocada ou -1 se nenhuma sala foi encontrada
     */
    public static int retornaSalaAula(Aula aula) {
        for (int i = 0; i < periodosPorDia * diasLetivos; i++) {
            for (int j = 0; j < quantidadeSalas; j++) {
                if (tabelaHorario[j][i] == aula) {
                    return j;
                }
            }
        }

        return -1;
    }

    public void adicionaMateriaTabela(Aula aula) {
        int valor;
        for (int i = 0; i < diasLetivos * periodosPorDia; i++) {
            for (int j = 0; j < salas.size(); j++) {
                if (Testes.testaRestricoesFortes(aula, j, i)) {
                   
                    //System.out.println("Inserindo: " + aula.materia.nome + " nota = " + valor);
                    tabelaHorario[j][i] = aula;
                    return;
                }
            }

        }
        return;
    }

    public void preencheVagasVazias() {
        for (int i = 0; i < salas.size(); i++) {
            for (int j = 0; j < diasLetivos * periodosPorDia; j++) {

                if (tabelaHorario[i][j] == null) {
                    tabelaHorario[i][j] = Aula.LIVRE;
                }

            }
        }
    }

    public static Integer converteHorarioIndice(Integer dia, Integer hora) {

        return ((dia * HorarioEscolar.periodosPorDia) + (hora));
    }

    public void constroiTabela() {

        tabelaHorario = new Aula[quantidadeSalas][diasLetivos * periodosPorDia];
        aulasConflitantes = new int[getTotalAulas()][getTotalAulas()];
        horariosDisponiveis = new int[getTotalAulas()][diasLetivos * periodosPorDia];
        int valor = 0;
        

        Materia maisRestrita;
        List<Materia> mRestantes = new ArrayList<Materia>(materias);
        preencheVagasVazias();

        while (!mRestantes.isEmpty()) {
            maisRestrita = mRestantes.get(0);
            for (Materia m : mRestantes) {
                if (m.restricoes.size() > maisRestrita.restricoes.size()) {
                    maisRestrita = m;

                }
            }

            mRestantes.get(mRestantes.indexOf(maisRestrita)).qntAulasSemanais--;
            if (maisRestrita.qntAulasSemanais < 1) {
                mRestantes.remove(maisRestrita);
            }

            Aula novaAula = new Aula(maisRestrita);
            adicionaMateriaTabela(novaAula);
            aulas.add(novaAula);

        }

        constroiTabelaHorariosDisponiveis();
        constroiTabelaAulasConflitantes();

        Tabu tabu = new Tabu();
        tabu.target = aulas.get(7);

        int[] local = buscaLocalizacaoAula(aulas.get(7));

        tabu.horarioAtual = local[0];
        tabu.salaAtual = local[1];

        tabu.geraVizinhaca();
        System.out.println(Testes.testaSala());
        
        int qntSwap = 0, qntMove = 0;
        
        for (Movimento a : tabu.vizinhanca) {
            if(a.aula.equals(Aula.LIVRE)){
                qntMove++;
            }else{
                qntSwap++;
        }
            
        }
        
        System.out.println("Qnt Moves: "+qntMove+"\t Qnt Swaps: "+qntSwap);

        // System.out.println("Valor Objetivo: " + valor);
    }

    /*
        Inicialização de Objetos Finais
     */
    public void constroiTabelaAulasConflitantes() {

        for (int i = 0; i < aulas.size(); i++) {
            for (int j = 0; j < aulas.size(); j++) {

                if (aulas.get(i).equals(aulas.get(j))) {
                    aulasConflitantes[i][j] = 2;
                } else if (aulas.get(i).materia.getProfessor().equals((aulas.get(j).materia.getProfessor()))) {
                    aulasConflitantes[i][j] = 1;
                } else {
                    aulasConflitantes[i][j] = 0;
                    for (Turma turma : turmas) {
                        if ((turma.materias.contains(aulas.get(i).materia)) && (turma.materias.contains(aulas.get(j).materia))) {
                            aulasConflitantes[i][j] = 1;
                            break;
                        }
                    }

                }
            }
        }
    }

    public void constroiTabelaHorariosDisponiveis() {

        for (int i = 0; i < aulas.size(); i++) {
            for (int j = 0; j < diasLetivos * periodosPorDia; j++) {
                if (Testes.testaHorario(aulas.get(i), j)) {
                    horariosDisponiveis[i][j] = 0;
                } else {
                    horariosDisponiveis[i][j] = 1;
                }
            }
        }
    }

}
