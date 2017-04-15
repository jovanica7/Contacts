function updateContact(){
	var table = document.getElementById("allcontacts");
	var rows = table.getElementsByTagName("tr");
	for(i = 0; i < rows.length; i++){
		var currentRow = table.rows[i];
		var createClickHandler = 
		function(row){
			
			return function(){
				var cell = row.getElementsByTagName("td")[0];
				var id = cell.innerHTML;
				
				//alert("id:" + id);
				
				$.ajax({
					type: 'POST',
					url: '/addressBook/update/',
					data: {id: "id"},
					success: function(){
						alert("id:" +id);
					}
				});
				
				//var xhttp = new XMLHttpRequest();
				//xhttp.open("GET", "addressBook/update?id=" + id, true);
				//xhttp.send();
			
			};
			
		  };
		
		currentRow.onclick = createClickHandler(currentRow);
	}

}