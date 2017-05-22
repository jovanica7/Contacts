<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body>
<div class="container">
<div class="bg-success row  row-centered">
<div class="col-xs-6 col-md-6">
<div><h4><b>First name: </b><span th:inline="text">${contact.firstName}</span></h4></div>
<div><h4><b>Last name: </b><span th:inline="text">${contact.lastName}</span></h4></div>
<div><h4><b>Date of birth: </b><span th:inline="text">${contact.dateOfBirth}</span></h4></div>
<div><h4><b>Address: </b><span th:inline="text">${contact.address}</span></h4></div>
<div><h4><b>Phone: </b><span th:inline="text">${contact.phone}</span></h4></div>
<div><h4><b>Email: </b><span th:inline="text">${contact.email}</span></h4></div>
<div><h4><b>Sex: </b><span th:inline="text">${contact.sex}</span></h4></div>
</div>
<div class="col-xs-6 col-md-6">
<div><h4><b>Relations: </b><span th:inline="text"></span></h4>
<div class="table-responsive">
   <table id="relations" class="table table-hover">
    <thead>
      <tr>
      <th class="hidden-md hidden-lg">Id</th>
        <th><h4>First Name</h4></th>
        <th><h4>Last Name</h4></th>
        <th><h4>Type of relation</h4></th>
      </tr>
    </thead>
             <tr  th:each="relInf: ${relationsInfo}">
                <td class="hidden-md  hidden-lg"></td>
                    <td th:inline="text">${relInf.first_name}</td>
                    <td th:inline="text">${relInf.last_name}</td>
                    <td th:inline="text">${relInf.type}</td>
                   </tr>
                 </table>
             </div>
         </div>
 <div class="btn-toolbar">
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Add relations</button>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add New Relation</h4>
        </div>
        <div class="modal-body">
          <form action="#" th:object="${relInf}" th:action="@{/myAddressBook/details}" method="post" enctype="multipart/form-data">
          <div class="form-group">
           <label>First name:</label><input type="text" class="form-control" name= "first_name" th:value="${relInf.first_name}" /></div>
            <div class="form-group">
           <label>Last name:</label><input type="text" class="form-control" name= "last_name" th:value="${relInf.last_name}" /></div>
             <div class="form-group">
           <label>Type of relation:</label><input type="text" class="form-control" name= "type" th:value="${relInf.type}" /></div>
             <div class= "btn-toolbar"><button type="submit" class="btn btn-success">Add</button></div>
            </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      </div>
     </div>
     <button type="button" class="btn btn-info btn-lg">Export this contact</button>
</div>

</div>
</div>
</div>
</body>
</html>