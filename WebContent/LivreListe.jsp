<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
<!DOCTYPE html>
<html>
<head>
    <title>Books Store Application</title>
    
   <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>

<body>
<header>
  <nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
    <div class="navbar-brand">
        <h1>Books Management Application</h1>
     </div>
    </nav> 
    <br>
    <br>
    <center>
       <h3>
            <a href="<%=request.getContextPath()%>/new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/list">List All Books</a>  
           
             
        </h3>
   </center>
   </header>
   <br>
    <div align="center">
        <table border="1" cellpadding="4">
           <!-- <h2> List of Books</h2> -->  
            <tr>
                <th>ISNB</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Pages</th>
                <th>Year</th>
                <th>Actions</th>
            </tr>
            
            <c:forEach var="livre" items="${listLivre}">
                <tr>
                    <td><c:out value="${livre.isbn}" /></td>
                    <td><c:out value="${livre.titre}" /></td>
                    <td><c:out value="${livre.auteur}" /></td>
                    <td><c:out value="${livre.prix}" /></td>
                    <td><c:out value="${livre.nbrpages}" /></td>
                    <td><c:out value="${livre.annee_edition}" /></td>
                      
                    <!-- <td><c:out value="${Livre.action}" /></td>
                   // "  -->
                    
                       <!-- <a href="/edit?isbn=<c:out value='${livre.isbn}' />">Edit</a> --> 
                       <td>
                       <a href="/edit?isbn=<c:out value='${livre.isbn}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?isbn=<c:out value='${livre.isbn}' />">Delete</a>   
					 </td>
                    
                </tr>
           </c:forEach>
        </table>
    </div>   
</body>
</html>