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


function getId(xhr){
	
	let response = JSON.parse(xhr.response);
	
	id = response.id;	
		
	sendAjaxGet("http://localhost:8080/ERS/receipts?id="+id, display);
		
}


sendAjaxGet("http://localhost:8080/ERS/session", getId);



function display(xhr){
	receipts = JSON.parse(xhr.responseText);
	
	let table = document.getElementById("resolved");
	
	for(i in receipts){
		
		if(receipts[i].status == "RESOLVED"){
		
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
			<td> ${outcome} </td>`;
			
			table.appendChild(newRow);
		}
		
	}
	
	
}


