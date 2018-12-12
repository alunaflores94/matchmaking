package com.gmail.alunaflores94.matchmaking.modelo;

public class JugadorCoach extends Jugador {
	
	private final float COEFICIENTE_RAPIDEZ = .2f;
	private final float COEFICIENTE_INGENIO = 3;
	
	public JugadorCoach(String nombre, String apellido, float ingenio, float rapidez) {
		super(nombre, apellido, ingenio, rapidez);
	}

	@Override
	protected void updateELO() {
		this.ELO = getIngenio() * COEFICIENTE_INGENIO + getRapidez() * COEFICIENTE_RAPIDEZ;
	}

}
