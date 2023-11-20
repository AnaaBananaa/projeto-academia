package enums;

public enum EnumDiaSemana {
	
	SegundaFeira("Segunda-Feira"),
	TercaFeira("Terça-Feira"),
	QuartaFeira("Quarta-Feira"),
	QuintaFeira("Quinta-Feira"),
	SextaFeira("Sexta-Feira"),
	Sabado("Sábado"),
	Domingo("Domingo");
	
	private final String diaSemana;

	private EnumDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getDiaSemana() {
		return diaSemana;
	}
	
	

}
