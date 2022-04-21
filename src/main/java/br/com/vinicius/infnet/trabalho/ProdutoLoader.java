package br.com.vinicius.infnet.trabalho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.vinicius.infnet.trabalho.model.domain.Bebida;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.BebidaService;

@Order(3)
@Component
public class ProdutoLoader implements ApplicationRunner {

	@Autowired
	private BebidaService bebidaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		if (bebidaService.obterLista(usuario).size() == 0) {
			Bebida bebida = null;
			
			bebida = new Bebida();
			bebida.setCodigo(1);
			bebida.setGelada(true);
			bebida.setMarca("COCA COLA");
			bebida.setNome("COCA COLA");
			bebida.setTamanho(2000);
			bebida.setValor(15);
			bebida.setUsuario(usuario);
			bebidaService.incluir(bebida);
			
			bebida = new Bebida();
			bebida.setCodigo(2);
			bebida.setGelada(true);
			bebida.setMarca("COCA COLA");
			bebida.setNome("COCA COLA");
			bebida.setTamanho(500);
			bebida.setValor(8);
			bebida.setUsuario(usuario);
			bebidaService.incluir(bebida);
			
			bebida = new Bebida();
			bebida.setCodigo(3);
			bebida.setGelada(true);
			bebida.setMarca("COCA COLA");
			bebida.setNome("COCA COLA");
			bebida.setTamanho(350);
			bebida.setValor(6);
			bebida.setUsuario(usuario);
			bebidaService.incluir(bebida);
			
			bebida = new Bebida();
			bebida.setCodigo(4);
			bebida.setGelada(true);
			bebida.setMarca("COCA COLA");
			bebida.setNome("FANTA LARANJA");
			bebida.setTamanho(2000);
			bebida.setValor(15);
			bebida.setUsuario(usuario);
			bebidaService.incluir(bebida);
			
			bebida = new Bebida();
			bebida.setCodigo(5);
			bebida.setGelada(true);
			bebida.setMarca("COCA COLA");
			bebida.setNome("FANTA LARANJA");
			bebida.setTamanho(500);
			bebida.setValor(8);
			bebida.setUsuario(usuario);
			bebidaService.incluir(bebida);
			
			bebida = new Bebida();
			bebida.setCodigo(6);
			bebida.setGelada(true);
			bebida.setMarca("COCA COLA");
			bebida.setNome("FANTA LARANJA");
			bebida.setTamanho(350);
			bebida.setValor(6);
			bebida.setUsuario(usuario);
			bebidaService.incluir(bebida);
		}
	}
}