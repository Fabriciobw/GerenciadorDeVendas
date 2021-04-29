package br.model;

public class Evento {
	
	
	
	private String nome;
	private String data;
	private String hora;
	private String artista;
	private Local local;
	private Ingresso ingresso;
	
	
	
	
	public Evento() {
	
	}




	public Evento(String nome, String data, String hora, String artista) {
		
		this.nome = nome;
		this.data = data;
		this.hora = hora;
		this.artista = artista;
		
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getData() {
		return data;
	}




	public void setData(String data) {
		this.data = data;
	}




	public String getHora() {
		return hora;
	}




	public void setHora(String hora) {
		this.hora = hora;
	}




	public String getArtista() {
		return artista;
	}




	public void setArtista(String artista) {
		this.artista = artista;
	}




	public Local getLocal() {
		return local;
	}




	public void setLocal(Local local) {
		this.local = local;
	}


	

	public Ingresso getIngresso() {
		return ingresso;
	}




	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	


	@Override
	public String toString() {
		return 
				 "\nnome=" + nome + ", \n"
				+ "data=" + data + ", \n"
				+ "hora=" + hora + ", \n"
				+ "artista=" + artista + ", \n"
				+ "local=" + local + ", \n"
				+ "ingresso=" + ingresso + "\n" ;
	}




	
	

	
}
