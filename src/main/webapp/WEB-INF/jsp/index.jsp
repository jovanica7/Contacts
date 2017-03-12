<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Adress Book</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body>
 <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/adressbook"
        user="root" password="skockica777"
    />
    <sql:query var="allContacts" dataSource="${myDS}">
        SELECT * FROM contact;
    </sql:query>
<div class="container-fluid">
  <h1 class="text-success">My contacts</h1>
  <p class="text-right"><img src ="http://lorempixel.com/400/200/people/" class="img-responsive" width="170px" height="100px" alt="People"></img></p>
  <p><button class="btn btn-warning" onclick="location.href='/myAdressBook/addNew'">+ New contact</button></p>
  <div id="newcontact"></div>
</div>
<div class="table-responsive">
   <table id="allcontacts" class="table table-hover">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th></th>
      </tr>
    </thead>
    <c:forEach var="contact" items="${allContacts.rows}">
                <tr>
                    <td><c:out value="${contact.firstName}" /></td>
                    <td><c:out value="${contact.lastName}" /></td>
                    <td><c:out value="${contact.phone}" /></td>
                    <td><c:out value="${contact.email}" /></td>
                    <td>
       				 <div class="dropdown">
   					 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions
   					 <span class="caret"></span></button>
   					 <ul class="dropdown-menu">
     				   <li id="${contact.id}" onclick="/myAdressBook/updateContact"><a href='http://localhost:8080/myAdressBook/updateContact'>Update contact</a></li>
     				   <li class = "del"><a href="#">Delete contact</a></li>
   					 </ul>
 					 </div>
 					</td>           
                </tr>
            </c:forEach>
    <tbody>
</tbody>
</table>
</div>
<script src="javascript.js"></script>

</body>
</html>
