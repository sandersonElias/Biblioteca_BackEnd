package com.mycompany.bdcomjava.model;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {
       
    private static final String url = "jdbc:mysql://localhost:3306/bancoBiblioteca?useSSL=false";
    private static final String user = "root";
    private static final String password = "geovanna@2606";
    
    private static Connection conexao = null;
    
    // Método para obter a conexão
    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                // Carrega o driver JDBC (não necessário em versões modernas, mas mantido para compatibilidade)
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Estabelece a conexão
                conexao = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão com o MySQL estabelecida com sucesso!");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver JDBC não encontrado: " + e.getMessage());
            }
        }
        return conexao;
    }
    
    // Método para fechar a conexão
    public static void fecharConexao() {
        if (conexao != null) {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conexão com o MySQL fechada com sucesso!");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}