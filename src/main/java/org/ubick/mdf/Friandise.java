package org.ubick.mdf;

import java.io.*;
import java.security.interfaces.RSAKey;
import java.util.*;

public class Friandise {

	public static void main(String[] argv) throws Exception {

		Scanner sc = null;
		if (argv != null && argv.length > 0 && argv[0].equals("-d")) {
			try {
				sc = new Scanner(new File(argv[1]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			sc = new Scanner(System.in);
		}

		// parsing

		int m = Integer.parseInt(sc.nextLine());
		int t = Integer.parseInt(sc.nextLine());

		List<Piece> monnaies = new ArrayList<>();

		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();
			int v = sc.nextInt();
			monnaies.add(new Piece(v, n));
		}

		sc.close();

		int result = Integer.MAX_VALUE;

		result = combiAlgo(monnaies, m, 0);

		if (result == Integer.MAX_VALUE)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(result);
	}

	public static Integer combiAlgo(List<Piece> ensemble, Integer sum, int nbPieces) {

		// cas d'arrêt de la récursivité
		if (ensemble.isEmpty()) {
			if (sum == 0) {
				return nbPieces;
			} else {
				return Integer.MAX_VALUE;
			}
		}

		// on crée une sctructure pour les sous résultats
		List<Integer> subResults = new ArrayList<>();

		// on selectionne la piece courrante
		Piece piece = ensemble.get(0);

		// on détermine le min des pieces à calculer
		int r = sum / piece.v;
		int nbPieceMin = Math.min(piece.n, r);

		// i = 0 permet de prendre en compte le cas ou on ne veut pas de piece.
		for (int i = 0; i <= nbPieceMin; i++) {
			int newSum = sum - (i * piece.v);
			int newNbPieces = nbPieces + i;
			subResults.add(combiAlgo(ensemble.subList(1, ensemble.size()), newSum, newNbPieces));
		}

		Collections.sort(subResults);
		return subResults.get(0);
	}

}

class Piece {

	int v;

	int n;

	public Piece(int v, int n) {
		super();
		this.v = v;
		this.n = n;
	}

	@Override
	public String toString() {
		return "Piece[v=" + v + ", n=" + n + "]";
	}
}