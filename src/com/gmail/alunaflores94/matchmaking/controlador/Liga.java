package com.gmail.alunaflores94.matchmaking.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gmail.alunaflores94.matchmaking.modelo.Equipo;
import com.gmail.alunaflores94.matchmaking.modelo.Jugador;

public class Liga {
	
	public static final int MAX_EQUIPOS = 20;

	private List<Equipo> equipos = new ArrayList<>();
	
	public List<Equipo> getEquipos() {
		return this.equipos;
	}
	
	public void addEquipo(Equipo equipo) {
		if(this.equipos.size() < MAX_EQUIPOS) {
			this.equipos.add(equipo);
			this.equipos.sort(null);
		}
	}
	
	public List<Equipo> emparejamientos() {
		return this.equipos;
	}
	
	public List<Equipo> mejoresEquipos() {
		List<Equipo> equiposMejores = new ArrayList<>(this.equipos);
		Collections.reverse(equiposMejores);
		return equiposMejores.subList(0, 5);
	}

	public List<Jugador> mejoresJugadores() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		for(Equipo equipo : this.equipos) {
			jugadores.addAll(equipo.getJugadores());
		}
		jugadores.sort(null);
		Collections.reverse(jugadores);
		return jugadores.subList(0, 5);
	}
}
