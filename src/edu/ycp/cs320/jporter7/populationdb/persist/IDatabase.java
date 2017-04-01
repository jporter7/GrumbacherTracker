package edu.ycp.cs320.jporter7.populationdb.persist;

import java.util.List;

import edu.ycp.cs320.jporter7.populationdb.model.Author;
import edu.ycp.cs320.jporter7.populationdb.model.Book;
import edu.ycp.cs320.jporter7.populationdb.model.Pair;

public interface IDatabase 
{
	public List<Pair<Author, Book>> findAuthorAndBookByTitle(String title);
	public List<Pair<Author, Book>> findAuthorAndBookByAuthorLastName(String lastname);
	public List<Pair<Author, Book>> insertBook(String firstName, String lastname, String title, String isbn, String published);
}
