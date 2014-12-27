package com.example.models;

public class Imagenes {
	private String texto;
	private String rutaImagen;

	public Imagenes(String texto, String rutaImagen) {
		super();
		this.texto = texto;
		this.rutaImagen = rutaImagen;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

}
