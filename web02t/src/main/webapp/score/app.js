window.onload = function() {
  loadScoreList();
  
  document.getElementById("btnUpdate").onclick = updateScore;
  document.getElementById("btnReset").onclick = resetForm;
  
  document.getElementById("btnDelete").onclick = function(event) {
	deleteScore(document.getElementById("no").value);  
	location.href = "app.html";
  };
};

function resetForm() {
  changeFormState("newState");
}

function changeFormState(state) {
	var elements = document.querySelectorAll(".x-update-item");
	for (var i = 0; i < elements.length; i++) {
	  if (state == "updateState") {
		elements.item(i).style.display = ""; // 화면에 출력 
	  } else {
		elements.item(i).style.display = "none"; // 감추기
	  }
	}
	
	elements = document.querySelectorAll(".x-new-item");
	for (var i = 0; i < elements.length; i++) {
	  if (state == "updateState") {
	    elements.item(i).style.display = "none"; // 감추기
	  } else {
		elements.item(i).style.display = "";  // 출력
	  }
	}
}

function updateScore(event) {
  event.preventDefault(); 
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
    if (xhr.readyState == 4) {
    	location.href = "app.html";
    }
  };
  xhr.open('POST', 'update.json', true);
  
  // 전송 데이터 형식이 폼 데이터임을 알려야 한다.
  xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  
  // 서버에 보낼 데이터 준비
  // ASCII가 아닌 문자는 모두 URL 인코딩 해야 한다.
  var data = "no=" + document.getElementById("no").value
  	+ "&name=" + encodeURIComponent(document.getElementById("name").value)
  	+ "&kor=" + document.getElementById("kor").value
  	+ "&eng=" + document.getElementById("eng").value
  	+ "&math=" + document.getElementById("math").value
  	+ "&execDate=" + document.getElementById("execDate").value;
  	
  xhr.send(data);
}

function deleteScore(no) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
    if (xhr.readyState == 4) {
	  var result = JSON.parse(xhr.responseText); 
	  
	  if (result.status == "success") {
		  alert("삭제 성공입니다.");
		  location.href = "app.html";
	  } else {
		  alert("삭제 실패하였습니다.");
	  }
    }
  };
  
  xhr.open('GET', "delete.json?no=" + no , true);
  xhr.send(null);
}

function loadScoreDetail(event) {
  event.preventDefault(); // 웹 브라우저야, a 태그를 클릭할 때 수행하는 기본 작업을 하지 말아라!

  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
    if (xhr.readyState == 4) {
      // JSON 형식의 문자열을 실행하여 자바스크립트 객체를 생성한다. 
	  var score = JSON.parse(xhr.responseText); 
	  
	  // 서버로부터 받은 정보를 가지고 입력폼에 값을 설정한다.
	  document.getElementById("no").value = score.no;
	  document.getElementById("name").value = score.name;
	  document.getElementById("kor").value = score.kor;
	  document.getElementById("eng").value = score.eng;
	  document.getElementById("math").value = score.math;
	  document.getElementById("execDate").value = 
		  new Date(score.execDate).toString("yyyy-MM-dd");
	  
	  // 성적 폼의 상태를 변경 폼 상태로 바꾼다.
	  changeFormState("updateState");
    }
  };
  xhr.open('GET', this.href, true);
  xhr.send(null);
}

function loadScoreList() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
	if (xhr.readyState == 4) {
	  //1. 서버로부터 받은 JSON 문자열을 실행하여 자바스크립트 객체로 만든다.
	  var scores = eval('(' + xhr.responseText + ')');
	  
	  //2. 배열을 반복하면서 성적정보 출력
	  var table = document.getElementById("scoreTable");
	  var tr, td, a;
	  for (var i in scores) {
		scores[i].total = scores[i].kor + scores[i].eng + scores[i].math;
		scores[i].average = scores[i].total / 3;
		
		tr = document.createElement("tr"); //<tr></tr>
		table.appendChild(tr); //<table>...<tr></tr></table>
		
		td = document.createElement("td"); //<td></td>
		a = document.createElement("a"); //<a></a>
		a.href = 'update.json?no=' + scores[i].no; //<a href="..."></a>
		a.textContent = scores[i].no; //<a href="...">번호</a>
		a.onclick = loadScoreDetail;
		td.appendChild(a); //<td><a>...</a></td>
		tr.appendChild(td); //<tr><td>...</td></tr>
		
		td = document.createElement("td");
		td.textContent = new Date(scores[i].execDate).toString("yyyy-MM-dd");
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = scores[i].name;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = scores[i].kor;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = scores[i].eng;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = scores[i].math;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = scores[i].total ;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = scores[i].average;
		tr.appendChild(td);
		
		td = document.createElement("td");
		a = document.createElement("a");
		a.setAttribute("data-no", scores[i].no);
		a.textContent = '삭제';
		a.className = "btn btn-danger btn-xs";
		a.onclick = function(event) {
	      event.preventDefault();
		  deleteScore(this.getAttribute("data-no"));
		};
		td.appendChild(a);
		tr.appendChild(td);
	  }
	}
  };
  
  xhr.open('GET', 'list.json', true);
  xhr.send(null);	
}





