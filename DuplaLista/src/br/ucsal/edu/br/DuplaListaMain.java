package br.ucsal.edu.br;

public class DuplaListaMain {

	public static void main(String[] args) {
		
		ListaDupla lista = new ListaDupla();
		
		lista.inserirInicio("teste 3");
		lista.inserirInicio("teste 4");
		lista.inserirInicio("teste 5");
		
		lista.inserirFim("teste 3");
		lista.inserirFim("teste 1");
		lista.inserirFim("teste 0");
		
		lista.listar();
		
		lista.listarI();
	}

}
