package br.com.vinicius.infnet.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.vinicius.infnet.trabalho.model.domain.Bebida;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.BebidaService;

@Controller
public class BebidaController {
	
	@Autowired
	private BebidaService bebidaService;
	
	@GetMapping(value = "/bebida")
	public String cadastro() {
		return "bebida/cadastro";
	}
	
	@GetMapping(value = "/bebidas")
	public String lista(Model model, @SessionAttribute("usuarioLogado") Usuario usuario) {
		
		model.addAttribute("listagem", bebidaService.obterLista(usuario));
		
		return "bebida/lista";
	}

	@PostMapping(value = "/bebida/incluir") 
	public String incluir(Model model, Bebida bebida, @SessionAttribute("usuarioLogado") Usuario usuario) {
		
		bebida.setUsuario(usuario);
		
		bebidaService.incluir(bebida);

		return "redirect:/bebidas";
	}
	
	@GetMapping(value = "/bebida/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		bebidaService.excluir(id);
		
		return "redirect:/bebidas";
	}
}