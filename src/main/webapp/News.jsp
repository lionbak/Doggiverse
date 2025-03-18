<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="header.jsp" %>
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
    <script>
        function handleLogout() {
            alert('로그아웃 되었습니다.');
            document.getElementById('logout-form').submit();
        }
    </script>
</head>
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
<body>
<div class="slider-area2 slider-height2 d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>실시간 반려견 뉴스</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>&nbsp;</div>
 <div class="home_blog-area section-padding5">
        <div class="container">
            <div class="row justify-content-sm-center">
                <div class="cl-xl-7 col-lg-8 col-md-10">
                    <!-- Section Tittle -->
                    <!-- <div class="section-tittle text-center mb-70">
                        <span>Our recent news</span>
                        <h2>Our Recent Blog</h2>
                    </div>  -->
                </div>
            </div>
            <div class="row" id="newsContent">
                <!-- AJAX 동적 할당 -->
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script>
        $(document).ready(function() {
            $.ajax({
                url: '<%=request.getContextPath()%>/CrawlServlet',
                method: 'GET',
                dataType: 'json',
                success: function(data) {
                    var htmlStr = '';
                    $.each(data, function(index, news) {
                        htmlStr += '<div class="col-xl-4 col-lg-4 col-md-6">';
                        htmlStr += '<div class="single-blogs mb-30">';
                        htmlStr += '<div class="blog-img">';
                        if (news.img) {
                            htmlStr += '<img src="' + news.img + '" alt="뉴스 이미지">';
                        } else {
                            htmlStr += '<p>이미지가 없습니다</p>';
                        }
                        htmlStr += '</div>';
                        htmlStr += '<div class="blogs-cap">';
                        htmlStr += '<div class="date-info">';
                        htmlStr += '<span>' + news.ref + '</span>';
                        htmlStr += '<p>'+ news.regdate + '</p>'; // 날짜가 데이터에 없으므로 placeholder로 추가
                        htmlStr += '</div>';
                        htmlStr += '<h4><a href="' + news.href + '" target="_blank">' + news.title + '</a></h4>';
                        htmlStr += '<a href="' + news.href + '" target="_blank" class="read-more1">Read more</a>';
                        htmlStr += '</div>';
                        htmlStr += '</div>';
                        htmlStr += '</div>';
                    });
                    $('#newsContent').html(htmlStr);
                },
                error: function() {
                    $('#newsContent').html('<p>뉴스 데이터를 불러오는 데 실패했습니다.</p>');
                }
            });
        });
    </script>
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
    <script src="./assets/js/plugins.js"></script>
    <script src="./assets/js/main.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
<%@ include file="footer.jsp" %>