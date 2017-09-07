package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class TestFarmacia extends SpringTest{

	@Test
	@Transactional
	@Rollback
	public void testFarmaciasDeTurnoLosDiasMartes() {
		Farmacia farmaciaMartes = new Farmacia();
		farmaciaMartes.setId(1L);
		farmaciaMartes.setNombre("farmacia martes");;
		farmaciaMartes.setTelefono("46500539");
		farmaciaMartes.setDiaDeTurno("martes");
		getSession().save(farmaciaMartes);
		
		Farmacia farmaciaMartesDos = new Farmacia();
		farmaciaMartesDos.setId(2L);
		farmaciaMartesDos.setNombre("farmacia martes dos");;
		farmaciaMartesDos.setTelefono("46500539");
		farmaciaMartesDos.setDiaDeTurno("martes");
		getSession().save(farmaciaMartesDos);
		
		Farmacia farmaciaJueves = new Farmacia();
		farmaciaJueves.setId(3L);
		farmaciaJueves.setNombre("farmacia jueves");;
		farmaciaJueves.setTelefono("46500539");
		farmaciaJueves.setDiaDeTurno("jueves");
		getSession().save(farmaciaJueves);
		
		List resultado = getSession().createCriteria(Farmacia.class)
		.add(Restrictions.eq("diaDeTurno", "martes")).list();
		assertThat(resultado).hasSize(2); 
	}
	
	@Test
	@Transactional
	@Rollback
	public void testFarmaciasDeUnaCalle(){		
		
		Farmacia farmaciaUno = new Farmacia();
		farmaciaUno.setId(1L);
		farmaciaUno.setNombre("farmaciaUno");;
		farmaciaUno.setTelefono("46500539");
		farmaciaUno.setDiaDeTurno("martes");
		Farmacia farmaciaDos = new Farmacia();
		farmaciaDos.setId(2L);
		farmaciaDos.setNombre("farmaciaDos");;
		farmaciaDos.setTelefono("46500539");
		farmaciaDos.setDiaDeTurno("martes");
		Farmacia farmaciaTres = new Farmacia();
		farmaciaTres.setId(3L);
		farmaciaTres.setNombre("farmaciaTres");;
		farmaciaTres.setTelefono("46500539");
		farmaciaTres.setDiaDeTurno("martes");
		
		Direccion arieta =new Direccion();
		arieta.setId(1L);
		Direccion varela =new Direccion();
		varela.setId(2L);
		
		farmaciaUno.setDireccion(arieta);
		farmaciaUno.getDireccion().setCalle("arieta");
		farmaciaDos.setDireccion(arieta);
		farmaciaDos.getDireccion().setCalle("arieta");
		farmaciaTres.setDireccion(varela);
		farmaciaTres.getDireccion().setCalle("varela");
		
		getSession().save(farmaciaUno);
		getSession().save(farmaciaDos);
		getSession().save(farmaciaTres);
		
		List resultado = getSession().createCriteria(Farmacia.class)
				.createAlias("direccion", "dir")
				.add(Restrictions.eq("dir.calle","arieta"))
				.list();
				assertThat(resultado).hasSize(2);
	}
	
	@Test
	@Transactional
	@Rollback
	public void testFarmaciasDeUnBarrio(){
			
		Farmacia farmaciaUno = new Farmacia();
		farmaciaUno.setId(1L);
		farmaciaUno.setNombre("farmaciaUno");;
		farmaciaUno.setTelefono("46500539");
		farmaciaUno.setDiaDeTurno("martes");
		Farmacia farmaciaDos = new Farmacia();
		farmaciaDos.setId(2L);
		farmaciaDos.setNombre("farmaciaDos");;
		farmaciaDos.setTelefono("46500539");
		farmaciaDos.setDiaDeTurno("martes");
		
		Direccion arieta =new Direccion();
		arieta.setId(1L);
		
		Barrio sanJusto = new Barrio();
		sanJusto.setId(1L);
		
		farmaciaUno.setDireccion(arieta);
		farmaciaDos.setDireccion(arieta);
		
		farmaciaUno.getDireccion().setBarrio(sanJusto);
		farmaciaUno.getDireccion().getBarrio().setNombre("san justo");
		farmaciaDos.getDireccion().setBarrio(sanJusto);
		farmaciaDos.getDireccion().getBarrio().setNombre("san justo");
		
		farmaciaUno.getDireccion().getBarrio().getNombre();
		farmaciaDos.getDireccion().getBarrio().getNombre();
		
		getSession().save(farmaciaUno);
		getSession().save(farmaciaDos);
		getSession().save(sanJusto);
		getSession().save(arieta);
		
		List resultado = getSession().createCriteria(Farmacia.class,"farmacia")
				.createAlias("farmacia.direccion", "dir")
				.createAlias("dir.barrio", "barrios")
				.add(Restrictions.eq("barrios.nombre","san justo"))
				.list();
				assertThat(resultado).hasSize(2);
				
	}

}
