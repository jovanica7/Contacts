<html lang="en">
<head>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body>
<div class="container-fluid">
  <h1 class="text-success" >My contacts</h1>
  <p><button class="btn btn-warning" onclick="addContact()">+ New contact</button></p>
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
      <tr>
        <td>Aleksandar</td>
        <td>Dakic</td>
        <td>+381643298175</td>
        <td>acadakic@gmail.com</td>
        <td><div class="dropdown">
   		 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions
   			 <span class="caret"></span></button>
   			 <ul class="dropdown-menu">
     		   <li><a href="#">Update contact</a></li>
     		   <li><a href="#">Delete contact</a></li>
   			 </ul>
 		 </div></td></tr>
      <tr>
        <td>Bojan</td>
        <td>Samac</td>
        <td>+381633297845</td>
        <td>bojansamac@gmail.com</td>
        <td><div class="dropdown">
   		 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions
   			 <span class="caret"></span></button>
   			 <ul class="dropdown-menu">
     		   <li><a href="#">Update contact</a></li>
     		   <li><a href="#">Delete contact</a></li>
   			 </ul>
 		 </div></td></tr>
      <tr>
        <td>Milica</td>
        <td>Vukovic</td>
        <td>+381655298144</td>
        <td>mica7@gmail.com</td>
        <td>
        <div class="dropdown">
   		 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions
   			 <span class="caret"></span></button>
   			 <ul class="dropdown-menu">
     		   <li><a href="#">Update contact</a></li>
     		   <li><a href="#">Delete contact</a></li>
   			 </ul>
 		 </div>
 		</td>
      </tr>
      <tr>
        <td>Olgica</td>
        <td>Vajagic</td>
        <td>+381617784545</td>
        <td>oljavajagic@gmail.com</td>
        <td>
        <div class="dropdown">
   		 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions
   			 <span class="caret"></span></button>
   			 <ul class="dropdown-menu">
     		   <li><a href="#">Update contact</a></li>
     		   <li><a href="#">Delete contact</a></li>
   			 </ul>
 		 </div>
 		</td>
      </tr>
       <tr>
        <td>Sladjana</td>
        <td>Vukojevic</td>
        <td>+381647297747</td>
        <td>sladjavukojevic@hotmail.com</td>
        <td>
        <div class="dropdown">
   		 <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions
   			 <span class="caret"></span></button>
   			 <ul class="dropdown-menu">
     		   <li><a href="#">Update contact</a></li>
     		   <li><a href="#">Delete contact</a></li>
   			 </ul>
 		 </div>
 		</td>
      </tr>
    </tbody>
  </table>
  </div>
</div>
<script>
function addContact() {
    document.getElementById("newcontact").innerHTML = '<form><div class="form-group"><label>First name:</label><input type="text" class="form-control" id="fname"></div><div class="form-group"><label>Last name:</label><input type="text" class="form-control" id="lname"></div><div class="form-group"><label>Phone:</label><input type="text" class="form-control" id="phone"></div><div class="form-group"><label>Email:</label><input type="text" class="form-control" id="email"></div><div><button id= "save" class="btn btn-success" onclick="saveContact()">Save contact</button></div></form>';
}

</script>

<script>
function saveContact(){
	
	var first_name = document.getElementById("fname").value;
	var last_name = document.getElementById("lname").value;
	var phone = document.getElementById("phone").value;
	var email = document.getElementById("email").value;
	
	$('#allcontacts tr:last').after('<tr><td>first_name</td><td>last_name</td><td>phone</td><td>email</td><td><div class="dropdown"><button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions<span class="caret"></span></button><ul class="dropdown-menu"><li><a href="#">Update contact</a></li><li><a href="#">Delete contact</a></li></ul></div></td></tr>');
	

	//document.getElementById("allcontacts").innerHTML += '<tr><td>"+ first_name +"</td><td>last_name</td><td>phone</td><td>email</td><td><div class="dropdown"><button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions<span class="caret"></span></button><ul class="dropdown-menu"><li><a href="#">Update contact</a></li><li><a href="#">Delete contact</a></li></ul></div></td></tr>';

	
	//document.getElementById("allcontacts").appendChild('<tr><td>"+ first_name +"</td><td>last_name</td><td>phone</td><td>email</td><td><div class="dropdown"><button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions<span class="caret"></span></button><ul class="dropdown-menu"><li><a href="#">Update contact</a></li><li><a href="#">Delete contact</a></li></ul></div></td></tr>');

}
</script>
</body>
</html>
