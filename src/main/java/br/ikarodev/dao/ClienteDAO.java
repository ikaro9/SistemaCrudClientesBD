package br.ikarodev.dao;

import br.ikarodev.model.Cliente;
import br.ikarodev.db.Conexao;

import java.sql.*;

public class ClienteDAO {
    public void inserir (Cliente cliente){
        String sql = "INSERT INTO clientes (Nome, Telefone, Email) VALUES (?,?,?)";
        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,cliente.getNome());
            stmt.setInt(2,cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }
}
