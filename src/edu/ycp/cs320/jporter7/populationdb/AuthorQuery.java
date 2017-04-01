package edu.ycp.cs320.jporter7.populationdb;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.jporter7.populationdb.model.Author;
import edu.ycp.cs320.jporter7.populationdb.model.Book;
import edu.ycp.cs320.jporter7.populationdb.model.Pair;
import edu.ycp.cs320.jporter7.populationdb.persist.DatabaseProvider;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;

public class AuthorQuery 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter an author's last name: ");
		String lastName = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Pair<Author, Book>> authorBookList = db.findAuthorAndBookByAuthorLastName(lastName);
		
		// check if anything was returned and output the list
		if (authorBookList.isEmpty()) 
		{
			System.out.println("No books found for the last name <" + lastName + ">");
		}
		else 
		{
			for (Pair<Author, Book> authorBook : authorBookList) 
			{
				Author author = authorBook.getLeft();
				Book book = authorBook.getRight();
				System.out.println(author.getLastname() + "," + author.getFirstname() + "," + book.getTitle() + "," + book.getIsbn() + "," + book.getPublished());
			}
		}
	}
}
