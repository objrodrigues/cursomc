package br.com.objrodrigues.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.objrodrigues.cursomc.domain.Categoria;
import br.com.objrodrigues.cursomc.domain.Cidade;
import br.com.objrodrigues.cursomc.domain.Estado;
import br.com.objrodrigues.cursomc.domain.Produto;
import br.com.objrodrigues.cursomc.repositories.CategoriaRepository;
import br.com.objrodrigues.cursomc.repositories.CidadeRepository;
import br.com.objrodrigues.cursomc.repositories.EstadoRepository;
import br.com.objrodrigues.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			Categoria informatica = new Categoria(null, "Informática");
			Categoria escritorio = new Categoria(null, "Escritório");
			
			Produto computador = new Produto(null, "Computador", 2000.00);
			Produto impressora = new Produto(null, "Impressora", 800.00);
			Produto mouse = new Produto(null, "Mouse", 80.00);
			
			informatica.getProdutos().addAll(Arrays.asList(computador, impressora, mouse));
			escritorio.getProdutos().addAll(Arrays.asList(impressora));
			
			computador.getCategorias().addAll(Arrays.asList(informatica));
			impressora.getCategorias().addAll(Arrays.asList(informatica, escritorio));
			mouse.getCategorias().addAll(Arrays.asList(informatica));
			
			
			Estado minasGerais = new Estado(null, "Minas Gerais");
			Estado saoPaulo = new Estado(null, "São Paulo");
			
			Cidade uberlandia = new Cidade(null, "Uberlandia", minasGerais);
			Cidade cidadeSaoPaulo = new Cidade(null, "São Paulo", saoPaulo);
			Cidade campinas = new Cidade(null, "Campinas", saoPaulo);
			
			
			minasGerais.getCidades().addAll(Arrays.asList(uberlandia));
			saoPaulo.getCidades().addAll(Arrays.asList(cidadeSaoPaulo));
			saoPaulo.getCidades().addAll(Arrays.asList(campinas));
			
			
			categoriaRepository.saveAll(Arrays.asList(informatica, escritorio));
			produtoRepository.saveAll(Arrays.asList(computador, impressora, mouse));
			estadoRepository.saveAll(Arrays.asList(minasGerais, saoPaulo));
			cidadeRepository.saveAll(Arrays.asList(uberlandia, cidadeSaoPaulo, campinas));

	}

}