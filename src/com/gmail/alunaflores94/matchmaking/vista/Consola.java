package com.gmail.alunaflores94.matchmaking.vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.gmail.alunaflores94.matchmaking.modelo.Equipo;
import com.gmail.alunaflores94.matchmaking.modelo.Jugador;

public class Consola {

	private BufferedReader entrada;
	
	public Consola() {
		entrada = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void mostrarOpciones() {
		limpiarConsola();
		System.out.println("#### Opciones ####\n");
		System.out.println("1. Mostrar emparejamientos.");
		System.out.println("2. Mostrar 5 mejores jugadores.");
		System.out.println("3. Mostrar 5 mejores equipos.");
		System.out.println("4. Salir.");
	}
	
	public void mostrarEmparejamiento(String mensaje, List<Equipo> equipos) {
		limpiarConsola();
		System.out.printf("#### %s ####\n\n", mensaje);
		
		List<Equipo> emparejamientos = new ArrayList<>(equipos);
		
		int contadorPartida = 1;
		while(emparejamientos.size() > 1) {
			Equipo equipo1 = emparejamientos.remove(0);
			Equipo equipo2 = emparejamientos.remove(0);
			
			System.out.printf("Partida %d> %s (%.0f) -VS- %s (%.0f)\n", contadorPartida++, equipo1.getNombre(),
					equipo1.getELOMedio(), equipo2.getNombre(), equipo2.getELOMedio());
		}
		
		if(!emparejamientos.isEmpty()){
			System.out.printf("Partida %d> %s (%.0f) -VS- 'no hay mas equipos'\n", contadorPartida++, emparejamientos.get(0).getNombre(),
					emparejamientos.get(0).getELOMedio());
		}			
	}
	
	public void mostrarJugadores(String mensaje, List<Jugador> jugadores) {
		limpiarConsola();
		System.out.printf("#### %s ####\n\n", mensaje);
		for(Jugador jugador : jugadores) {
			System.out.printf("> %s %s (%.0f)\n", jugador.getNombre(), jugador.getApellido(), jugador.getELO());
		}
	}
	
	public void mostrarEquipos(String mensaje, List<Equipo> equipos) {
		limpiarConsola();
		System.out.printf("#### %s ####\n\n", mensaje);
		for(Equipo equipo : equipos) {
			System.out.printf("> %s (%.0f)\n", equipo.getNombre(), equipo.getELOMedio());
		}
	}
	
	public void mostrarMensaje(String mensaje, boolean limpiar) {
		if(limpiar) {
			limpiarConsola();
		}
		System.out.println(mensaje);
	}
	
	public String pedirDato(String mensaje) {
		System.out.print(mensaje);
		String dato = "";
		try {
			dato = entrada.readLine();
		}
		catch (IOException e) {
		}
		return dato;
	}
	
	public void limpiarConsola() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	public void cerrarConsola() {
		try {
			entrada.close();
		} catch (IOException e) {
		}
	}
}
