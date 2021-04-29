package dario.roedores.tipos;

import dario.roedores.Roedor;
import dario.roedores.interfaces.Correr;
import dario.roedores.interfaces.Nadar;

public class Capybara extends Roedor implements Nadar, Correr {

	public Capybara() {
		super("ROJIZO", 40000);
	}

	@Override
	public String correr() {
		return "Soy un capybara y estoy corriendo";
	}

	@Override
	public String nadar() {
		return "Soy un capybara y estoy nadando";
	}

	@Override
	public String comer() {
		return "Soy un capybara y estoy comiendo";
	}

	@Override
	public String dormir() {
		return "Soy un capybara y estoy durmiendo";
	}

	@Override
	public String mirar() {
		return "Soy un capybara y estoy mirando";
	}

	@Override
	public String olfatear() {
		return "Soy un capybara y estoy olfateando";
	}
	
	@Override
	public String toString() {
		return "Capybara color " + getColor() + " de peso " + getPeso() + "gr.";
	}
}
