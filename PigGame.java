package com.aurionpro.test;

import java.util.*;

public class PigGame {
	public static void main(String[] args) {
		{
			System.out.println("First Player Starts Playing");
			int turn = 1;
			Scanner sc = new Scanner(System.in);
			char input;
			System.out.println("Roll or hold? (r/h) : ");
			input = sc.next().charAt(0);
			int turnScore = 0;
			int totalScore = 0;
			System.out.println("Turn " + turn);
			int playerOneTurnScore = playgame(input, turnScore, totalScore, turn);
			System.out.println("Second Player Starts Playing");
			playInput(input, turnScore, totalScore, turn);
			int playerTwoTurnScore = playgame(input, turnScore, totalScore, turn);
			System.out.println(playerTwoTurnScore);
			if (playerOneTurnScore < playerTwoTurnScore)
				System.out.println("Player One wins");
			else if (playerOneTurnScore > playerTwoTurnScore)
				System.out.println("Player Two Wins");
			else if (playerOneTurnScore == playerTwoTurnScore)
				System.out.println("Tie");

		}

	}

	private static int playgame(char input, int turnScore, int totalScore, int turn) {
		while (input == 'r') {
			Scanner sc = new Scanner(System.in);
			int cp = getRandomto6();
			System.out.println("Die :" + cp);
			if (cp == 1) {;
				turnScore = 0;
				System.out.println("TURN OVER NO SCORE ");
				turn++;
				totalScore = 0;
				System.out.println("TURN " + turn);
			} else {
				turnScore = turnScore + cp;
				totalScore = totalScore + cp;
			}
			System.out.print("Roll or hold? (r/h) : ");
			input = sc.next().charAt(0);
			if (input == 'h') {
				System.out.println("Score for Turn :" + turnScore);
				System.out.println("Total Score :" + totalScore);
				turn++;
				turnScore = 0;
				if (totalScore >= 20) {
					System.out.println("You finished in " + (turn - 1) + "  turns!");
					break;
				}
				System.out.println("TURN " + turn);
				System.out.print("Roll or hold? (r/h) : ");
				input = sc.next().charAt(0);
			}
		}
		return (turn - 1);

	}


	private static void playInput(char input, int turnScore, int totalScore, int turn) {
		Scanner sc = new Scanner(System.in);
		turn = 1;
		turnScore = 0;
		totalScore = 0;
		System.out.println("Roll or hold? (r/h) : ");
		input = sc.next().charAt(0);
		System.out.println("Turn " + turn);

	}

	static int getRandomto6() {
		int random = (int) (Math.random() * 6) + 1;
		return random;
	}

}