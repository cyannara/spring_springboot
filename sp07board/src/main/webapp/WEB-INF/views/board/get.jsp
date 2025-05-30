<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Read</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>Bno</label> <input class="form-control" name='bno'
            value='<c:out value="${board.bno }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='content'
            readonly="readonly"><c:out value="${board.content}" /></textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer }"/>' readonly="readonly">
        </div>

<%-- 		<button data-oper='modify' class="btn btn-default">
        <a href="/board/modify?bno=<c:out value="${board.bno}"/>">Modify</a></button>
        <button data-oper='list' class="btn btn-info">
        <a href="/board/list">List</a></button> --%>


<button data-oper='modify' class="btn btn-default">Modify</button>
<button data-oper='list' class="btn btn-info">List</button>

<%-- <form id='operForm' action="/boad/modify" method="get">
  <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
</form> --%>


<form id='operForm' action="/boad/modify" method="get">
  <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
  <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
  <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
  <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>  
</form>



      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
  
  <div>
      <!-- 댓글 입력 폼 -->
    <div class="mb-3">
      <textarea class="form-control mb-2" rows="3" placeholder="댓글을 입력하세요..."></textarea>
      <button class="btn btn-primary">댓글 작성</button>
    </div>

    <hr>

    <!-- 댓글 리스트 -->
    <div id="commentlist">
	    <div class="comment mb-4">
	      <div class="d-flex justify-content-between">
	        <strong>user123</strong>
	        <small class="text-muted">2025-05-22</small>
	      </div>
	      <p class="mb-1">좋은 글이네요!</p>
	      <div>
	        <button class="btn btn-sm btn-outline-secondary">수정</button>
	        <button class="btn btn-sm btn-outline-danger">삭제</button>
	      </div>
	    </div>
	    <div class="comment mb-4">
	      <div class="d-flex justify-content-between">
	        <strong>user456</strong>
	        <small class="text-muted">2025-04-12</small>
	      </div>
	      <p class="mb-1">감사합니다!</p>
	      <div>
	<!--         <button class="btn btn-sm btn-outline-secondary">수정</button>
	        <button class="btn btn-sm btn-outline-danger">삭제</button> -->
	      </div>
	    </div>
  </div>
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
  
  var operForm = $("#operForm"); 
  
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/board/modify").submit();
    
  });
  
    
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.find("#bno").remove();
    operForm.attr("action","/board/list")
    operForm.submit();
    
  });  
});
</script>


<%@include file="../includes/footer.jsp"%>
