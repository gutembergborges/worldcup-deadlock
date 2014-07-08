package model;

public enum Fase {
	
	GRUPO("Fase de Grupos"), 
	OITAVAS("Oitavas de Final"), 
	QUARTAS("Quartas de Final"), 
	SEMI("Semi-Final"), 
	FINAL("Final");
	
    private final String fase;

    Fase(String fase) {
        this.fase = fase;
    }

    public String getFase() {
        return fase;
    }

}
