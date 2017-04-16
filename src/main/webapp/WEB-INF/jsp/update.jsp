<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
 	<meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Update Contact</title>
</head>
<body>
<div class = "bg-success col-md-4 col-md-offset-4 vcenter">
<div class="text-info" ><h2>Update Contact</h2></div> 
  <form action="#" th:object="${contact}" th:action="@{/myAddressBook/update/${contact.id}}" method="post" modelAttribute="contact" enctype="multipart/form-data">
  <div class="form-group hidden-md  hidden-lg"><label>Id:</label><input type="text" name="id" th:field="*{id}" class="form-control"></div>
  <div class="form-group"><label>First name:</label><input type="text" name="fname" th:name="*{firstName}" th:value="${contact.firstName}" class="form-control"></div>
  <div class="form-group"><label>Last name:</label><input type="text" name= "lname" th:field="*{lastName}" class="form-control" > </div>
  <div class="form-group"><label>Date of birth:</label><input type="text" name= "date" th:field="*{dateOfBirth}" class="form-control" > </div>
  <div class="form-group"><label>Address:</label><input type="text" name= "address" th:field="*{address}" class="form-control" > </div>
  <div class="form-group"><label>Phone:</label><input type="text" name="number" th:field="*{phone}" class="form-control" >  </div>
  <div class="form-group"><label>Email:</label><input type="text" name="mail" th:field="*{email}" class="form-control" >  </div>
   <div class="form-group"><label>Sex:</label><input type="text" name="pol" th:field="*{sex}" class="form-control" >  </div>
  <div class= "btn-toolbar"><button type="submit" value="Save" class="btn btn-success">Save</button> <button type="button" value="Cancel" onclick="location.href='/myAddressBook'" class="btn btn-danger" >Cancel</button> </div>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form>
  </div>
  <script src="functions.js"></script> 
  </body>
</html>