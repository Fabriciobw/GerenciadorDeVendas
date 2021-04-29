package br.model;

public class Ingresso {
	
		private float valor;
		private int quantidadeVendida;
		private int quantidadeDisponivel;
		
		
		public Ingresso() {
			
		}
		public Ingresso(float valor) {
			
			this.valor = valor;
			
		}

		
		public Ingresso(float valor, int quantidadeVendida) {
		
			this.valor = valor;
			this.quantidadeVendida = quantidadeVendida;
		}
		
		

		public int getQuantidadeVendida() {
			return quantidadeVendida;
		}
		public void setQuantidadeVendida(int quantidadeVendida) {
			this.quantidadeVendida += quantidadeVendida;
		}
		public int getQuantidadeDisponivel() {
			return quantidadeDisponivel;
		}
		public void setQuantidadeDisponivel(int quantidadeDisponivel) {
			this.quantidadeDisponivel = quantidadeDisponivel;
		}
		public float getValor() {
			return valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}

		public void setQuantidadeVendida() {
			this.quantidadeVendida++;
		}
		@Override
		public String toString() {
			return "[valor=" + valor + ", quantidade de ingressos vendidos=" + quantidadeVendida + "]";
		}


}
