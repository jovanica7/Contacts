<html lang="en">
<head>
 	<meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add New Contact</title>
</head>
<body>
  <form>
  <div class="form-group"><label>First name:</label><input type="text" class="form-control" id="fname"></div>
  <div class="form-group"><label>Last name:</label><input type="text" class="form-control" id="lname"></div>
  <div class="form-group"><label>Phone:</label><input type="text" class="form-control" id="phone"></div>
  <div class="form-group"><label>Email:</label><input type="text" class="form-control" id="email"></div>
  <div><button id= "save" class="btn btn-success" onclick="href='/myAdressBook/saveContact'">Save contact</button></div>
  </form>';

</body>
</html>