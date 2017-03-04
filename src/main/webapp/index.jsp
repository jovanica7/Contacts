<html lang="en">
<head>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
    $(document).ready(function(){
		$(".del").click(function() {
			var retVal = confirm("Are you sure you want to delete this contact?");
		    if( retVal == true ){
		    	    var i = this.parentNode.parentNode.parentNode.parentNode.rowIndex;
		    	    document.getElementById("allcontacts").deleteRow(i);
		    	//document.getElementById("allcontacts").deleteRow(this.rowIndex);
		    	//$(this).closest('.tr').remove();
		    }
		});  
	});
    </script>
  </head>
<body>
<div class="container-fluid">
  <h1 class="text-success">My contacts</h1>
  <p class="text-right"><img src ="https://placeimg.com/640/480/people" class=".img-responsive" width="150px" height="100px" alt="People"></img></p>
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
     		   <li class = "del"><a href="#">Delete contact</a></li>
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
     		   <li  class = "del"><a href="#">Delete contact</a></li>
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
     		   <li  class = "del"><a href="#">Delete contact</a></li>
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
     		   <li  class = "del"><a href="#">Delete contact</a></li>
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
     		   <li class = "del" ><a href="#">Delete contact</a></li>
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
