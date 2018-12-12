package com.gmail.alunaflores94.matchmaking.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo implements Comparable<Equipo> {

	public static final int MAX_JUGADORES = 5;
	
	private String nombre;
	private List<Jugador> jugadores = new ArrayList<>(MAX_JUGADORES);
	private float ELOMedio = 0;
	
	public Equipo(String nombre) {
		setNombre(nombre);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Jugador> getJugadores() {
		return this.jugadores;
	}
	
	public void addJugador(Jugador jugador) {
		if(jugadores.size() < MAX_JUGADORES) {
			this.jugadores.add(jugador);
			updateELOMedio();
		}
	}
	
	public float getELOMedio() {
		return this.ELOMedio;
	}
	
	private void updateELOMedio() {
		float ELOJugadores = 0;
		for(Jugador jugador : this.jugadores) {
			ELOJugadores += jugador.getELO();
		}
		this.ELOMedio = ELOJugadores / jugadores.size();
	}

	@Override
	public int compareTo(Equipo otroEquipo) {
		if(this.ELOMedio < otroEquipo.ELOMedio) {
			return -1;
		}
		else if(this.ELOMedio > otroEquipo.ELOMedio) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
