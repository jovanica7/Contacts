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
 <div> <p><button class="btn btn-warning" onclick="location.href='/myAddressBook/addNew'">+ New contact</button></p>
 <div class="row">
		<div class="col-md-12">
		<div class="pull-right">
            <div class="input-group text-right" id="adv-search"><c:url var="searchUrl" value="/myAddressBook/searchByName"/> 
              <form class="form-horizontal" action="${searchUrl}" method="post">
            	<div class="form-group">
                 <input type="text" class="form-control" name= "firstName" th:value="${contact.firstName}" placeholder="Search for contact by name" />
                 <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                 </div>
                </form>
            </div>
            </div>
          </div>
        </div>
     </div>
  <div class="table-responsive">
   <table id="allcontacts" class="table table-hover">
    <thead>
      <tr>
      	<th class="hidden-md hidden-lg">Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Date Of Birth</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Sex</th>
        <th></th>
      </tr>
    </thead>
    <c:forEach var="contact" items="${allContacts}">
                <tr>
                	<td class="hidden-md  hidden-lg"><c:out value="${contact.id}"/></td>
                    <td><c:out value="${contact.firstName}" /></td>
                    <td><c:out value="${contact.lastName}" /></td>
                    <td><c:out value="${contact.dateOfBirth}"/></td>
                    <td><c:out value="${contact.address}"/></td>
                    <td><c:out value="${contact.phone}" /></td>
                    <td><c:out value="${contact.email}" /></td> 
                    <td><c:out value="${contact.sex}"/></td>
                    <td>
                    <div class="dropdown">
   					 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions
   					 <span class="caret"></span></button>
   					 <ul class="dropdown-menu">
					<li>
           			 <button class="btn btn-warning"  onclick="location.href='/myAddressBook/update/${contact.id}'" >Update contact</button>
       				</li>     				   
       				 <li><c:url var="deleteUrl" value="/myAddressBook/delete"/>  
     				   <form action="${deleteUrl}" method="post">
                    <input name="id" type="hidden" value="${contact.id}"/>
           			 <button type="submit" onClick="return confirm('Are you sure you want to delete this contact?')" class="btn btn-warning">Delete contact</button>
       				 </form></li>
   					 </ul>
 					 </div>
 					</td>           
                </tr>
            </c:forEach>
    <tbody>
</tbody>
</table>
</div>
</body>
</html>
