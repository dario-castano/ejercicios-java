package dario.lectorprecios;

import java.util.Arrays;

public class LectorPrecios {
	private Integer[] listaPrecios;
	private Integer precioMasAlto;
	private Integer precioFinal;

	public LectorPrecios(Integer[] listaPrecios) {
		setListaPrecios(listaPrecios);
	}

	public Integer[] getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(Integer[] listaPrecios) {
		if (listaPrecios.length != 5) {
			throw new IllegalArgumentException("La lista debe tener 5 elementos");
		}
		
		Boolean allPositives = todosPositivos(listaPrecios);
		
		if (allPositives) {
			this.listaPrecios = listaPrecios;
			this.precioMasAlto = calcularPrecioMasAlto(listaPrecios);
			this.precioFinal = calcularPrecioFinal(listaPrecios);
		} else {
			throw new IllegalArgumentException("La lista debe tener precios positivos");
		}
	}

	public Integer getPrecioMasAlto() {
		return precioMasAlto;
	}

	public Integer getPrecioFinal() {
		return precioFinal;
	}
	
	private Boolean todosPositivos(Integer[] listaPrecios) {
		return Arrays
				.asList(listaPrecios)
				.stream()
				.allMatch(x -> x > 0);
	}
	
	private Integer calcularPrecioMasAlto(Integer[] listaPrecios) {
		return Arrays
				.asList(listaPrecios)
				.stream()
				.reduce(0, (a, b) -> Math.max(a, b));
	}
	
	private Integer sumarPrecios(Integer[] listaPrecios) {
		return Arrays
				.asList(listaPrecios)
				.stream()
				.reduce(0, (a, b) -> a + b);
	}
	
	private Integer calcularPrecioFinal(Integer[] listaPrecios) {
		Double suma = new Double(sumarPrecios(listaPrecios));
		if (suma > 300) {
			suma *= 1.3;
		} 
		else {
			suma *= 1.07;
		}
		return new Integer(suma.intValue());
	}
}
