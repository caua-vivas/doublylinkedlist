package br.ucsal.edu.br;

public class ListaDupla {

	Elemento inicio;
	Elemento fim;
	int tamanho = 0;

	public void inserirInicio(String info) {

		Elemento elemento = new Elemento();

		elemento.info = info;
		elemento.anterior = null;
		elemento.proximo = inicio;

		if (inicio != null) {

			inicio.anterior = elemento;

		}

		inicio = elemento;

		if (tamanho ==0) {

			fim = inicio;

		}
		tamanho++;
	}

	public void inserirFim(String info) {

		Elemento elemento = new Elemento();

		Elemento local = fim;

		elemento.info = info;
		elemento.anterior = local;
		elemento.proximo = null;

		if (inicio != null) {

			fim.proximo = elemento;

		}

		fim = elemento;

		if (tamanho == 0) {

			inicio = fim;
		}
		tamanho++;

	}

	public String retirarInicio() {

		if (inicio == null) {

			return null;
		}

		String out = inicio.info;

		inicio = inicio.proximo;

		if (inicio != null) {

			inicio.anterior = null;

		} else {

			fim = null;

		}
		tamanho--;

		return out;
	}

	public String retirarFim() {
		
		if (fim == null) {
			
			System.out.println("Lista vazia");
			return null;
		}
		
		return null;
	}
	
	public void inserirPosicao(int posicao, String info) {
		
		if (posicao<= 0) {
			
			inserirInicio(info);
			
		} else if (posicao >= tamanho) {
			
			inserirFim(info);
			
		} else {
			
			Elemento local = inicio;
			
			for (int i = 0; i < posicao - 1; i++) {
				
				local = local.proximo;
				
			}
			
			Elemento elemento = new Elemento();
			elemento.info = info;
			
			elemento.anterior = local;
			elemento.proximo = local.proximo;
			
			local.proximo = elemento;
			elemento.proximo.anterior = elemento;
			
			tamanho++;
		}
	}

	public String retirarPosicao(int posicao) {
		
		if (posicao < 0 || posicao >= tamanho || inicio == null) {
			
			return null;
		
		} else if (posicao == 0) {
			
			return retirarInicio();
			
		} else if (posicao == tamanho - 1) {
			
			return retirarFim();
			
		}
		
		Elemento local = inicio;
		
		for (int i = 0; i < posicao; i++) {
			
			local= local.proximo;
			
		} if (local.anterior != null) {
			
			local.anterior.proximo = local.proximo;
			
		} if (local.proximo != null) {
			
			local.proximo.anterior = local.anterior;
		
		}
		
		tamanho--;
		return local.info;
	}
	
	public void listar() {
		System.out.println(toString());
	}

	public void listarI() {
		System.out.println(toStringI());
	}

	public String toString() {

		String str = "Tamanho da lista: |" + tamanho + "|";
		Elemento local = inicio;

		while (local != null) {

			str += "\n" + local.info;
			local = local.proximo;

		}

		return str;
	}

	public String toStringI() {

		String str = "Tamanho da lista: |" + tamanho + "|";
		Elemento local = fim;

		while(local != null) {

			str += "\n" + local.info;
			local = local.anterior;

		}

		return str;
	}
}
