package hashCode2020.kuni;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Library {

	public static int[] bookScores = null;
	public static int[] bookRepeated = null;
	public static boolean[] bookUsed = null;
	static Map<Integer, List<Library>> mapLibros = null;

	private Integer index;
	private Integer numBooks;
	private Integer signUp;
	private Integer shipPerDay;
	private List<Integer> books;
	private List<Integer> scannedBooks;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getNumBooks() {
		return numBooks;
	}

	public void setNumBooks(Integer numBooks) {
		this.numBooks = numBooks;
	}

	public Integer getSignUp() {
		return signUp;
	}

	public void setSignUp(Integer signUp) {
		this.signUp = signUp;
	}

	public Integer getShipPerDay() {
		return shipPerDay;
	}

	public void setShipPerDay(Integer shipPerDay) {
		this.shipPerDay = shipPerDay;
	}

	public List<Integer> getBooks() {
		return books;
	}

	public void setBooks(List<Integer> books) {
		this.books = books;
	}

	public List<Integer> getScannedBooks() {
		return scannedBooks;
	}

	public void setScannedBooks(List<Integer> scannedBooks) {
		this.scannedBooks = scannedBooks;
	}

	public float getMaxPoints(Integer firstDay, Integer totalDays) {
		int d = firstDay;
		d += signUp;
		float score = 0;
		Iterator<Integer> it = books.iterator();
		while (d < totalDays && it.hasNext()) {
			int i = 0;
			while (it.hasNext() && i < shipPerDay) {
				Integer book = it.next();
				if (!bookUsed[book]) {
					score += bookScores[book];
					i++;
				}
			}
			d++;
		}
		return score/(d-firstDay);
	}
	
	public float getMaxPoints2(Integer firstDay, Integer totalDays) {
		int d = firstDay;
		d += signUp;
		float score = 0;
		Iterator<Integer> it = books.iterator();
		while (d < totalDays && it.hasNext()) {
			int i = 0;
			while (it.hasNext() && i < shipPerDay) {
				Integer book = it.next();
				if (!bookUsed[book]) {
					score += bookScores[book];
					i++;
				}
			}
			d++;
		}
		return score;
	}
	
	public int getNotUsedBooks() {
		int notUsedBooks = 0;
		for (int book : books) {
			if (!bookUsed[book]) {
				notUsedBooks++;
			}
		}
		return notUsedBooks;
	}
	
	public float getMostFrecuent() {
		int count = 0;
		int notUsedBooks = 0;
		for (int book : books) {
			if (!bookUsed[book]) {
				notUsedBooks++;
				count+=bookRepeated[book];
			}
		}
		return (float) count/notUsedBooks;
	}
	
	public void scanBooks(Integer day, Integer totalDays) {
		List<Integer> scannedBooks = new LinkedList<Integer>();
		Iterator<Integer> it = books.iterator();
		while (day < totalDays && it.hasNext()) {
			int i = 0;
			while (it.hasNext() && i < shipPerDay) {
				Integer book = it.next();
				if (!bookUsed[book]) {
					bookUsed[book] = true;
					scannedBooks.add(book);
					i++;
				}
			}
			day++;
		}
		this.scannedBooks = scannedBooks;
	}
	
	public void scanBooks2(Integer day, Integer totalDays) {
		List<Integer> scannedBooks = new LinkedList<Integer>();
		List<Integer> booksCopy = new ArrayList<Integer>(books);
		Iterator<Integer> it = booksCopy.iterator();
		while (day < totalDays && it.hasNext()) {
			int i = 0;
			while (it.hasNext() && i < shipPerDay) {
				Integer book = it.next();
				for (Library l : mapLibros.get(book)) {
					l.getBooks().remove(book);
				}
				mapLibros.remove(book);
				scannedBooks.add(book);
				i++;
			}
			day++;
		}
		System.out.println(day);
		this.scannedBooks = scannedBooks;
	}

}