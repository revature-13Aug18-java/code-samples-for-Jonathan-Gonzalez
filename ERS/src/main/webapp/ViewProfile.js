


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


function getId(xhr){
	
	let response = JSON.parse(xhr.response);
	
	id = response.id;	
		
	sendAjaxGet("http://localhost:8080/ERS/profile?id="+id, display);
		
}


sendAjaxGet("http://localhost:8080/ERS/session", getId);



function display(xhr){
	console.log(xhr.responseText);
	profile = JSON.parse(xhr.responseText);
	
	let table = document.getElementById("profile");
	
		
		
			let newDiv = document.createElement("div");
			
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
			
			if(profile.street){
				street = profile.street;
			} else {
				street = "n/a";
			}
			
			if(profile.city){
				city = profile.city;
			} else {
				city = "n/a";
			}
			
			if(profile.state){
				state = profile.state;
			} else {
				state = "n/a";
			}
			
			if(profile.zipcode){
				zipcode = profile.zipcode;
			} else {
				zipcode = "n/a";
			}
			
			if(profile.phone){
				phone = profile.phone;
			} else {
				phone = "n/a";
			}
			
			if(profile.hireDate){
				hireDate = profile.hireDate;
			} else {
				hireDate = "n/a";
			}
			
			if(profile.birthDate){
				birthDate = profile.birthDate;
			} else {
				birthDate = "n/a";
			}
			
			if(profile.email){
				email = profile.email;
			} else {
				email = "n/a";
			}
			
			
			
			
			
			
			newDiv.innerHTML = `
			<h6>First Name:</h6>
			<p>${fname}</p><br>
			<h6>Last Name:</h6>
			<p>${lname}</p><br>
			<h6>Street Address:</h6>
			<p>${street}</p><br>
			<h6>City:</h6>
			<p>${city}</p><br>
			<h6>State:</h6>
			<p>${state}</p><br>
			<h6>Zipcode:</h6>
			<p>${zipcode}</p><br>
			<h6>Phone:</h6>
			<p>${phone}</p><br>
			<h6>Hire date:</h6>
			<p>${hireDate}</p><br>
			<h6>Birthdate:</h6>
			<p>${birthDate}</p><br>
			<h6>Email:</h6>
			<p>${email}</p><br>
			`;
			
			table.appendChild(newDiv);
		
		
	
	
	
}


