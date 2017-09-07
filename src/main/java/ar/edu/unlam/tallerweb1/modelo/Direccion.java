package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Direccion {
	@Id
	private Long id;
	private String calle;
	private String numero;
	
	@OneToOne(mappedBy="direccion",fetch=FetchType.LAZY)
	private Farmacia farmacia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="barrio")
	private Barrio barrio;
	
	public Direccion(){
		
	}

	public Direccion(Long id, String calle, String numero, Farmacia farmacia, Barrio barrio) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.farmacia = farmacia;
		this.barrio = barrio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Farmacia getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
	
	
}
