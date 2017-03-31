package edu.ycp.cs320.jporter7.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.jporter7.controller.NumbersController;
import edu.ycp.cs320.jporter7.controller.UserController;
import edu.ycp.cs320.jporter7.model.Numbers;
import edu.ycp.cs320.jporter7.model.User;

public class AccountCreationAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get parameters
		
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastname");;
		String email = req.getParameter("email");
		int id = getInt(req, "id");
		
		// Check whether parameters are valid
		if (firstName == null || lastName == null || password == null || username == null || email == null) 
		{
			badRequest("Bad parameters", resp);
			return;
		}
		
		// Use a controller to process the request
		User user = new User();
		UserController controller = new UserController(user);
		controller.createUser(password, username, email, firstName, lastName, id);
		
		// Send back a response
		resp.setContentType("text/plain");
		resp.getWriter().println("Account Created!");
	}

	private Integer getInt(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		if (val == null) {
			return null;
		}
		try {
			return Integer.parseInt(val);
		} catch (NumberFormatException e) {
			return null;
		}
	}


	private void badRequest(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().println(message);
	}
}

