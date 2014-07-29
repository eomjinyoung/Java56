window.onload = function() {
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
		
		tr = document.createElement("tr");
		table.appendChild(tr);
		
		td = document.createElement("td");
		a = document.createElement("a");
		a.href = 'update.do?no=' + scores[i].no;
		a.textContent = scores[i].no;
		td.appendChild(a);
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.textContent = scores[i].execDate;
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
		a.href = 'delete.do?no=' + scores[i].no;
		a.textContent = '삭제';
		td.appendChild(a);
		tr.appendChild(td);
	  }
	}
  };
  
  xhr.open('GET', 'list.json', true);
  xhr.send(null);
};





