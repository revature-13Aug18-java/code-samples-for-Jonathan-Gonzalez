


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
			<form action="updateprofile" method="POST" class="container">
			<h6>First Name:</h6>
			<textarea name="fname" class="form-control" />${fname}</textarea>
			<h6>Last Name:</h6>
			<textarea name="lname" class="form-control" />${lname}</textarea>
			<h6>Street Address:</h6>
			<textarea name="street" class="form-control" />${street}</textarea>
			<h6>State:</h6>
			<textarea name="state" class="form-control" />${state}</textarea>
			<h6>City:</h6>
			<textarea name="city" class="form-control" type="text"/>${city}</textarea>
			<h6>Zipcode:</h6>
			<textarea name="zipcode" class="form-control" type="number"/>${zipcode}</textarea>
			<h6>Phone:</h6>
			<textarea name="phone" class="form-control" />${phone}</textarea>
			<h6>Hire date:</h6>
			<textarea name="hireDate" class="form-control" />${hireDate}</textarea>
			<h6>Birthdate:</h6>
			<textarea name="birthDate" class="form-control" />${birthDate}</textarea>
			<h6>Email:</h6>
			<textarea name="email" class="form-control" />${email}</textarea>
			<br>
			<input type="submit" value="Update" class="btn btn-primary">
			`;
			
			table.appendChild(newDiv);
		
		
	
	
	
}


