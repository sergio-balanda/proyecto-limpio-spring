package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Farmacia {
	@Id
	private Long id;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="punto")
	private Punto punto;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="direccion")
	private Direccion direccion;
	
	
	public Farmacia(){
		
	}


	public Farmacia(Long id, String nombre, String telefono, String diaDeTurno, Punto punto, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.diaDeTurno = diaDeTurno;
		this.punto = punto;
		this.direccion = direccion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDiaDeTurno() {
		return diaDeTurno;
	}


	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}


	public Punto getPunto() {
		return punto;
	}


	public void setPunto(Punto punto) {
		this.punto = punto;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	
}
