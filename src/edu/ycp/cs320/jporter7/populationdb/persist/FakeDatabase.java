package edu.ycp.cs320.jporter7.populationdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.jporter7.populationdb.model.Author;
import edu.ycp.cs320.jporter7.populationdb.model.Book;
import edu.ycp.cs320.jporter7.populationdb.model.Pair;

public class FakeDatabase implements IDatabase {
	
	private List<Author> authorList;
	private List<Book> bookList;
	
	public FakeDatabase() {
		authorList = new ArrayList<Author>();
		bookList = new ArrayList<Book>();
		
		// Add initial data
		readInitialData();
		
		System.out.println(authorList.size() + " authors");
		System.out.println(bookList.size() + " books");
	}

	public void readInitialData() {
		try {
			authorList.addAll(InitialData.getAuthors());
			bookList.addAll(InitialData.getBooks());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	@Override
	public List<Pair<Author, Book>> findAuthorAndBookByTitle(String title) {
		List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();
		for (Book book : bookList) {
			if (book.getTitle().equals(title)) {
				Author author = findAuthorByAuthorId(book.getAuthorId());
				result.add(new Pair<Author, Book>(author, book));
			}
		}
		return result;
	}

	private Author findAuthorByAuthorId(int authorId) {
		for (Author author : authorList) {
			if (author.getAuthorId() == authorId) {
				return author;
			}
		}
		return null;
	}
	
	public List<Pair<Author, Book>> findAuthorAndBookByAuthorLastName(String lastname)
	{
		List<Pair<Author, Book>> authorBookList = new ArrayList<Pair<Author,Book>>();
		
		//iterate through the entire authorList
		for (Author author : authorList)
		{
			//if the last name of the author passed in is in the author table
			//execute this
			if (author.getLastname().equals(lastname))
			{
				//iterate through the bookList
				for (Book book: bookList)
				{
					//if the book's author_id and author's author id match
					//execute this
					if (book.getAuthorId() == author.getAuthorId())
					{
						//add the author author and book information into the
						//authorBookList that will be returned to be printed out in AuthorQuery
						//or some other function
						authorBookList.add(new Pair<Author, Book>(author, book));
					}
				}
			}
		}
		
		return authorBookList;
	}
	
	public List<Pair<Author, Book>> insertBook(String firstName, String lastName, String title, String isbn, String published)
	{
		//throw new UnsupportedOperationException();
		List<Pair<Author, Book>> authorBookList = new ArrayList<Pair<Author,Book>>();
		boolean inAuthorTable = false;
		Author author = null;
		Book book = null;
		
		//iterate through the author table
		for (Author author2 : authorList)
		{
			//get the author's full name and then check if the author
			//that is passed in is in the author's table
			String fullName = author2.getFirstname() + " " + author2.getLastname();
			if (fullName.equals(firstName + " " + lastName))
			{
				//if the author information that is passed in is in the author's table
				//create a new book and add it to the book table
				book = new Book();
				book.setAuthorId(author2.getAuthorId());
				book.setIsbn(isbn);
				book.setPublished(Integer.parseInt(published));
				book.setTitle(title);
				bookList.add(book);
				inAuthorTable = true;
				System.out.println("Author was in Author list and book has been added");
			}
		}
		//if the author was not in the author's table, create a new author and add
		//that author to the author's table and then create a new book
		//and add that book to the books table
		if (inAuthorTable == false)
		{
			author = new Author();
			author.setFirstname(firstName);
			author.setLastname(lastName);
			author.setAuthorId(authorList.size());
			authorList.add(author);
			
			book = new Book();
			book.setBookId(bookList.size());
			book.setAuthorId(author.getAuthorId());
			book.setIsbn(isbn);
			book.setPublished(Integer.parseInt(published));
			book.setTitle(title);
			bookList.add(book);
			System.out.println("Author wasn't in Author list, but the book has been added");
			
		}
		
		//add the author and book to the authorBookList to be returned from this method
		authorBookList.add(new Pair<Author, Book>(author, book));
		
		//print out the amount of authors and books to check if they were added
		//because the data does not persist in this database
		System.out.println(authorList.size() + " authors");
		System.out.println(bookList.size() + " books");
		return authorBookList;
	}
}
