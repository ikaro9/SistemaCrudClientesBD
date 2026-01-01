package br.ikarodev.dao;

import br.ikarodev.model.Cliente;
import br.ikarodev.db.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void inserir (Cliente cliente){
        String sql = "INSERT INTO Clientes (Nome, Telefone, Email) VALUES (?,?,?)";
        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public void remover(int id){
        String sql = "DELETE FROM Clientes WHERE ID = ?";
      try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
          stmt.setInt(1,id);
          stmt.executeUpdate();
      } catch (SQLException e) {
          System.out.println("Erro ao remover cliente: " + e.getMessage());
      }
    }

    public void atualizar(Cliente cliente){
        String sql = "UPDATE Clientes set Nome = ?,Telefone = ?,Email = ? WHERE ID = ?";
        try(Connection conn = Conexao.conectar();PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4,cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }

        }

     public List<Cliente> listar(){
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

        } catch (SQLException e) {
        System.out.println("Erro ao atualizar cliente: " + e.getMessage());
    }
        return clientes;
     }
}
