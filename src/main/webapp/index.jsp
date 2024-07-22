<%@ page import="java.sql.Connection" %>
<%@ page import="com.conn.DBconnect" %>
<%@ page import="com.dao.studentdao" %>
<%@ page import="com.entity.student" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body class="bg-light">
<h1>Index page</h1>

<%@ include file="all_css.jsp" %>


<%@include file="navbar.jsp" %>

<% 
  Connection conn = DBconnect.getconn(); 
  out.println(conn);

%>

 <div class="container p-3">
 <div class="card">
<div class="card-body">
 <p class="text-center fs-1">All Student Detail</p>
 
 
  <c:if test="${not empty mcgsucc }">
                    <p class="text-center text-success">${mcgsucc }</p>
                    <c:remove var="mcgsucc"/>
                    </c:if>
                    
                     <c:if test="${not empty error }">
                    <p class="text-center text-success">${error }</p>
                    <c:remove var="error"/>
                    </c:if>
 
 
 
 
 <table class="table">
  <thead>
    <tr>
      <th scope="col">Full Name</th>
      <th scope="col">DOB</th>
      <th scope="col">Address</th>
      <th scope="col">Qualification</th>
      <th scope="col">Email</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
   studentdao dao = new studentdao(DBconnect.getconn());
  List<student> list = dao.getallstudent();
  for(student s:list){
	%>
	
	<tr>
      <th scope="row"><%=s.getFullname() %></th>
      <td><%= s.getDob() %></td>
      <td><%= s.getAddress() %></td>
      <td><%=s.getQualification() %></td>
      <td><%=s.getEmail() %></td>
      <td>
      <a href="edit_stu.jsp?id=<%=s.getId() %>" class="btn btn-sm btn-primary">edit</a>
      <a href="delete?id=<%=s.getId() %>" class="btn btn-sm btn-danger ms-1">delete</a>
      </td>
      
    </tr>
	
	
	
	<%   
	  
	  
  }
  
  %>
  
    
   
    
  </tbody>
</table>

</div> 
 </div>
 
 
 
 
 
 </div>





</body>
</html> 