/** 비트 자바스크립트 라이브러리
 * 
 */

function bit(value) {
  var elements;
  if (value.charAt(0) == "<") {
	/*
	var startIndex = 1;
	var endIndex = value.length - 1;
	var tagName = value.substring(startIndex, endIndex);
	var newElement = document.createElement(tagName);
	elements = [];
	elements.push(newElement);
	*/
	elements = [document.createElement(value.substring(1, value.length - 1))];
  } else {
    elements = document.querySelectorAll(value);	  
  }
  
  // 엘리먼트 목록에 양념 함수를 추가한다.
  // 1) 목록에서 첫 번재 항목의 value 값을 리턴하는 함수
  //  파라미터 값이 없으면 getter 함수로 사용됨.
  //  파라미터 값이 있으면 setter 함수로 사용됨.
  elements.val = function(value) {
	if (arguments.length == 0) {
      return this[0].value;
	} 
	  
	for (var i = 0; i < this.length; i++) {
	  this[i].value = value;
	}
	return this;
  };
  
  // 2) click 이벤트 리스너를 등록하는 함수
  elements.click = function(listener) {
	for (var i = 0; i < this.length; i++) {
		this[i].addEventListener("click", listener);
	}
	return this;
  };
  
  // 3) 스타일을 설정하는 함수
  elements.css = function(styleName, value) {
    for (var i = 0; i < this.length; i++) {
      this[i].style[styleName] = value;
	} 
    return this;
  }
  
  // 4) 자식 엘리먼트 추가하는 함수
  elements.append = function(child) {
	for (var i = 0; i < this.length; i++) {
	  if (child instanceof Array || child instanceof NodeList) { //목록일 때,
		for (var j = 0; j < child.length; j++) {
		  this[i].appendChild(child[j]);
		}
	  } else { // 단일 태그일 때,
		this[i].appendChild(child);  
	  }
	}
	return this;
  }
  
  // 5) 부모에게 붙이는 함수
  elements.appendTo = function(parent) {
    for (var i = 0; i < this.length; i++) {
	  parent[0].appendChild(this[i]);
    }
	return this;
  }
  
  // 6) 엘리먼트의 콘텐츠 설정 함수
  elements.text = function(value) {
	if (arguments.length == 0) {
	  return this[0].textContent;
	}
	
	for (var i = 0; i < this.length; i++) {
      this[i].textContent = value;
	}
	return this;
  }
  
  // 7) 엘리먼트에 속성을 추가하는 함수
  elements.attr = function(attrName, value) {
	if (arguments.length == 1) {
		return this[0].getAttribute(attrName);
	}
	
	for (var i = 0; i < this.length; i++) {
	  this[i].setAttribute(attrName, value);
	}
	return this;
  }
  
  return elements; // NodeList + 양념들
}

// 함수도 객체이기 때문에 프로퍼티를 추가할 수 있다.
bit.ajax = function(url, settings) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(event) {
	if (xhr.readyState == 4) {  
	  var result = JSON.parse(xhr.responseText);
	  if (settings.success) {
		  settings.success(result);
	  }
	}
  }
  xhr.open(settings.type, url, true);
  if (settings.type == "POST") { // POST 요청
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    var queryString = "";
    for (var propName in settings.data) {
      if (queryString.length > 0) {
    	queryString += "&";
      }
      queryString = queryString + propName + "=" 
    					+ encodeURIComponent(settings.data[propName]);
    }
    xhr.send(queryString);
  } else { //GET 요청
	xhr.send(null);  
  }
};

var $ = bit;









