package com.mycompany.bdcomjava.model;

public class Usuarios {

    //Atributos:
    private int id;
    private String nome;
    private String turma;
    private int ano;
    private String senha;
    private Livros livroEmprestado;

    //Construtor:

    public Usuarios(int id, String nome, String turma, int ano, String senha, Livros livroEmprestado) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
        this.ano = ano;
        this.senha = senha;
        this.livroEmprestado = livroEmprestado;
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Livros getLivroEmprestado() {
        return livroEmprestado;
    }

    public void setLivroEmprestado(Livros livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }
}
