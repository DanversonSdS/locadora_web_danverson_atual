package br.com.locadora.locadora_web_danverson.model;
/*
Representa um filme cadastrado na locadora */
public class Filme {
    // Atributos:
    private  int codigo;
    private String nome;
    private String genero;
    private boolean alugado;

    public Filme(){
        // Construtor vazio
        this.alugado = false;
    }

    public Filme(int codigo, String nome, String genero){
        // Recebe os dados do filme, this -> referencia o atributo do próprio objeto
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
    }// get = consultar os valores

    public void setNome(String nome) {
        this.nome = nome;
    } // set = alterar os valores

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
            throw new IllegalArgumentException("Filme já alugado.");
        }alugado = true;
    }
    public void devolver(){
        alugado = false;
    }
    @Override // indica que um metodo esta sendo sobrescrito, nesse caso o metodo toString
    public String toString(){ //Define como o objeto sera mostrado em texto
        String status = alugado ? "Alugado" : "Disponivel"; //Operador ternario = if/else resumido
        return "Código: " + codigo
                + "| Nome: " +  nome
                + "| Gênero: " + genero
                + "| Status: " + status;
    }
}

