package br.model;

public class Local {
	
	private String endereco;
	private int capacidade;
	
	
	
    public Local() {
		
	}
	
	public Local(String endereco, int capacidade) {
		
		this.endereco = endereco;
		this.capacidade = capacidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return "[endereço=" + endereco + ", capacidade=" + capacidade + " pessoas]";
	}
	
	
	
	

}
