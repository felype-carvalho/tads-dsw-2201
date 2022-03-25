package br.senac.tads.dsw.exemplosspringmvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExemploController {

    @GetMapping("/ex01") // Significa: Responde método GET do HTTP para URL /ex01
    public String exemplo01() {
        return "template01"; // Significa: nome do arquivo de template que será usado para montar resposta
                             // HTTP
    }

    @GetMapping("/ex02")
    public String exemplo02(Model model) {
        String titulo = "Exemplo 2 - Título gerado no Controller";
        LocalDateTime dataHora = LocalDateTime.now();
        int numero = 98;

        model.addAttribute("tituloAttr", titulo);
        model.addAttribute("dataHoraXyz", dataHora);
        model.addAttribute("algumNumero", numero);

        return "template02";
    }

    @GetMapping("/ex02b")
    public ModelAndView exemplo02b() {
        String titulo = "Exemplo 2B - Título gerado no Controller";
        LocalDateTime dataHora = LocalDateTime.now();
        int numero = 33;

        ModelAndView mv = new ModelAndView("template02");

        mv.addObject("tituloAttr", titulo);
        mv.addObject("dataHoraXyz", dataHora);
        mv.addObject("algumNumero", numero);

        return mv;
    }

    @GetMapping("/ex03")
    public ModelAndView exemplo03() {

        ModelAndView mv = new ModelAndView("template03");

        List<String> valores = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            valores.add("Item " + i);
        }

        boolean mostraMensagem = true;

        mv.addObject("lista", valores);
        mv.addObject("flagMensagem", mostraMensagem);

        return mv;
    }

    @GetMapping("/ex04a")
    public ModelAndView exemplo04SomaDoisNumeros(
            @RequestParam("n1") int n1,
            @RequestParam("n2") int n2) {

        ModelAndView mv = new ModelAndView("template04a");

        int soma = n1 + n2;
        mv.addObject("resultado", soma);

        return mv;
    }

    @GetMapping("/ex04b")
    public ModelAndView exemplo04SomaDoisNumerosComForm(
            @RequestParam(value = "n1", defaultValue = "0") int n1,
            @RequestParam(value = "n2", defaultValue = "0") int n2) {

        ModelAndView mv = new ModelAndView("template04b");

        int soma = n1 + n2;
        mv.addObject("resultado", soma);

        return mv;
    }

    @GetMapping("/ex05")
    public ModelAndView exemplo05(
        @RequestParam String nome, 
        @RequestParam String dataNascimento, 
        @RequestParam String email, 
        @RequestParam String senha) {

        ModelAndView mv = new ModelAndView("template05");

        mv.addObject("nome", nome);
        mv.addObject("dataNascimento", dataNascimento);
        mv.addObject("email", email);
        mv.addObject("senha", senha);

        return mv;
    }

    @GetMapping("/ex06")
    public ModelAndView exemplo06(
        @RequestParam String nome, 
        @RequestParam String dataNascimento, 
        @RequestParam String email, 
        @RequestParam String senha) {

       DadosPessoais dadosPessoais = new DadosPessoais(nome, dataNascimento, email, senha) ;

        ModelAndView mv = new ModelAndView("template06");
        mv.addObject("dadosPessoais", dadosPessoais);

        return mv;
    }

    @GetMapping("/ex07")
    public ModelAndView exemplo07() {

        List<DadosPessoais> lista = new ArrayList();
        DadosPessoais d1 = new DadosPessoais("Felype", "03/07/2000", "f@f.com", "password") ;
        lista.add(d1);
        DadosPessoais d2 = new DadosPessoais("Felype", "03/07/2000", "f@f.com", "password") ;
        lista.add(d2);
        DadosPessoais d3 = new DadosPessoais("Felype", "03/07/2000", "f@f.com", "password") ;
        lista.add(d3);
        DadosPessoais d4 = new DadosPessoais("Felype", "03/07/2000", "f@f.com", "password") ;
        lista.add(d4);

        ModelAndView mv = new ModelAndView("template07");
        mv.addObject("lista", lista);

        return mv;
    }
}
