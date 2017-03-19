<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Address Book</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body>
<div class="container-fluid">
  <h1 class="col-md-4 col-md-offset-4 vcenter text-info">My contacts</h1>
  </div>
 <div> <p><button class="btn btn-warning" onclick="location.href='/myAddressBook/addNew'">+ New contact</button></p></div>
 <div class="row">
		<div class="col-md-12">
            <div class="input-group" id="adv-search">
                <input type="text" class="form-control" placeholder="Search for contact" />
                <div class="input-group-btn">
                    <div class="btn-group" role="group">
                        <div class="dropdown dropdown-lg">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                            <div class="dropdown-menu dropdown-menu-right" role="menu">
                                <form class="form-horizontal" role="form">
                                  <div class="form-group">
                                    <label for="contain">First name</label>
                                    <input class="form-control" type="text" />
                                  </div>
                                  <div class="form-group">
                                    <label for="contain">Last name</label>
                                    <input class="form-control" type="text" />
                                  </div>
                                  <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                </form>
                            </div>
                        </div>
                        <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                    </div>
                </div>
            </div>
          </div>
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
    <c:forEach var="contact" items="${allContacts}">
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
     				   <li><a href='/myAddressBook/update'>Update contact</a></li>
     				   <li><a href="#">Delete contact</a></li>
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
