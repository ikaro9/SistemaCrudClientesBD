package br.ikarodev.menu;

public class Utilitarios {
    public boolean validarTelefone(String telefone) {
        return telefone.matches("\\d{11}");
    }
    public boolean validarNome(String nome){
        return nome.matches("^(?=.{2,}$)[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)*$");
    }
    public boolean validarEmail(String email){
        return email.matches("^(?=.{8,}$)[A-Za-z0-9._%+-]+@(gmail|outlook|hotmail|yahoo|live|uol|bol|globomail)\\.(com|net|org)(\\.br)?(\\.edu)?$");
    }
}