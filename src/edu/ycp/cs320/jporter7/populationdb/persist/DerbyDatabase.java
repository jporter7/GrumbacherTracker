package edu.ycp.cs320.jporter7.populationdb.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.jporter7.controller.UserController;
import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.model.Book;
import edu.ycp.cs320.jporter7.populationdb.model.Pair;
import edu.ycp.cs320.jporter7.sqldemo.DBUtil;

public class DerbyDatabase implements IDatabase 
{
	static 
	{
		try 
		{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} 
		catch (Exception e) 
		{
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> 
	{
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	@Override
	public List<Pair<User, Book>> findUserAndBookByTitle(final String title) 
	{
		return executeTransaction(new Transaction<List<Pair<User,Book>>>() 
		{
			@Override
			public List<Pair<User, Book>> execute(Connection conn) throws SQLException 
			{
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try 
				{
					// retreive all attributes from both Books and Users tables
					stmt = conn.prepareStatement(
							"select users.*, books.* " +
							"  from users, books " +
							" where users.user_id = books.user_id " +
							"   and books.title = ?"
					);
					stmt.setString(1, title);
					
					List<Pair<User, Book>> result = new ArrayList<Pair<User,Book>>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) 
					{
						found = true;
						
						// create new User object
						// retrieve attributes from resultSet starting with index 1
						User user = new User();
						loadUser(user, resultSet, 1);
						
						// create new Book object
						// retrieve attributes from resultSet starting at index 4
						Book book = new Book();
						loadBook(book, resultSet, 4);
						
						result.add(new Pair<User, Book>(user, book));
					}
					
					// check if the title was found
					if (!found) 
					{
						System.out.println("<" + title + "> was not found in the books table");
					}
					
					return result;
				} 
				finally 
				{
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) 
	{
		try 
		{
			return doExecuteTransaction(txn);
		} 
		catch (SQLException e) 
		{
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException 
	{
		Connection conn = connect();
		
		try 
		{
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) 
			{
				try 
				{
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} 
				catch (SQLException e) 
				{
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) 
					{
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} 
					else 
					{
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) 
			{
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} 
		finally 
		{
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException 
	{
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");
		
		// Set autocommit to false to allow execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	private void loadUser(User user, ResultSet resultSet, int index) throws SQLException 
	{
		UserController controller = new UserController(user);
		controller.createUser(resultSet.getString(index++), resultSet.getString(index++), resultSet.getString(index++),
				resultSet.getString(index++), resultSet.getString(index++), resultSet.getInt(index++));
		/*user.setUserId(resultSet.getInt(index++));
		user.setLastname(resultSet.getString(index++));
		user.setFirstname(resultSet.getString(index++));*/
	}
	
	private void loadBook(Book book, ResultSet resultSet, int index) throws SQLException 
	{
		book.setBookId(resultSet.getInt(index++));
		book.setUserId(resultSet.getInt(index++));
		book.setTitle(resultSet.getString(index++));
		book.setIsbn(resultSet.getString(index++));
		book.setPublished(resultSet.getInt(index++));		
	}
	
	public void createTables() 
	{
		executeTransaction(new Transaction<Boolean>() 
		{
			@Override
			public Boolean execute(Connection conn) throws SQLException 
			{
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				
				try 
				{
					stmt1 = conn.prepareStatement(
						"create table users (" +
						"	user_id integer primary key " +
						"		generated always as identity (start with 1, increment by 1), " +									
						"	lastname varchar(40)," +
						"	firstname varchar(40)" +
						")"
					);	
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"create table books (" +
							"	book_id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	user_id integer constraint user_id references users, " +
							"	title varchar(70)," +
							"	isbn varchar(15)," +
							"   published integer " +
							")"
					);
					stmt2.executeUpdate();
					
					return true;
				} 
				finally 
				{
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<User> userList;
				List<Book> bookList;
				
				try {
					userList = InitialData.getUsers();
					bookList = InitialData.getBooks();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser = null;
				PreparedStatement insertBook   = null;

				try {
					// populate users table (do users first, since user_id is foreign key in books table)
					insertUser = conn.prepareStatement("insert into users (lastname, firstname) values (?, ?)");
					for (User user : userList) {
//						insertUser.setInt(1, user.getUserId());	// auto-generated primary key, don't insert this
						insertUser.setString(1, user.getLastName());
						insertUser.setString(2, user.getFirstName());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					// populate books table (do this after users table,
					// since user_id must exist in users table before inserting book)
					insertBook = conn.prepareStatement("insert into books (user_id, title, isbn, published) values (?, ?, ?, ?)");
					for (Book book : bookList) {
//						insertBook.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
						insertBook.setInt(1, book.getUserId());
						insertBook.setString(2, book.getTitle());
						insertBook.setString(3, book.getIsbn());
						insertBook.setInt(4,  book.getPublished());
						insertBook.addBatch();
					}
					insertBook.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertBook);
					DBUtil.closeQuietly(insertUser);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}
	
	public ArrayList<User> findUserByLastName(String lastName)
	{
		return executeTransaction(new Transaction<ArrayList<User>>() 
		{
			@Override
			public ArrayList<User> execute(Connection conn) throws SQLException 
			{
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				//@SuppressWarnings("resource")

				try 
				{
					
					// a canned query to find book information (including user name) from title
					//add order by statement and change ? position and change return values
					stmt = conn.prepareStatement(
							"select users.*, books.* "
							+ "  from users, books "
							+ "  where users.user_id = books.user_id "
							+ "        and users.lastname = ?"
							+ "  order by books.title"
					);
					

					// substitute the title entered by the user for the placeholder in the query
					//change title variable to last name
					stmt.setString(1, lastName);

					ArrayList<User> result = new ArrayList<User>();
					
					// execute the query
					resultSet = stmt.executeQuery();

					Boolean found = false;
					
					while (resultSet.next()) 
					{
						found = true;
						
						// create new User object
						// retrieve attributes from resultSet starting with index 1
						User user = new User();
						loadUser(user, resultSet, 1);
						
						// create new Book object
						// retrieve attributes from resultSet starting at index 4
						Book book = new Book();
						loadBook(book, resultSet, 4);
						
						result.add(user);
					}
					
					// check if the title was found
					if (!found) 
					{
						System.out.println("<" + lastName + "> was not found in the users table");
					}
					
					return result;
				} 
				finally 
				{
					// close result set and statement
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}

			}
		});
	}
	
	public ArrayList<User> getAllUsers()
	{
		throw new UnsupportedOperationException();
	}
	
	public List<Pair<User, Book>> insertBook(String firstName, String lastName, String title, String isbn, String published)
	{
		return executeTransaction(new Transaction<List<Pair<User,Book>>>() 
		{
			@SuppressWarnings("resource")
			@Override
			public List<Pair<User, Book>> execute(Connection conn) throws SQLException 
			{
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				ResultSet resultSet = null;
				
				try 
				{
					stmt = conn.prepareStatement(
							"select users.user_id "
							+ "  from users "
							+ "  where users.firstname = ? and users.lastname = ?"		
					);
					
					//set variables equal to question marks and execute the query
					stmt.setString(1, firstName);
					stmt.setString(2, lastName);
					resultSet = stmt.executeQuery();
					
					//if the user was already in the the table, run this block
					if (resultSet.next())
					{
						//set object to user id and create statement to add user's new book
						Object obj = resultSet.getString(1);
						stmt2 = conn.prepareStatement(
								"insert into books (user_id, title, isbn, published) "
								+ "  values (?, ?, ?, ?)"
						);			
						

						// substitute the question marks for variables
						stmt2.setString(1, obj.toString());
						stmt2.setString(2, title);
						stmt2.setString(3, isbn);
						stmt2.setString(4, published);

						// execute the update
						stmt2.executeUpdate();
					}
					//if the user was not in the books table, run this block
					else
					{
						//create statement to insert new user into user's table
						stmt3 = conn.prepareStatement(
								"insert into users (lastname, firstname)"
								+ "  values (?, ?)"
										
						);
						
						//set ?'s equal to variables and execute update
						stmt3.setString(1, lastName);
						stmt3.setString(2, firstName);
						stmt3.executeUpdate();
						
						
						//create new statement to get new user's id
						stmt = conn.prepareStatement(
								"select users.user_id "
								+ "  from users "
								+ "  where users.firstname = ? and users.lastname = ?"		
						);
						
						//set variables equal to question marks and set resultSet equal to user's id
						stmt.setString(1, firstName);
						stmt.setString(2, lastName);
						resultSet = stmt.executeQuery();
						System.out.println("User added");
						
						//move cursor and create statement to add user's new book into books
						resultSet.next();
						Object obj = resultSet.getString(1);
						stmt2 = conn.prepareStatement(
								"insert into books (user_id, title, isbn, published) "
								+ "  values (?, ?, ?, ?)"
						);			
						

						// substitute the title entered by the user for the placeholder in the query
						stmt2.setString(1, obj.toString());
						stmt2.setString(2, title);
						stmt2.setString(3, isbn);
						stmt2.setString(4, published);

						// execute the update
						stmt2.executeUpdate();
					}
					List<Pair<User, Book>> result = new ArrayList<Pair<User,Book>>();
					
					
					while (resultSet.next()) 
					{	
						// create new User object
						// retrieve attributes from resultSet starting with index 1
						User user = new User();
						loadUser(user, resultSet, 1);
						
						// create new Book object
						// retrieve attributes from resultSet starting at index 4
						Book book = new Book();
						loadBook(book, resultSet, 4);
						
						result.add(new Pair<User, Book>(user, book));
					}
				
					return result;
				} 
				finally 
				{
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}
}
