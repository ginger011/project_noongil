// 고장 신고 정보

function loadbreport() {
	$.ajax({
		url: "api/breport/",  //요청경로
		type: "get", //요청방식(get/post)
		dataType: "json",   //서버 반환 데이터 타입
		success: function (data) {
			// console.log(data);
			let result = '';
			for(let i = 0; i < data.length; i++) {
				console.log(i, data[i]);
				result += "<tr>"
				result += "<th><span>"+data[i]['userReportNum']+"</span></th>";
				result += "<th><span>"+data[i]['userReportDate']+"</span></th>";
				result += "<th><span>"+data[i]['userReportDate']+"</span></th>";
				result += "<th><span>"+data[i]['userReportPlace']+"</span></th>";
				result += "<th><span>"+data[i]['userReportContent']+"</span></th>";
				result += "<th><span>"+data[i]['userReportState']+"</span></th>";
				result += "</tr>"


			}
		}
	})
}

