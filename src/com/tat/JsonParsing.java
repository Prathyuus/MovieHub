package com.tat;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsonParsing
 */
@WebServlet("/JsonParsing")
public class JsonParsing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONArray jarray = new JSONArray();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// creating json object
				JSONObject json = new JSONObject();

				// setting response type
				response.setContentType("application/json");
				// sending the response
				String moviename = request.getParameter("moviename");
				PrintWriter out = response.getWriter();
				// shows the movie added
				out.print("Thank you for adding <b>" + moviename + "</b> to your favorite locations");
				// retrieving the values from the request
				String rating = request.getParameter("ratings");
				String releasedate = request.getParameter("releasedate");
				String poster = request.getParameter("poster");
				String overview = request.getParameter("overview");

				// json object to store key value pairs
				json.put("moviename", moviename);
				json.put("rating", rating);
				json.put("releasedate", releasedate);
				json.put("poster", poster);
				json.put("overview", overview);

				// adding json object to json array
				jarray.add(json);

				FileWriter jsonFile = null;

				try {
					// opening a file and writing json array in it
					jsonFile = new FileWriter("/TatMovie/favorit.json");
					jsonFile.write(jarray.toString());
					System.out.println(json.toString());
				} catch (Exception e) {
					// in case of exception
					System.out.println("Please enter a valid path where you want to store your json");
				} finally {
					jsonFile.flush();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
