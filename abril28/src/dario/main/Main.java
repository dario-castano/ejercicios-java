package dario.main;

import java.util.ArrayList;

import dario.lectorfecha.LectorFecha;
import dario.lectorprecios.LectorPrecios;
import dario.roedores.Roedor;
import dario.roedores.tipos.Capybara;
import dario.roedores.tipos.Hamster;
import dario.roedores.tipos.RataCanguro;
import dario.roedores.tipos.Raton;

public class Main {
	public static void main(String[] args) {
		ejemploRoedores();
		System.out.println("\n\n----------------------------------------------\n\n");
		ejemploFecha();
		System.out.println("\n\n----------------------------------------------\n\n");
		ejemploListaPrecios();
	}
	
	public static void ejemploRoedores() {
		ArrayList<Roedor> roedores = new ArrayList<Roedor>();
		roedores.add(new Raton());
		roedores.add(new Hamster());
		roedores.add(new RataCanguro());
		roedores.add(new Capybara());
		
		for (Roedor r : roedores) {
			System.out.println(r.toString());
			System.out.println(r.comer());
			System.out.println(r.dormir());
			System.out.println(r.mirar());
			System.out.println(r.olfatear());
		}
	}
	
	public static void ejemploFecha() {
		LectorFecha fecha = new LectorFecha("03/12/1994");
		String day = fecha.getDay();
		String month = fecha.getMonth();
		String year = fecha.getYear();
		
		System.out.println("Dia: " + day);
		System.out.println("Mes: " + month);
		System.out.println("Año: " + year);
	}
	
	public static void ejemploListaPrecios() {
		Integer[] lista = {123, 345, 444, 435, 666};
		
		LectorPrecios lp = new LectorPrecios(lista);
		System.out.println("El precio mas alto fue: " + lp.getPrecioMasAlto());
		System.out.println("El precio final fue: " + lp.getPrecioFinal());
	}
}
