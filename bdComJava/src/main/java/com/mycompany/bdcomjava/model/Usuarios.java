package com.mycompany.bdcomjava.model;

public class Usuarios {

    //Atributos:
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cidade;
    private String rua; 
    private String bairro; 
    private int numeroDaCasa; 
    private Livros livroEmprestado;

    //Construtor:
    public Usuarios(int id ,String nome, String email, String senha, String cidade, String rua, String bairro, int numeroDaCasa, Livros livroEmprestado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numeroDaCasa = numeroDaCasa;
        this.livroEmprestado = livroEmprestado;
    }

    public Usuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(int numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public Livros getLivroEmprestado() {
        return livroEmprestado;
    }

    public void setLivroEmprestado(Livros livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }
      
}
