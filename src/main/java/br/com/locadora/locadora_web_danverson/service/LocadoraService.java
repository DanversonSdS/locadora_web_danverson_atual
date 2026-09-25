package br.com.locadora.locadora_web_danverson.service;

import br.com.locadora.locadora_web_danverson.model.Filme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
Contém as regras do negócio da locadora
 */

@Service //Faz o string criar e gerenciar um unico objeto
public class LocadoraService {
    private final List<Filme> filmes; // final List -> declara a lista que guarda os filmes na memoria
    private int proximoCodigoFilme; // guarda o proximo codigo automaticamente


    public LocadoraService() {
        filmes = new ArrayList<>();
        proximoCodigoFilme = 1;
    }

    public void cadastrarFilme(Filme filme) {
        filme.setCodigo(proximoCodigoFilme); //Define o codigo automaticamente
        proximoCodigoFilme++;
        filmes.add(filme);
    }

    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes); // cria uma copia da lista para proteger a lista interna
    }

    public Filme buscarFilmePorCodigo(int codigo) {
        for (Filme filme : filmes) {// Percorre cada objeto da lista um por vez
            if (filme.getCodigo() == codigo) {
                return filme;
            }
        }
        return null;
    }
}
