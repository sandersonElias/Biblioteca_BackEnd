package com.mycompany.bdcomjava.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BibliotecaDAO {
    
    public void insertUsuario(Usuarios usuario){
        String sql = "insert into usuarios (nome, senha, turma, ano) values (?,?,?,?);";
        try (Connection conn = ConexaoSQL.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTurma());
            stmt.setInt(4, usuario.getAno());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Erro ao salvar usuario: " + e.getMessage());
        }
    }
}