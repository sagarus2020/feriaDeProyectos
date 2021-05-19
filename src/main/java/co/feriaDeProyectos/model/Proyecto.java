package co.feriaDeProyectos.model;

import java.io.Serializable;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto implements Serializable {

	private int id;
	private String nombre;
	private String resumen;
	private String video;
	private int tipo;
	private int cat;
	private String asig;
	private int evento;
	


	public Proyecto(String nombre, String resumen, String video, int tipo, int cat, String asig, int evento) {
		this.nombre = nombre;
		this.resumen = resumen;
		this.video = video;
		this.tipo = tipo;
		this.cat = cat;
		this.asig = asig;
		this.evento = evento;
	}


}
