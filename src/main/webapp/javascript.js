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

}














