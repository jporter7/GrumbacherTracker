package edu.ycp.cs320.jporter7.populationdb.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.model.Author;
import edu.ycp.cs320.jporter7.populationdb.model.Book;
import edu.ycp.cs320.jporter7.populationdb.model.Pair;

public interface IDatabase 
{
	public List<Pair<User, Book>> findUserAndBookByTitle(String title);
	public ArrayList<User> findUserByLastName(String lastname);
	public List<Pair<User, Book>> insertBook(String firstName, String lastname, String title, String isbn, String published);
	public ArrayList<User> getAllUsers();
}
