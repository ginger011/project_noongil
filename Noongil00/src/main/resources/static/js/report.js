// 고장 신고 정보

function loadbreport() {
	$.ajax({
		url: "api/breport/",  //요청경로
		type: "get", //요청방식(get/post)
		dataType: "json",   //서버 반환 데이터 타입
		success: function (data) {
			let result = '';
			for (let i = 0; i < data.length; i++) {
				console.log(data[i])
				result += "<tr>"
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
				result += "<th><span>" + data[i]['userReportState'] + "</span></th>";
				result += "</tr>"
			}
			document.querySelector('.user-div tbody').innerHTML = result;
		},
		error: function () {
			alert("통신실패!")
		}
	})
}


