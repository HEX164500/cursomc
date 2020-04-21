package com.curso.cursomc.domain.enuns;

public enum TipoCliente {

	PESSOAFISICA(1,"Pessoa Fisica"),
	PESSOAJURIDICA(2,"Pessoa Juridica");
	
	private Integer codigo;
	private String  descricao;
	
	private TipoCliente ( Integer cod, String decricao) {
		this.codigo = cod;
		this.descricao = decricao;
	}
	
	public Integer getCod() {
		return this.codigo;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null ) {
			
		}
		for(TipoCliente x: TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Codigo invalido: " + cod);
	}
}
