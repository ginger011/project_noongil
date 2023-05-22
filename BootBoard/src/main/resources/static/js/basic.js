	function loadList(){
		$.ajax({
			url : "board",  //요청경로
			type : "get", //요청방식(get/post)
			dataType : "json",   //서버 반환 데이터 타입
			success : htmlView,  //리스트 출력해주는 함수 호출
			error : function(){
				alert("통신실패!")
			}
		})
	}
	
	function htmlView(data){ //data : 통신 성공하고 서버로부터 응답받은 값
		console.log(data);
		var result = "<table class='table table-bordered table-hover'>";
		result += "<tr>";
		result += "<td>번호</td>";
		result += "<td>제목</td>";
		result += "<td>작성자</td>";
		result += "<td>작성일</td>";
		result += "<td>조회수</td>";
		result += "</tr>";
		//반복문
		$.each(data, (index,vo)=> { //data : boardlist / vo : Board
			result += "<tr>";
			result += "<td>"+vo.idx+"</td>";
			result += "<td id='t"+vo.idx+"'><a href='javascript:contentView("+vo.idx+")'>"+vo.title+"</a></td>";
			result += "<td id='w"+vo.idx+"'>"+vo.writer+"</td>";
			result += "<td>"+vo.indate+"</td>";
			result += "<td id='u"+vo.idx+"'><button class='btn btn-success btn-sm' onclick='goUpdate("+vo.idx+")'>수정</button></td>"
			result += "<td><button class='btn btn-warning btn-sm' onclick='goDelete("+vo.idx+")'>삭제</button></td>"
			result += "</tr>";
			result += "<tr id='cv"+vo.idx+"' style='display:none'>";
			result += "<td>내용</td>";
			result += "<td colspan='4'>";
			result += "<textarea rows='6' class='form-control' id='c"+vo.idx+"'>"+vo.content+"</textarea>";
			result += "<br>";
			result += "<button class='btn btn-success btn-sm' onclick='updateFn("+vo.idx+")'>수정</button>&nbsp;";
			result += "<button class='btn btn-warning btn-sm' onclick='closeFn("+vo.idx+")'>닫기</button>";
			result += "</td>";
			result += "</tr>";
		})
		result += "<tr>";
		result += "<td colspan='6'>";
		result += "<button class='btn btn-primary btn-sm' onclick='goView()'>글쓰기</button>";
		result += "</td>";
		result += "</tr>";
		result += "</table>";
		$("#list").html(result)
	}
	
	function contentView(idx){
		//내용행이 안보일 때 -> 보이게
		//내용행이 보이게 -> 안보이게
		if($("#cv"+idx).css("display")=="none"){ //현재 display 속성값이 none인지?
			$("#cv"+idx).css("display", "table-row")
		}else{ //보일때
			$("#cv"+idx).css("display", "none")
		}
	}
	
	function closeFn(idx){
		$("#cv"+idx).css("display", "none") 
	}
	
	function updateFn(idx){
		let content = $("#c"+idx).val()   //사용자가 작성한 내용 수정본
		
		$.ajax({
			url : "boardcontentupdate",  //요청경로
			type : "post",  //요청방식
			data : {"idx":idx,"content":content}, //요청데이터 (인덱스, 내용)
			success : loadList,
			error : function(){
				alert("실패!")
			}
		})
	}
	
	function goUpdate(idx){ //선택한 게시물의 제목,작성자를 수정할 수 있는 폼으로 만들어주는 함수
		
		let t = $("#t"+idx).text()   //text => innerText  , html => innerHtml
		//제목수정 input
		let tInput = "<input id='nt"+idx+"' type='text' class='form-control' value='"+t+"'>"
		$("#t"+idx).html(tInput)
		
		let w = $("#w"+idx).text()
		let wInput = "<input id='nw"+idx+"' type='text' class='form-control' value='"+w+"'>"
		$("#w"+idx).html(wInput)
		
		let newBtn = "<button class='btn btn-info btn-sm' onclick='updateTWFn("+idx+")'>수정하기!</button>"
		$("#u"+idx).html(newBtn)
	}
	
	function updateTWFn(idx){
		let title = $("#nt"+idx).val()   //val() -> value
		let writer = $("#nw"+idx).val()
		
		$.ajax({
			url : "boardtwupdate",
			type : "post",
			data : {"idx":idx, "title":title,"writer":writer},
			success : loadList,
			error : function (){
				alert("실패!")
			}
		})
	}
	
	function goDelete(idx){
		$.ajax({
			url : "boarddelete",
			type : "get",
			data : {"idx" : idx},
			success : loadList,
			error : function(){
				alert("실패!")
			}
		})
	}
	
	function goView(){
		if($("#wform").css("display") == "none"){ //안보이는지 확인
			$("#wform").slideDown();
		}else{
			$("#wform").slideUp();	
		}
	}
	
	function goInsert(){
		let f = $("#frm").serialize();
		console.log(f);
		
		$.ajax({
			url : "board/insert",
			data : f,  
			type : "post",
			success : loadList,
			error : function(){
				alert("실패!")
			}
		})
		
		$("#init").trigger("click")  //강제로 click이벤트 발생
		$("#wform").css("display", "none") //글작성 영역 안보이게
	}