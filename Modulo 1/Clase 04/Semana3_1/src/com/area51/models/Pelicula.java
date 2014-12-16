package com.area51.models;

public class Pelicula {
	private int id;
	private String titulo;
	private String descripcion;
	private String rutaImagen;

	public Pelicula(int id, String titulo, String descripcion, String rutaImagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.rutaImagen = rutaImagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

}
