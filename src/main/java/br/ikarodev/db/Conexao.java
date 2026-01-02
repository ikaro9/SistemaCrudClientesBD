package br.ikarodev.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
  private static final String url =  "jdbc:sqlite:clientes.db";

  public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url);
  }

  public static void CriarTabela(){
      String sql = "CREATE TABLE IF NOT EXISTS Clientes (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Nome TEXT NOT NULL, Telefone TEXT, Email TEXT)";
      try(Connection conn = conectar(); Statement stmt = conn.createStatement()) {
          stmt.execute(sql);
      } catch (SQLException e) {
          System.out.println("Falha ao criar tabela: " + e.getMessage());
      }
  }
}
