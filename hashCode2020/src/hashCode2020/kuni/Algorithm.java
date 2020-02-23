package hashCode2020.kuni;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Algorithm {

	public static List<Library> A(Integer totalBooks, Integer totalLibraries, Integer totalDays,
			List<Library> librerias) {
		Integer day = 0;
		List<Library> solutions = new LinkedList<Library>();
		while (day < totalDays && !librerias.isEmpty()) {
			Library library = null;
			float maxScore = 0;
			for (Library l : librerias) {
				// add days left
				float score = l.getMaxPoints(day, totalDays);
				if (maxScore < score) {
					maxScore = score;
					library = l;
				}
			}
			if (library == null) {
				break;
			}
			day += library.getSignUp();
			library.scanBooks(day, totalDays);
			librerias.remove(library);
			solutions.add(library);
		}
		return solutions;
	}

	public static List<Library> B(Integer totalBooks, Integer totalLibraries, Integer totalDays,
			List<Library> librerias) {
		Integer day = 0;
		List<Library> solutions = new LinkedList<Library>();
		librerias.sort((o1, o2) -> o1.getSignUp() - o2.getSignUp());
		Iterator<Library> it = librerias.iterator();
		while (day < totalDays && it.hasNext()) {
			Library library = it.next();
			if (library.getSignUp() + day < totalDays) {
				day += library.getSignUp();
				library.scanBooks(day, totalDays);
				solutions.add(library);
			}
		}
		return solutions;
	}

	public static void C() {

	}

	public static List<Library> D(Integer totalBooks, Integer totalLibraries, Integer totalDays,
			List<Library> librerias) {
		Integer day = 0;
		List<Library> solutions = new LinkedList<Library>();
		while (day < totalDays && !librerias.isEmpty()) {
			Library library = null;
			int max = 0;
			for (Library l : librerias) {
				// add days left
				int notUsedBooks = l.getNotUsedBooks();
				if (max < notUsedBooks) {
					max = notUsedBooks;
					library = l;
				}
			}
			day += library.getSignUp();
			if (day < totalDays) {
				library.scanBooks(day, totalDays);
				librerias.remove(library);
				solutions.add(library);
			}
		}
		return solutions;
	}

	public static List<Library> E(Integer totalBooks, Integer totalLibraries, Integer totalDays,
			List<Library> librerias) {
		Integer day = 0;
		List<Library> solutions = new LinkedList<Library>();
		while (day < totalDays && !librerias.isEmpty()) {
			Library library = null;
			float maxScore = 0;
			for (Library l : librerias) {
				// add days left
				float score = l.getMaxPoints2(day, totalDays);
				if (maxScore < score) {
					maxScore = score;
					library = l;
				}
			}
			if (library == null) {
				break;
			}
			day += library.getSignUp();
			library.scanBooks(day, totalDays);
			librerias.remove(library);
			solutions.add(library);
		}
		return solutions;
	}

	public static void F() {

	}

}
