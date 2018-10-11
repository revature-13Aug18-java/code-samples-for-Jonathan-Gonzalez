/**
 * 
 */

//console.log("Hello world from directory.js");


//let checkSessionUrl = "http://localhost:8080/ERS/session";

sendAjaxGet(checkSessionUrl, getUsername);

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
var username;



//document.getElementById("ViewEmployee").addEventListener("click", getId);

function getUsername(){

	username =  response.username;
}

function getId(){

	id = document.getElementById("id").value;
	console.log(id);
	document.getElementById("receipts").innerHTML = "";
	
	sendAjaxGet("http://localhost:8080/ERS/receipts?id="+id, display);
}

function display(xhr){
	console.log(xhr.responseText);
	receipts = JSON.parse(xhr.responseText);
	
//	let firstname = document.getElementById("firstname").value;
//	let id = document.getElementById("Search");
	
	
	
	let table = document.getElementById("receipts");
	
	for(i in receipts){
		
			let newRow = document.createElement("tr");
			
			if(receipts[i].rid){
				rid = receipts[i].rid;
			} else {
				rid = "n/a";
			}
			
			if(receipts[i].status){
				status = receipts[i].status;
			} else {
				status = "n/a";
			}
			
			if(receipts[i].amount){
				amount = receipts[i].amount;
			} else {
				amount = "n/a";
			}
			
			if(receipts[i].details){
				details = receipts[i].details;
			} else {
				details = "n/a";
			}
			
			if(receipts[i].statusDate){
				statusDate = receipts[i].statusDate;
			} else {
				statusDate = "n/a";
			}
			
			if(receipts[i].purchaseDate){
				purchaseDate = receipts[i].purchaseDate;
			} else {
				purchaseDate = "n/a";
			}	
			
			if(receipts[i].resolvedBy){
				resolvedBy = receipts[i].resolvedBy;
			} else {
				resolvedBy = "n/a";
			}	
			
			if(receipts[i].outcome){
				outcome = receipts[i].outcome;
			} else {
				outcome = "n/a";
			}	
			
			
			newRow.innerHTML = `<td>${rid} </td>
			<td> ${amount} </td> 
			<td> ${details} </td>
			<td> ${statusDate} </td>
			<td> ${purchaseDate} </td>
			<td> ${resolvedBy} </td>
			<td> ${status} </td>
			<td> ${outcome} </td>`;
			
			if(status == "PENDING"){
				newRow.innerHTML = newRow.innerHTML +`
					<td>    
					<form action="resolve" method="POST" class="container">
		                    <select class="form-control" id="outcome" name="outcome">
		                        <option>Approve</option>
		                        <option>Deny</option>
		                    </select>
		                    <input id="prodId" name="resolvedby" type="hidden" value="${username}">
		                    <input id="prodId" name="rid" type="hidden" value=${rid}>
						<button id="form-sub" class="btn btn-outline-primary">Submit</button>
		                </form>
		                </td>`;
			}
			else{
				newRow.innerHTML = newRow.innerHTML +`<td></td>`
			}
			
			table.appendChild(newRow);
		
		
	}
	
	
}


