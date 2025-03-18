<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title> DoggiVerse </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
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
    <style>
.login-page {
display: flex;
justify-content: center;
align-items: center;
height: 30vh;
background-color: #fff;
}

.login-container {		
    padding: 0px;
    background-color: #fff;
    box-shadow: 0 0 0px rgba(0, 0, 0, 0.1);
    border-radius: 20px;
    justify-content: center;
    text-align: center;
    display: flex;
    max-width: 800px;
    width: 100%;
            
}

.form-group {
    margin-bottom: 15px;
}

.form-group input[type="text"],
.form-group input[type="password"] {
    width: 100%;
    padding: 15px; /* Increased padding for larger input fields */
    margin: 5px 0;
    box-sizing: border-box;
    font-size: 16px; /* Increased font size */
}


.error-message {
    height: 40px; /* Set a fixed height */
    display: flex;
    align-items: center;
    justify-content: center;
    color: red;
    margin-bottom: 15px;
}

.error-message p{
    height: 40px; /* Set a fixed height */
    display: flex;
    align-items: center;
    justify-content: center;
    color: red;
    margin-bottom: 15px;
}
</style>
<script>
        function handleLogout() {
            alert('로그아웃 되었습니다.');
            document.getElementById('logout-form').submit();
        }
    </script>
</head>
<body>
<!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assets/img/logo/logo.jpeg" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
 <main>
    <div class="slider-area2 slider-height2 d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>로그인</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	<div class="login-page"> 
		<div class="login-container">
			<div class="login-container">
		<form method="post" action="/doggimain/UserServlet"> <!-- post 정보를 숨기는 메서드 -->
	 		<c:if test="${not empty sessionScope.errorMessage}"> 
	 			<div class = "error-message">
	 				<p>${sessionScope.errorMessage}</p><br>
	 			</div>
	 			<c:remove var="errorMessage" scope="session"/>
			</c:if>
			<input type = "hidden" name = "pagecode" value = "P002">
			<!-- loginAction 페이지로 로그인 정보를 보내주겠다 -->
				<div class="form-fjrst">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="username" maxlength = "20" required autofocus>
					</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="password" maxlength = "20" required> 
				</div>
					<div class="form-group">
						<input type = "submit" class = "btn btn-primary form-control" value="로그인">
						<!-- 로그인을 누르면 loginAction 페이지로 이동 -->
					</div>
				</div>
		</form>
			</div>
		</div>
	</div>
	</main>
<!-- JS here -->
    
    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
    <!-- Jquery, Popper, Bootstrap -->
    <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="./assets/js/popper.min.js"></script>
    <script src="./assets/js/bootstrap.min.js"></script>
    <!-- Jquery Mobile Menu -->
    <script src="./assets/js/jquery.slicknav.min.js"></script>

    <!-- Jquery Slick , Owl-Carousel Plugins -->
    <script src="./assets/js/owl.carousel.min.js"></script>
    <script src="./assets/js/slick.min.js"></script>
    <!-- One Page, Animated-HeadLin -->
    <script src="./assets/js/wow.min.js"></script>
    <script src="./assets/js/animated.headline.js"></script>
    <script src="./assets/js/jquery.magnific-popup.js"></script>

    <!-- Nice-select, sticky -->
    <script src="./assets/js/jquery.nice-select.min.js"></script>
    <script src="./assets/js/jquery.sticky.js"></script>
    
    <!-- contact js -->
    <script src="./assets/js/contact.js"></script>
    <script src="./assets/js/jquery.form.js"></script>
    <script src="./assets/js/jquery.validate.min.js"></script>
    <script src="./assets/js/mail-script.js"></script>
    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>
    
    <!-- Jquery Plugins, main Jquery -->	
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
</body>
</html>

 

<%@ include file="footer.jsp" %>