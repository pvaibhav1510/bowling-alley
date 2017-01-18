package com.ba.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ba.models.Player;

public class BowlingAlley {
	public static final int numberOfTotalLanes = 10;

	public void start() throws Exception {
		Scanner sc = new Scanner(System.in);

		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("-------- The game is started --------");
		int laneRunning = 0;
		while (laneRunning < numberOfTotalLanes) {
			System.out.println("Do you want to start a new lane (y) :");
			char choice = (char) read.read();
			if (choice == 'y') {
				System.out.println("Number of players :");
				Integer numOfPlayers = sc.nextInt();

				List<Player> players = new ArrayList<>();
				for (int i = 0; i < numOfPlayers; i++) {
					System.out.println("Player Name [" + i + "] :");
					players.add(new Player().name(sc.next()));
				}
				_start(players, laneRunning++);
			}
		}

	}

	private void _start(List<Player> players, int laneCount) {
		Lane l = new Lane(players);
		l.setName("Lane " + laneCount);
		l.start();
	}
}
