<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="bg-light">

<%@ include file="all_css.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="fs-3 text-center">Add Student</p>
                    
                    <c:if test="${not empty mcgsucc }">
                    <p class="text-center text-success">${mcgsucc }</p>
                    <c:remove var="mcgsucc"/>
                    </c:if>
                    
                     <c:if test="${not empty error }">
                    <p class="text-center text-success">${error }</p>
                    <c:remove var="error"/>
                    </c:if>
                    
                    <form action="register" method="post">
                        <div class="mb-3">
                            <label class="form-label">Full Name</label>
                            <input name="name" type="text" class="form-control" aria-describedby="emailHelp">
                        </div>     
                        <div class="mb-3">
                            <label class="form-label">Date of Birth</label>
                            <input name="dob" type="date" class="form-control" aria-describedby="emailHelp">
                        </div> 
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <input name="address" type="text" class="form-control" aria-describedby="emailHelp">
                        </div>  
                        <div class="mb-3">
                            <label class="form-label">Qualification</label>
                            <input name="qualification" type="text" class="form-control" aria-describedby="emailHelp">
                        </div>      
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input name="email" type="email" class="form-control" aria-describedby="emailHelp">
                        </div>
                        <button type="submit" class="btn btn-primary col-md-12">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
