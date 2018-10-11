/**
 * 
 */

//console.log("Hello world from directory.js");

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

sendAjaxGet("http://localhost:8080/ERS/session", displayMenu);

//function display(xhr){
//	employees = JSON.parse(xhr.responseText);
//	//console.log(employees)
//	employeeArr = employees.employees;
//	
//	let table = document.getElementById("table");
//	
//	for(i in employeeArr){
//		let newRow = document.createElement("tr");
//		
//		if(employeeArr[i].location){
//			loc = `${employeeArr[i].location.city}, ${employeeArr[i].location.state}`;
//		} else {
//			loc = "n/a";
//		}
//		
//		if(employeeArr[i].department){
//			dpt = employeeArr[i].department.name;
//		} else {
//			dpt = "n/a";
//		}
//		
//		
//		newRow.innerHTML = `<td>${employeeArr[i].name} </td>
//		<td> ${loc} </td>
//		<td> ${dpt} </td> `;
//		
//		table.appendChild(newRow);
//		
//	}	
//}

function displayMenu(xhr){
	response = JSON.parse(xhr.responseText);
	//console.log(employees)

	
	let menu = document.getElementById("menu");
	
	//let list = document.createElement("ul");
		
		menu.innerHTML = `
              <li class="nav-item">
                <a class="nav-link active" href="dashboard">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                  Dashboard <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="pending">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  Pending Reimbursements
                </a>
              </li>
               <li class="nav-item">
                <a class="nav-link" href="resolved">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  Resolved Reimbursements
                </a>
              </li>
                <li class="nav-item">
                <a class="nav-link" href="SubmitReceipt">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  Submit Request
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="viewprofile">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  My Profile
                </a>
              </li>
                <li class="nav-item">
                <a class="nav-link" href="updateprofile">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  Update Profile
                </a>
              </li>
            `
			console.log(response.role);
			
			if(response.role == 1){
				
				menu.innerHTML = menu.innerHTML + `<br><br><h6>Manager Menu:</h6>
				<br>
				<li class="nav-item">
                <a class="nav-link" href="ManagerPending">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  View All Pending
                </a>
              </li>
				<li class="nav-item">
                <a class="nav-link" href="ManagerResolved">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  View All Resolved
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="AllEmployees">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  View All Employees
                </a>
              </li>
                <li class="nav-item">
                <a class="nav-link" href="ViewEmployee">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                  Search for Employee
                </a>
              </li>`
				
			}
			
			;
		
	//table.appendChild(newRow);
		
	
}