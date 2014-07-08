package model;

public enum Posicao {
	
	ZAGUEIRO("Zagueiro"),
	LATERAL("Lateral"),
	MEIODECAMPO("Meio de Campo"),
	VOLANTE("Volante"),
	ATACANTE("Atacante");
	
	private final String posicao;

    Posicao(String posicao) {
        this.posicao = posicao;
    }

    public String getFuncao() {
        return posicao;
    }

}
