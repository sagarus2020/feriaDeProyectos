package co.feriaDeProyectos.model;

import java.io.Serializable;


public class Asignatura implements Serializable {

	private String codigo;
	private String nombre;
	
	
	public Asignatura(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
}
