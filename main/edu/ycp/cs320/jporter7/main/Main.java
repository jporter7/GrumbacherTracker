package edu.ycp.cs320.jporter7.main;

import java.util.Scanner;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

import edu.ycp.cs320.jporter7.populationdb.InitDatabase;
import edu.ycp.cs320.jporter7.populationdb.persist.DatabaseProvider;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;
import edu.ycp.cs320.jporter7.servlet.AccountCreationServlet;
import edu.ycp.cs320.jporter7.servlet.IndexServlet;
import edu.ycp.cs320.jporter7.servlet.LoginServlet;
import edu.ycp.cs320.jporter7.servlet.ReservationsServlet;

public class Main {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8081);

		// Create and register a webapp context
		WebAppContext handler = new WebAppContext();
		handler.setContextPath("/jporter7");
		handler.setWar("./war"); // web app is in the war directory of the project
		server.setHandler(handler);
		
		// Use 20 threads to handle requests
		server.setThreadPool(new QueuedThreadPool(20));
		
		// Start the server
		server.start();
		
		// Wait for the user to type "quit"
		System.out.println("Web server started, type quit to shut down");
		////////////////////////Initialize database and pass to login servlet//////////////////////////////////
		Scanner keyboard2 = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard2);
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		
		handler.setAttribute("database", db);
        handler.addServlet(LoginServlet.class, "/login/*");
        handler.addServlet(AccountCreationServlet.class, "/accountCreation/*");
        handler.addServlet(IndexServlet.class, "/index/*");
        handler.addServlet(ReservationsServlet.class, "/reservations/*");
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		Scanner keyboard = new Scanner(System.in);
		while (keyboard.hasNextLine()) {
			String line = keyboard.nextLine();
			if (line.trim().toLowerCase().equals("quit")) {
				break;
			}
		}
		
		System.out.println("Shutting down...");
		keyboard.close();
		server.stop();
		server.join();
		System.out.println("Server has shut down, exiting");
	}
}
