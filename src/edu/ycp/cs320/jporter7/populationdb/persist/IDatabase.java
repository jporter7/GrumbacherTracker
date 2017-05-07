package edu.ycp.cs320.jporter7.populationdb.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.jporter7.model.Reservation;
import edu.ycp.cs320.jporter7.model.User;

public interface IDatabase 
{
	public ArrayList<User> getAllUsers();
	public User insertUser(String password, String username, String email, String firstName, String lastName, String id);
	public ArrayList<User> getActiveUsers();
	public User insertActiveUser(String dbId, String roomNumber);
	public Reservation insertReservation(String date, String startTime, int roomNumber, int userId);
	public ArrayList<Reservation> getReservationsForRoom(String room, String date);
	public User getUserFromReservationTime(String room, String time);
	public ArrayList<Reservation> getReservationsForUser(String dbId);
	public ArrayList<Reservation> getReservationsForUserAndDate(String dbId, String date);
	public User removeReservation(String room, String time);
	public User removeActiveUser(String dbId);
	public ArrayList<User> getActiveUsersInRoom(String room);
}
