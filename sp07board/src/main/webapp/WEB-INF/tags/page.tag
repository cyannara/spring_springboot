<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="page" type="com.yedam.common.PageDTO" %>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:if test="${pageMaker.prev}">
				<li class="page-item previous">
				   <a class="page-link" href="${pageMaker.startPage -1}">Previous</a></li>
			</c:if>

			<c:forEach var="num" begin="${pageMaker.startPage}"
				end="${pageMaker.endPage}">
				<li class="page-item  ${pageMaker.cri.pageNum == num ? "active":""} ">
					<a class="page-link" href="${num}">${num}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next}">
				<li class="page-item next">
				  <a class="page-link" href="${pageMaker.endPage +1 }">Next</a></li>
			</c:if>
		</ul>
	</nav>
