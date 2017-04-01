package edu.ycp.cs320.jporter7.populationdb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.model.Author;
import edu.ycp.cs320.jporter7.populationdb.model.Book;
import edu.ycp.cs320.jporter7.populationdb.model.Pair;
import edu.ycp.cs320.jporter7.populationdb.persist.DatabaseProvider;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;

public class UserQuery 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter a user's last name: ");
		String lastName = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		ArrayList<User> userList = db.findUserByLastName(lastName);
		
		// check if anything was returned and output the list
		if (userList.isEmpty()) 
		{
			System.out.println("No books found for the last name <" + lastName + ">");
		}
		else 
		{
			User user = new User();
			user = userList.get(0);
			System.out.println(user.getFullName() + "," + user.getEmail() + "," + user.getPassword() + "," + user.getUserName() + "," + user.getId());
		}
	}
}
