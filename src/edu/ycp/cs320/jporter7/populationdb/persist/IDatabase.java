package edu.ycp.cs320.jporter7.populationdb.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.jporter7.model.Reservation;
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
	public User insertUser(String password, String username, String email, String firstName, String lastName, String id);
	public ArrayList<User> getActiveUsers();
	public User insertActiveUser(String dbId, String roomNumber);
	public Reservation insertReservation(String date, String startTime, int roomNumber, int userId);
	public ArrayList<Reservation> getReservationsForRoom(String room, String date);
	public User getUserFromReservationTime(String room, String time);
	public User removeReservation(String room, String time);
	public User removeActiveUser(String dbId);
}
