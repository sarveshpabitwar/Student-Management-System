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
import com.entity.student;

@WebServlet("/update")
public class updateservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String name = req.getParameter("name");
	        String dob = req.getParameter("dob");
	        String address = req.getParameter("address");
	        String qualification = req.getParameter("qualification");
	        String email = req.getParameter("email");
	        int id=Integer.parseInt(req.getParameter("id"));

	        student s = new student(id,name, dob, address, qualification, email);

	        studentdao dao = new studentdao(DBconnect.getconn());
	        HttpSession session = req.getSession();
	        boolean f=dao.updateStudent(s);
	        
	        if (f) {
	        	session.setAttribute("mcgsucc","Student detail update successfully" );
	        	resp.sendRedirect("index.jsp");
	            //resp.getWriter().println("Student detail submitted successfully");
	        } else {
	        	session.setAttribute("error","Error while submitting student details...." );
	        	resp.sendRedirect("index.jsp");
	            //resp.getWriter().println("Error while submitting student details....");
	        }
		
	}

	
	
	
}
