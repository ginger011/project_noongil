const currentPageURL = window.location.href;

// li 요소들에 대해 반복하여 현재 페이지와 일치하는지 확인
const navItems = document.querySelectorAll('.main-nav li');
navItems.forEach(item => {
	const link = item.querySelector('a');
	if (link.href === currentPageURL) {
		item.classList.add('active');
	}
});

const divLoginSpan = document.getElementsByClassName('main-login')[0].getElementsByTagName('span')[0].textContent;
// 로그인 버튼 클릭 시 로그인 창 보이기
const btnLogin = document.querySelector('.btn-login');
const loginOverlay = document.querySelector('.login-overlay');


document.querySelector('.btn-login').addEventListener('click', function (event) {
	// 로그인 버튼의 글씨가 로그인일 경우에 실행
	if (btnLogin.textContent === '로그인') {
		// 로그인 창을 보이도록 설정
		document.querySelector('.login-overlay').style.display = 'flex';
		// 이벤트 전파(stopPropagation)를 막기 위해 클릭 이벤트를 처리합니다.
		event.stopPropagation();
		
	} else if (btnLogin.textContent === '로그아웃'){
		// 로그인 버튼의 글씨가 로그아웃일 때 실행 될 것들
		sessionStorage.removeItem("managerID");
	    sessionStorage.removeItem("managerPW");
	    
	    btnLogin.style.backgroundColor = ''; // 이전에 설정된 스타일 제거
	    btnLogin.style.color = ''; // 이전에 설정된 스타일 제거
	    btnLogin.textContent = '로그인';	    
	    // location.reload(); // 페이지 새로고침
	}

});

document.querySelector('.login').addEventListener('click', function (event) {
	// 로그인 창 내부를 클릭해도 이벤트가 전파되지 않도록 막습니다.
	event.stopPropagation();
});

document.querySelector('.login-overlay').addEventListener('click', function (event) {
	// 배경을 클릭했을 때만 로그인 창을 숨기도록 처리
	if (event.target === this) {
		document.querySelector('.login-overlay').style.display = 'none';
	}
});

if (divLoginSpan.includes('환영합니다')) {
	btnLogin.style.backgroundColor = '#FF4949'; // 스타일을 변경할 원하는 스타일로 설정하세요
	btnLogin.style.color = 'white';
	btnLogin.textContent = '로그아웃';	
}


// span 태그들을 선택합니다.
var spans = document.getElementsByTagName("span");

// 각 span 태그를 순회하며 확인합니다.
for (var i = 0; i < spans.length; i++) {
	var span = spans[i];

	// span 태그의 텍스트가 "warning"인 경우 스타일을 변경합니다.
	if (span.innerHTML.trim() === "warning") {
		console.log("hi")
		span.style.color = "red";
	}
}


// 회원가입 페이지에 *(필수 표시) 글씨가 있다면 빨간색으로 강조해주기 ex) * 아이디
const joinPtag = document.querySelectorAll('p');
joinPtag.forEach((p) => {
	if (p.textContent.includes('*')) {
		// ('*')을 빨간색으로
		let content = p.textContent.replace('*', '<span style="color: red">*</span>');
		p.innerHTML = content
	}
});


// 로그인 - 세션 사용하기
// document.getElementById("input 태그의 id값")
let id = document.getElementById("managerID")
let pw = document.getElementById("managerPW")


// 로그인 버튼 클릭하면 세션에 저장
function loginStore(){	
	sessionStorage.setItem("managerID", id.value);
	sessionStorage.setItem("managerPW", pw.value);
}

function logout() {
  var xhr = new XMLHttpRequest();
  xhr.open('POST', '/web_user/logout', true);  // 로그아웃 요청을 보낼 URL을 적절히 변경해야 합니다.
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.onload = function() {
    if (xhr.status === 200) {
      // 로그아웃 성공
      sessionStorage.removeItem("managerID");
      sessionStorage.removeItem("managerPW");
      console.log('로그아웃되었습니다.');
      // 페이지 새로고침 등 로그아웃 이후에 수행할 동작을 여기에 추가할 수 있습니다.
    } else {
      // 로그아웃 실패
      console.error('로그아웃에 실패했습니다.');
    }
  };
  xhr.send();
}

// 세션 존재 시에만 점자블록 이동
function toMap() { // 로그인 O	
	if(sessionStorage.getItem('managerID') != null){				
		// alert(sessionStorage.getItem('managerID'));
		location.href="/noongil/map"; 
	}else{ // 로그인 X
		// '점자블록' 클릭했을 때 로그인 창 보이게
		document.querySelector('.login-overlay').style.display = 'flex';
	}
}

// 세션 존재 시에만 고장신고
function userReport(){
	if(sessionStorage.getItem('managerID') != null){				
		location.href="/noongil/userReport";
	}else{
		document.querySelector('.login-overlay').style.display = 'flex';			
	}
}

// 세션 존재 시에만 회원정보
function user(){
	if(sessionStorage.getItem('managerID') != null){				
		location.href="/noongil/user";
	}else{
		document.querySelector('.login-overlay').style.display = 'flex';			
	}
}