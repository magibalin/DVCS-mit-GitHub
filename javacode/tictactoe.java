import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Magi Balin
 * Tic-Tac-Toe
 * 02.12.2021
 */

public class TicTacToe {
	static Scanner eingabe;
	static String[] feld;
	static String aktuellerSpieler;

	public static void main(String[] args) {
		eingabe = new Scanner(System.in);
		feld = new String[9];
		aktuellerSpieler = "X";
		String gewinner = null;
		feldDefinieren();

		System.out.println("Willkommen zum Tic-Tac-Toe-Spiel!");
		feldZeichnen();
		System.out.println("Spieler X beginnt. Feldnummer für Platzierung eine " + aktuellerSpieler + "s eingeben:");

		while (gewinner == null) {
			int eingabeBenutzer;
			try {
				eingabeBenutzer = eingabe.nextInt();
				if (!(eingabeBenutzer > 0 && eingabeBenutzer <= 9)) {
					System.out.println("Ungültige Eingabe. Geben Sie eine der dargestellten Feldnummern an:");
					continue;
				}
			} catch (InputMismatchException exception) {
				System.out.println("Ungültige Eingabe. Geben Sie eine der dargestellten Feldnummern an:");
				continue;
			}
			if (feld[eingabeBenutzer-1].equals(String.valueOf(eingabeBenutzer))) {
				feld[eingabeBenutzer-1] = aktuellerSpieler;
				if (aktuellerSpieler.equals("X")) {
					aktuellerSpieler = "O";
				} else {
					aktuellerSpieler = "X";
				}
				feldZeichnen();
				gewinner = gewinnerPruefen();
			} else {
				System.out.println("Feld ist bereits belegt. Geben Sie eine der dargestellten Feldnummern an:");
				continue;
			}
		}
		if (gewinner.equalsIgnoreCase("unentschieden")) {
			System.out.println("Unentschieden! Vielen Dank für's Spielen.");
		} else {
			System.out.println("Herzlichen Glückwunsch, Spieler " + gewinner + ", du hast gewonnen! Vielen Dank für's Spielen.");
		}
	}

	static String gewinnerPruefen() {
		for (int nummerMoeglicheZeichenfolge = 0; nummerMoeglicheZeichenfolge < 8; nummerMoeglicheZeichenfolge++) {
			String zeichenfolge = null;
			switch (nummerMoeglicheZeichenfolge) {
			case 0:
				zeichenfolge = feld[0] + feld[1] + feld[2];
				break;
			case 1:
				zeichenfolge = feld[3] + feld[4] + feld[5];
				break;
			case 2:
				zeichenfolge = feld[6] + feld[7] + feld[8];
				break;
			case 3:
				zeichenfolge = feld[0] + feld[3] + feld[6];
				break;
			case 4:
				zeichenfolge = feld[1] + feld[4] + feld[7];
				break;
			case 5:
				zeichenfolge = feld[2] + feld[5] + feld[8];
				break;
			case 6:
				zeichenfolge = feld[0] + feld[4] + feld[8];
				break;
			case 7:
				zeichenfolge = feld[2] + feld[4] + feld[6];
				break;
			}
			if (zeichenfolge.equals("XXX")) {
				return "X";
			} else if (zeichenfolge.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(feld).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "unentschieden";
		}

		System.out.println("Spieler " + aktuellerSpieler + " ist an der Reihe. Feldnummer für Platzierung eines " + aktuellerSpieler + "s eingeben:");
		return null;
	}

	static void feldZeichnen() {
		System.out.println(" ----------- ");
		System.out.println("| " + feld[0] + " | " + feld[1] + " | " + feld[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + feld[3] + " | " + feld[4] + " | " + feld[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + feld[6] + " | " + feld[7] + " | " + feld[8] + " |");
		System.out.println(" ----------- ");
	}

	static void feldDefinieren() {
		for (int feldnummer = 0; feldnummer < 9; feldnummer++) {
			feld[feldnummer] = String.valueOf(feldnummer+1);
		}
	}
}
