package br.ikarodev.dao;

import br.ikarodev.model.Cliente;
import br.ikarodev.db.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void inserir (Cliente cliente) throws SQLException{
        String sql = "INSERT INTO Clientes (Nome, Telefone, Email) VALUES (?,?,?)";
        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        }
    }

    public void remover(int id)throws SQLException{
        String sql = "DELETE FROM Clientes WHERE ID = ?";
      try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
          stmt.setInt(1, id);
          stmt.executeUpdate();
      }
    }

    public void atualizar(Cliente cliente)throws SQLException {
        String sql = "UPDATE Clientes set Nome = ?,Telefone = ?,Email = ? WHERE ID = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
        }
    }

     public List<Cliente> listar()throws SQLException{
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
        while(rs.next()){
            Cliente cliente = new Cliente(rs.getInt("ID"),
                                          rs.getString("Nome"),
                                          rs.getString("Telefone"),
                                          rs.getString("Email"));

        clientes.add(cliente);
        }

        }
        return clientes;
     }

     public Cliente buscarID(int id)throws SQLException{
        String sql = "SELECT * FROM Clientes WHERE ID = ?";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    Cliente cliente = new Cliente(rs.getInt("ID"),
                            rs.getString("Nome"),
                            rs.getString("Telefone"),
                            rs.getString("Email"));
                    return cliente;
                }
            }

        }catch (SQLException e){
            System.out.println("Erro ao buscar ID: " + e.getMessage());
        }
      return null;
     }

     public void limparRegistros()throws SQLException {
         String sqlDelete = "DELETE FROM Clientes";
         String sqlReset = "DELETE FROM sqlite_sequence WHERE name = 'Clientes'";
         try (Connection conn = Conexao.conectar();
              Statement stmt = conn.createStatement()) {
             stmt.execute(sqlDelete);
             stmt.execute(sqlReset);
         }
     }

     public boolean TabelaVazia()throws SQLException{
        String sql = "SELECT COUNT (*) FROM Clientes";
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            if(rs.next()){
                return rs.getInt(1) == 0;
            }
        }
        return true;
     }
}
