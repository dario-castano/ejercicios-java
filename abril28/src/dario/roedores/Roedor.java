package dario.roedores;

public abstract class Roedor {
	private String color;
	private Integer peso;
	private Integer edad;
	private Integer saciedad;
	
	public Roedor(
			String color, 
			Integer peso) {
		setColor(color);
		setPeso(peso);
		setEdad(0);
		setSaciedad(100);		
	}
	
	public abstract String comer();
	public abstract String dormir();
	public abstract String mirar();
	public abstract String olfatear();
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Integer getPeso() {
		return peso;
	}
	
	public void setPeso(Integer peso) {
		if (peso < 0) {
			throw new IllegalArgumentException("Edad debe ser mayor que cero");
		}	
		this.peso = peso;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public void setEdad(Integer edad) {
		if (edad < 0) {
			throw new IllegalArgumentException("Edad debe ser mayor que cero");
		}	
		this.edad = edad;
	}
	
	public Integer getSaciedad() {
		return saciedad;
	}
	
	public void setSaciedad(Integer saciedad) {
		if (saciedad < 0 || saciedad > 100) {
			throw new IllegalArgumentException("Saciedad debe estar entre 0 y 100");
		}
		this.saciedad = saciedad;
	}
}
