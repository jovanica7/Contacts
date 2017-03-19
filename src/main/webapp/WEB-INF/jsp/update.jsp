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
  <form action="#" th:action="@{/myAddressBook/addNew}" th:object="${contact}" method="post" enctype="multipart/form-data">
  <div class="form-group"><label>First name:</label><input type="text" name="fname" th:field="*{firstName}" class="form-control" id="contact.firstName"> </div>
  <div class="form-group"><label>Last name:</label><input type="text" name= "lname" th:field="*{lastName}" class="form-control" id="contact.lastName"> </div>
  <div class="form-group"><label>Phone:</label><input type="text" name="number" th:field="*{phone}" class="form-control" id="contact.phone">  </div>
  <div class="form-group"><label>Email:</label><input type="text" name="mail" th:field="*{email}" class="form-control" id="contact.email">  </div>
  <div class= "btn-toolbar"><input type="submit" value="Update" id= "save" class="btn btn-success" /><input type="submit" value="Cancel" id= "cancel" class="btn btn-danger" /></div>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form>
  </div>
  </body>
</html>