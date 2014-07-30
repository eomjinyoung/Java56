window.onload = function() {
  var xhr = new XMLHttpRequest();
  
  // 서버로부터 응답을 받았을 때 호출될 함수 등록
  // => 요청 상태가 바뀔 때 마다 호출됨. 네가지 상태가 있음.
  // 1 : open() 호출 후
  // 2 : send() 호출 후
  // 3 : 서버에서 응답을 받는 중
  // 4 : 서버에서 응답을 모두 받았음.
  xhr.onreadystatechange = function(event) {
	if (xhr.readyState == 4) {
	  console.log(xhr.responseText);
	}
  };
  
  xhr.open('GET', 'list.json', true); // 비동기 방식으로 서버에 요청하라고 지정한다.
  xhr.send(null); // 서버에 요청한 후 기다림 없이 즉시 리턴한다.
  
  //서버로부터 응답을 받기도 전에 responseText 값을 사용한다면 빈 값만 얻을 것이다. 
  //console.log("==>", xhr.responseText); 
};





