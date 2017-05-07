package edu.ycp.cs320.jporter7.servlet.ajax;

/*
 * All of the ajax servlets were not used and were copied from the class lab
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReservationsAjaxServlet extends HttpServlet {
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
		Double first = getDouble(req, "first");
		Double second = getDouble(req, "second");
		Double third = getDouble(req, "third");
		
		// Check whether parameters are valid
		if (first == null || second == null || third == null) 
		{
			badRequest("Bad parameters", resp);
			return;
		}
		
		// Use a controller to process the request
		//Numbers model = new Numbers();
		//model.setFirst(first);
		//model.setSecond(second);
		//model.setThird(third);
		//NumbersController controller = new NumbersController(model);
		//controller.add();
		
		// Send back a response
		resp.setContentType("text/plain");
		//resp.getWriter().println(model.getAddResult().toString());
	}

	private Double getDouble(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		if (val == null) {
			return null;
		}
		try {
			return Double.parseDouble(val);
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

