<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>


<%@include file="../includes/header.jsp"%>
<div class="container-lg">
<h2>자유게시판</h2>

<div class="card">
	<div class="card-header">
		Board List Page
		<button id='regBtn' type="button"
			class="btn btn-xs pull-right text-decoration-underline">글등록</button>
	</div>
	<div class="card-body">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>#번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.bno}</td>
						<!-- <td><a href='<c:url value="/board/get?bno=${board.bno}"/>'>${board.title}</a></td> -->
						<td><a class='move' href='${board.bno}'>${board.title}</a></td>
						<td><c:out value="${board.writer}" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${board.regdate}" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd"
								value="${board.updateDate}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form id='searchForm' action="/board/list" method='get'>
			<div class="d-flex justify-content-end mb-4">
			  <div class="pe-3">
				<select name='type' class="form-control">
					<option value="">--</option>
					<option value="T">제목</option>
					<option value="C">내용</option>
					<option value="W">작성자</option>
					<option value="TC">제목 or 내용</option>
					<option value="TW">제목 or 작성자</option>
					<option value="TWC">제목 or 내용 or 작성자</option>
				</select>
			</div>
			<div class="pe-3">
				<input type='text' class="form-control" name='keyword' value='${pageMaker.cri.keyword}' />
			</div>	
			<div class="pe-3">
				<button class='btn btn-outline-primary'>Search</button>
			</div>	
			<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}' />
			<input type='hidden' name='amount' value='${pageMaker.cri.amount}' />
			</div>
		</form>

		<my:page page="${pageMaker}"></my:page>
		<!--  end Pagination -->
	</div>

	<form id='actionForm' action="/board/list" method='get'>
		<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
		<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
		<input type='hidden' name='type' value='${ pageMaker.cri.type }'>
		<input type='hidden' name='keyword'	value='${ pageMaker.cri.keyword }'>
	</form>
</div>
<!--  end panel-body -->
</div>

<!-- Modal  추가 -->
<div class="modal fade" id="myModal" tabindex="-1" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">처리가 완료되었습니다.</div>
			<div class="modal-footer">
				<button type="button" id="btnClose" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script type="text/javascript">
	$(document).ready( function() {

		var result = '${result}';
		checkModal(result);
		//history.replaceState({}, null, null);

		function checkModal(result) {

			if (result === '') { // || history.state
				return;
			}

			if (parseInt(result) > 0) {
				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}

		    const options = { backdrop: false, focus: false, keyboard: true }
		    const myModal = document.getElementById('myModal')
		    const myModalAlternative = new bootstrap.Modal('#myModal', options)
		    myModalAlternative.show(myModal)
		}

		$("#regBtn").on("click", function() {
			self.location = "/board/register";
		});

		var actionForm = $("#actionForm");

		$(".move").on("click", function(e) {
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno' value='"
											+ $(this).attr("href")
											+ "'>");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		});

		var searchForm = $("#searchForm");

		$("#searchForm button").on("click", function(e) {
			if (!searchForm.find("option:selected").val()) {
				alert("검색종류를 선택하세요");
				return false;
			}

			if (!searchForm.find("input[name='keyword']").val()) {
				alert("키워드를 입력하세요");
				return false;
			}

			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			searchForm.submit();
		});

		$(".pagination a").on("click", function(e) {
			e.preventDefault();
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			searchForm.submit();
		});
	});
</script>






<%@include file="../includes/footer.jsp"%>
