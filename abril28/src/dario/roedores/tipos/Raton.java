package dario.roedores.tipos;

import dario.roedores.Roedor;
import dario.roedores.interfaces.Correr;
import dario.roedores.interfaces.Escalar;

public class Raton extends Roedor implements Correr, Escalar {
	
	public Raton() {
		super("GRIS", 30);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String comer() {
		return "Soy un ratón y estoy comiendo";
	}

	@Override
	public String dormir() {
		return "Soy un ratón y estoy durmiendo";
	}

	@Override
	public String mirar() {
		return "Soy un ratón y estoy mirando";
	}

	@Override
	public String olfatear() {
		return "Soy un ratón y estoy olfateando";
	}

	@Override
	public String correr() {
		return "Soy un ratón y estoy corriendo";
	}

	@Override
	public String escalar() {
		return "Soy un ratón y estoy escalando";
	}
	
	@Override
	public String toString() {
		return "Ratón color " + getColor() + " de peso " + getPeso() + "gr.";
	}
}
