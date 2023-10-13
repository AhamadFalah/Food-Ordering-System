function validateData(){
	let password=document.getElementById("pwd1").value;
	let confirm_password=document.getElementById("pwd2").value;
	if(password!=confirm_password){
		alert("Passwords does not match.Enter again");
        return false;
	}
}