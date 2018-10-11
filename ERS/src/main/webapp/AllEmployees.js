/**
 * 
 */

//console.log("Hello world from directory.js");

//let checkSessionUrl = "http://localhost:8080/ERS/session";


function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState==4 && this.status==200){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}


var id;


sendAjaxGet("http://localhost:8080/ERS/profile", display);



function display(xhr){
	profiles = JSON.parse(xhr.responseText);
	
	profiles = profiles.profiles;
	
	let table = document.getElementById("employees");
	
	for(profile of profiles){
		
			let newRow = document.createElement("tr");
			
			if(profile.id){
				id = profile.id;
			} else {
				id = "n/a";
			}
			
			if(profile.fname){
				fname = profile.fname;
			} else {
				fname = "n/a";
			}
			
			if(profile.lname){
				lname = profile.lname;
			} else {
				lname = "n/a";
			}
			
			if(profile.email){
				email = profile.email;
			} else {
				email = "n/a";
			}
			
			if(profile.phone){
				phone = profile.phone;
			} else {
				phone = "n/a";
			}
			
			
			
			newRow.innerHTML = `<td>${id} </td>
			<td> ${fname} </td> 
			<td> ${lname} </td>
			<td> ${email} </td>
			<td> ${phone} </td>`;
			
			table.appendChild(newRow);
		
		
	}
	
	
}


