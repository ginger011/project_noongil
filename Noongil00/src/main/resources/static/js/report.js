function loadbreport() {
	$.ajax({
		url: "api/breport/",  //요청경로
		type: "get", //요청방식(get/post)
		dataType: "json",   //서버 반환 데이터 타입
		success: function (data) {
			// console.log(data);
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
		// console.log(data[i]);
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
		// console.log(data[i]);
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
    const existingBox = document.querySelector('.status-box');
    if (existingBox) {
        existingBox.style.display = "block";
    	existingBox.style.position = "fixed";
    	existingBox.style.top = "50%";
    	existingBox.style.left = "50%";
    	existingBox.style.transform = "translate(-50%, -50%)";
    }

    const statusBtns = document.querySelectorAll(".status-btn button");
    for (let i = 0; i < statusBtns.length; i++) {
        let btn = statusBtns[i];
        btn.addEventListener('click', function() {
            if (i === 0) {
                console.log('고장 버튼 눌러짐');
            } else if (i === 1) {
                console.log('처리중 버튼 눌러짐');
            } else if (i === 2) {
                console.log('처리완료 버튼 눌러짐');
            }
            existingBox.style.display = 'none';
        })
    }
}
