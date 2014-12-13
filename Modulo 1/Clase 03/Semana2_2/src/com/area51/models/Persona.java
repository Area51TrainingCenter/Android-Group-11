package com.area51.models;

public class Persona {
	private int id;
	private String nombre;
	private String hora;
	private String textoUno;
	private String textoDos;
	private int rutaImagen;
	private boolean cross;

	public Persona(int id, String nombre, String hora, String textoUno,
			String textoDos, int rutaImagen, boolean cross) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.hora = hora;
		this.textoUno = textoUno;
		this.textoDos = textoDos;
		this.rutaImagen = rutaImagen;
		this.cross = cross;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTextoUno() {
		return textoUno;
	}

	public void setTextoUno(String textoUno) {
		this.textoUno = textoUno;
	}

	public String getTextoDos() {
		return textoDos;
	}

	public void setTextoDos(String textoDos) {
		this.textoDos = textoDos;
	}

	public int getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(int rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public boolean isCross() {
		return cross;
	}

	public void setCross(boolean cross) {
		this.cross = cross;
	}

}
