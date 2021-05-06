package net.dario.personas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonasApplication.class, args);
		printExercise();
	}
	
	public static void printExercise() {
		System.out.println("\n\n---------- IMPRIME LISTA DE NOMBRES ----------\n\n");
		//TODO: Terminar la impresion de los nombres
	}

}
