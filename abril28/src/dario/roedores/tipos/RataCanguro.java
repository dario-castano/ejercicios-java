package dario.roedores.tipos;

import dario.roedores.Roedor;
import dario.roedores.interfaces.Cavar;
import dario.roedores.interfaces.Saltar;

public class RataCanguro extends Roedor implements Saltar, Cavar {

	public RataCanguro() {
		super("CAFE/GRIS", 35);
	}

	@Override
	public String cavar() {
		return "Soy una rata canguro y estoy cavando";
	}

	@Override
	public String saltar() {
		return "Soy una rata canguro y estoy saltando";
	}

	@Override
	public String comer() {
		return "Soy una rata canguro y estoy comiendo";
	}

	@Override
	public String dormir() {
		return "Soy una rata canguro y estoy durmiendo";
	}

	@Override
	public String mirar() {
		return "Soy una rata canguro y estoy mirando";
	}

	@Override
	public String olfatear() {
		return "Soy una rata canguro y estoy olfateando";
	}
	
	@Override
	public String toString() {
		return "Rata canguro color " + getColor() + " de peso " + getPeso() + "gr.";
	}
}
