function senduser(){
	let form=document.getElementById("registration-form");
	let username="";
	let password="";
	username = form.elements[0].value;
	password=form.elements[1].value;
			let user={
					username:username,
					password:password,
			}; 
			$.ajax({
		       url:'/register',
		       contentType:"application/JSON",
		       type:"POST",
		       data:JSON.stringify(user),
		       dataType:'JSON',
		       success: function (data) {
		    	   console.log("if success");
		    	   if(data){
		    		   console.log("in if success");
		    		   window.location.href ="/adminmenu";
		    	   }
		    	   else console.log("error");
		       },
		       error: function (data) {
		           console.log("Error2");
		       }
		   });
	  }
	  else console.log("Invalid email or password");
	 sleep(500);
	
}