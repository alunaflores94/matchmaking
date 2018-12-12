package com.gmail.alunaflores94.matchmaking.modelo;

public class JugadorCarry extends Jugador {
	
	private final float COEFICIENTE_RAPIDEZ = 2;
	private final float COEFICIENTE_INGENIO = .5f;

	public JugadorCarry(String nombre, String apellido, float ingenio, float rapidez) {
		super(nombre, apellido, ingenio, rapidez);
	}

	@Override
	protected void updateELO() {
		this.ELO = getRapidez() * COEFICIENTE_RAPIDEZ + getIngenio() * COEFICIENTE_INGENIO;
	}
	
}
