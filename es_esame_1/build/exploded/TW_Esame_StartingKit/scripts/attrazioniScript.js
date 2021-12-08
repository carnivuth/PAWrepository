function requestUpdateAttrazioni(uri){
	  var xhr = new XMLHttpRequest(); 
	  xhr.onreadystatechange = function() { callbackAttrazioni(xhr); };
	        
	try {
		xhr.open("get", uri, true);
	}
	catch(e) {
		// Exceptions are raised when trying to access cross-domain URIs 
		alert(e);
	}
	xhr.send(null);
    
}
function callbackAttrazioni(xhr){
	var attrazioni=JSON.parse(xhr.responseText);
	for(a in attrazioni){
		this.document.getElementById("attrazioniTable").innerHTML="<tr>"+"<td>"+a.nome+"</td>"+"<td>"+a.descrizione+"</td>"+"</tr>";	
	}
		
}

  
