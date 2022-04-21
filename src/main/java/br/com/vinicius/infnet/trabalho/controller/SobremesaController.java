package br.com.vinicius.infnet.trabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.vinicius.infnet.trabalho.model.domain.Sobremesa;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.SobremesaService;

@Controller
public class SobremesaController {
	
	@Autowired
	private SobremesaService sobremesaService;
	
	@GetMapping(value = "/sobremesa")
	public String cadastro() {
		return "sobremesa/cadastro";
	}
	
	@GetMapping(value = "/sobremesas")
	public String lista(Model model, @SessionAttribute("usuarioLogado") Usuario usuario) {
		
		model.addAttribute("listagem", sobremesaService.obterLista(usuario));
		
		return "sobremesa/lista";
	}

	@PostMapping(value = "/sobremesa/incluir") 
	public String incluir(Model model, Sobremesa sobremesa, @SessionAttribute("usuarioLogado") Usuario usuario) {
		
		sobremesa.setUsuario(usuario);
		
		sobremesaService.incluir(sobremesa);

		return "redirect:/sobremesas";
	}
	
	@GetMapping(value = "/sobremesa/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		sobremesaService.excluir(id);
		
		return "redirect:/sobremesas";
	}
}