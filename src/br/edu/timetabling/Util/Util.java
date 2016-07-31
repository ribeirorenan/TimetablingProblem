/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.timetabling.Util;

/**
 *
 * @author Rodrigo
 */
public class Util {

    public static int indicePalavra;
    public static String restante;

    public static String buscaPalavra(String s) {
        indicePalavra = 0;
        
        if(s.isEmpty()){
            return "";
        }
        
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == ' ') || (s.charAt(i) == ':')) {
                if(s.charAt(i) == ':'){
                    indicePalavra = i + 2;
                }else{
                    indicePalavra = i + 1;
                }
                
                if(s.length() > indicePalavra){ //Se tiver algo mais para se ler:
                   restante = s.substring(indicePalavra, s.length());
                }
                
                return s.substring(0, i);
                
                
            }
        }
        return "";
    }

}
