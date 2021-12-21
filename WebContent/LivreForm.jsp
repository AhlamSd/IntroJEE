<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
         <c:if test="${livre != null}">
              <form action="update" method="post">
      
        </c:if>
        
        <c:if test="${livre == null}">
            <form action="insert" method="post">
        </c:if>
        
        <table border="1" cellpadding="4">
            <caption>
                <h2>
                    <c:if test="${livre != null}">
                        Edit Livre
                    </c:if>
                    <c:if test="${livre == null}">
                        <!-- Add New Livre -->
                    </c:if>
                </h2>
            </caption>
                <c:if test="${livre != null}">
                    <input type="hidden" name="isbn" value="<c:out value='${livre.isbn}' />" />
                </c:if>    
                     
            <tr>
                <th>ISBN : </th>
                <td>
                    <input type="text" name="isbn" size="45"
                            value="<c:out value='${livre.isbn}' />"
                        />
                </td>
            </tr>  
            <tr>
                <th>Titre: </th>
                <td>
                    <input type="text" name="titre" size="45"
                            value="<c:out value='${livre.titre}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Auteur: </th>
                <td>
                    <input type="text" name="auteur" size="45"
                            value="<c:out value='${livre.auteur}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Prix: </th>
                <td>
                    <input type="text" name="prix" size="5"
                            value="<c:out value='${livre.prix}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Nombre de pages: </th>
                <td>
                    <input type="text" name="nbrpages" size="5"
                            value="<c:out value='${livre.nbrpages}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Année d'édition : </th>
                <td>
                    <input type="text" name="annee_edition" size="5"
                            value="<c:out value='${livre.annee_edition}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                   <input type="submit" value="Enregistrer" />
                </td>
            </tr>
        </table>
   </form>
   </div>
</body>
</html>