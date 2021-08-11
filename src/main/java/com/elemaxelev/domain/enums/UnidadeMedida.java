package com.elemaxelev.domain.enums;

public enum UnidadeMedida {

	UNIDADE(1, "UNIDADE"),
	PECA(2, "PECA"),
	METRO(3, "METRO"),
	LITRO(4, "LITRO"),
	QUILO(5, "QUILO");

	private int cod;
	private String descricao;

	private UnidadeMedida(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static UnidadeMedida toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (UnidadeMedida unidadeMedida : UnidadeMedida.values()) {
			if (cod.equals(unidadeMedida.getCod())) {
				return unidadeMedida;
			}

		}

		throw new IllegalArgumentException("Id Inválido: " + cod);
	}

}
