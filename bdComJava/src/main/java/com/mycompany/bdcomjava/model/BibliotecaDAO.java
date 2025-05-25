package com.mycompany.bdcomjava.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {
    // Métodos para Livros

    // Inserir um novo livro
    public void inserirLivro(Livros livro) throws SQLException {
        String sql = "INSERT INTO livros (isbn, nome, autor, quantidade, categoria) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoSQL.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, livro.getIsbn());
            stmt.setString(2, livro.getNome());
            stmt.setString(3, livro.getAutor());
            stmt.setInt(4, livro.getQuantidade());
            stmt.setString(5, livro.getCategoria());
            stmt.executeUpdate();
            System.out.println("Livro inserido com sucesso: " + livro.getNome());
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir livro: " + e.getMessage());
        }
    }

    // Listar todos os livros
    public List<Livros> listarLivros() throws SQLException {
        List<Livros> livros = new ArrayList<>();
        String sql = "SELECT isbn, nome, autor, quantidade, categoria FROM livros";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Livros livro = new Livros();
                livro.setIsbn(rs.getLong("isbn"));
                livro.setNome(rs.getString("nome"));
                livro.setAutor(rs.getString("autor"));
                livro.setQuantidade(rs.getInt("quantidade"));
                livro.setCategoria(rs.getString("categoria"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar livros: " + e.getMessage());
        }
        return livros;
    }

    // Atualizar um livro
    public void atualizarLivro(Livros livro) throws SQLException {
        String sql = "UPDATE livros SET nome = ?, autor = ?, quantidade = ?, categoria = ? WHERE isbn = ?";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getQuantidade());
            stmt.setString(4, livro.getCategoria());
            stmt.setLong(5, livro.getIsbn());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro atualizado com sucesso: " + livro.getNome());
            } else {
                throw new SQLException("Livro com ISBN " + livro.getIsbn() + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    // Deletar um livro
    public void deletarLivro(long isbn) throws SQLException {
        String sql = "DELETE FROM livros WHERE isbn = ?";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, isbn);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro com ISBN " + isbn + " deletado com sucesso.");
            } else {
                throw new SQLException("Livro com ISBN " + isbn + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar livro: " + e.getMessage());
        }
    }
    
     // Métodos para Usuarios

    // Inserir um novo usuário
    public void inserirUsuario(Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha, cidade, rua, bairro, numero_casa, isbn_livro_emprestado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCidade());
            stmt.setString(5, usuario.getRua());
            stmt.setString(6, usuario.getBairro());
            stmt.setInt(7, usuario.getNumeroDaCasa());
            stmt.setObject(8, usuario.getLivroEmprestado() != null ? usuario.getLivroEmprestado().getIsbn() : null);
            stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso: " + usuario.getNome());
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir usuário: " + e.getMessage());
        }
    }

    // Listar todos os usuários
    public List<Usuarios> listarUsuarios() throws SQLException {
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "SELECT u.id, u.nome, u.email, u.senha, u.cidade, u.rua, u.bairro, u.numero_casa, u.isbn_livro_emprestado, l.nome AS nome_livro " +
                    "FROM usuarios u LEFT JOIN livros l ON u.isbn_livro_emprestado = l.isbn";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setRua(rs.getString("rua"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setNumeroDaCasa(rs.getInt("numero_casa"));
                if (rs.getLong("isbn_livro_emprestado") != 0) {
                    Livros livro = new Livros();
                    livro.setIsbn(rs.getLong("isbn_livro_emprestado"));
                    livro.setNome(rs.getString("nome_livro"));
                    usuario.setLivroEmprestado(livro);
                }
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    // Atualizar um usuário
    public void atualizarUsuario(Usuarios usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ?, cidade = ?, rua = ?, bairro = ?, numero_casa = ?, isbn_livro_emprestado = ? WHERE id = ?";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCidade());
            stmt.setString(5, usuario.getRua());
            stmt.setString(6, usuario.getBairro());
            stmt.setInt(7, usuario.getNumeroDaCasa());
            stmt.setObject(8, usuario.getLivroEmprestado() != null ? usuario.getLivroEmprestado().getIsbn() : null);
            stmt.setInt(9, usuario.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário atualizado com sucesso: " + usuario.getNome());
            } else {
                throw new SQLException("Usuário com ID " + usuario.getId() + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    // Deletar um usuário
    public void deletarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário com ID " + id + " deletado com sucesso.");
            } else {
                throw new SQLException("Usuário com ID " + id + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar usuário: " + e.getMessage());
        }
    }

    // Emprestar um livro a um usuário
    public void emprestarLivro(int idUsuario, long isbn) throws SQLException {
        String sql = "UPDATE usuarios SET isbn_livro_emprestado = ? WHERE id = ?";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, isbn);
            stmt.setInt(2, idUsuario);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro com ISBN " + isbn + " emprestado ao usuário com ID " + idUsuario);
            } else {
                throw new SQLException("Usuário com ID " + idUsuario + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao emprestar livro: " + e.getMessage());
        }
    }

    // Devolver um livro (remove a associação)
    public void devolverLivro(int idUsuario) throws SQLException {
        String sql = "UPDATE usuarios SET isbn_livro_emprestado = NULL WHERE id = ?";
        try (Connection conexao = ConexaoSQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro devolvido pelo usuário com ID " + idUsuario);
            } else {
                throw new SQLException("Usuário com ID " + idUsuario + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao devolver livro: " + e.getMessage());
        }
    }
}

