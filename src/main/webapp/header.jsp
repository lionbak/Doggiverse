<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html class="no-js" lang="kor">
<head>
<meta charset="UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title> DoggiVerse </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <!-- CSS here -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/slicknav.css">
    <link rel="stylesheet" href="assets/css/flaticon.css">
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <link rel="stylesheet" href="assets/css/nice-select.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <script>
        function handleLogout() {
            alert('로그아웃 되었습니다.');
            document.getElementById('logout-form').submit();
        }
    </script>
</head>
<body>
    <header>
        <!--? Header Start -->
        <div class="header-area header-transparent">
            <div class="main-header header-sticky">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <!-- Logo -->
                        <div class="col-xl-2 col-lg-2 col-md-1">
                            <div class="logo">
                                <a href="index.jsp"><img src="assets/img/logo/logo2.png" alt=""></a>
                            </div>
                        </div>
                        <div class="col-xl-10 col-lg-10 col-md-10">
                            <div class="menu-main d-flex align-items-center justify-content-end">
                                <!-- Main-menu -->
                                <div class="main-menu f-right d-none d-lg-block">
                                    <nav> 
                                        <ul id="navigation">
                                            <li><a href="index.jsp">홈</a></li>
                                            <!-- <li><a href="about.html">About</a></li> -->
                                            <li><a href="News.jsp">뉴스</a></li>
                                            <li><a href="${pageContext.request.contextPath}/list.board?page=1&cpp=">자유게시판</a></li>
                                            <li><a href="dog.jsp">유기견 조회하기</a></li>
                                            <!-- <li><a href="blog.html">각종정보</a>
                                                <ul class="submenu">
                                                    <li><a href="board.jsp">게시판</a></li>
                                                    <li><a href="blog_details.html">게시판 보기</a></li>
                                                    <li><a href="elements.html">Element</a></li>
                                                </ul>
                                            </li> -->
                                            <!-- <li><a href="contact.html">Contact</a></li> -->
                                        </ul>
                                    </nav>
                                </div>
                                <div class="header-right-btn f-right d-none d-lg-block ml-30">
             							<c:choose>
                    			 			<c:when test="${not empty sessionScope.username}">
                    			 				<%-- <span>${sessionScope.username} 님</span> --%>
                    			 				<a href="viewAccount.jsp" class="header-btn">내 계정</a>
                        					 	<a href="#" class="header-btn" onclick="handleLogout()">로그아웃</a>
                            				 	<form id="logout-form" action="/doggimain/UserServlet" method="post" style="display: none;">
                               				<input type="hidden" name="pagecode" value="logout">
                           			    	</form>
                     					</c:when>
		                        <c:otherwise>
		                            <a href="login.jsp" class="header-btn">로그인</a>
		                            <a href="signup2.jsp" class="header-btn">회원가입</a>
		                        </c:otherwise>
								</c:choose>
						            </div>
                                </div>
                            </div>
                        </div>   
                        <!-- Mobile Menu -->
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
            </div>
        
        <!-- Header End -->
    </header>
</body>
</html>