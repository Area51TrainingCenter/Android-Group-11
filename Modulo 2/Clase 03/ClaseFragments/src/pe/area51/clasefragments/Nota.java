package pe.area51.clasefragments;

public class Nota {

	private String asunto;
	private String contenido;

	public Nota(final String asunto, final String contenido) {
		this.asunto = asunto;
		this.contenido = contenido;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

}
