package edu.ycp.cs320.jporter7.populationdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.jporter7.controller.UserController;
import edu.ycp.cs320.jporter7.model.User;
//import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.model.Book;
import edu.ycp.cs320.jporter7.populationdb.model.Pair;

public class FakeDatabase implements IDatabase {
	
	private List<User> userList;
	private List<Book> bookList;
	
	public FakeDatabase() {
		userList = new ArrayList<User>();
		bookList = new ArrayList<Book>();
		
		// Add initial data
		readInitialData();
		
		System.out.println(userList.size() + " users");
		System.out.println(bookList.size() + " books");
	}

	public void readInitialData() {
		try {
			userList.addAll(InitialData.getUsers());
			//bookList.addAll(InitialData.getBooks());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	@Override
	public List<Pair<User, Book>> findUserAndBookByTitle(String title) {
		List<Pair<User, Book>> result = new ArrayList<Pair<User,Book>>();
		for (Book book : bookList) {
			if (book.getTitle().equals(title)) {
				User user = findUserByUserId(book.getUserId());
				result.add(new Pair<User, Book>(user, book));
			}
		}
		return result;
	}

	private User findUserByUserId(int userId) {
		for (User user : userList) {
			if (user.getId() == userId) {
				return user;
			}
		}
		return null;
	}
	
	public ArrayList<User> findUserByLastName(String lastname)
	{
		ArrayList<User> resultList = new ArrayList<User>();
		
		//iterate through the entire userList
		for (User user : userList)
		{
			//if the last name of the user passed in is in the user table
			//execute this
			if (user.getLastName().equals(lastname))
			{
				resultList.add(user);
			}
		}
		
		return resultList;
	}
	
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> resultList = new ArrayList<User>();
		
		//iterate through the entire userList
		for (User user : userList)
		{
			resultList.add(user);
		}
		
		return resultList;
	}
	
	public List<Pair<User, Book>> insertBook(String firstName, String lastName, String title, String isbn, String published)
	{
		//throw new UnsupportedOperationException();
		List<Pair<User, Book>> userBookList = new ArrayList<Pair<User,Book>>();
		boolean inuserTable = false;
		User user = null;
		Book book = null;
		
		//iterate through the user table
		for (User user2 : userList)
		{
			//get the user's full name and then check if the user
			//that is passed in is in the user's table
			String fullName = user2.getFirstName() + " " + user2.getLastName();
			if (fullName.equals(firstName + " " + lastName))
			{
				//if the user information that is passed in is in the user's table
				//create a new book and add it to the book table
				book = new Book();
				book.setUserId(user2.getId());
				book.setIsbn(isbn);
				book.setPublished(Integer.parseInt(published));
				book.setTitle(title);
				bookList.add(book);
				inuserTable = true;
				System.out.println("user was in user list and book has been added");
			}
		}
		//if the user was not in the user's table, create a new user and add
		//that user to the user's table and then create a new book
		//and add that book to the books table
		if (inuserTable == false)
		{
			user = new User();
			UserController controller = new UserController(user);
			controller.createUser("", "", "", "", "", 0);
			user.setId(userList.size());
			userList.add(user);
			
			book = new Book();
			book.setBookId(bookList.size());
			book.setUserId(user.getId());
			book.setIsbn(isbn);
			book.setPublished(Integer.parseInt(published));
			book.setTitle(title);
			bookList.add(book);
			System.out.println("user wasn't in user list, but the book has been added");
			
		}
		
		//add the user and book to the userBookList to be returned from this method
		userBookList.add(new Pair<User, Book>(user, book));
		
		//print out the amount of users and books to check if they were added
		//because the data does not persist in this database
		System.out.println(userList.size() + " users");
		System.out.println(bookList.size() + " books");
		return userBookList;
	}
	
	public User insertUser(String password, String username, String email, String firstName, String lastName, String id)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<User> getActiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
