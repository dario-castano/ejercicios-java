package dario.roedores.tipos;

import dario.roedores.Roedor;
import dario.roedores.interfaces.Almacenar;
import dario.roedores.interfaces.Correr;

public class Hamster extends Roedor implements Almacenar, Correr {
	private Integer capacidadCachete;

	public Hamster() {
		super("CAFE/BLANCO", 120);
		setCapacidadCachete(0);
	}
	
	public Integer getCapacidadCachete() {
		return capacidadCachete;
	}

	public void setCapacidadCachete(Integer capacidadCachete) {
		if (capacidadCachete < 0 || capacidadCachete > 100) {
			throw new IllegalArgumentException("La capacidad del cachete debe estar entre 0 y 100");
		}
		this.capacidadCachete = capacidadCachete;
	}

	@Override
	public String correr() {
		return "Soy un hamster y estoy corriendo";
	}

	@Override
	public String almacenar() {
		setCapacidadCachete(100);
		return "Soy un hamster y estoy guardando comida en el cachete";
	}

	@Override
	public String comer() {
		return "Soy un hamster y estoy comiendo";
	}

	@Override
	public String dormir() {
		return "Soy un hamster y estoy durmiendo";
	}

	@Override
	public String mirar() {
		return "Soy un hamster y estoy mirando";
	}

	@Override
	public String olfatear() {
		return "Soy un hamster y estoy olfateando";
	}
	
	@Override
	public String toString() {
		return "Hamster color " + getColor() + " de peso " + getPeso() + "gr.";
	}

}
