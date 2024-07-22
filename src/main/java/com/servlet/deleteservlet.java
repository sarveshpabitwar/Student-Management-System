package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBconnect;
import com.dao.studentdao;

@WebServlet("/delete")
public class deleteservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int id=Integer.parseInt(req.getParameter("id"));
		 studentdao dao = new studentdao(DBconnect.getconn());
		 boolean f=dao.deletestudentbyid(id);
		 HttpSession session = req.getSession();
	        

	        if (f) {
	        	session.setAttribute("mcgsucc","Student detail submitted successfully" );
	        	resp.sendRedirect("index.jsp");
	            //resp.getWriter().println("Student detail submitted successfully");
	        } else {
	        	session.setAttribute("error","Error while submitting student details...." );
	        	resp.sendRedirect("index.jsp");
	            //resp.getWriter().println("Error while submitting student details....");
	        }
		 
		 
	}
	

}
