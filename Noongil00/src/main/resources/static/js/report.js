// 고장 신고 정보

	function loadbreport(){
		$.ajax({
			url : "api/breport/",  //요청경로
			type : "get", //요청방식(get/post)
			dataType : "json",   //서버 반환 데이터 타입
			success : function(data){
				console.log(data)
			},  //리스트 출력해주는 함수 호출
			error : function(){
				alert("통신실패!")
			}
		})
	}