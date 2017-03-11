<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body>
<div class="container-fluid">
  <h1 class="text-success">My contacts</h1>
  <p class="text-right"><img src ="https://placeimg.com/640/480/people" class="img-responsive" width="170px" height="100px" alt="People"></img></p>
  <p><button class="btn btn-warning" onclick="location.href='/myAdressBook/addNew'">+ New contact</button></p>
  <div id="newcontact"></div>
  <div class="table-responsive">
   <table id="allcontacts" class="table table-hover">
    <thead>
      <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone</th>
        <th>Email</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr th:each="contact : ${contacts}">
        <td th:text="${contact.firstName}" class = "name_value" ></td>
        <td th:text="${contact.lastName}" class = "lastname_value">/</td>
        <td th:text="${contact.phone}" class = "phone_value"></td>
        <td th:text="${contact.email}" class = "email_value"></td>
        <td><div class="dropdown">
   		 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions
   			 <span class="caret"></span></button>
   			 <ul class="dropdown-menu">
     		   <li onclick = "updateContact()"><a href="#">Update contact</a></li>
     		   <li class = "del"><a href="#">Delete contact</a></li>
   			 </ul>
 		 </div>
 		 </td>
 	 </tr>
    </tbody>
  </table>
  </div>
</div>
<script src="javascript.js"></script>

</body>
</html>
