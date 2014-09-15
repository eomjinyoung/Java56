window.onload = function() {
  $('#btnLogin').click(function(event) {
	  event.preventDefault();
	  var saveIdStatus = 'no';
	  if ($('#saveId:checked').length > 0) {
		  saveIdStatus = 'yes';
	  }
	  $.ajax('login.json', {
			type: "POST",
			dataType: "json",
			data: {
				email: $("#email").val(),
				password: $("#password").val(),
				saveId: saveIdStatus
			},
			success: function(result) {
				if (result.status == 'success') {
					location.href = '../score/app.html';
				} else {
					alert('사용자 아이디 또는 암호가 맞지 않습니다.');
					$('#email').val('');
					$('#password').val('');
				}
			}
		  });
  });
};








