package br.com.vinicius.infnet.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.vinicius.infnet.trabalho.model.domain.Comida;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.ComidaService;

@Controller
public class ComidaController {
	
	@Autowired
	private ComidaService comidaService;
	
	@GetMapping(value = "/comida")
	public String cadastro() {
		return "comida/cadastro";
	}
	
	@GetMapping(value = "/comidas")
	public String lista(Model model, @SessionAttribute("usuarioLogado") Usuario usuario) {
		
		model.addAttribute("listagem", comidaService.obterLista(usuario));
		
		return "comida/lista";
	}

	@PostMapping(value = "/comida/incluir") 
	public String incluir(Model model, Comida comida, @SessionAttribute("usuarioLogado") Usuario usuario) {
		
		comida.setUsuario(usuario);
		
		comidaService.incluir(comida);

		return "redirect:/comidas";
	}
	
	@GetMapping(value = "/comida/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		comidaService.excluir(id);
		
		return "redirect:/comidas";
	}
}