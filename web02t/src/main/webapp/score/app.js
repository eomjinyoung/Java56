function initPage() {
  loadScoreList();
  
  $("#btnUpdate").click(updateScore);
  $("#btnReset").click(resetForm);
  
  $("#btnDelete").click(function(event) {
	deleteScore(document.getElementById("no").value);  
  });
  
  $("#btnAdd").click(addScore); 
  $("#logout").click(function(event){
	  event.preventDefault();
	  $.getJSON('../auth/logout.json', function(result) {
		 if(result.status == "success") {
		    location.href = "../auth/login.html";
		 }
	  });
  });
};

function resetForm() {
  changeFormState("newState");
}

function changeFormState(state) {
  var elements = $(".x-update-item");
  if (state == "updateState") {
	elements.css("display", ""); // 화면에 출력 
  } else {
	elements.css("display", "none"); // 감추기
  }
	
  elements = $(".x-new-item");
  if (state == "updateState") {
	elements.css("display", "none"); // 감추기
  } else {
	elements.css("display", ""); // 화면에 출력 
  }
}

function addScore(event) {
  event.preventDefault(); 
  
  $.ajax('add.json', {
	type: "POST",
	dataType: "json",
	data: {
		name: $("#name").val(),
		kor: $("#kor").val(),
		eng: $("#eng").val(),
		math: $("#math").val(),
		execDate: $("#execDate").val()
	},
	success: function(result) {
		location.href = "app.html";
	}
  });
}

function updateScore(event) {
  event.preventDefault();
  
  $.ajax('update.json', {
	type: "POST",
	dataType: "json",
	data: {
		no: $("#no").val(),
		name: $("#name").val(),
		kor: $("#kor").val(),
		eng: $("#eng").val(),
		math: $("#math").val(),
		execDate: $("#execDate").val()
	},
	success: function(result) {
		location.href = "app.html";
	}
  });
}

function deleteScore(no) {
  $.ajax("delete.json?no=" + no, {
	type: "GET",
	dataType: "json",
	success: function(result) {
	  if (result.status == "success") {
		  alert("삭제 성공입니다.");
		  location.href = "app.html";
	  } else {
		  alert("삭제 실패하였습니다.");
	  }
	}
  });
}

function loadScoreDetail(event) {
  event.preventDefault(); // 웹 브라우저야, a 태그를 클릭할 때 수행하는 기본 작업을 하지 말아라!

  $.getJSON(this.href, function(result) {
	  var score = result.score;
	  $("#no").val(score.no);
	  $("#name").val(score.name);
	  $("#kor").val(score.kor);
	  $("#eng").val(score.eng);
	  $("#math").val(score.math);
	  $("#execDate").val(new Date(score.execDate).toString("yyyy-MM-dd"));
	  
	  changeFormState("updateState");
	});
}

function loadScoreList() {
  $.ajax('list.json', {
	type: "GET",
	dataType: "json",
	success: function(result) {
	  var scores = result.scores;
	  var table = $("#scoreTable");
	  var tr, td, a;
	  for (var i in scores) {
		scores[i].total = scores[i].kor + scores[i].eng + scores[i].math;
		scores[i].average = scores[i].total / 3;
		
		$("<tr>")
		.append($("<td>").append( 
					$("<a>").attr('href', 'update.json?no=' + scores[i].no)
					.text(scores[i].no)
					.click(loadScoreDetail)))
		.append($("<td>").text(new Date(scores[i].execDate).toString("yyyy-MM-dd")))
		.append($("<td>").text(scores[i].name))
		.append($("<td>").text(scores[i].kor))
		.append($("<td>").text(scores[i].eng))
		.append($("<td>").text(scores[i].math))
		.append($("<td>").text(scores[i].total))
		.append($("<td>").text(scores[i].average))
		.append($("<td>").append(
					$("<a>").attr("data-no", scores[i].no)
					.text('삭제')
					.attr("class", "btn btn-danger btn-xs")
					.click(function(event) {
						event.preventDefault();
						deleteScore(this.getAttribute("data-no"));
					})))
		.appendTo(table);
	  }
	}
  });
}





