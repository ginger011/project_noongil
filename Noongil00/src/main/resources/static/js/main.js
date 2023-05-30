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
	// 로그인 버튼으 글씨가 로그인일 경우에 실행
	if (btnLogin.textContent === '로그인') {
		// 로그인 창을 보이도록 설정
		document.querySelector('.login-overlay').style.display = 'flex';
		// 이벤트 전파(stopPropagation)를 막기 위해 클릭 이벤트를 처리합니다.
		event.stopPropagation();
	} else {
		// 로그인 버튼의 글씨가 로그아웃일 때 실행 될 것들
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

// settings 클래스를 가진 span 요소들을 선택합니다.
// let settings = document.getElementsByClassName('settings-link')[0].querySelector('span');

// // span 요소를 클릭했을 때 이벤트 핸들러를 등록합니다.
// settings.addEventListener('click', function () {
// 	// 클릭된 span 요소의 부모 요소인 <a> 요소를 찾습니다.
// 	let parentLink = this.parentNode;
// 	console.log("a태그", parentLink);
// 	// <a> 요소의 부모 요소인 <td> 요소를 찾습니다.
// 	let parentTd = parentLink.parentNode;
// 	console.log("td태그", parentTd);
// 	// <td> 요소의 부모 요소인 <tr> 요소를 찾습니다.
// 	let parentTr = parentTd.parentNode;
// 	console.log("parentTr태그", parentTr);
// 	// <th> 요소의 자식 요소인 <span> 요소를 찾습니다.
// 	let span = parentTr.querySelector('span');
// 	console.log("span태그", span);
// 	// 텍스트를 변경합니다.
// });

