<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" %>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tbody{
		font-size: 20px;
	}

	.btn-countPerPage {
		background-color: gray;
		color: white;
	}


</style>

</head>
<body>


	<div class="container">
		<h2>My Web게시판</h2>


		<span style="float: right; margin-bottom: 15px">
			<input class="btn btn-countPerPage" type="button" value="10" onclick="location.href='/doggimain/list.board?page=1&cpp=10'">
			<input class="btn btn-countPerPage" type="button" value="20" onclick="location.href='/doggimain/list.board?page=1&cpp=20'">
			<input class="btn btn-countPerPage" type="button" value="30" onclick="location.href='/doggimain/list.board?page=1&cpp=30'">
		</span>


		<table class="table table-secondary table-hover table-bordered">
			<thead style="font-size: 25px">
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>



			<tbody>
                <c:forEach var="b" items="${boardList}">
                    <tr>
                        <td>${b.boardId}</td> <!-- td는 위에있는 th만큼. -->
                        <td>${b.writer}</td>
                        <td><a href="/doggimain/content.board?bId=${b.boardId}&page=${pc.paging.page}&cpp=${pc.paging.cpp}">${b.title}</a></td>
                        <td>${b.regDate}</td>
                        <td>${b.hit}</td>
                    </tr>
                </c:forEach>
            </tbody>






			<tbody>
				<tr>
					<td colspan="5" align="center">
						<ul class="pagination pagination-lg">




                     <c:if test="${pc.prev}">

	                        <li class="page-item"><a class="page-link"
	                           href="/doggimain/list.board?page=${pc.beginPage-1}&cpp=${pc.paging.cpp}"
	                           style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">이전</a>
	                        </li>

                     </c:if>

   						<c:forEach var="pageNum" begin="1" end="5">
	                        <li class="page-item">
	                        <a href="/doggimain/list.board?page=${pageNum}&cpp=${pc.paging.cpp}" class="page-link"
	                           style="margin-top: 0; height: 40px; color: pink; border: 1px solid #643691; ${pageNum == pc.paging.page ? 'background-color: orange' : ''}">${pageNum}</a> <%--조건문으로 사용자가 보고 있는 버튼을 눈에 띄게 칠해보자. 어느 페이지로 이동한지 모르니까. 트루면 오렌지색. 아니면 비운다는 뜻이다~ --%>
	                        </li>
               			</c:forEach>

    					<c:if test="${pc.next}">
	                        <li class="page-item"><a class="page-link"
	                           href="/doggimain/list.board?page=${pc.endPage+1}&cpp=${pc.paging.cpp}"
	                           style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">다음</a>
	                        </li>
						</c:if>
						</ul>
					</td>
				</tr>
			</tbody>

			<tbody>
				<tr>
					<td colspan="5" align="right">
						<form action="/doggimain/search.board" class="form-inline" >
						  <div class="form-group">

						  	<select name="category" class="form-control">
						  		<option value="title">제목</option>
						  		<option value="writer">작성자</option>
						  		<option value="content">내용</option>
						  	</select>

						    <input type="text" name="search" placeholder="검색어 입력" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='/doggimain/write.board'">
						  </div>
						</form>
					</td>
				</tr>
			</tbody>

		</table>
	</div>


</body>
</html>







