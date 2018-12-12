package com.gmail.alunaflores94.matchmaking.controlador;

import java.util.Random;

import com.gmail.alunaflores94.matchmaking.modelo.Equipo;
import com.gmail.alunaflores94.matchmaking.modelo.JugadorCarry;
import com.gmail.alunaflores94.matchmaking.modelo.JugadorCoach;
import com.gmail.alunaflores94.matchmaking.vista.Consola;

public class Main {
	
	private static final String[] nombresJugadores = {
			"Alberto", "Alfonso", "Alicia", "Bonifacio", "Cristina", "Carlos", "Alfredo",
			"Marta", "Cristian", "Alejandro", "Angel", "Eva", "Maria", "Manuel", "Jose",
			"Marcos", "Sara", "Francisco", "Paco", "Marina"
	};
	
	private static final String[] apellidosJugadores = {
			"Luna", "Garcia", "Lopez", "Jimenez", "Bernia", "Quintero", "Estevez", "Gracia",
			"Alvarez", "Vazquez", "Ronaldo", "Cayuela", "Loscos", "Rufian", "Sanchez", "Alarcon"
	};
	
	private Consola consola = new Consola();
	private Liga liga = new Liga();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.generarDatos();
		main.empezar();
	}
	
	private void generarDatos() {
		Random random = new Random();
		for(int i = 0; i < Liga.MAX_EQUIPOS; i++) {
			Equipo equipo = new Equipo("Equipo " + (i+1));
			for(int j = 0; j < Equipo.MAX_JUGADORES; j++) {
				String nombre = nombresJugadores[random.nextInt(nombresJugadores.length)];
				String apellido = apellidosJugadores[random.nextInt(apellidosJugadores.length)];
				float ingenio = random.nextFloat() * 1000;
				float rapidez = random.nextFloat() * 1000;
				if(random.nextInt(10) > 5)
				{
					equipo.addJugador(new JugadorCarry(nombre, apellido, ingenio, rapidez));
				}
				else {
					equipo.addJugador(new JugadorCoach(nombre, apellido, ingenio, rapidez));
				}
			}
			liga.addEquipo(equipo);
		}
	}
	
	private void empezar() {
		boolean salir = false;
		
		while(!salir) {
			consola.mostrarOpciones();
			switch(consola.pedirDato("\nOpcion: ")) {
				case "1":
					consola.mostrarEmparejamiento("Mejores emparejamientos", liga.emparejamientos());
					consola.pedirDato("\nPulse ENTER para continuar.");
					break;
				case "2":
					consola.mostrarJugadores("Mejores 5 jugadores de la liga", liga.mejoresJugadores());
					consola.pedirDato("\nPulse ENTER para continuar.");
					break;
				case "3":
					consola.mostrarEquipos("Mejores 5 equipos de la liga", liga.mejoresEquipos());
					consola.pedirDato("\nPulse ENTER para continuar.");
					break;
				case "4":
					salir = true;
					break;						
			}
		}
		
		consola.mostrarMensaje("\nSaliendo...", false);
		consola.cerrarConsola();
	}

}
