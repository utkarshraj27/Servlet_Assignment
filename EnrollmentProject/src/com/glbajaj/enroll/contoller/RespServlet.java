package com.glbajaj.enroll.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glbajaj.enroll.dao.DatabaseDaoImpl;
import com.glbajaj.enroll.service.OperationClass;

/**
 * Servlet implementation class RespServlet
 */
public class RespServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		String tname=req.getParameter("tname");
		int seat=Integer.parseInt(req.getParameter("seats"));
		PrintWriter out = resp.getWriter();
		if(seat==0) {
			out.print("<b>No Seats Are Available.</b>");
			out.print("</br></br><a href='index.html'>Enroll Again</a>");
		}
		else{
			String msg=OperationClass.doUpdate(id, tname, seat);
			out.print("<h1>"+msg+"</h1>");
			out.print("</br></br><a href='index.html'>Enroll Again</a>");
		}
	}
	
}
