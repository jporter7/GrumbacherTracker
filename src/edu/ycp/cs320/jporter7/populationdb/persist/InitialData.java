package edu.ycp.cs320.jporter7.populationdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.jporter7.controller.UserController;
import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.model.Author;
import edu.ycp.cs320.jporter7.populationdb.model.Book;

public class InitialData {
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("UserInfo.csv");
		try 
		{
			// auto-generated primary key for authors table
			Integer userId = 1;
			while (true) 
			{
				List<String> tuple = readUsers.next();
				if (tuple == null) 
				{
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				UserController controller = new UserController(user);
				controller.createUser(i.next(), i.next(), i.next(), i.next(), i.next(), Integer.parseInt(i.next()));
				userList.add(user);
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	public static List<Book> getBooks() throws IOException {
		List<Book> bookList = new ArrayList<Book>();
		ReadCSV readBooks = new ReadCSV("books.csv");
		try {
			// auto-generated primary key for books table
			Integer bookId = 1;
			while (true) {
				List<String> tuple = readBooks.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Book book = new Book();
				book.setBookId(bookId++);
				book.setUserId(Integer.parseInt(i.next()));
				book.setTitle(i.next());
				book.setIsbn(i.next());
				book.setPublished(Integer.parseInt(i.next()));
				bookList.add(book);
			}
			return bookList;
		} finally {
			readBooks.close();
		}
	}
}
