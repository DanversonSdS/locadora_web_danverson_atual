package br.com.locadora.locadora_web_danverson.controller;

import br.com.locadora.locadora_web_danverson.model.Filme;
import br.com.locadora.locadora_web_danverson.service.LocadoraService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filmes") //Define o /filmes como inicio de todas as rotas da classe

public class FilmeController {
    private final LocadoraService service; //guarda referencia do service usado pelo controller

    public FilmeController(LocadoraService service) {
        this.service = service; // guarda o objeto recebido no atributo
    }

    @GetMapping("/novo")
    public String abrirFormulario(Model model){ //objeto usado para enviar dados do java para o HTML
        model.addAttribute("filme", new Filme()); //Envia um objeto vazio chamado filme para o formulário
        return "filmes/formulario";
    }
    @PostMapping("/salvar") // Cria a rota post que recebe o nome do formulario
    public String salvarFilmes(
            @ModelAttribute Filme filme,
            Model model // Pede ao Spring para preencher o objeto filme para os dados enviados
    ){
        try{//inicia um bloco que pode gerar erro de regra
            service.cadastrarFilme(filme); //Entrega o objeto ao service
            return "redirect:/filmes?sucesso=true"; // Manda o navegador abrir a listagem dos filmes e acrescenta um parametro de sucesso
        }catch (IllegalArgumentException erro){ // Captura uma regra invalida lancada pelo service
            model.addAttribute("mensagemErro", erro.getMessage()); //Obter a mensagem de erro
            return "filmes/formulario";
        }
    }
    @GetMapping
    public String listarFilmes(Model model){
        model.addAttribute("filmes", service.listarFilmes()); //Envia a lista de filmes para a pagina
        return "filmes/lista";
    }
}

