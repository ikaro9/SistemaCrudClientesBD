package br.ikarodev.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
  private static final String url = "jdbc:sqlite:clientes.db";

  public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(url);
  }
}
