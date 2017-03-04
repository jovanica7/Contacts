function addContact() {
    document.getElementById("newcontact").innerHTML = '<form><div class="form-group"><label>First name:</label><input type="text" class="form-control" id="fname"></div><div class="form-group"><label>Last name:</label><input type="text" class="form-control" id="lname"></div><div class="form-group"><label>Phone:</label><input type="text" class="form-control" id="phone"></div><div class="form-group"><label>Email:</label><input type="text" class="form-control" id="email"></div><div><button id= "save" class="btn btn-success" onclick="saveContact()">Save contact</button></div></form>';
}

function saveContact(){
	
	var first_name = document.getElementById("fname").value;
	var last_name = document.getElementById("lname").value;
	var phone = document.getElementById("phone").value;
	var email = document.getElementById("email").value;
	
	var table = document.getElementById("allcontacts");
    var row = table.insertRow(table.length-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);

    cell1.innerHTML = first_name;
    cell2.innerHTML = last_name;
    cell3.innerHTML = phone;
    cell4.innerHTML = email;
    cell5.innerHTML = '<div class="dropdown"><button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions<span class="caret"></span></button><ul class="dropdown-menu"><li><a href="#">Update contact</a></li><li><a href="#">Delete contact</a></li></ul></div>';

	
	//$('#allcontacts tr:last').after('<tr><td>first_name</td><td>last_name</td><td>phone</td><td>email</td><td><div class="dropdown"><button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions<span class="caret"></span></button><ul class="dropdown-menu"><li><a href="#">Update contact</a></li><li><a href="#">Delete contact</a></li></ul></div></td></tr>');
	

	//document.getElementById("allcontacts").innerHTML += '<tr><td>"+ first_name +"</td><td>last_name</td><td>phone</td><td>email</td><td><div class="dropdown"><button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions<span class="caret"></span></button><ul class="dropdown-menu"><li><a href="#">Update contact</a></li><li><a href="#">Delete contact</a></li></ul></div></td></tr>';

	
	//document.getElementById("allcontacts").appendChild('<tr><td>"+ first_name +"</td><td>last_name</td><td>phone</td><td>email</td><td><div class="dropdown"><button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Actions<span class="caret"></span></button><ul class="dropdown-menu"><li><a href="#">Update contact</a></li><li><a href="#">Delete contact</a></li></ul></div></td></tr>');

}


















