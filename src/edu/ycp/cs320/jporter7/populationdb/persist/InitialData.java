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
				user.setDbId(userId);
				controller.createUser(i.next(), i.next(), i.next(), i.next(), i.next(), Integer.parseInt(i.next()));
				userList.add(user);
				userId++;
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	public static List<User> getActive() throws IOException {
		List<User> activeList = new ArrayList<User>();
		ReadCSV readActive = new ReadCSV("active.csv");
		try {
			// auto-generated primary key for books table
			Integer activeId = 1;
			while (true) {
				List<String> tuple = readActive.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				user.setDbId(Integer.parseInt(i.next()));
				user.setRoom(Integer.parseInt(i.next()));
				activeList.add(user);
			}
			return activeList;
		} finally {
			readActive.close();
		}
	}
}
