<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="js/basic.js"></script>
</head>
<body>
 
<div class="container">
  <h2>영표쌤반 게시판😎😎</h2>
  <div class="panel panel-default">
    <div class="panel-heading">게시판</div>
    <div class="panel-body" id="list"></div>
    <div class="panel-body" id="wform" style="display:none">
    		<form  class="form-horizontal" action="#" id="frm">
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="title">제목 : </label>
			    <div class="col-sm-10">
			      <input type="text" name="title" class="form-control" placeholder="Enter title">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="content">내용 : </label>
			    <div class="col-sm-10">
			      <textarea rows="10" name="content" class="form-control"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="control-label col-sm-2" for="writer">작성자:</label>
			    <div class="col-sm-10">
			      <input type="text" name="writer" class="form-control" placeholder="Enter writer">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="button" onclick="goInsert()" class="btn btn-success btn-sm">등록</button>
			      <button type="reset" class="btn btn-warning btn-sm" id="init">취소</button>
			    </div>
			  </div>
			</form>
    </div>
    <div class="panel-footer">지능형 IoT융합 SW전문가 과정 (담임 : 선영표)</div>
  </div>
</div>
<script type="text/javascript">
	//basic.jsp 페이지가 로드 되자마자 리스트를 가지고 와야함!
	$(document).ready(()=>{
		loadList();
	})
	
</script>
</body>
</html>


 --%>
