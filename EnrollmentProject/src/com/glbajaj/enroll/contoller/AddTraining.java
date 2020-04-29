package com.glbajaj.enroll.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glbajaj.enroll.service.OperationClass;

/**
 * Servlet implementation class AddTraining
 */
public class AddTraining extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.print("<h2>Add Training</h2>");
		out.print("<form method='post' action='AddTraining'>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<td>Training Id</td><td><input type='number' name='tid' required></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Training Name</td><td><input type='text' name='tname' required></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Available Seats</td><td><input type='number' name='seats' required></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><input type='submit' value='submit'></td>");
		out.print("</tr>");
		out.print("<table>");
		out.print("</form>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int id=Integer.parseInt(req.getParameter("tid"));
		String tname=req.getParameter("tname");
		int seats=Integer.parseInt(req.getParameter("seats"));
		String msg=OperationClass.doAdd(id, tname, seats);
		out.print("<h2>"+msg+"</h2>");
		out.print("</br></br><a href='index.html'>Check Training added</a>");
	}
	

}
