function loadbreport() {
	$.ajax({
		url: "api/breport/",  //요청경로
		type: "get", //요청방식(get/post)
		dataType: "json",   //서버 반환 데이터 타입
		success: function (data) {
			console.log(data);
		},
		error: function () {
			alert("통신실패!");
		}
	});
	$.when(
		$.ajax({
			url: "api/breport/",
			type: "get",
			dataType: "json",
		}),
		$.ajax({
			url: "api/autoreport/",
			type: "get",
			dataType: "json",
		})
	)
		.done(function (breportData, autoreportData) {
			populateTable1(breportData[0]);
			populateTable2(autoreportData[0]);
		})
		.fail(function () {
			alert("통신실패!");
		});
}
function populateTable1(data) {
	let result = '';
	for (let i = 0; i < data.length; i++) {
		console.log(data[i]);
		result += "<tr>";
		// 번호
		result += "<th><span>" + data[i]['userReportNum'] + "</span></th>";
		// 구분
		result += "<th><span>" + data[i]['userID'] + "</span></th>";
		// 작성일자
		result += "<th><span>" + data[i]['userReportDate'] + "</span></th>";
		// 위치
		result += "<th><span>" + data[i]['userReportPlace'] + "</span></th>";
		// 내용
		result += "<th><span>" + data[i]['userReportContent'] + "</span></th>";
		// 상태
		result += "<th><span class='state' onclick='showAlert(this)'>" + data[i]['userReportState'] + "</span></th>";
		result += "</tr>";
	}
	document.querySelector('.user-div tbody').innerHTML += result;
}


function populateTable2(data) {
	let result = '';
	for (let i = 0; i < data.length; i++) {
		console.log(data[i]);
		result += "<tr>";
		// 번호
		result += "<th><span>" + data[i]['autoReportNum'] + "</span></th>";
		// 구분
		result += "<th><span>" + data[i]['autoID'] + "</span></th>";
		// 작성일자
		result += "<th><span>" + data[i]['autoReportDate'] + "</span></th>";
		// 위치
		result += "<th><span>" + data[i]['autoReportPlace'] + "</span></th>";
		// 내용
		result += "<th><span>" + data[i]['autoReportContent'] + "</span></th>";
		// 상태
		result += "<th><span class='state' onclick='showAlert(this)'>" + data[i]['autoReportState'] + "</span></th>";
		result += "</tr>";
	}
	document.querySelector('.user-div tbody').innerHTML += result;
}

function showAlert(element) {
    console.log(element.textContent);

    const existingBox = document.querySelector('.status-box');
    // existingBox가 존재하면, 즉 .status-box 요소가 이미 있으면 다음 코드를 실행합니다.
	console.log(existingBox)
    if (existingBox) {
        existingBox.style.display = "block"; // 기존 박스를 보이도록 스타일을 변경합니다.
        console.log("hihi"); // "hihi"를 콘솔에 출력합니다.
    }

    const statusBtns = document.querySelector(".status-btn button");

    // statusBtns에 대해 forEach 루프를 실행합니다.
    statusBtns.forEach(btn => {
        // 각 버튼에 클릭 이벤트 리스너를 추가합니다.
        btn.addEventListener("click", () => {
            existingBox.style.display = "none"; // 박스를 숨기도록 스타일을 변경합니다.
        });
    });
}
