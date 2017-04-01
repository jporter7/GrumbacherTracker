package edu.ycp.cs320.jporter7.populationdb;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.jporter7.populationdb.model.Author;
import edu.ycp.cs320.jporter7.populationdb.model.Book;
import edu.ycp.cs320.jporter7.populationdb.model.Pair;
import edu.ycp.cs320.jporter7.populationdb.persist.DatabaseProvider;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;

public class InsertBook 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		//get information for the book that is being added
		System.out.print("Enter an author's first name: ");
		String firstName = keyboard.nextLine();
		System.out.print("Enter a author's last name: ");
		String lastName = keyboard.nextLine();
		System.out.print("Enter a book title: ");
		String title = keyboard.nextLine();
		System.out.print("Enter the ISBN: ");
		String isbn = keyboard.nextLine();
		System.out.print("Enter the year published: ");
		String published = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		db.insertBook(firstName, lastName, title, isbn, published);
	}
}
