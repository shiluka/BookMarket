package bookrating.algorithm.hashmap;

import bookrating.book.Book;

//Hash Entry for Book
public class HashEntry {

	private String key;
	private Book value;

	HashEntry(String key, Book value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public Book getValue() {
		return value;
	}
}