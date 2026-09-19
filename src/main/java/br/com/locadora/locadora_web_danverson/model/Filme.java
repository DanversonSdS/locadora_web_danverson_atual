package br.com.locadora.locadora_web_danverson.model;
/*
Representa um filme cadastrado na locadora */
public class Filme {
    private  int codigo;
    private String nome;
    private String genero;
    private boolean alugado;

    public Filme(){
        this.alugado = false;
    }

    public Filme(int codigo, String nome, String genero){
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.alugado = false;
    }

    /*Consultar codigo*/
    public int getCodigo() {
        return codigo;
    }

    /*Permite definir o codigo automático no service*/
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /*Permite ler e alterar o nome*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isAlugado() {
        return alugado;
    }

    /*alterar o estado de alugado do filme*/
    public void alugar(){
        if(alugado){
            throw new IllegalAccessException("Filme já alugado!");
        }alugado = true;
    }
    public void devolver(){
        alugado = false;
    }
    @Override
    public String toString(){
        String status = alugado ? "Alugado" : "Disponivel";
        return "Código: " + codigo
                + "| Nome: " +  nome
                + "| Gênero: " + genero
                + "| Status: " + status;
    }
}

