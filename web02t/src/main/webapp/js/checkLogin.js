$(function(){
	$.getJSON('../auth/loginUserInfo.json', function(result) {
	  if (result.status == 'success') {
	    var loginUserInfo = result.loginUserInfo;
		$('#userName').text(loginUserInfo.name);
		$('#userEmail').text(loginUserInfo.email);
		$("#logout").click(function(event){
			  event.preventDefault();
			  $.getJSON('../auth/logout.json', function(result) {
				 if(result.status == "success") {
				    location.href = "../auth/login.html";
				 }
			  });
		  });
		if (initPage) {
			initPage();
		}
	  } else {
		  location.href = '../auth/login.html'; 
	  }
	});
});

 