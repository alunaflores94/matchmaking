package com.gmail.alunaflores94.matchmaking.modelo;

public abstract class Jugador implements Comparable<Jugador> {

	private String nombre = "";
	private String apellido = "";
	private float ingenio = 0;
	private float rapidez = 0;
	protected float ELO = 0;
	
	public Jugador(String nombre, String apellido, float ingenio, float rapidez) {
		setNombre(nombre);
		setApellido(apellido);
		setIngenio(ingenio);
		setRapidez(rapidez);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public float getIngenio() {
		return ingenio;
	}

	public void setIngenio(float ingenio) {
		this.ingenio = ingenio;
		updateELO();
	}

	public float getRapidez() {
		return rapidez;
	}

	public void setRapidez(float rapidez) {
		this.rapidez = rapidez;
		updateELO();
	}
	
	public float getELO() {
		return this.ELO;
	}
	
	protected abstract void updateELO();
	
	@Override
	public int compareTo(Jugador otroJugador) {
		if(this.ELO < otroJugador.ELO) {
			return -1;
		}
		else if(this.ELO > otroJugador.ELO) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
}
