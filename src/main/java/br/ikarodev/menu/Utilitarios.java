package br.ikarodev.menu;

public class Utilitarios {
    public boolean validarTelefone(String telefone){
         return telefone.matches("\\d{11}");
    }
}
