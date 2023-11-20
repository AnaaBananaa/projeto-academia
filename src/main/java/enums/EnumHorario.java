package enums;

public enum EnumHorario {

	    SETE_HORAS("07:00"),
	    SETE_E_TRINTA("07:30"),
	    OITO_HORAS("08:00"),
	    OITO_E_TRINTA("08:30"),
	    NOVE_HORAS("09:00"),
	    NOVE_E_TRINTA("09:30"),
	    DEZ_HORAS("10:00"),
	    DEZ_E_TRINTA("10:30"),
	    ONZE_HORAS("11:00"),
	    ONZE_E_TRINTA("11:30"),
	    DOZE_HORAS("12:00"),
	    DOZE_E_TRINTA("12:30"),
	    UMA_HORA("13:00"),
	    UMA_E_TRINTA("13:30"),
	    DUAS_HORAS("14:00"),
	    DUAS_E_TRINTA("14:30"),
	    TRES_HORAS("15:00"),
	    TRES_E_TRINTA("15:30"),
	    QUATRO_HORAS("16:00"),
	    QUATRO_E_TRINTA("16:30"),
	    CINCO_HORAS("17:00"),
	    CINCO_E_TRINTA("17:30"),
	    SEIS_HORAS("18:00"),
	    SEIS_E_TRINTA("18:30"),
	    SETE_HORAS_E_TRINTA("19:30"),
	    OITO_HORAS_E_TRINTA("20:30"),
	    NOVE_HORAS_E_TRINTA("21:30"),
	    DEZ_HORAS_E_TRINTA("22:30");

	    private final String horario;

	    EnumHorario(String horario) {
	        this.horario = horario;
	    }

	    public String getHorario() {
	        return horario;
	    }
	}