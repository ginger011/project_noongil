// 고장 신고 정보

function loadbreport() {
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
		for(let i = 0; i < data.length; i++) {
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
		document.querySelector('.user-div tbody').innerHTML += result;

  
}


function populateTable2(data) {
  
		let result = '';
		for(let i = 0; i < data.length; i++) {
			console.log(data[i])
		  result += "<tr>"
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
		  result += "<th><span>" + data[i]['autoReportState'] + "</span></th>";
		  result += "</tr>"
		}
		document.querySelector('.user-div tbody').innerHTML += result;

  
}