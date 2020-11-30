package com.hermanitto.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.hermanitto.socialbooks.client.LivrosClient;
import com.hermanitto.socialbooks.client.domain.Livro;

public class Aplicacao {
	
	private static String URL = "http://localhost:8080";
	private static String usuario = "algaworks";
	private static String pass = "s3nh4";
	
	
	public static void main(String[] args) throws ParseException {
			
		LivrosClient cliente = new LivrosClient(URL, usuario, pass);
		
		List<Livro> listaLivros = cliente.listar();
		
		
		for (Livro livro : listaLivros) {
			System.out.println("Livro: " + livro.getNome());
		}
		
		Livro livro = new Livro();
		livro.setNome("Git passo-a-passo");
		livro.setEditora("AlgaWorks");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/01/2020"));
		
		livro.setResumo("Este livro aborda técnicas de desenvolvimento de APIs.");
		
		String localizacao = cliente.salvar(livro);
		System.out.println("URI do livro salvo: " + localizacao);
		
		Livro livroBuscado = cliente.buscar(localizacao);
		System.out.println("Livro Buscado: "+ livroBuscado.getNome());
	}

}
