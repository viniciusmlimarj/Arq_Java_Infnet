package br.com.vinicius.infnet.trabalho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.vinicius.infnet.trabalho.model.domain.Solicitante;
import br.com.vinicius.infnet.trabalho.model.domain.Usuario;
import br.com.vinicius.infnet.trabalho.model.service.SolicitanteService;

@Order(2)
@Component
public class SolicitanteLoader implements ApplicationRunner {

	@Autowired
	private SolicitanteService solicitanteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		if (solicitanteService.obterLista(usuario).size() == 0) {
			Solicitante solicitante = null;
			
			solicitante = new Solicitante();
			solicitante.setCpf("99999999999");
			solicitante.setEmail("solicitante1@gmail.com");
			solicitante.setNome("Erica");
			solicitante.setUsuario(usuario);
			solicitanteService.incluir(solicitante);
			
			solicitante = new Solicitante();
			solicitante.setCpf("88888888888");
			solicitante.setEmail("solicitante2@gmail.com");
			solicitante.setNome("Larissa");
			solicitante.setUsuario(usuario);
			solicitanteService.incluir(solicitante);
		}
	}
}
