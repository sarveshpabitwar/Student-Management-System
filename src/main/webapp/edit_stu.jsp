<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dao.studentdao" %>
<%@ page import="com.entity.student" %>
<%@ page import="com.conn.DBconnect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bg-light">

<%@ include file="all_css.jsp" %>


<%@include file="navbar.jsp" %>

<div class="container p-4">
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <div class="card">
        <div class="card-body">
          <p class="fs-3 text-center">Edit Student</p>
          
          <%
          int id=Integer.parseInt(request.getParameter("id"));
          studentdao dao = new studentdao(DBconnect.getconn());
          student s=dao.getstudentbyid(id);
          
          
          %>
          
            <form action="update" method="post">
    
     <div class="mb-3">
    <label  class="form-label">Full Name</label>
    <input name="name" type="text" value="<%=s.getFullname() %>" class="form-control"  aria-describedby="emailHelp">
   
  </div>     
  
  <div class="mb-3">
    <label  class="form-label">Date of birth</label>
    <input name="dob" type="Date" value="<%=s.getDob() %>" class="form-control"  aria-describedby="emailHelp">
   
  </div> 
  
  <div class="mb-3">
    <label  class="form-label">Address</label>
    <input name="address" type="text" value="<%= s.getAddress() %>" class="form-control"  aria-describedby="emailHelp">
   
  </div>  
  
  <div class="mb-3">
    <label  class="form-label">Qualification</label>
    <input name="qualification" type="text" value="<%=s.getQualification() %>" class="form-control"  aria-describedby="emailHelp">
   
  </div>      
            
            
            
  <div class="mb-3">
    <label  class="form-label">Email </label>
    <input name="email" type="email" value="<%=s.getEmail() %>" class="form-control"  aria-describedby="emailHelp">
   
  </div>
  
  <input type="hidden" name="id" value="<%= s.getId()%>">
 
 
  <button type="submit" class="btn btn-primary col-md-12">update</button>
</form>
          
          
          
        </div>
      </div>
    </div>
  </div>
</div>


</body>
</html>