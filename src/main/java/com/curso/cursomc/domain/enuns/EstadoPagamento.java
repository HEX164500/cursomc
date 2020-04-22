package com.curso.cursomc.domain.enuns;

public enum EstadoPagamento {

	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	private Integer cod;
	private String  descricao;
	
	private EstadoPagamento(Integer cod, String decricao) {
		this.cod = cod;
		this.descricao = decricao;
	}
	
	public Integer getCod() {
		return this.cod;
	}
	
	public String getDesc() {
		return this.descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for( EstadoPagamento est : EstadoPagamento.values()) {
			if(cod.equals(est.getCod()) ) {
				return est;
			}
		}
		
		throw new IllegalArgumentException("Codigo invalido : " + cod);
		
	}
	
}
