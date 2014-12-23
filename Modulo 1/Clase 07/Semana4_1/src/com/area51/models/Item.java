package com.area51.models;

public class Item {
	private String rutaImagen;
	private String texto;

	public Item(String rutaImagen, String texto) {
		super();
		this.rutaImagen = rutaImagen;
		this.texto = texto;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
