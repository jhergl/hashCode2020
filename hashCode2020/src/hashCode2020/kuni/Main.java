package hashCode2020.kuni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {

		BufferedReader reader;
		try {
			for (Input input : Input.values()) {
				reader = new BufferedReader(new FileReader(Constants.RESOURCES_URL.concat(input.getName())));
				String line = reader.readLine();
				Integer lineN = 0;
				Integer totalBooks = 0;
				Integer totalLibraries = 0;
				Integer totalDays = 0;

				// Loading globals
				if (lineN == 0) {
					String[] splited = line.split("\\s+");
					totalBooks = Integer.parseInt(splited[0]);
					totalLibraries = Integer.parseInt(splited[1]);
					totalDays = Integer.parseInt(splited[2]);

				}
				List<Library> librerias = new LinkedList<Library>();
				Library.bookRepeated = new int[totalBooks];
				Library.bookScores = new int[totalBooks];
				Library.bookUsed = new boolean[totalBooks];
				line = reader.readLine();
				lineN++;
				if (lineN == 1) {
					String[] splited = line.split("\\s+");
					int i = 0;
					for (String str : splited) {
						Library.bookScores[i] = Integer.parseInt(str);
						i++;
					}
				}

				// Loading libraries
				Library.mapLibros = new HashMap<>();
				for (int i = 0; i < totalLibraries; i++) {
					line = reader.readLine();
					String[] splited = line.split("\\s+");
					Library l = new Library();
					l.setIndex(i);
					l.setNumBooks(Integer.valueOf(splited[0]));
					l.setSignUp(Integer.valueOf(splited[1]));
					l.setShipPerDay(Integer.valueOf(splited[2]));

					List<Integer> books = new ArrayList<Integer>();
					line = reader.readLine();
					splited = line.split("\\s+");
					for (String s : splited) {
						Integer book = Integer.valueOf(s);
						if (!Library.mapLibros.containsKey(book)) {
							Library.mapLibros.put(book, new ArrayList<Library>());
						}
						Library.mapLibros.get(book).add(l);
						Library.bookRepeated[book]++;
						books.add(book);
					}
					books.sort((o1, o2) -> Library.bookScores[o2] - Library.bookScores[o1]);
					l.setBooks(books);
					librerias.add(l);
				}
				reader.close();
				
//				Backtracking.backtracking(librerias, totalLibraries, totalDays);
				
				
				List<Library> solutions;
				switch (input) {
//				case B:
//					solutions = Algorithm.B(totalBooks, totalLibraries, totalDays, librerias);
//					break;
//				case D:
//					solutions = Algorithm.DD(totalBooks, totalLibraries, totalDays, librerias);
//					break;
//				case E:
//					solutions = Algorithm.E(totalBooks, totalLibraries, totalDays, librerias);
//					break;
				default:
					solutions = Algorithm.DD(totalBooks, totalLibraries, totalDays, librerias);
					break;
				}

				PrintWriter writer = new PrintWriter(Constants.SOLUTIONS_URL.concat(input.getName()));
				// First line
				writer.println(solutions.size());
				// Libraries
				int score = 0;
				for (Library l : solutions) {
					writer.println(l.getIndex() + " " + l.getScannedBooks().size());
					Iterator<Integer> it = l.getScannedBooks().iterator();
					StringBuilder sb = new StringBuilder();
					while (it.hasNext()) {
						int book = it.next();
						score+=Library.bookScores[book];
						sb.append(book);
						if (it.hasNext()) {
							sb.append(Constants.WHITESPACE);
						}
					}
					writer.println(sb);
				}
				writer.close();
				System.out.println(Constants.RESOURCES_URL.concat(input.getName()).concat(Constants.WHITESPACE)+score);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
