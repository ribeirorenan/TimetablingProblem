/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.timetabling.model;

import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Aula {
    
    static final Aula LIVRE = new Aula(new Materia("livre", "professor", Integer.BYTES, Integer.MIN_VALUE, Integer.MIN_VALUE));

    Materia materia;

    public Aula(Materia materia) {
        this.materia = materia;
   
    }
    
    

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Aula{" + "materia=" + materia.nome + '}';
    }

    
    

    
}
