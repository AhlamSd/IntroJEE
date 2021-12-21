<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DAO.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>

<h1> The book is added successfully </h1>

 <c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach>

<table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ISNB</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Pages</th>
                <th>Year</th>
                <th>Actions</th>
            </tr>
            
  <c:forEach var="Livre" items="${listLivre}">
                <tr>
                
                    <td> <c:out value="${Livre.isbn}" /> </td>
                    <td><c:out value="${Livre.titre}" /></td>
                    <td><c:out value="${Livre.auteur}" /></td>
                    <td><c:out value="${Livre.prix}" /></td>
                    <td><c:out value="${Livre.nbrpages}" /></td>
                    <td><c:out value="${Livre.annee_edition}" /></td>
                      
                    <!-- <td><c:out value="${Livre.action}" /></td> -->
                    
                    <td>
                        <a href="/edit?isbn=<c:out value='${Livre.isbn}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?isbn=<c:out value='${Livre.isbn}' />">Delete</a>                     
                    </td>
                    
                </tr>
                </c:forEach>
                </table>

<!--  <a href=""></a> -->

</body>
</html>