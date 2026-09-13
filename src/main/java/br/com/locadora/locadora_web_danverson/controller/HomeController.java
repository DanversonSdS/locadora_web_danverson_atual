package br.com.locadora.locadora_web_danverson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
Abre a pagina inicial da locadora
@return o nome da pagina HTML
Linha 3: Coloca a classe pacote no controller
Linha 4 : Importa a anotação que identifica o Controller, Importa a anotação usada para as rotas do Get
psvma - atalho para criar o main
*/
@Controller //Informa ao spring que a classe recebe acesso ao navegador
public class HomeController { //Declara o Controller da pagina inicial
    @GetMapping("/") //Liga o endereço principal ao metodo abaixo
    public String abrirPaginaInicial () {
        return "index";
    }
}
