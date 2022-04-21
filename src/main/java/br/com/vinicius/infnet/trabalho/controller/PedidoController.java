package br.com.vinicius.infnet.trabalho.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.vinicius.infnet.trabalho.model.domain.Pedido;
import br.com.vinicius.infnet.trabalho.model.domain.Produto;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.PedidoService;
import br.com.vinicius.infnet.trabalho.model.service.ProdutoService;
import br.com.vinicius.infnet.trabalho.model.service.SolicitanteService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private SolicitanteService solicitanteService;
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/pedido")
	public String cadastro(Model model, @SessionAttribute("usuarioLogado") Usuario usuario) {
		
		model.addAttribute("solicitantes", solicitanteService.obterLista(usuario));
		
		model.addAttribute("produtos", produtoService.obterLista(usuario));
		
		return "pedido/cadastro";
	}
	
	@GetMapping(value = "/pedidos")
	public String lista(Model model, @SessionAttribute("usuarioLogado") Usuario usuario) {
		
		model.addAttribute("listagem", pedidoService.obterLista(usuario));
		
		return "pedido/lista";
	}

	@PostMapping(value = "/pedido/incluir") 
	public String incluir(Model model, Pedido pedido, @RequestParam String[] idsProdutos, @SessionAttribute("usuarioLogado") Usuario usuario) {
		pedido.setUsuario(usuario);
				
		List<Produto> produtos = new ArrayList<Produto>();
		
		for(String id : idsProdutos) {
			
			Produto produto = produtoService.obterPorId(Integer.valueOf(id));
			
			produtos.add(produto);
		}
		
		pedido.setProdutos(produtos);

		pedidoService.incluir(pedido);

		return "redirect:/pedidos";
	}
	
	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		pedidoService.excluir(id);
		
		return "redirect:/pedidos";
	}
}