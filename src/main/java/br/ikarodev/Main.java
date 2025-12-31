package br.ikarodev;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn =
                    DriverManager.getConnection("jdbc:sqlite:clientes.db");
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
