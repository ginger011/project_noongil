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
			document.querySelector('.user-div tbody').innerHTML = result;
		},  //리스트 출력해주는 함수 호출
		error: function () {
			alert("통신실패!")
		}
	})
}

console.log("리포트 js 가져오기 성공")

	// <tr tr th: each = "item:${list}" >
    //                         <th scope="row" th:text="${item.userResportNum}"></th>
    //                         <td th:text="${item.userID}"></td>
    //                         <td th:text="${item.userReportPlace}"></td>
    //                         <td th:text="${item.usetReportContent}"></td>
    //                         <td th:text="${item.userReportState}"></td>
    //                         <td th:text="${item.userReportDate}"></td>
    //                     </tr >